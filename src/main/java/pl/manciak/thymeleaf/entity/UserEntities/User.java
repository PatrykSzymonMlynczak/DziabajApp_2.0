package pl.manciak.thymeleaf.entity.UserEntities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "users")
public class User {

    @Id
    private String id;
/*

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
*/

    private String username;

    private String password;

/*
    private Set<RoleName> role;
*/

    public User(){}

    public User(String username, String password/*, Set<RoleName> role*/) {

        this.username = username;
        this.password = password;
        /*this.role = role;*/
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


/*
    public Set<RoleName> getRole() {
        return role;
    }

    public void setRole(Set<RoleName> role) {
        this.role = role;
    }*/
}
