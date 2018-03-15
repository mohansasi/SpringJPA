package co.enlume.spring.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableJpaRepositories("co.enlume.spring.dao")
@EnableTransactionManagement
public class TransactionsConfig {
	
	//Not required because of DataSourceConfiguration.Tomcat matched:
		@Bean
		public DataSource dataSource() {
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/quisk_live_dashboard");
			ds.setUsername("root");
			ds.setPassword("enlume123");
			return ds;
		}

		//Not required because of JpaBaseConfiguration#jpaVendorAdapter matched
		@Bean
		public JpaVendorAdapter hibJpaVendorAdapter() {
			HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
			adapter.setDatabase(Database.MYSQL);
			adapter.setShowSql(true);
			adapter.setGenerateDdl(false);
			// adapter.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
			return adapter;
		}

		//Not required because of HibernateJpaAutoConfiguration matched
		//Method name must be entitiyManagerFactory because Spring Data Jpa by default looks for an EntityManagerFactory named 'entityManagerFactory' 
		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds,
				JpaVendorAdapter jpaVendorAdapter) {
			LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
			emfb.setDataSource(ds);
			emfb.setJpaVendorAdapter(jpaVendorAdapter);
			emfb.setPackagesToScan("co.enlume.spring.model");
			return emfb;
		}

		//Not required because of JpaBaseConfiguration#transactionManager matched 
		@Bean
		public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
			EntityManagerFactory factory = entityManagerFactory.getObject();
			return new JpaTransactionManager(factory);
		}
	
	
}
