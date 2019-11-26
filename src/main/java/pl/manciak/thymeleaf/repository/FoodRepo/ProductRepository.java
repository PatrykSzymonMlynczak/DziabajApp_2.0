package pl.manciak.thymeleaf.repository.FoodRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.manciak.thymeleaf.entity.FoodEntities.Products;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    Optional<Products> findByName(String name);

    void deleteByName(String name);
}
