package pl.manciak.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.Quantity;
import pl.manciak.thymeleaf.repository.QuantityRepository;

import java.util.Optional;

@Service
public class QuantityService  {

    QuantityRepository quantityRepo;

    @Autowired
    public QuantityService(QuantityRepository gramRepo) { this.quantityRepo = gramRepo; }

    public Quantity save (Quantity gram){
        return quantityRepo.save(gram);
    }

    public Optional<Quantity> findLast(){ return quantityRepo.findTopByOrderByIdDesc();}

}
