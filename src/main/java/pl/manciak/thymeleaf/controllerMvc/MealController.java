package pl.manciak.thymeleaf.controllerMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.manciak.thymeleaf.Manager.MealManager;
import pl.manciak.thymeleaf.Manager.ProductManager;
import pl.manciak.thymeleaf.entity.FoodEntities.Meal;
import pl.manciak.thymeleaf.payload.MealModel;
import pl.manciak.thymeleaf.payload.NameQuantityModel;
import pl.manciak.thymeleaf.payload.MealProperties;

import java.util.*;

@Controller
public class MealController {

    private MealProperties mealProperties = new MealProperties();
    private HashMap<String, String> newMeal = new HashMap<>();
    private MealModel mealModel = new MealModel();
    private String mealName;

    private MealManager mealManager;
    private ProductManager productManager;

    @Autowired
    public MealController( ProductManager productManager, MealManager mealManager
    ) {
        this.mealManager = mealManager;
        this.productManager = productManager;
    }

    @GetMapping("/mealsThy")
    public String meal(Model model) {

        Iterable<Meal> mealList = mealManager.getAllMeals();
        model.addAttribute("mealList", mealList);
        model.addAttribute("properties", mealProperties);

        return "mealsThy";
    }

    @PostMapping("/mealPropertiesThy")
    public String mealPropertiesShow(@ModelAttribute NameQuantityModel nameQuantityModel) {

        mealProperties = mealManager.getMealPropertiesByName(nameQuantityModel.getMealName());

        return "redirect:/mealsThy";
    }

    @GetMapping("/createMeal")
    public String createMeal(Model model) {

        model.addAttribute("newMealMap", newMeal);
        model.addAttribute("mealName", mealName);

        return "createMeal";
    }

    @PostMapping("/createMealSendRequest")
    public String createMealSendRequest(@ModelAttribute NameQuantityModel nameQuantityModel) {

        mealName = nameQuantityModel.getMealName();

        if (productManager.findProductByName(nameQuantityModel.getProductName()).isEmpty()) {
            return "redirect:/createMeal";
        } else {
            if(! newMeal.containsKey(nameQuantityModel.getProductName()))
            {
                newMeal.putIfAbsent(
                        nameQuantityModel.getProductName(),
                        nameQuantityModel.getProductQuantity().toString());
            }
        }
        return "redirect:/createMeal";
    }

    @PostMapping("/createMealSendCommit")
    public String createMealSend() {

        mealModel.setNameMeal(mealName);
        mealModel.setMealModel(newMeal);
        mealManager.createMeal(mealModel);

        return "redirect:/createMeal";
    }

}
