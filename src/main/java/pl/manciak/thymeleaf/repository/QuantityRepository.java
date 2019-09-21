package pl.manciak.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.manciak.thymeleaf.entity.Quantity;

import java.util.Optional;

public interface QuantityRepository extends JpaRepository<Quantity,Long> {
    Optional<Quantity> findTopByOrderByIdDesc();

}
