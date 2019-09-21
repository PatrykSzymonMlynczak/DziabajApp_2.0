package pl.manciak.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.manciak.thymeleaf.entity.Meal;

import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>, CrudRepository<Meal, Long> {
    Optional<Meal> findByName(String name);

}