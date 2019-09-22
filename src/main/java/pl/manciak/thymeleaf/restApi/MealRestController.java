package pl.manciak.thymeleaf.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.manciak.thymeleaf.entity.Meal;

import pl.manciak.thymeleaf.manager.MealManager;
import pl.manciak.thymeleaf.payload.MealRestModel;


@RestController
@RequestMapping("/meals")
public class MealRestController {

    private MealManager mealManager;

    @Autowired
    public MealRestController(MealManager mealManager) {
        this.mealManager = mealManager;
    }

    @PostMapping()
    public ResponseEntity<String> createMeal(@RequestBody MealRestModel mealRestModel){

        return new ResponseEntity<>(mealManager.createMeal(mealRestModel), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteMelalByName(@PathVariable String name){
        mealManager.deleteMelalByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Iterable<Meal>> showAllMeals(){
        return new ResponseEntity<>( mealManager.getAllMeals(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}/propertiesBy")
    @ResponseBody
    public ResponseEntity<String> showMealPropertiesById(@PathVariable Long id) {
       return new ResponseEntity<>(mealManager.getMealPropertiesById(id), HttpStatus.OK);
    }

    @GetMapping("/{name}/properties")
    @ResponseBody
    public ResponseEntity<String> showMealByName(@PathVariable String name) {
        return new ResponseEntity<>(mealManager.getMealPropertiesByName(name), HttpStatus.OK);

    }


}
