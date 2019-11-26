package pl.manciak.thymeleaf.service.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.FoodEntities.Quantity;
import pl.manciak.thymeleaf.repository.FoodRepo.QuantityRepository;

import java.util.Optional;

@Service
public class QuantityDataService {

    QuantityRepository quantityRepo;

    @Autowired
    public QuantityDataService(QuantityRepository gramRepo) { this.quantityRepo = gramRepo; }

    public Quantity save (Quantity gram){
        return quantityRepo.save(gram);
    }

    public Optional<Quantity> findLast(){ return quantityRepo.findTopByOrderByIdDesc();}

}
