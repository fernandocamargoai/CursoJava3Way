package br.com.threeway.locadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//@Configuration
//@ComponentScan(basePackages = "br.com.threeway.locadora")
//@EntityScan(basePackages = "br.com.threeway.locadora.domain")
//@EnableJpaRepositories(basePackages = "br.com.threeway.locadora.dao")
public class LocadoraApplication extends SpringBootServletInitializer { // WebApplicationInitializer

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LocadoraApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
	}
}
