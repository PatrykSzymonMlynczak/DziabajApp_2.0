package pl.manciak.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.manciak.thymeleaf.entity.Product;
import pl.manciak.thymeleaf.service.ProductService;


import java.util.List;

@Controller
public class ProductController {

    List<Product> productList;

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/prod")
    public String prod(Model model){

        Iterable<Product> iterable = productService.findAll();
        model.addAttribute("iterable", iterable);

        return "prod";
    }

}
