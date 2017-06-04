package viti.kaf22.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Random;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import viti.kaf22.entities.Abiturient;
import viti.kaf22.entities.Atestat;
import viti.kaf22.entities.BalZno;
import viti.kaf22.entities.DisciplineZno;
import viti.kaf22.entities.Imya;
import viti.kaf22.entities.ImyaPoBatkovi;
import viti.kaf22.entities.NomerTelefonu;
import viti.kaf22.entities.Pilgi;
import viti.kaf22.entities.PilgiDocument;
import viti.kaf22.entities.Prizvishche;
import viti.kaf22.entities.SertifikatZno;
import viti.kaf22.entities.Specialnist;
import viti.kaf22.entities.SpecialnistGeneral;
import viti.kaf22.entities.Stat;
import viti.kaf22.entities.enums.TipPilgi;
import viti.kaf22.services.AbiturientService;
import viti.kaf22.services.HService;

/**
 * Created by korch on 25.05.17
 */
public class App {

	// LOGGER
	private static Logger logger = Logger.getLogger(App.class);

	// SERVICES
	private static ApplicationContext context;
	private static AbiturientService aService;
	private static HService hService;

	// TEST OBJECTS
	private static Abiturient abiturient;
	private static SertifikatZno zno;
	private static SpecialnistGeneral specialnistGeneral;


	// FOR TEST OBJECTS
	private static ArrayList<Abiturient> abiturients = new ArrayList<>();

	public static void main(String[] arg) {
		try {
			init();
			setUp();
		} catch (Exception e) {
			logger.error("failed!", e);
			e.printStackTrace();
		}
		test();
		((AbstractApplicationContext) context).close();
	}

	public static void test() {
		logger.info("************START TEST***************");
		logger.info("abiturients:" + abiturients);
		logger.info("abituriens size:" + abiturients.size());
		logger.info("zno:" + zno);

//		aService.save(abiturient);
//		abiturient.setSertifikatZnos(new HashSet<SertifikatZno>());
//		abiturient.getSertifikatZnos().add(zno);
//		aService.update(abiturient);
//		Abiturient abiturientTest = aService.getWithLazy(abiturient.getId());
//		System.out.println(abiturientTest.getSertifikatZnos().stream().findAny().get().getBalZno().stream().findAny().get());
//		aService.delete(abiturient);


		
		
		abiturient.setPilgis(new HashSet<>());
		Pilgi pilga = new Pilgi();
		pilga.setData(new Date());
		pilga.setNomer("Test Number");
		pilga.setTip_pilgi(TipPilgi.PershoCherg);
		PilgiDocument document = new PilgiDocument();
		document.setShortName("УБД");
		pilga.setPilgiDocument(document);
		abiturient.getPilgis().add(pilga);
		
		
		abiturient.setSpecialnistGenerals(new HashSet<SpecialnistGeneral>());
		abiturient.getSpecialnistGenerals().add(specialnistGeneral);
		SpecialnistGeneral general = new SpecialnistGeneral();
		general.setPrioritet(specialnistGeneral.getPrioritet());
		general.setSpecialnist(specialnistGeneral.getSpecialnist());
		
		
		aService.save(abiturient);
		
		pilga.setData(new Date());
		pilga.setTip_pilgi(TipPilgi.None);
		aService.saveOrUpdate(abiturient);
		
		Abiturient abiturient2 = aService.getWithLazy(abiturient.getId());
		System.out.println(abiturient2.getPilgis().stream().findFirst().get().getTip_pilgi().equals(TipPilgi.None));
		System.out.println(abiturient2.getPilgis().stream().findFirst().get().getPilgaTipName());

		
		
		pilga.setTip_pilgi(TipPilgi.PozaCherg);
		aService.update(abiturient);
		
		Abiturient abiturient3 = aService.getWithLazy(abiturient.getId());
		System.out.println(abiturient3.getPilgis().stream().findFirst().get().getTip_pilgi().equals(TipPilgi.PozaCherg));
		System.out.println(abiturient3.getPilgis().stream().findFirst().get().getPilgaTipName());
		
//		aService.delete(abiturient);
		Abiturient abiturient4 = aService.getWithLazy(abiturient.getId());
		System.out.println(abiturient4);

		logger.info("*************TEST FINISHED**************");
	}

	public static void setUp() throws Exception {
		Random random = new Random();

		abiturient = new Abiturient();
		Stat statM = new Stat();
		statM.setName("чоловік");
		Stat stat = hService.getAll(Stat.class).stream().findFirst().orElse(statM);

		Imya imya = (Imya) hService.namedQuery("imya.findByName", "Анатолій").stream().findFirst().orElse(null);
		if (imya == null) {
			imya = new Imya();
			imya.setName("Анатолій");
		}

		Prizvishche prizvishche = (Prizvishche) hService.namedQuery("prizvishche.findByName", "Антоніо").stream()
				.findFirst().orElse(null);
		if (prizvishche == null) {
			prizvishche = new Prizvishche();
			prizvishche.setName("Антоніо");
		}

		ImyaPoBatkovi batkovi = (ImyaPoBatkovi) hService.namedQuery("imyaPoBatkovi.findByName", "Анатолійович").stream()
				.findFirst().orElse(null);
		if (batkovi == null) {
			batkovi = new ImyaPoBatkovi();
			batkovi.setName("Анатолійович");
		}

		NomerTelefonu nomerTelefonu = new NomerTelefonu();
		nomerTelefonu.setNomer("050" + nextIntNumberDigits(7));
		NomerTelefonu nomerTelefonu2 = new NomerTelefonu();
		nomerTelefonu2.setNomer("063" + nextIntNumberDigits(7));

		Atestat atestat = new Atestat();
		atestat.setAverage12(random.nextInt(24) / 2);
		atestat.setAverage200(100 + random.nextInt(100));
		atestat.setNomerSeria("RT" + nextIntNumberDigits(6));
		atestat.setDataVidachi(new Date());

		Date birth = new GregorianCalendar(1999, random.nextInt(11), random.nextInt(27) + 1).getTime();
		abiturient.setBirth(birth);
		abiturient.setSprava("ЦМД-" + nextIntNumberDigits(4));
		abiturient.setChasReestr(new Date());
		abiturient.setImya(imya);
		abiturient.setImyaPoBatkovi(batkovi);
		abiturient.setNomerTelefonus(new HashSet<NomerTelefonu>());
		abiturient.getNomerTelefonus().add(nomerTelefonu);
		abiturient.getNomerTelefonus().add(nomerTelefonu2);
		abiturient.setPrizvishche(prizvishche);

		abiturient.setAtestat(atestat);
		abiturient.setStat(stat);

		zno = new SertifikatZno();
		logger.debug("BEFORE CREATE ZNO");
		zno.setBalZno(new HashSet<BalZno>());
		logger.debug("BEFORE CREATE HASH BALS");

		DisciplineZno disciplineZno1 = new DisciplineZno();
		disciplineZno1.setNazvaDiscipline("Англійська мова");
		logger.debug("BEFORE CREATE DisciplineZno");
		DisciplineZno disciplineZno2 = new DisciplineZno();
		disciplineZno2.setNazvaDiscipline("Математика");
		BalZno balZno1 = new BalZno();
		balZno1.setBal(random.nextInt(100) + 100);
		balZno1.setDisciplineZno(disciplineZno1);
		logger.debug("BEFORE CREATE BalZno");

		BalZno balZno2 = new BalZno();
		balZno2.setBal(random.nextInt(100) + 100);
		balZno2.setDisciplineZno(disciplineZno2);
		logger.debug("BEFORE BAL1:" + balZno1);
		logger.debug("BEFORE BAL2:" + balZno2);
		HashSet<BalZno> set = (HashSet<BalZno>) zno.getBalZno();
		logger.debug("BEFORE set S:" + set);

		set.add(balZno1);
		set.add(balZno2);
		logger.debug("BEFORE set F:" + set);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

		zno.setData(format.parse(nextIntNumberDigits(1) + "/" + nextIntNumberDigits(1) + "/17"));
		zno.setSeriyaNomerZno(nextIntNumberDigits(10));
		logger.debug("BEFORE ZNO" + zno);
		
		specialnistGeneral = new SpecialnistGeneral();
		specialnistGeneral.setPrioritet((byte) 1);
		
		Specialnist specialnist = new Specialnist();
		specialnist.setAbriviatura("КН");
		specialnistGeneral.setSpecialnist(specialnist );
	}

	private static void init() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] { "db_conf.xml" });
		aService = (AbiturientService) context.getBean("abiturientService");
		hService = context.getBean(HService.class);
	}

	private static String nextIntNumberDigits(int digits) {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		int x;
		for (int i = 0; i < digits; i++) {
			x = random.nextInt(9);
			builder.append(x);
		}
		return builder.toString();
	}
}
