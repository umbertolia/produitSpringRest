package hdn.example.catservice.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages =  "hdn.example.catservice.daomongo")
public class MongoConfig {
}