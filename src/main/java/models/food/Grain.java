package models.food;

import models.food.Food;

import javax.persistence.*;

@Entity
@Table(name="grains")
public class Grain extends Food {
    private int id;
    private Meal meal;

    public Grain() {
    }

    public Grain(String name, int calCount, double protein, double fat, double carbs) {
        super(name, calCount, protein, fat, carbs);
        this.meal = null;
    }
}
