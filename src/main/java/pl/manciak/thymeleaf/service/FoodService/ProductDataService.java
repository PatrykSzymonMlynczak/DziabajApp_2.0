package pl.manciak.thymeleaf.service.FoodService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.FoodEntities.Products;
import pl.manciak.thymeleaf.repository.FoodRepo.ProductRepository;

import java.util.Optional;

@Service
public class ProductDataService {

    private ProductRepository productRepo;

    @Autowired
    public ProductDataService(ProductRepository repo){
        this.productRepo = repo;
    }


    public Optional<Products> findById(long id){
        return productRepo.findById(id);
    }

    public Optional<Products> findByName(String name)
    {
        return productRepo.findByName(name);
    }

    public Iterable<Products> findAll(){
        return productRepo.findAll();
    }

    public void deleteById(Long id){
        productRepo.deleteById(id);
    }

    public void deleteByName(String name){
        productRepo.deleteByName(name);
    }

    public Products save (Products product){

        return productRepo.save(product);
    }

}
