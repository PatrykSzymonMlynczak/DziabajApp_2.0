package pl.manciak.thymeleaf.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.UserEntities.RoleName;
import pl.manciak.thymeleaf.entity.UserEntities.User;
import pl.manciak.thymeleaf.exceptions.ResourceAlreadyExistsException;
import pl.manciak.thymeleaf.payload.UserData;
import pl.manciak.thymeleaf.repository.UserRepo.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static pl.manciak.thymeleaf.entity.UserEntities.RoleName.*;

@Service
public class UserDataService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(email);

        if(user == null){
            throw new UsernameNotFoundException(String.format("User with email : %s not found", email));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>());
    }

    public User save(UserData user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new ResourceAlreadyExistsException(String.format("User with email %s already exists", user.getUsername()));
        }
        return userRepository.save(
                new User(
                    user.getUsername(),
                    passwordEncoder.encode(user.getPassword()),
                    Collections.singleton(setUserRole(USER))
                )
        );
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


    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

}
