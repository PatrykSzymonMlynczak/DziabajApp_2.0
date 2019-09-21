package pl.manciak.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.manciak.thymeleaf.entity.Product;
import pl.manciak.thymeleaf.service.ProductService;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> showAllProducts(){

        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "id/{index}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long index){

        return new ResponseEntity<>(productService.findById(index), HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Optional<Product>> getProductByName(@PathVariable String name){

        return new ResponseEntity<>(productService.findByName(name), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        return new ResponseEntity<>( productService.save(product), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){

        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @DeleteMapping(path ="/{index}")
    public ResponseEntity<?> deleteById(@PathVariable Long index){

        productService.deleteById(index);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/sum")
    @ResponseBody
    public String summarizePropertiesById(@RequestBody HashMap<String,String> map) {
        Float sumCal = 0F;
        Float sumCarbo = 0F;
        Float sumProt = 0F;
        Float sumFat = 0F;

        for (HashMap.Entry<String,String> entry : map.entrySet()) {

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
