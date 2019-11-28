package pl.manciak.thymeleaf.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import pl.manciak.thymeleaf.entity.UserEntities.RoleName;
import pl.manciak.thymeleaf.entity.UserEntities.Users;
import pl.manciak.thymeleaf.repository.UserRepo.UserRepository;

import java.util.Collections;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {

/*  @Bean
    CommandLineRunner commandLineRunner (UserRepository userRepository){
        return strings ->{
                userRepository.save(new Users(1,"sd", "swe","wffwf@gf.sd", "23r2f2", Collections.singleton(RoleName.USER)));
                userRepository.save(new Users(2,"sd", "swe","wffwf@gf.sd", "23r2f2", Collections.singleton(RoleName.USER)));
            };

    }*/
}
