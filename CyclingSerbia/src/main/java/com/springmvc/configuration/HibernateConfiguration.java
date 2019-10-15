package com.springmvc.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.springmvc.configuration"})
@PropertySource(value = {"classpath:application.properties" })
public class HibernateConfiguration {
	
	@Autowired
	private Environment env;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(dataSource());
		sf.setPackagesToScan(new String [] {"com.springmvc.model"});
		sf.setHibernateProperties(hibernateProperties());
		return sf;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		ds.setUrl(env.getRequiredProperty("jdbc.url"));
		ds.setUsername(env.getRequiredProperty("jdbc.username"));
		ds.setPassword(env.getRequiredProperty("jdbc.password"));
		return ds;
	}
	
	private Properties hibernateProperties() {
		Properties p = new Properties();
		p.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		p.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		p.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		return p;
	}
	@Bean @Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager hTM = new HibernateTransactionManager();
		hTM.setSessionFactory(s);
		return hTM;
	}
}
