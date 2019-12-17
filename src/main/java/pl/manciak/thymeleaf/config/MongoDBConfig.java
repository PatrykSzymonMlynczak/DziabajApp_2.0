package pl.manciak.thymeleaf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import pl.manciak.thymeleaf.repository.UserRepo.UserRepository;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {

/*  @Beanh
    CommandLineRunner commandLineRunner (UserRepository userRepository){
        return strings ->{
                userRepository.save(new User(1,"sd", "swe","wffwf@gf.sd", "23r2f2", Collections.singleton(RoleName.USER)));
                userRepository.save(new User(2,"sd", "swe","wffwf@gf.sd", "23r2f2", Collections.singleton(RoleName.USER)));
            };

    }*/
}
