package hdn.example.catservice.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Gandalf : Important !!! pour dissocier les packages des repository
 * evite les erreurs de compil du style : The bean 'produitMongoRepository' could not be registered. 
 * ...A bean with that name has already been defined and overriding is disabled
 */
@Configuration
@EnableJpaRepositories(basePackages =  "hdn.example.catservice.daojpa")
public class RepositoriesConfig {

}
