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
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.util.StringUtils;

import hdn.example.catservice.conf.RepositoriesConfig;
//import hdn.example.catservice.daojpa.ProduitRepository;
import hdn.example.catservice.daomongo.ProduitMongoRepository;
import hdn.example.catservice.entities.Produit;
import hdn.example.catservice.utils.Utilitaire;

@SpringBootApplication
@Import ({RepositoriesConfig.class})
public class CatServiceApplication implements CommandLineRunner {

	/*@Autowired
	private ProduitRepository produitRepository;*/
	
	@Autowired
	ProduitMongoRepository produitMongoRepository;

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
		} 
		catch (Throwable e) {
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
		return factory -> factory.setContextPath(!StringUtils.isEmpty(appliContextPath) ? appliContextPath : "");
	}

	@Override
	public void run(String... args) throws Exception {

		restConfiguration.exposeIdsFor(Produit.class);

		/*if (produitRepository != null) {
			logger.debug("\n*****************************************");
			logger.debug("liste des produits avec JpaRepository...");
			logger.debug("\n*****************************************");
			produitRepository.findAll().forEach(produit -> {
				logger.debug(produit.toString());
				System.out.println(produit);
			});
		}*/
		
		if (produitMongoRepository != null) {
			logger.debug("\n*****************************************");
			logger.debug("liste des produits avec MongoRepository...");
			logger.debug("\n*****************************************\n\n");
			produitMongoRepository.findAll().forEach(produit -> {
				logger.debug(produit.toString());
				System.out.println(produit);
			});
		}
	}

}
