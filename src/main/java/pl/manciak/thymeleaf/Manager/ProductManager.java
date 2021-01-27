package pl.manciak.thymeleaf.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.FoodEntities.Product;
import pl.manciak.thymeleaf.service.FoodService.ProductDataService;

import java.util.HashMap;
import java.util.Optional;

@Service
public class ProductManager {

    private ProductDataService productDataService;

    @Autowired
    ProductManager(ProductDataService productDataService) {
        this.productDataService = productDataService;
    }

    public String summarizeProductPropertiesById(HashMap<String,String> productsIdsMap){

        float sumCal = 0F;
        float sumCarbo = 0F;
        float sumProt = 0F;
        float sumFat = 0F;

        for (HashMap.Entry<String,String> entry : productsIdsMap.entrySet()) {

            sumCal += (productDataService.findById(Long.parseLong(entry.getKey()))
                    .map(Product::getCalories).orElse(0F))/100*Integer.parseInt(entry.getValue());
            sumCarbo += (productDataService.findById(Long.parseLong(entry.getKey()))
                    .map(Product::getCarbohydrates).orElse(0F))/100*Integer.parseInt(entry.getValue());
            sumProt += (productDataService.findById(Long.parseLong(entry.getKey()))
                    .map(Product::getProtein).orElse(0F))/100*Integer.parseInt(entry.getValue());
            sumFat += (productDataService.findById(Long.parseLong(entry.getKey()))
                    .map(Product::getFat).orElse(0F))/100*Integer.parseInt(entry.getValue());
        }

        return sumCal+" kcal" +"  "+sumCarbo+" wegli"+"  "+sumProt+"bialka "+sumFat+"tluszczu";
    }

    public Product addProduct(Product product){

        if(!productDataService.findByName(product.getName()).isPresent())
        {
            return productDataService.save(product);
        }
        return product;
    }

    public Iterable<Product> getAllProducts() {
             return productDataService.findAll();
    }

    public Optional<Product> findProductById(Long index) {
        return productDataService.findById(index);
    }

    public Optional<Product> findProductByName(String name) {
        return productDataService.findByName(name);
    }

    public void deleteProductByName(String name) {
        productDataService.deleteByName(name);
    }
}
