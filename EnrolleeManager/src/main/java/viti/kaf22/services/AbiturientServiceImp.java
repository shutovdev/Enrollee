package viti.kaf22.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import viti.kaf22.dao.DAO;
import viti.kaf22.entities.Abiturient;
import viti.kaf22.entities.Atestat;
import viti.kaf22.entities.BalZno;
import viti.kaf22.entities.DisciplineZno;
import viti.kaf22.entities.FormaNavch;
import viti.kaf22.entities.Imya;
import viti.kaf22.entities.ImyaPoBatkovi;
import viti.kaf22.entities.NavchZaklad;
import viti.kaf22.entities.Pilgi;
import viti.kaf22.entities.PilgiDocument;
import viti.kaf22.entities.Prizvishche;
import viti.kaf22.entities.SertifikatZno;
import viti.kaf22.entities.SocialniyStatus;
import viti.kaf22.entities.Specialnist;
import viti.kaf22.entities.SpecialnistGeneral;
import viti.kaf22.entities.Stat;
import viti.kaf22.entities.ViyskovaChastina;
import viti.kaf22.entities.Zvanya;
import viti.kaf22.utils.HelpUtil;

/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */
@Service("abiturientService")
public class AbiturientServiceImp implements AbiturientService {

	private static final Logger logger = Logger.getLogger(AbiturientServiceImp.class);

	@Autowired
	private DAO abiturientDao;

	@Transactional
	@Override
	public void delete(Abiturient abiturient) {
		logger.debug("**AbiturientServiceImp**DELETE******");
		logger.debug("**AbiturientServiceImp**ID******" + abiturient.getId());
		Abiturient abiturientDel = this.getWithLazy(abiturient.getId());
		if (abiturientDel == null) {
			abiturientDel = (Abiturient) abiturientDao.namedQuery("abiturient.findBySprava", abiturient.getSprava())
					.stream().findAny().orElse(null);
			if (abiturientDel == null) {
				logger.info("**AbiturientServiceImp**DELETE******NOT FOUND ABITURIENT ID:" + abiturient.getId()
						+ " SPRAVA:" + abiturient.getSprava());
				return;
			}

		}
		if (abiturientDel.getSertifikatZnos() != null)
			abiturientDel.getSertifikatZnos().forEach(s -> s.getBalZno().forEach(b -> abiturientDao.delete(b)));
		if(abiturientDel.getPilgis()!=null)
			abiturientDel.getPilgis().forEach(p->abiturientDao.delete(p));
		abiturientDel.setPilgis(null);
		HelpUtil.executeBySetObject(abiturientDel, Set.class, abiturientDao::delete, true, BalZno.class, Pilgi.class, 
				SertifikatZno.class);
		abiturientDao.delete(abiturientDel);
	}

	@Transactional(readOnly = true)
	@Override
	public Abiturient get(Long id) {
		return abiturientDao.get(Abiturient.class, id);
	}

	@Transactional(readOnly = true)
	@Override
	public Abiturient getWithLazy(Long id) {
		return abiturientDao.getWithLazy(Abiturient.class, id);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void save(Abiturient abiturient) {
		ArrayList<Class<?>> typeList = initAbiturientInnerObjects(abiturient);

		if (abiturient.getPilgis() != null)
			abiturient.getPilgis().stream().forEach(p -> {
				if (p.getPilgiDocument().getShortName() != null) {
					p.setPilgiDocument((PilgiDocument) abiturientDao
							.namedQuery("pilgiDocument.findByShortName", p.getPilgiDocument().getShortName()).get(0));
				} else if (p.getPilgiDocument().getName() != null)
					p.setPilgiDocument((PilgiDocument) abiturientDao
							.namedQuery("pilgiDocument.findByName", p.getPilgiDocument().getName()).get(0));
				else if (p.getPilgiDocument().getId() != 0)
					p.setPilgiDocument(abiturientDao.getWithLazy(PilgiDocument.class, p.getPilgiDocument().getId()));

			});
		
		
		logger.info("**AbiturientService** SAVE******INIT SET OBJS");
		HelpUtil.initSetObjects(abiturient, Set.class);
		HelpUtil.clearBuffer();
		logger.info("**AbiturientService** SAVE******EXEC BY OBJS");
		HelpUtil.executeByUserObjects(abiturient, Serializable.class, abiturientDao::save, true);
		HelpUtil.clearBuffer();
		logger.info("**AbiturientService** SAVE******INIT OBJS");
		HelpUtil.initUserObjects(abiturient, Serializable.class);
		logger.info("**AbiturientService** SAVE******Abiturient save");
		abiturientDao.save(abiturient);
		logger.info("**AbiturientService** SAVE******SET OBJS SAVE");
		HelpUtil.executeBySetObject(abiturient, Set.class, abiturientDao::save, true,
				typeList.toArray(new Class<?>[typeList.size()]));
		logger.info("**AbiturientService** SAVE******OTHER OBJS SAVE");
		if (abiturient.getSertifikatZnos() != null)
			abiturient.getSertifikatZnos().stream().forEach(s -> s.getBalZno().stream().forEach(b -> {
				String nazvaDiscipline = b.getDisciplineZno().getNazvaDiscipline();
				DisciplineZno disciplineZno = (DisciplineZno) abiturientDao
						.namedQuery("disciplineZno.findByNazvaDiscipline", nazvaDiscipline).get(0);
				b.setDisciplineZno(disciplineZno);
				SertifikatZno sertifikatZno = (SertifikatZno) abiturientDao
						.namedQuery("sertifikatZno.findBySeriyaNomerZno", s.getSeriyaNomerZno()).get(0);
				b.setSertifikatZno(sertifikatZno);
				abiturientDao.save(b);
			}));
		logger.info("**AbiturientService** SAVE******Sertifikat SAVED");

		if (abiturient.getSpecialnistGenerals() != null)
			abiturient.getSpecialnistGenerals().stream().forEach(g -> {
				if (g.getSpecialnist().getAbriviatura() != null) {
					g.setSpecialnist((Specialnist) abiturientDao
							.namedQuery("specialnist.findByAbriviatura", g.getSpecialnist().getAbriviatura()).get(0));
				} else if (g.getSpecialnist().getSpecialnist() != null)
					g.setSpecialnist((Specialnist) abiturientDao
							.namedQuery("specialnist.findBySpecialnist", g.getSpecialnist().getSpecialnist()).get(0));
				else if (g.getSpecialnist().getId() != 0)
					g.setSpecialnist(abiturientDao.getWithLazy(Specialnist.class, g.getSpecialnist().getId()));

				abiturientDao.saveOrUpdate(g);
			});
		logger.info("**AbiturientService** SAVE******Specialnist SAVED");

		if (abiturient.getPilgis() != null)
			abiturient.getPilgis().stream().forEach(p -> {
				if (p.getPilgiDocument().getShortName() != null) {
					logger.info(p.getPilgiDocument().getShortName());
					logger.info(abiturientDao.namedQuery("pilgiDocument.findByShortName",
							p.getPilgiDocument().getShortName()));
					p.setPilgiDocument((PilgiDocument) abiturientDao
							.namedQuery("pilgiDocument.findByShortName", p.getPilgiDocument().getShortName()).get(0));
				} else if (p.getPilgiDocument().getName() != null)
					p.setPilgiDocument((PilgiDocument) abiturientDao
							.namedQuery("pilgiDocument.findByName", p.getPilgiDocument().getName()).get(0));
				else if (p.getPilgiDocument().getId() != 0)
					p.setPilgiDocument(abiturientDao.getWithLazy(PilgiDocument.class, p.getPilgiDocument().getId()));

				abiturientDao.saveOrUpdate(p);
			});
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveOrUpdate(Abiturient abiturient) {
		// GET ID IF EXIST FOR ABITURIENT
		ArrayList<Class<?>> typeList = initAbiturientInnerObjects(abiturient);

		Abiturient abiturientUpdate = (Abiturient) abiturientDao
				.namedQuery("abiturient.findBySprava", abiturient.getSprava()).stream().findFirst().orElse(abiturient);
		abiturient.setId(abiturientUpdate.getId());
		
		if (abiturient.getPilgis() != null)
			abiturient.getPilgis().stream().forEach(p -> {
				if (p.getPilgiDocument().getShortName() != null) {
					p.setPilgiDocument((PilgiDocument) abiturientDao
							.namedQuery("pilgiDocument.findByShortName", p.getPilgiDocument().getShortName()).get(0));
				} else if (p.getPilgiDocument().getName() != null)
					p.setPilgiDocument((PilgiDocument) abiturientDao
							.namedQuery("pilgiDocument.findByName", p.getPilgiDocument().getName()).get(0));
				else if (p.getPilgiDocument().getId() != 0)
					p.setPilgiDocument(abiturientDao.getWithLazy(PilgiDocument.class, p.getPilgiDocument().getId()));

			});
		
		if (abiturient.getId() != 0) {
			Atestat atestat = (Atestat) abiturientDao.namedQuery("atestat.findByAbiturient", abiturient).stream()
					.findFirst().orElse(abiturient.getAtestat());
			abiturient.getAtestat().setId(atestat.getId());
		}
		HelpUtil.initSetObjects(abiturient, Set.class);
		HelpUtil.clearBuffer();
		HelpUtil.executeByUserObjects(abiturient, Serializable.class, abiturientDao::saveOrUpdate, true);
		HelpUtil.clearBuffer();
		HelpUtil.initUserObjects(abiturient, Serializable.class);
		logger.info("*****************   TRY SAVE *************************");

		abiturientDao.saveOrUpdate(abiturient);
		HelpUtil.executeBySetObject(abiturient, Set.class, abiturientDao::saveOrUpdate, true,
				typeList.toArray(new Class<?>[typeList.size()]));
		if (abiturient.getSertifikatZnos() != null)
			abiturient.getSertifikatZnos().stream().forEach(s -> s.getBalZno().stream().forEach(b -> {
				String nazvaDiscipline = b.getDisciplineZno().getNazvaDiscipline();
				DisciplineZno disciplineZno = (DisciplineZno) abiturientDao
						.namedQuery("disciplineZno.findByNazvaDiscipline", nazvaDiscipline).get(0);
				b.setDisciplineZno(disciplineZno);
				SertifikatZno sertifikatZno = (SertifikatZno) abiturientDao
						.namedQuery("sertifikatZno.findBySeriyaNomerZno", s.getSeriyaNomerZno()).get(0);
				b.setSertifikatZno(sertifikatZno);
				abiturientDao.saveOrUpdate(b);
			}));
		if (abiturient.getSpecialnistGenerals() != null)
			abiturient.getSpecialnistGenerals().stream().forEach(g -> {
				if (g.getSpecialnist().getAbriviatura() != null) {
					g.setSpecialnist((Specialnist) abiturientDao
							.namedQuery("specialnist.findByAbriviatura", g.getSpecialnist().getAbriviatura()).get(0));
				} else if (g.getSpecialnist().getSpecialnist() != null)
					g.setSpecialnist((Specialnist) abiturientDao
							.namedQuery("specialnist.findBySpecialnist", g.getSpecialnist().getSpecialnist()).get(0));
				else if (g.getSpecialnist().getId() != 0)
					g.setSpecialnist(abiturientDao.getWithLazy(Specialnist.class, g.getSpecialnist().getId()));

				abiturientDao.saveOrUpdate(g);
			});
		logger.info("PILGIS");
		if (abiturient.getPilgis() != null)
			abiturient.getPilgis().stream().forEach(p -> {
				if (p.getPilgiDocument().getShortName() != null) {
					logger.info(p.getPilgiDocument().getShortName());
					logger.info(abiturientDao.namedQuery("pilgiDocument.findByShortName",
							p.getPilgiDocument().getShortName()));
					p.setPilgiDocument((PilgiDocument) abiturientDao
							.namedQuery("pilgiDocument.findByShortName", p.getPilgiDocument().getShortName()).get(0));
				} else if (p.getPilgiDocument().getName() != null)
					p.setPilgiDocument((PilgiDocument) abiturientDao
							.namedQuery("pilgiDocument.findByName", p.getPilgiDocument().getName()).get(0));
				else if (p.getPilgiDocument().getId() != 0)
					p.setPilgiDocument(abiturientDao.getWithLazy(PilgiDocument.class, p.getPilgiDocument().getId()));

				abiturientDao.saveOrUpdate(p);
			});
		
	}

	@Transactional(readOnly = true)
	@Override
	public List<Abiturient> getAll() {
		return abiturientDao.getAll(Abiturient.class);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Abiturient> getAllWithLazy() {
		return abiturientDao.getAllWithLazy(Abiturient.class);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void update(Abiturient abiturient) {
		// abiturientDao.update(abiturient);
		// abiturient = abiturientDao.getWithLazy(Abiturient.class,
		// abiturient.getId());
		ArrayList<Class<?>> typeList = initAbiturientInnerObjects(abiturient);

		if (abiturient.getPilgis() != null)
			abiturient.getPilgis().stream().forEach(p -> {
				if (p.getPilgiDocument().getShortName() != null) {
					p.setPilgiDocument((PilgiDocument) abiturientDao
							.namedQuery("pilgiDocument.findByShortName", p.getPilgiDocument().getShortName()).get(0));
				} else if (p.getPilgiDocument().getName() != null)
					p.setPilgiDocument((PilgiDocument) abiturientDao
							.namedQuery("pilgiDocument.findByName", p.getPilgiDocument().getName()).get(0));
				else if (p.getPilgiDocument().getId() != 0)
					p.setPilgiDocument(abiturientDao.getWithLazy(PilgiDocument.class, p.getPilgiDocument().getId()));

			});
		
		
		HelpUtil.initSetObjects(abiturient, Set.class);
		HelpUtil.clearBuffer();
		HelpUtil.executeByUserObjects(abiturient, Serializable.class, abiturientDao::saveOrUpdate, true);
		HelpUtil.clearBuffer();
		HelpUtil.initUserObjects(abiturient, Serializable.class);
		abiturientDao.update(abiturient);
		HelpUtil.executeBySetObject(abiturient, Set.class, abiturientDao::saveOrUpdate, true,
				typeList.toArray(new Class<?>[typeList.size()]));
		if (abiturient.getSertifikatZnos() != null)
			abiturient.getSertifikatZnos().stream().forEach(s -> s.getBalZno().stream().forEach(b -> {
				String nazvaDiscipline = b.getDisciplineZno().getNazvaDiscipline();
				DisciplineZno disciplineZno = (DisciplineZno) abiturientDao
						.namedQuery("disciplineZno.findByNazvaDiscipline", nazvaDiscipline).get(0);
				b.setDisciplineZno(disciplineZno);
				SertifikatZno sertifikatZno = (SertifikatZno) abiturientDao
						.namedQuery("sertifikatZno.findBySeriyaNomerZno", s.getSeriyaNomerZno()).get(0);
				b.setSertifikatZno(sertifikatZno);
				abiturientDao.saveOrUpdate(b);
			}));
		if (abiturient.getSpecialnistGenerals() != null)
			abiturient.getSpecialnistGenerals().stream().forEach(g -> {
				if (g.getSpecialnist().getAbriviatura() != null) {
					g.setSpecialnist((Specialnist) abiturientDao
							.namedQuery("specialnist.findByAbriviatura", g.getSpecialnist().getAbriviatura()).get(0));
				} else if (g.getSpecialnist().getSpecialnist() != null)
					g.setSpecialnist((Specialnist) abiturientDao
							.namedQuery("specialnist.findBySpecialnist", g.getSpecialnist().getSpecialnist()).get(0));
				else if (g.getSpecialnist().getId() != 0)
					g.setSpecialnist(abiturientDao.getWithLazy(Specialnist.class, g.getSpecialnist().getId()));
				abiturientDao.saveOrUpdate(g);
			});
		if (abiturient.getPilgis() != null)
			abiturient.getPilgis().stream().forEach(p -> {
				if (p.getPilgiDocument().getShortName() != null) {
					p.setPilgiDocument((PilgiDocument) abiturientDao
							.namedQuery("pilgiDocument.findByShortName", p.getPilgiDocument().getShortName()).get(0));
				} else if (p.getPilgiDocument().getName() != null)
					p.setPilgiDocument((PilgiDocument) abiturientDao
							.namedQuery("pilgiDocument.findByName", p.getPilgiDocument().getName()).get(0));
				else if (p.getPilgiDocument().getId() != 0)
					p.setPilgiDocument(abiturientDao.getWithLazy(PilgiDocument.class, p.getPilgiDocument().getId()));
				abiturientDao.saveOrUpdate(p);
			});
	}

	@Transactional(readOnly = true)
	@Override
	public List<Abiturient> namedQuery(String query, Object value) {
		return abiturientDao.namedQuery(query, value);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
	public ArrayList<Class<?>> initAbiturientInnerObjects(Abiturient abiturient) {
		ArrayList<Class<?>> typeList = new ArrayList<>();
		typeList.add(BalZno.class);
		typeList.add(Specialnist.class);
		typeList.add(SpecialnistGeneral.class);
		typeList.add(Pilgi.class);
		typeList.add(PilgiDocument.class);

		if (abiturient.getId() != 0) {
			Atestat atestat = (Atestat) abiturientDao.namedQuery("atestat.findByAbiturient", abiturient).stream()
					.findFirst().orElse(abiturient.getAtestat());
			abiturient.getAtestat().setId(atestat.getId());
		}

		Imya imya = (Imya) abiturientDao.namedQuery("imya.findByName", abiturient.getImya().getName()).stream()
				.findFirst().orElse(null);
		if (imya != null) {
			typeList.add(Imya.class);
			abiturient.setImya(imya);

		}
		ImyaPoBatkovi imyaPoBatkovi = (ImyaPoBatkovi) abiturientDao
				.namedQuery("imyaPoBatkovi.findByName", abiturient.getImyaPoBatkovi().getName()).stream().findFirst()
				.orElse(null);
		if (imyaPoBatkovi != null) {
			typeList.add(ImyaPoBatkovi.class);
			abiturient.setImyaPoBatkovi(imyaPoBatkovi);

		}
		Prizvishche prizvishche = (Prizvishche) abiturientDao
				.namedQuery("prizvishche.findByName", abiturient.getPrizvishche().getName()).stream().findFirst()
				.orElse(null);
		if (prizvishche != null) {
			typeList.add(Prizvishche.class);
			abiturient.setPrizvishche(prizvishche);

		}
		if (abiturient.getZvan() != null) {
			Zvanya zvanya = (Zvanya) abiturientDao.namedQuery("zvanya.findByName", abiturient.getZvan().getName())
					.stream().findFirst().orElse(null);
			if (zvanya == null)
				zvanya = abiturientDao.get(Zvanya.class, abiturient.getZvan().getId());
			if (zvanya != null) {
				typeList.add(Zvanya.class);
				abiturient.setZvan(zvanya);
			}
		}
		if (abiturient.getStat() != null) {
			Stat stat = (Stat) abiturientDao.namedQuery("stat.findByName", abiturient.getStat().getName()).stream()
					.findFirst().orElse(null);
			if (stat == null)
				stat = abiturientDao.get(Stat.class, abiturient.getStat().getId());
			if (stat != null) {
				typeList.add(Stat.class);
				abiturient.setStat(stat);
			}
		}
		if (abiturient.getStatus() != null) {
			SocialniyStatus status = (SocialniyStatus) abiturientDao
					.namedQuery("socialniyStatus.findByName", abiturient.getStatus().getName()).stream().findFirst()
					.orElse(null);
			if (status == null)
				status = abiturientDao.get(SocialniyStatus.class, abiturient.getStatus().getId());
			if (status != null) {
				typeList.add(SocialniyStatus.class);
				abiturient.setStatus(status);
			}
		}
		if (abiturient.getFormaNavch() != null) {
			FormaNavch formaNavch = (FormaNavch) abiturientDao
					.namedQuery("formaNavch.findByTip", abiturient.getFormaNavch().getTip()).stream().findFirst()
					.orElse(null);
			if (formaNavch == null)
				formaNavch = abiturientDao.get(FormaNavch.class, abiturient.getFormaNavch().getId());
			if (formaNavch != null) {
				typeList.add(FormaNavch.class);
				abiturient.setFormaNavch(formaNavch);
			}
		}
		if (abiturient.getNavchZaklad() != null) {
			NavchZaklad navchZaklad = (NavchZaklad) abiturientDao
					.namedQuery("navchZaklad.findByName", abiturient.getNavchZaklad().getName()).stream().findFirst()
					.orElse(null);
			if (navchZaklad == null)
				navchZaklad = abiturientDao.get(NavchZaklad.class, abiturient.getNavchZaklad().getId());
			if (navchZaklad != null) {
				typeList.add(NavchZaklad.class);
				abiturient.setNavchZaklad(navchZaklad);
			}
		}
		if (abiturient.getViyskovaChastina() != null) {
			ViyskovaChastina viyskovaChastina = (ViyskovaChastina) abiturientDao
					.namedQuery("viyskovaChastina.findByNumber", abiturient.getViyskovaChastina().getNumber()).stream()
					.findFirst().orElse(null);
			if (viyskovaChastina == null)
				viyskovaChastina = abiturientDao.get(ViyskovaChastina.class, abiturient.getViyskovaChastina().getId());
			if (viyskovaChastina != null) {
				typeList.add(ViyskovaChastina.class);
				abiturient.setViyskovaChastina(viyskovaChastina);
			}
		}
		return typeList;
	}

}
