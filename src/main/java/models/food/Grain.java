package models.food;

import models.food.Food;

import javax.persistence.*;

@Entity
@Table(name="grains")
public class Grain extends Food {
    private Meal meal;

    public Grain() {
    }

    public Grain(String name, int calCount, double protein, double fat, double carbs) {
        super(name, calCount, protein, fat, carbs);


    }


    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
