package viti.kaf22.springconf;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import viti.kaf22.entities.*;

//@Configuration
//@PropertySource("classpath:db.properties")
//@EnableTransactionManagement
//@ComponentScans(value = { @ComponentScan("viti.kaf22.services"), @ComponentScan("viti.kaf22.entities"),
//		@ComponentScan("viti.kaf22.dao")})
public class AppConfig {
	@Autowired
	private Environment env;

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		Map<String, Object> map = new HashMap<>();
		Properties props = new Properties();
		((AbstractEnvironment) env).getPropertySources().forEach(ps -> {
			if (ps instanceof MapPropertySource) {
				map.putAll(((MapPropertySource) ps).getSource());
				map.forEach((k, v) -> {
					if (k.startsWith("hibernate.")) {
						props.put(k, env.getProperty(k));

					}
				});
			}
		});

		// FIRST TIME USE THIS TO CHECK ENITIES
		// props.put("hibernate.hbm2ddl.auto",
		// env.getProperty("hibernate.hbm2ddl.auto"));
		System.out.println("*******************SET PROP*************************");
		factoryBean.setHibernateProperties(props);
		System.out.println("*******************SET CLASSES************************");

		factoryBean.setAnnotatedClasses(new Class[] { Abiturient.class, FormaNavch.class, Imya.class,
				ImyaPoBatkovi.class, NavchZaklad.class, Prizvishche.class, SocialniyStatus.class, Stat.class,
				ViyskovaChastina.class, Zvanya.class, NomerTelefonu.class, Atestat.class });

		System.out.println("*******************BEFORE RETURN*************************");

		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
	
	
}
