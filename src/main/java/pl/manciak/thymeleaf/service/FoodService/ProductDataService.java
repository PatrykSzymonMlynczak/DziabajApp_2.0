package pl.manciak.thymeleaf.service.FoodService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.FoodEntities.Product;
import pl.manciak.thymeleaf.repository.FoodRepo.ProductRepository;

import java.util.Optional;

@Service
public class ProductDataService {

    private ProductRepository productRepo;

    @Autowired
    public ProductDataService(ProductRepository repo){
        this.productRepo = repo;
    }


    public Optional<Product> findById(long id){
        return productRepo.findById(id);
    }

    public Optional<Product> findByName(String name)
    {
        return productRepo.findByName(name);
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void deleteById(Long id){
        productRepo.deleteById(id);
    }

    public void deleteByName(String name){
        productRepo.deleteByName(name);
    }

    public Product save (Product product){

        return productRepo.save(product);
    }

}
