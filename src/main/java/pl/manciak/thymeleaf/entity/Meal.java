package pl.manciak.thymeleaf.entity;

import javax.persistence.*;
import java.util.Map;


@Entity
@Table(name = "meals")
public  class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long idMeal;

    private String name;

    @OneToMany
    private Map<Product, Quantity> productsWithQuantity;

    public Meal(){}

    public Meal(String name, Map<Product, Quantity> productsWithQuantity) {
        this.name = name;
        this.productsWithQuantity = productsWithQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Product, Quantity> getProductsWithQuantity() {
        return productsWithQuantity;
    }

    public void setProductsWithQuantity(Map<Product, Quantity> productsWithQuantity) {
        this.productsWithQuantity = productsWithQuantity;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "meal_ID=" + idMeal +
                ", name='" + name + '\'' +
                ", productsWithQuantity=" + productsWithQuantity +
                '}';
    }
}

