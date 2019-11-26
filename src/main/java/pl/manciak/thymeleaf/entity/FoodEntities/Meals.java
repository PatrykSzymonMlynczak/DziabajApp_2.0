package pl.manciak.thymeleaf.entity.FoodEntities;

import javax.persistence.*;
import java.util.Map;


@Entity
@Table(name = "meals")
public  class Meals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long idMeal;

    private String name;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Map<Products, Quantity> productsWithQuantity;


    public Meals(){}

    public Meals(String name, Map<Products, Quantity> productsWithQuantity) {
        this.name = name;
        this.productsWithQuantity = productsWithQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Products, Quantity> getProductsWithQuantity() {
        return productsWithQuantity;
    }

    public void setProductsWithQuantity(Map<Products, Quantity> productsWithQuantity) {
        this.productsWithQuantity = productsWithQuantity;
    }

    @Override
    public String toString() {
        return "Meals{" +
                "meal_ID=" + idMeal +
                ", name='" + name + '\'' +
                ", productsWithQuantity=" + productsWithQuantity +
                '}';
    }
}

