package pl.manciak.thymeleaf.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.UserEntities.RoleName;
import pl.manciak.thymeleaf.entity.UserEntities.Users;
import pl.manciak.thymeleaf.exceptions.ResourceAlreadyExistsException;
import pl.manciak.thymeleaf.repository.UserRepo.UserRepository;

import java.util.Collections;

import static pl.manciak.thymeleaf.entity.UserEntities.RoleName.ROLE_ADMIN;
import static pl.manciak.thymeleaf.entity.UserEntities.RoleName.ROLE_MOD;

@Service
public class UserDataService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDataService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(Users user, RoleName role) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResourceAlreadyExistsException(String.format("User with email %s already exists", user.getEmail()));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Collections.singleton(setUserRole(role)));
        userRepository.save(user);
    }

    private RoleName setUserRole(RoleName role){
        if (role.equals(ROLE_ADMIN))
        {
            return ROLE_ADMIN;
        }
        else if(role.equals(ROLE_MOD))
        {
            return RoleName.ROLE_MOD;
        }else
        {
            return RoleName.ROLE_USER;
        }
    }
}
