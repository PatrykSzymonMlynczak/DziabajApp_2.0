package pl.manciak.thymeleaf.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.manciak.thymeleaf.entity.FoodEntities.Meal;

import pl.manciak.thymeleaf.Manager.MealManager;
import pl.manciak.thymeleaf.payload.MealModel;

@RestController
@RequestMapping("/meals")
public class MealRestController {

    private MealManager mealManager;

    @Autowired
    public MealRestController(MealManager mealManager) {
        this.mealManager = mealManager;
    }

    @PostMapping()
    public ResponseEntity<String> createMeal(@RequestBody MealModel mealModel){

        return new ResponseEntity<>(mealManager.createMeal(mealModel), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(path ="/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMelalByName(@PathVariable String name){
        mealManager.deleteMealByName(name);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Iterable<Meal>> showAllMeals(){
        return new ResponseEntity<>( mealManager.getAllMeals(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @ResponseBody
    public ResponseEntity<String> showMealByName(@PathVariable String name) {
        return new ResponseEntity<>(mealManager.getMealPropertiesByNameString(name), HttpStatus.OK);

    }


}
