package pl.manciak.thymeleaf.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.Meal;
import pl.manciak.thymeleaf.entity.Product;
import pl.manciak.thymeleaf.entity.Quantity;

import pl.manciak.thymeleaf.payload.MealRestModel;

import pl.manciak.thymeleaf.service.MealDataService;
import pl.manciak.thymeleaf.service.ProductDataService;
import pl.manciak.thymeleaf.service.QuantityDataService;

import java.util.HashMap;
import java.util.Map;

@Service
public class MealManager {

    private ProductDataService productDataService;
    private MealDataService mealDataService;
    private QuantityDataService quantityDataService;


    @Autowired
    public MealManager(ProductDataService productDataService, MealDataService mealDataService, QuantityDataService quantityDataService) {
        this.productDataService = productDataService;
        this.mealDataService = mealDataService;
        this.quantityDataService = quantityDataService;
    }

    public String createMeal(MealRestModel mealRestModel){

        if(mealDataService.findByName(mealRestModel.getName()).isPresent() == false) {

            Map<Product, Quantity> productsWithGrams = new HashMap<>();

            for (HashMap.Entry<String, String> entry : mealRestModel.getMap().entrySet()) {
                Quantity weight = new Quantity();
                weight.setWeight(Float.parseFloat(entry.getValue()));
                quantityDataService.save(weight);

                productsWithGrams.put(
                        productDataService.findById(Long.parseLong(entry.getKey())).get(),
                        quantityDataService.findLast().get()
                );
            }

            Meal meal = new Meal(mealRestModel.getName(), productsWithGrams);
            mealDataService.save(meal);
        }else return "Taki element juz istnieje";

        return mealRestModel.getMap().entrySet().toString();
    }

    public void deleteMealByName(String name) {
        mealDataService.deleteByName(name);
    }

    public Iterable<Meal> getAllMeals(){
        Iterable<Meal> allMeals = mealDataService.findAll();
        return allMeals;
    }

/*    public MealProperties getMealPropertiesById(Long id){
        Map<Product,Quantity> productsFromMeal = mealDataService.findById(id).get().getProductsWithQuantity();
        return countMealProperties(name, productsFromMeal);
    }*/

    public String getMealPropertiesByName(String name){

        Map<Product,Quantity> productsFromMeal = mealDataService.findByName(name).get().getProductsWithQuantity();
        return countMealProperties(name, productsFromMeal);

    }

    public String countMealProperties(String name, Map<Product,Quantity> productsFromMeal){
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
        //return new MealProperties(name, sumCal,sumCarbo,sumProt,sumFat,sumPrice);
        return sumCal+" kcal" +"  "+sumCarbo+" wegli"+"  "+sumProt+"bialka "+sumFat+"tluszczu";
    }



}
