package config;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Properties;

@Configuration
@ComponentScan("java.*")
@PropertySource("classpath:database.properties")
public class PersistenceJPAConfig {

    @PostConstruct
    public void init() {
        try {
            Server.createTcpServer().start();
        } catch (SQLException e) {
            throw new RuntimeException("Fail start tcp h2 Server");
        }
    }

    @Autowired
    Environment env;

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//       em.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
//       em.setPersistenceUnitName("persistence-unit");
//        return em;
//    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("bean");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("hibernate.hikari.driverClassName"));
        dataSource.setUrl(env.getProperty("hibernate.hikari.jdbcUrl"));
        dataSource.setUsername(env.getProperty("hibernate.hikari.username"));
        dataSource.setPassword(env.getProperty("hibernate.hikari.password"));
        return dataSource;
    }

//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager transactionManager = new
//                JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }

    Properties additionalProperties() {
        Properties properties = new Properties();
//        properties.setProperty("hibernate.hikari.connectionTimeout", env.getProperty("hibernate.hikari.connectionTimeout"));
//        properties.setProperty("hibernate.hikari.poolName", env.getProperty("hibernate.hikari.poolName"));
//        properties.setProperty("hibernate.hikari.maxLifetime", env.getProperty("hibernate.hikari.maxLifetime"));
//        properties.setProperty("hibernate.hikari.minimumIdle", env.getProperty("hibernate.hikari.minimumIdle"));
//        properties.setProperty("hibernate.hikari.maximumPoolSize", env.getProperty("hibernate.hikari.maximumPoolSize"));
//        properties.setProperty("hibernate.hikari.idleTimeout", env.getProperty("hibernate.hikari.idleTimeout"));
//        properties.setProperty("hibernate.hikari.leakDetectionThreshold", env.getProperty("hibernate.hikari.leakDetectionThreshold"));
//        properties.setProperty("hibernate.connection.provider_class", env.getProperty("hibernate.connection.provider_class"));
        properties.setProperty("javax.persistence.schema-generation.database.action", env.getProperty("javax.persistence.schema-generation.database.action"));
        properties.setProperty("javax.persistence.sql-load-script-source", env.getProperty("javax.persistence.sql-load-script-source"));
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        properties.setProperty("hibernate.use_sql_comments", env.getProperty("hibernate.use_sql_comments"));
//        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        return properties;
    }


}
