package pl.manciak.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Siemano {

    @GetMapping("/hello")
    public String hello(Model model){

        Car car = new Car("VW", "golf");

        model.addAttribute("name", "Patryk");
        model.addAttribute("car", car);

        return "hello";
    }
}
