package hdn.example.catservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.mysql.cj.util.StringUtils;

import hdn.example.catservice.dao.ProduitRepository;
import hdn.example.catservice.entities.Produit;
import hdn.example.catservice.utils.Utilitaire;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;

	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	@Autowired
	private Environment environment;
	
	@Value( "${application.contextPath}" )
	private String appliContextPath;
	
	private static final Logger logger = LoggerFactory.getLogger(CatServiceApplication.class);


	public static void main(String[] args) {
		try {
			SpringApplication.run(CatServiceApplication.class, args);
		} catch (Throwable e) {
			logger.error("ERREUR de configuration !!!!");
		}
	}

	// pour setter le contextPath de la servlet
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		for (String profileName : environment.getActiveProfiles()) {
			System.out.println("Currently active profile - " + profileName);
		}
		// Change the default value of java.io.tmpdir
		if (Utilitaire.isUnixOs()) {
			System.setProperty("java.io.tmpdir", "/home/aragorn/temp");
		}
		return factory -> factory.setContextPath(!StringUtils.isNullOrEmpty(appliContextPath) ? appliContextPath : "");
	}

	@Override
	public void run(String... args) throws Exception {

		restConfiguration.exposeIdsFor(Produit.class);

		logger.debug("liste des produits...");
		produitRepository.findAll().forEach(produit -> {
			logger.debug(produit.toString());
			System.out.println(produit);
		});

	}

}
