package pl.manciak.thymeleaf.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.UserEntities.RoleName;
import pl.manciak.thymeleaf.entity.UserEntities.Users;
import pl.manciak.thymeleaf.exceptions.ResourceAlreadyExistsException;
import pl.manciak.thymeleaf.exceptions.ResourceNotFoundException;
import pl.manciak.thymeleaf.repository.UserRepo.UserRepository;

import java.util.Collections;
import java.util.List;

import static pl.manciak.thymeleaf.entity.UserEntities.RoleName.*;

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
        if (role.equals(ADMIN))
        {
            return ADMIN;
        }
        else if(role.equals(MOD))
        {
            return MOD;
        }else
        {
            return USER;
        }
    }

    public Users findByEmail(String email) {
        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with email %s does not exists", email)));
        return user;
    }


    public Users findById(Integer userID) {
        Users user = userRepository.findById(userID)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with id %s does not exists", userID)));
        return user;
    }


    public void deleteUser(String email) {
        Users user = findByEmail(email);
        userRepository.deleteById(user.getId());
    }


    public List<Users> findAll() {
        List<Users> users= userRepository.findAll();
        return users;
    }

}
