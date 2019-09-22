package pl.manciak.thymeleaf.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.Product;
import pl.manciak.thymeleaf.service.ProductDataService;

import java.util.HashMap;

@Service
public class ProductManager {

    private ProductDataService productDataService;

    @Autowired
    public ProductManager(ProductDataService productDataService) {
        this.productDataService = productDataService;
    }

    public String summarizeProductPropertiesById(HashMap<String,String> productsIdsMap){

        Float sumCal = 0F;
        Float sumCarbo = 0F;
        Float sumProt = 0F;
        Float sumFat = 0F;

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

    public String addProduct(Product product){

       if( productDataService.findByName(product.getName()).isPresent())
        {
            productDataService.save(product);
        } else return "Taki Produkt już istnieje";

        return product.toString();
    }
}
