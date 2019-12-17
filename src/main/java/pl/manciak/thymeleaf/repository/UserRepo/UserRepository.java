package pl.manciak.thymeleaf.repository.UserRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.manciak.thymeleaf.entity.UserEntities.User;


public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
    Boolean existsByUsername(String username);
}

