package pl.manciak.thymeleaf.payload;


import java.util.HashMap;

public class MealRestModel {

    private String name;
    private HashMap<String,String> map;

    public MealRestModel(String name, HashMap<String, String> map) {
        this.name = name;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }
}
