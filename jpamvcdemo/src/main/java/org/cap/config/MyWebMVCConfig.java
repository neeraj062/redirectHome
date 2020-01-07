package org.cap.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.cap.dto.SessionData;
import org.cap.entities.AppUser;
import org.hibernate.dialect.Oracle10gDialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("org.cap")
@EnableTransactionManagement
public class MyWebMVCConfig {
    private static Logger Log = LoggerFactory.getLogger(MyWebMVCConfig.class);

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public SessionData sessionData() {
        return new SessionData();
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(oracleDataSource());
        em.setPackagesToScan("org.cap");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(oracleProperties());
        return em;
    }

    /**
     * postgres
     *
     * @return
     */
/*
	@Bean
	public DataSource postgresDataSource() {
		try {
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass("org.postgresql.Driver");
			dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/students");
			dataSource.setUser("scooby");
			dataSource.setPassword("scooby123");
			return dataSource;
		} catch (Throwable e) {
			Log.error("exception in postgresDataSource()",e);
			return null;
		}
	}


	Properties postgresProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.dialect", PostgreSQL95Dialect.class.getName());
		properties.setProperty("hibernate.show_sql", "false");
		properties.setProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation", "true");
		return properties;
	}

*/



/*
    For oracle
*/
    @Bean
    public DataSource oracleDataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
            dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            dataSource.setUser("scott");
            dataSource.setPassword("tiger");
            return dataSource;
        } catch (Throwable e) {
            Log.error("exception in postgresDataSource()", e);
            return null;
        }
    }

    Properties oracleProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", Oracle10gDialect.class.getName());
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation", "true");
        return properties;
    }


    @Bean
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }




/*

   For mysql

	@Bean
	public DataSource mysqlDataSource() {
		try {
			ComboPooledDataSource postgresDataSource = new ComboPooledDataSource();
			postgresDataSource.setDriverClass("com.mysql.jdbc.Driver");
			postgresDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/students");
			postgresDataSource.setUser("scooby");
			postgresDataSource.setPassword("scooby123");
			return postgresDataSource;
		} catch (Throwable e) {
			Log.error("exception in postgresDataSource()",e);
			return null;
		}
	}


	Properties mysqlProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", MariaDBDialect.class.getName());
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "false");
		properties.setProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation", "true");
		return properties;
	}
*/


}
