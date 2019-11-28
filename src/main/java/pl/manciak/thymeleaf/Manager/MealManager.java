package pl.manciak.thymeleaf.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.FoodEntities.Meal;
import pl.manciak.thymeleaf.entity.FoodEntities.Product;
import pl.manciak.thymeleaf.entity.FoodEntities.Quantity;

import pl.manciak.thymeleaf.exceptions.ItemAlreadyExistsException;
import pl.manciak.thymeleaf.payload.MealModel;

import pl.manciak.thymeleaf.payload.MealProperties;
import pl.manciak.thymeleaf.service.FoodService.MealDataService;
import pl.manciak.thymeleaf.service.FoodService.ProductDataService;
import pl.manciak.thymeleaf.service.FoodService.QuantityDataService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public String createMeal(MealModel mealModel){


        if(mealDataService.findByName(mealModel.getNameMeal()).isPresent() == false) {

            Map<Product, Quantity> productsWithGrams = new HashMap<>();

            for (HashMap.Entry<String, String> entry : mealModel.getMealModel().entrySet()) {
                Quantity weight = new Quantity();

                 weight.setWeight(Float.parseFloat(entry.getValue()));
                quantityDataService.save(weight);

                productsWithGrams.put(
                        productDataService.findByName(entry.getKey()).get(),
                        quantityDataService.findLast().get()
                );
            }

            Meal meal = new Meal(mealModel.getNameMeal(), productsWithGrams);
            mealDataService.save(meal);
        }else throw new ItemAlreadyExistsException("Taki element juz istnieje");

        return mealModel.getMealModel().entrySet().toString();
    }

    public void deleteMealByName(String name) {
        mealDataService.deleteByName(name);
    }

    public Iterable<Meal> getAllMeals(){
        return mealDataService.findAll();
    }

    public Optional<Meal> getMealByName(String name){
        return mealDataService.findByName(name);
    }

    public MealProperties getMealPropertiesByName(String name){

        Map<Product,Quantity> productsFromMeal = mealDataService.findByName(name).get().getProductsWithQuantity();
        return countMealPropertiesFromMealMap(name, productsFromMeal);
    }

    public String getMealPropertiesByNameString(String name){

        Map<Product,Quantity> productsFromMeal = mealDataService.findByName(name).get().getProductsWithQuantity();
        return countMealPropertiesFromMealMap(name, productsFromMeal).toString();

    }

    public MealProperties countMealPropertiesFromMealMap(String name, Map<Product,Quantity> productsFromMeal){
        float sumCal = 0F;
        float sumCarbo = 0F;
        float sumProt = 0F;
        float sumFat = 0F;
        float sumPrice = 0F;

        for(HashMap.Entry<Product,Quantity> entry: productsFromMeal.entrySet())
        {
            sumCal += entry.getKey().getCalories()*entry.getValue().getWeight()/100;
            sumCarbo += entry.getKey().getCarbohydrates()*entry.getValue().getWeight()/100;
            sumProt += entry.getKey().getProtein()*entry.getValue().getWeight()/100;
            sumFat += entry.getKey().getFat()*entry.getValue().getWeight()/100;

            sumPrice += entry.getKey().getPrice();
        }

        return new MealProperties(name, sumCal, sumCarbo, sumProt, sumFat, sumPrice);
    }

}
