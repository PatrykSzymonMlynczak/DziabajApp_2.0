package pl.manciak.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BootController {
    private String appMode;

    @Autowired
    public BootController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }


    @RequestMapping("/start")
    public String test(Model model){


        return "start";
    }
}