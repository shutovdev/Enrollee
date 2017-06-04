package viti.kaf22.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Random;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import viti.kaf22.entities.*;
import viti.kaf22.services.AbiturientService;
import viti.kaf22.services.HService;
/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */
@Category(IntegrationTest.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AbiturientServiceSpecialnostIT {

	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hhmmss");
		System.setProperty("current.date", dateFormat.format(new Date()));
	}

	private static String getAbiturientDate(Abiturient abiturient) {
		return abiturient.getPrizvishche().getName() + " " + abiturient.getSprava() + " id:" + abiturient.getId();
	}

	final static Logger logger = Logger.getLogger(AbiturientServiceSpecialnostIT.class);
	private static int counter = 1;

	private static ApplicationContext context;
	private static AbiturientService aService;
	private static HService hService;

	private Abiturient abiturient;
	private SertifikatZno zno;
	private SpecialnistGeneral specialnistGeneral;
	private static ArrayList<Abiturient> abiturients = new ArrayList<>();

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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] { "db_conf.xml" });
		aService = (AbiturientService) context.getBean("abiturientService");
		hService = context.getBean(HService.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// context.close();
	}

	@Before
	public void setUp() throws Exception {
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
		disciplineZno2.setNazvaDiscipline("Українська мова та література");
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

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void a_testSaveWithSpecialnist() {

		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");

		logger.info("***************STEP 1******************");

		abiturient.setSpecialnistGenerals(new HashSet<SpecialnistGeneral>());
		abiturient.getSpecialnistGenerals().add(specialnistGeneral);
		SpecialnistGeneral general = new SpecialnistGeneral();
		general.setPrioritet(specialnistGeneral.getPrioritet());
		general.setSpecialnist(specialnistGeneral.getSpecialnist());
		aService.save(abiturient);
		assertTrue(true);
		logger.info("***************STEP 2******************");
		specialnistGeneral.setPrioritet((byte)2);
		aService.saveOrUpdate(abiturient);
		assertTrue(true);
		logger.info("***************STEP 3******************");
		specialnistGeneral.setPrioritet((byte)3);
		Specialnist specialnist = new Specialnist();
		specialnist.setAbriviatura("ОВТ");
		specialnistGeneral.setSpecialnist(specialnist);
		abiturient.getSpecialnistGenerals().add(general);
		assertTrue(true);
		logger.info("***************STEP 3******************");
		aService.update(abiturient);
		assertTrue(true);
		logger.info("***************STEP 4******************");
		aService.delete(abiturient);
		logger.info("abiturients:" + abiturients);
		logger.info("abituriens size:" + abiturients.size());
		logger.info(getAbiturientDate(abiturient));

		assertTrue(true);

		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");
	}


}
