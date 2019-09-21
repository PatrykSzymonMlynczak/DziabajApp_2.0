package pl.manciak.thymeleaf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.manciak.thymeleaf.entity.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    List<Car> cars;

    public CarController() {
        Car car4 = new Car("VW", "golf");
        Car car1 = new Car("BMW", "e46");
        Car car2 = new Car("mój", "golfik");
        Car car3 = new Car("audi", "a5");

        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
    }

    @GetMapping("/car")
    public ResponseEntity hello(Model model, Car car2){

        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        model.addAttribute("c2", car2);

       // return "car";
        return new ResponseEntity<>("car", HttpStatus.OK);
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car){
        cars.add(car);
        return "redirect:/car";
    }
}
