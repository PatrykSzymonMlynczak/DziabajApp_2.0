package pl.manciak.thymeleaf.repository.FoodRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.manciak.thymeleaf.entity.FoodEntities.Meal;

import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    Optional<Meal> findByName(String name);
    void deleteByName(String name);
}
