package com.proyecto.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.proyecto.repositories.AlumnoRepository;
import com.proyecto.repositories.AlumnoRepositoryImpl;
import com.proyecto.repositories.ClaseRepository;
import com.proyecto.repositories.ClaseRepositoryImpl;
import com.proyecto.repositories.TareaRepository;
import com.proyecto.repositories.TareaRepositoryImpl;
import com.proyecto.repositories.UsuarioRepository;
import com.proyecto.repositories.UsuarioRepositoryImpl;
import com.proyecto.services.AlumnoService;
import com.proyecto.services.AlumnoServiceImpl;
import com.proyecto.services.ClaseService;
import com.proyecto.services.ClaseServiceImpl;
import com.proyecto.services.TareaService;
import com.proyecto.services.TareaServiceImpl;
import com.proyecto.services.UsuarioService;
import com.proyecto.services.UsuarioServiceImpl;

@Configuration
@ComponentScan("com.proyecto")
@EnableTransactionManagement
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter{
	
	@Bean(name = "entityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource());
		entityManager.setPackagesToScan(new String[] { "com.proyecto.entities" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManager.setJpaVendorAdapter(vendorAdapter);
		entityManager.setJpaProperties(additionalProperties());

		return entityManager;
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/agenda?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		/*dataSource.setUrl("jdbc:mysql://217.199.187.199/cl56-agenda?useSSL=false");
		dataSource.setUsername("cl56-agenda");
		dataSource.setPassword("Ymt6jtNq-");*/
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	public Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}
	
	
	/*@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.cors().and().csrf().disable();

		httpSecurity.authorizeRequests()
					.antMatchers("/superadmin/**").access("hasRole('ROLE_SUPER_ADMIN')")
					.antMatchers("/admin/**").access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
					.antMatchers("/employee/**").access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
					.and()
					.formLogin()
					.loginPage("/dashboard/login.html")
					.loginProcessingUrl("/dashboard/process-login.html")
					.defaultSuccessUrl("/dashboard/welcome.html")
					.failureUrl("/dashboard/login.html?error")
					.usernameParameter("username").passwordParameter("password")
					.and()
					.logout()
					.logoutUrl("/dashboard/logout.html")
					.logoutSuccessUrl("/dashboard/login.html?logout").and()
					.exceptionHandling()
					.accessDeniedPage("/dashboard/accessDenied.html");
	}*/

	/*@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("superadmin").password(passwordEncoder().encode("123456")).authorities("ROLE_SUPER_ADMIN", "ROLE_ADMIN", "ROLE_EMPLOYEE")
			.and()
			.withUser("admin").password(passwordEncoder().encode("123456")).authorities("ROLE_ADMIN", "ROLE_EMPLOYEE")
			.and()
			.withUser("employee").password(passwordEncoder().encode("123456")).authorities("ROLE_EMPLOYEE");
	}*/

	
	@Bean(name = "alumnoRepository")
	public AlumnoRepository alumnoRepository() {
		return new AlumnoRepositoryImpl();
	}

	@Bean(name = "alumnoService")
	public AlumnoService alumnoService() {
		return new AlumnoServiceImpl(alumnoRepository());
	}
	
	
	@Bean(name = "claseRepository")
	public ClaseRepository claseRepository() {
		return new ClaseRepositoryImpl();
	}

	@Bean(name = "claseService")
	public ClaseService claseService() {
		return new ClaseServiceImpl(claseRepository());
	}
	
	@Bean(name="usuarioRepository")
	public UsuarioRepository usuarioRepository() {
		return new UsuarioRepositoryImpl();
	}
	
	@Bean(name="usuarioService")
	public UsuarioService usuarioService() {
		return new UsuarioServiceImpl(usuarioRepository());
	}

	@Bean(name = "tareaRepository")
	public TareaRepository tareaRepository() {
		return new TareaRepositoryImpl();
	}

	@Bean(name = "tareaService")
	public TareaService tareaService() {
		return new TareaServiceImpl(tareaRepository());
	}
	
	

}
