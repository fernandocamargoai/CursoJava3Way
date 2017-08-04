package br.com.threeway.locadora;

import br.com.threeway.locadora.domain.TipoFilme;
import br.com.threeway.locadora.service.TipoFilmeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

	@Override
	protected WebApplicationContext run(SpringApplication application) {
		WebApplicationContext webApplicationContext = super.run(application);

		TipoFilmeService tipoFilmeService = webApplicationContext.getBean(TipoFilmeService.class);

		tipoFilmeService.save(new TipoFilme("Catálogo", 3, 1.5, 1.0));
		tipoFilmeService.save(new TipoFilme("Lançamento", 2, 2.5, 2.0));
		tipoFilmeService.save(new TipoFilme("Super Lançamento", 1, 4.0, 4.0));

		return webApplicationContext;
	}

	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
	}
}
