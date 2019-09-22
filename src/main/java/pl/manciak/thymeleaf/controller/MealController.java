package pl.manciak.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.manciak.thymeleaf.service.MealDataService;

@Controller
public class MealController {

    MealDataService mealDataService;

    @Autowired
    public MealController(MealDataService mealDataService) {
        this.mealDataService = mealDataService;
    }

    @GetMapping("/meal")
    public String meal(){
        return "meal";
    }
}
