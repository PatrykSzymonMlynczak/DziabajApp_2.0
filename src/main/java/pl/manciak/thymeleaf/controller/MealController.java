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
import pl.manciak.thymeleaf.payload.DatePlanted;
import pl.manciak.thymeleaf.payload.MealProperties;
import pl.manciak.thymeleaf.service.MealDataService;

import java.util.*;

@Controller
public class MealController {

    MealDataService mealDataService;

    @Autowired
    public MealController(MealDataService mealDataService,  MealManager mealManager) {
        this.mealDataService = mealDataService;
    }



    @GetMapping("/meal")
    public String meal( Model model){

        Iterable<Meal> mealList = mealDataService.findAll();
        model.addAttribute("mealList", mealList );

        return "meal";
    }

    @GetMapping("/mealProperties")
    public String mealProperties( Model model){

       // model.addAttribute("datePlanted", new String());
        return "mealProperties";
    }

    @PostMapping("/mealProperties-show")
    public String mealPropertiesshow(@ModelAttribute DatePlanted datePlanted, Model model){

        System.out.println(datePlanted.getName());
        /*
        Map<Product, Quantity> productsFromMeal = mealDataService.findByName(datePlanted).get().getProductsWithQuantity();
        Float sumCal = 0F;
        Float sumCarbo = 0F;
        Float sumProt = 0F;
        Float sumFat = 0F;
        Float sumPrice = 0F;

        for(HashMap.Entry<Product,Quantity> entry: productsFromMeal.entrySet())
        {
            sumCal += entry.getKey().getCalories()*entry.getValue().getWeight()/100;
            sumCarbo += entry.getKey().getCarbohydrates()*entry.getValue().getWeight()/100;
            sumProt += entry.getKey().getProtein()*entry.getValue().getWeight()/100;
            sumFat += entry.getKey().getFat()*entry.getValue().getWeight()/100;

            sumPrice += entry.getKey().getPrice();
        }

        model.addAttribute("properties", new MealProperties(datePlanted ,sumCal,sumCarbo,sumProt,sumFat,sumPrice));
        model.addAttribute("name", new MealProperties(datePlanted ,sumCal,sumCarbo,sumProt,sumFat,sumPrice));

        System.out.println(new MealProperties(datePlanted ,sumCal,sumCarbo,sumProt,sumFat,sumPrice));
*/
        return "redirect:/mealProperties";
    }

/*
    @PostMapping("/findMealProperties")
    public String findMealProperties(@ModelAttribute String name, Model model){
        model.addAttribute("properties",mealManager.getMealPropertiesByName(name));

        return "redirect:/meal";
    }*/
}
