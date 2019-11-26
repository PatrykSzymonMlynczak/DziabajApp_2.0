package pl.manciak.thymeleaf.service.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.FoodEntities.Meals;
import pl.manciak.thymeleaf.repository.FoodRepo.MealRepository;


import java.util.Optional;

@Service
public class MealDataService {

    private MealRepository mealRepo;

    @Autowired
    MealDataService(MealRepository mealRepo){
        this.mealRepo = mealRepo;
    }

    public Optional<Meals> findByName(String name){ return mealRepo.findByName(name);}

    public Iterable<Meals> findAll(){return mealRepo.findAll();}

    public void deleteById(Long id){
        mealRepo.deleteById(id);
    }

    public void deleteByName(String name){
        mealRepo.deleteByName(name);
    }

    public Meals save (Meals meal){
        return mealRepo.save(meal);
    }



}
