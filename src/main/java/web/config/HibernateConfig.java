package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "web") // пакет, где будет проходить сканирование
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class HibernateConfig { /// PersistenceJPAConfig

    private final Environment env;

    public HibernateConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean(); // можно добавит final
        em.setDataSource(dataSource());
        em.setPackagesToScan("web.models");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(hibernateProperties()); // о том, что EntityManagerFactory предоставляется Hibernate-ом
        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver")); //dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(env.getProperty("db.url")); ///dataSource.setUrl("jdbc:mysql://localhost:3306/my_db");
        dataSource.setUsername(env.getProperty("db.username")); // dataSource.setUsername( "root" );
        dataSource.setPassword(env.getProperty("db.password")); //dataSource.setPassword( "root" );
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql")); // чтобы было видно команды SQL
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

        //properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        return properties;
    }
}