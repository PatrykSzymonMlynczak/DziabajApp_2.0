package pl.manciak.thymeleaf.repository.FoodRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.manciak.thymeleaf.entity.FoodEntities.Meals;

import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meals, Long> {
    Optional<Meals> findByName(String name);
    void deleteByName(String name);
}
