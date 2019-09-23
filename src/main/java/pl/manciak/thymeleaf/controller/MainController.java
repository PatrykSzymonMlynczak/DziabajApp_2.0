package pl.manciak.thymeleaf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    private String appMode;

    @RequestMapping("/start")
    public String test(Model model){

        return "start";
    }

}