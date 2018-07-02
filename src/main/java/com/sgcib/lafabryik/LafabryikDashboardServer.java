package com.sgcib.lafabryik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan
@SpringBootApplication
public class LafabryikDashboardServer {
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
//		ds.setUrl("jdbc:mysql://127.0.0.1:3306/lafabryik?useSSL=false");
//		ds.setUsername("rooter");
//		ds.setPassword("Priya$31");
//
//		return ds;
//	}


	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context =
//				new AnnotationConfigApplicationContext(LafabryikDashboardServer.class);
//		context.getBean(PersonClient.class).process();
//
//		context.close();

		SpringApplication.run(LafabryikDashboardServer.class, args);
	}

	public @Bean WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
}
