package pl.manciak.thymeleaf.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.manciak.thymeleaf.entity.Product;
import pl.manciak.thymeleaf.manager.ProductManager;
import pl.manciak.thymeleaf.service.ProductService;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private ProductService productService;
    private ProductManager productManager;

    @Autowired
    public ProductRestController(ProductService productService, ProductManager productManager) {
        this.productService = productService;
        this.productManager = productManager;
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


    @Transactional
    @DeleteMapping(path ="/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByName(@PathVariable String name){

           productService.deleteByName(name);
    }

    @PostMapping("/sum")
    @ResponseBody
    public ResponseEntity<String> summarizePropertiesById(@RequestBody HashMap<String,String> productsIdsMap) {

        return new ResponseEntity<>(productManager.summarizeProductPropertiesById(productsIdsMap), HttpStatus.OK);
    }
}
