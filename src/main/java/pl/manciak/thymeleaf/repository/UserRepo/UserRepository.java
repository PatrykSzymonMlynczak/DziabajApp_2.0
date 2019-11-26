package pl.manciak.thymeleaf.repository.UserRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.manciak.thymeleaf.entity.UserEntities.Users;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);
    Optional<Users> findByLastName(String lastName);
    Boolean existsByEmail(String email);
    List<Users> deleteByEmailLike(String email);
}

