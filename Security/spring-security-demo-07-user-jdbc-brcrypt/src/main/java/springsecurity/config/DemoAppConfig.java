package springsecurity.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	@Autowired
	private Environment env;
	
	// Logger for diagnostics
	
	private Logger logger = Logger.getLogger(getClass().getName());

	// define a bean for ViewResolver

	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// define a bean for our security datasource
	
	@Bean
	public DataSource securityDataSource() {
		
		ComboPooledDataSource securityDSource =
				new ComboPooledDataSource();
		
		try {
			securityDSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));
		
		
		securityDSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDSource.setUser(env.getProperty("jdbc.user"));
		securityDSource.setPassword(env.getProperty("jdbc.password"));
		
		
		securityDSource.setInitialPoolSize(
				propertyToInt("connection.pool.initialPoolSize"));
		securityDSource.setMinPoolSize(
				propertyToInt("connection.pool.minPoolSize"));
		securityDSource.setMaxPoolSize(
				propertyToInt("connection.pool.maxPoolSize"));
		securityDSource.setMaxIdleTime(
				propertyToInt("connection.pool.maxIdleTime"));
		
		
		
		return securityDSource;
	}
	
	public int propertyToInt(String s) {
		int x = Integer.valueOf(env.getProperty(s));
		return x;
	}
	
}









