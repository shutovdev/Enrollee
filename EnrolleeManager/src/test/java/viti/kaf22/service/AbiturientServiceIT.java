package viti.kaf22.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;
import org.hibernate.NonUniqueObjectException;
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
public class AbiturientServiceIT {

	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hhmmss");
		System.setProperty("current.date", dateFormat.format(new Date()));
	}

	private static String getAbiturientDate(Abiturient abiturient) {
		return abiturient.getPrizvishche().getName() + " " + abiturient.getSprava() + " id:" + abiturient.getId();
	}

	final static Logger logger = Logger.getLogger(AbiturientServiceIT.class);
	private static int counter = 1;

	private static ApplicationContext context;
	private static AbiturientService aService;
	private static HService hService;

	private Abiturient abiturient;

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

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void ab_testSave() {
		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");
		logger.info("testSave");
		logger.info("abiturients:" + abiturients);

		aService.saveOrUpdate(abiturient);
		assertTrue(true);
		abiturients.add(abiturient);

		logger.info("abituriens size:" + abiturients.size());
		logger.info(getAbiturientDate(abiturient));
		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");
		assertTrue(true);
	}

	@Test
	public void b_testGet() {
		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");

		List<Abiturient> alist = (List<Abiturient>) aService.getAll();
		logger.info("GET ALL");
		logger.info(alist);
		Abiturient abiturient = alist.stream().reduce((a1, a2) -> a2).get();
		assertNotNull(aService.get(abiturient.getId()));

		logger.info("testGet");
		logger.info("abiturients:" + abiturients);
		logger.info("abituriens size:" + abiturients.size());
		logger.info(getAbiturientDate(abiturient));
		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");	}

	@Test
	public void c_testGetWithLazy() {
		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");

		logger.info("testGetWithLazy");
		logger.info("abiturients:" + abiturients);
		logger.info("abituriens size:" + abiturients.size());

		abiturient = aService.getAll().get(0);
		logger.info("abiturient from GETALL:" + abiturient);
		assertNotNull(aService.getWithLazy(abiturient.getId()).getAtestat());
		assertNotNull(aService.getWithLazy(abiturient.getId()).getImya());
		assertNotNull(aService.getWithLazy(abiturient.getId()).getNomerTelefonus());

		logger.info(getAbiturientDate(abiturient));
		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");	}

	@Test
	public void d_testSaveOrUpdate_SaveOnly() {

		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");
		logger.info("abiturients:" + abiturients);
		logger.info("abituriens size:" + abiturients.size());

		aService.saveOrUpdate(abiturient);
		abiturients.add(abiturient);

		assertTrue(true);
		abiturient.setChasReestr(new Date());
		aService.saveOrUpdate(abiturient);
		assertTrue(true);

		logger.info(getAbiturientDate(abiturient));
		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");	}

	@Test
	public void e_testSaveOrUpdate_UpdateOnly() {
		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");

		abiturient = aService.getAllWithLazy().stream().reduce((a1, a2) -> a2).get();

		aService.saveOrUpdate(abiturient);
		assertTrue(true);
		abiturient.setChasReestr(new Date());
		aService.saveOrUpdate(abiturient);
		assertTrue(true);

		logger.info("abiturients:" + abiturients);
		logger.info("abituriens size:" + abiturients.size());
		logger.info(getAbiturientDate(abiturient));
		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");
	}

	@Test
	public void f_testGetAll() {
		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");

		assertTrue(aService.getAll().size() > 0);

		logger.info(getAbiturientDate(abiturient));
		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");	}

	@Test
	public void g_testGetAllWithLazy() {
		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");

		assertTrue(aService.getAllWithLazy().size() > 0);
		assertNotNull(aService.getAllWithLazy().get(0).getAtestat());
		assertNotNull(aService.getAllWithLazy().get(0).getPrizvishche());
		assertNotNull(aService.getAllWithLazy().get(0).getNomerTelefonus());

		logger.info(getAbiturientDate(abiturient));
		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");	}

	@Test
	public void h_testUpdate() {

		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");
		logger.info("abiturients:" + abiturients);
		logger.info("abituriens size:" + abiturients.size());

		abiturient = aService.getAllWithLazy().stream().reduce((a1, a2) -> a2).get();
		abiturient.setChasReestr(new Date());
		abiturient.setSprava("ЦМД-" + nextIntNumberDigits(4));
		aService.update(abiturient);
		assertTrue(true);

		logger.info(getAbiturientDate(abiturient));
		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");
	}

	@Test
	public void i_testNamedQuery() {

		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");

		abiturient = aService.getAll().stream().reduce((a1, a2) -> a2).get();
		Abiturient abiturientTest = aService.namedQuery("abiturient.findBySprava", abiturient.getSprava()).get(0);
		assertEquals(abiturient.getSprava(), abiturientTest.getSprava());

		logger.info("abiturients:" + abiturients);
		logger.info("abituriens size:" + abiturients.size());
		logger.info(getAbiturientDate(abiturientTest));
		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");
	}

	@Test(expected = NonUniqueObjectException.class)
	public void j_testDublicate() throws Exception {
		Exception expected = null;
		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");
		logger.info("abiturients:" + abiturients);
		logger.info("abituriens size:" + abiturients.size());
		try{
		aService.save(abiturients.get(0));
		aService.save(abiturients.get(0));
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
			logger.error(e.getCause());
			logger.error(e.getClass());
			expected=e;
		}
		logger.info(getAbiturientDate(abiturients.get(0)));
		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");
		if(expected!=null)
			throw expected;
	}

	@Test
	public void k_testDelete() {
		Abiturient abiturient = abiturients.stream().findAny()
				.orElse(aService.getAll().stream().reduce((a1, a2) -> a2).get());

		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");
		logger.info("abiturients:" + abiturients);
		logger.info("abituriens size:" + abiturients.size());
		logger.info(getAbiturientDate(abiturient));

		aService.delete(abiturient);
		assertTrue(true);
		logger.info("delete OK");
		abiturients.remove(abiturient);
		logger.info("delete from collection");
		assertTrue(true);
		logger.info("testDelete new SIZE:" + abiturients.size());
		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");	}

	@Test
	public void l_testDeletes() {
		logger.info("*************" + (counter++) + "**************");
		logger.info("**" + new Object() {
		}.getClass().getEnclosingMethod().getName() + "**");
		logger.info("************START TEST***************");
		abiturients.forEach(a -> logger.info("delete:" + a.getId()));
		logger.info("delete will be!");
		abiturients.forEach(a -> aService.delete(a));
		logger.info("delete all");
		assertTrue(true);

		logger.info("abiturients:" + abiturients);
		logger.info("abituriens size:" + abiturients.size());
		logger.info("*************" + (counter++) + "**************");
		logger.info("*************TEST FINISHED**************");	}

}