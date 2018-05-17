package models.food;

import models.calander.Day;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="meals")
public class Meal {
    private int id;
    private List<Food> foods;
    private MealType mealType;
    private Day day;

    public Meal(MealType mealType, Day day) {
        this.foods =  new ArrayList<Food>();
        this.mealType = mealType;
        this.day = day;
    }

    public Meal() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "meal")
    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public int calCountForDay() {
        int calCount = 0;
        for (Food food : this.foods) {
            calCount += food.getCalCount();
        }
        return calCount;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="meal_type")
    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    @ManyToOne
    @JoinColumn(name ="day_id", nullable = false)
    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public void addFood(Food food){
        this.foods.add(food);
    }
}
