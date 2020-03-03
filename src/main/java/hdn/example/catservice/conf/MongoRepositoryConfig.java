package hdn.example.catservice.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Gandalf : Important !!! pour dissocier avec le package de JpaRepository
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = {"hdn.example.catservice.daomongo"})
public class MongoRepositoryConfig {

}
