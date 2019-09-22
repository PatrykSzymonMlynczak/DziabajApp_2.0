package pl.manciak.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.manciak.thymeleaf.entity.Meal;
import pl.manciak.thymeleaf.repository.MealRepository;

import java.util.Optional;

@Service
public class MealDataService {

    private MealRepository mealRepo;

    @Autowired
    MealDataService(MealRepository mealRepo){
        this.mealRepo = mealRepo;
    }

    public Optional<Meal> findById(Long id){ return mealRepo.findById(id);}

    public Optional<Meal> findByName(String name){ return mealRepo.findByName(name);}

    public Iterable<Meal> findAll(){return mealRepo.findAll();}

    public void deleteById(Long id){
        mealRepo.deleteById(id);
    }

    public void deleteByName(String name){
        mealRepo.deleteByName(name);
    }

    public Meal save (Meal meal){
        return mealRepo.save(meal);
    }


}
