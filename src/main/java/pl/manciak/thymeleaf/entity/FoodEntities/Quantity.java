package pl.manciak.thymeleaf.entity.FoodEntities;

import javax.persistence.*;

@Entity
@Table(name = "grams")
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Float weight;

    public Quantity(){}

    public Quantity(Float weight) {
        this.weight = weight;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
