package pl.manciak.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.manciak.thymeleaf.entity.Meal;
import pl.manciak.thymeleaf.entity.Product;
import pl.manciak.thymeleaf.entity.Quantity;
import pl.manciak.thymeleaf.manager.MealManager;
import pl.manciak.thymeleaf.payload.MealProperties;
import pl.manciak.thymeleaf.service.MealDataService;

import javax.swing.*;
import javax.validation.Valid;
import java.util.*;

@Controller
public class MealController {

    MealDataService mealDataService;
    MealManager mealManager;


    @Autowired
    public MealController(MealDataService mealDataService,  MealManager mealManager) {
        this.mealDataService = mealDataService;
    }

    @GetMapping("/meal")
    public String meal(@ModelAttribute Optional<String> name, Model model){

        Iterable<Meal> mealList = mealDataService.findAll();
        model.addAttribute("mealList", mealList );
        Optional<MealProperties> mealProperties = mealManager.getMealPropertiesByName("Placek1");

       // model.addAttribute("properties", mealManager.getMealPropertiesByName("Placek1"));
       /*if(name.isPresent()){
           String toSend = name.get();

        }*/

        return "meal";
    }

/*
    @PostMapping("/findMealProperties")
    public String findMealProperties(@ModelAttribute String name, Model model){
        model.addAttribute("properties",mealManager.getMealPropertiesByName(name));

        return "redirect:/meal";
    }*/
}
