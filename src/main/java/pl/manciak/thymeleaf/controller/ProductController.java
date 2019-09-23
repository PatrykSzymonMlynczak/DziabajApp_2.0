package pl.manciak.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.manciak.thymeleaf.entity.Product;
import pl.manciak.thymeleaf.service.ProductDataService;


import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    List<Product> productList;
    ProductDataService productDataService;

    @Autowired
    public ProductController(ProductDataService productDataService) {
        this.productDataService = productDataService;
    }

    @GetMapping("/prod")
    public String prod(Model model){

        model.addAttribute("prods", productDataService.findAll());
        model.addAttribute("newProd", new Product());

        return "prod";
    }

    @PostMapping("/add-prod")
    public String addProd(@Valid @ModelAttribute Product product){

        productDataService.save(product);

        return "redirect:/prod";
    }

}
