package pl.manciak.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
public class BootController {
    private String appMode;

    @Autowired
    public BootController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/boot")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Ömerrrr");
        model.addAttribute("mode", appMode);

        return "boot";
    }

    @RequestMapping("/test")
    public String test(Model model){
        return "test";
    }
}