package hdn.example.catservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import hdn.example.catservice.dao.ProduitRepository;
import hdn.example.catservice.entities.Produit;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;

	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		try {
			SpringApplication.run(CatServiceApplication.class, args);
		} catch (Throwable e) {
			System.err.println("ERREUR !!!!");
			System.err.println(e.getMessage());
		}

	}

	// pour setter le contextPath de la servlet
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		for (String profileName : environment.getActiveProfiles()) {
			System.out.println("Currently active profile - " + profileName);
		}
		return factory -> factory.setContextPath("/catalogue");
	}

	@Override
	public void run(String... args) throws Exception {

		restConfiguration.exposeIdsFor(Produit.class);

		produitRepository.findAll().forEach(produit -> {
			System.out.println(produit);
		});

	}

}
