package pl.manciak.thymeleaf.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.thymeleaf.entity.Product;
import pl.manciak.thymeleaf.service.ProductService;

import java.util.HashMap;

@Service
public class ProductManager {

    private ProductService productService;

    @Autowired
    public ProductManager(ProductService productService) {
        this.productService = productService;
    }

    public String summarizeProductPropertiesById(HashMap<String,String> productsIdsMap){

        Float sumCal = 0F;
        Float sumCarbo = 0F;
        Float sumProt = 0F;
        Float sumFat = 0F;

        for (HashMap.Entry<String,String> entry : productsIdsMap.entrySet()) {

            sumCal += (productService.findById(Long.parseLong(entry.getKey()))
                    .map(Product::getCalories).orElse(0F))/100*Integer.parseInt(entry.getValue());
            sumCarbo += (productService.findById(Long.parseLong(entry.getKey()))
                    .map(Product::getCarbohydrates).orElse(0F))/100*Integer.parseInt(entry.getValue());
            sumProt += (productService.findById(Long.parseLong(entry.getKey()))
                    .map(Product::getProtein).orElse(0F))/100*Integer.parseInt(entry.getValue());
            sumFat += (productService.findById(Long.parseLong(entry.getKey()))
                    .map(Product::getFat).orElse(0F))/100*Integer.parseInt(entry.getValue());
        }

        return sumCal+" kcal" +"  "+sumCarbo+" wegli"+"  "+sumProt+"bialka "+sumFat+"tluszczu";
    }
}
