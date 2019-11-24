package pl.manciak.thymeleaf.controllerMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.manciak.thymeleaf.Manager.ProductManager;
import pl.manciak.thymeleaf.entity.Product;
import pl.manciak.thymeleaf.validate.CheckEnteredValue;

@Controller
public class ProductController {

    ProductManager productManager;

    @Autowired
    public ProductController(ProductManager productManager) {
        this.productManager = productManager;
    }

    @GetMapping("/productsThy")
    public String prod(Model model){

        model.addAttribute("prods", productManager.getAllProducts());
        model.addAttribute("newProd", new Product());

        return "productsThy";
    }

    @PostMapping("/newProductThy")
    public String addProd(@ModelAttribute Product product){

           productManager.addProduct(product);

        return "redirect:/productsThy";
    }
}
