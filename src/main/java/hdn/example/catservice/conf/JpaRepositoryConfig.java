package hdn.example.catservice.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Gandalf : Important !!! pour dissocier avec le package de MongoRepository
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = {"hdn.example.catservice.daojpa"})
public class JpaRepositoryConfig {

}
