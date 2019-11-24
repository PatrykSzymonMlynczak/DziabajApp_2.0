package pl.manciak.thymeleaf.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.manciak.thymeleaf.entity.Product;
import pl.manciak.thymeleaf.Manager.ProductManager;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private ProductManager productManager;

    @Autowired
    public ProductRestController(ProductManager productManager) {
        this.productManager = productManager;
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> showAllProducts(){

        return new ResponseEntity<>(productManager.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(path = "id/{index}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long index){

        return new ResponseEntity<>(productManager.findProductById(index), HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")//B/Y////N/A/M/E
    public ResponseEntity<Optional<Product>> getProductByName(@PathVariable String name){

        return new ResponseEntity<>(productManager.findProductByName(name), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){

        return new ResponseEntity<>( productManager.addProduct(product), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(path ="/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByName(@PathVariable String name){

        productManager.deleteProductByName(name);
    }

    @PostMapping("/sum")
    @ResponseBody
    public ResponseEntity<String> summarizePropertiesById(@RequestBody HashMap<String,String> productsIdsMap) {

        return new ResponseEntity<>(productManager.summarizeProductPropertiesById(productsIdsMap), HttpStatus.OK);
    }
}
