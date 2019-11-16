package pl.manciak.thymeleaf.payload;


import java.util.HashMap;

public class MealModel {

    private String nameMeal;
    private HashMap<String,String> mealModel;

    public MealModel() {
    }

    public MealModel(String nameMeal, HashMap<String, String> mealModel) {
        this.nameMeal = nameMeal;
        this.mealModel = mealModel;
    }

    public String getNameMeal() {
        return nameMeal;
    }

    public void setNameMeal(String nameMeal) {
        this.nameMeal = nameMeal;
    }

    public HashMap<String, String> getMealModel() {
        return mealModel;
    }

    public void setMealModel(HashMap<String, String> mealModel) {
        this.mealModel = mealModel;
    }

    @Override
    public String toString() {
        return "MealModel{" +
                "nameMeal='" + nameMeal + '\'' +
                ", mealModel=" + mealModel +
                '}';
    }
}
