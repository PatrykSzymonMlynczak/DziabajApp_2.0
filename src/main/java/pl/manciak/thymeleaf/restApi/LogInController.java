package pl.manciak.thymeleaf.restApi;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.manciak.thymeleaf.entity.UserEntities.Users;

import java.util.Date;

@RestController
@RequestMapping("/jwt")
public class LogInController {

    @PostMapping("/login")
    public String login(@RequestBody Users user){

        long currentTimeMilis = System.currentTimeMillis();
        return Jwts.builder()
                    .setSubject(user.getEmail())
                    .claim("roles", "USER")
                    .setIssuedAt(new Date(currentTimeMilis))
                    .setExpiration(new Date(currentTimeMilis + 50000))
                    .signWith(SignatureAlgorithm.HS512, user.getPassword())
                    .compact();
    }

}
