package br.com.spring.data.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

//@Configuration
public class HibernateConfig {

	@Autowired
	private Environment env;

//	@Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(getDataSource());
//        emf.setPackagesToScan("br.com.spring.data.entity");
//
//        final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        emf.setJpaVendorAdapter(vendorAdapter);
//        emf.setJpaProperties(hibernateProperties());
//
//        return emf;
//    }
	
//	@SuppressWarnings("rawtypes")
//	@Bean
//    public DataSource getDataSource() {
//		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//		dataSourceBuilder.url(env.getProperty("spring.datasource.url"));
//		dataSourceBuilder.username(env.getProperty("spring.datasource.username"));
//		dataSourceBuilder.password(env.getProperty("spring.datasource.password"));
//
//        return dataSourceBuilder.build();	
//    }
//	
//	private final Properties hibernateProperties() {
//        final Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
//        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
//        hibernateProperties.setProperty("hibernate.show_sql", "true");
//
//        return hibernateProperties;
//    }
}
