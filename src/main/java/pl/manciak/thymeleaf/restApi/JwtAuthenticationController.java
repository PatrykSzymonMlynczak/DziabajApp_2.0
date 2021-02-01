package pl.manciak.thymeleaf.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pl.manciak.thymeleaf.entity.UserEntities.User;
import pl.manciak.thymeleaf.payload.JwtRequest;
import pl.manciak.thymeleaf.payload.JwtResponse;
import pl.manciak.thymeleaf.payload.UserData;
import pl.manciak.thymeleaf.security.JwtTokenUtil;
import pl.manciak.thymeleaf.service.UserService.UserDataService;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDataService userDataService;

    @Autowired
    public JwtAuthenticationController(UserDataService userDataService){
        this.userDataService = userDataService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDataService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody UserData user) throws Exception {

        return ResponseEntity.ok(userDataService.save(user));
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}