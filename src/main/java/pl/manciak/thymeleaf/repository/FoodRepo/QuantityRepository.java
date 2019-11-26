package pl.manciak.thymeleaf.repository.FoodRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.manciak.thymeleaf.entity.FoodEntities.Quantity;

import java.util.Optional;

public interface QuantityRepository extends JpaRepository<Quantity,Long> {
    Optional<Quantity> findTopByOrderByIdDesc();

}
