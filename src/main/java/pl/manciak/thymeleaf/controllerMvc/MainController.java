package pl.manciak.thymeleaf.controllerMvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    private String appMode;

    @RequestMapping("/start")
    public String test(){
        return "start";
    }

}