package models.food;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name ="foods")
public abstract class Food {
    private int id;
    private String name;
    private int calCount;
    private double protein;
    private double fat;
    private double carbs;
    private Meal meal;

    public Food() {
    }

    public Food(String name, int calCount, double protein, double fat, double carbs) {
        this.name = name;
        this.calCount = calCount;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "cal_count")
    public int getCalCount() {
        return calCount;
    }

    public void setCalCount(int calCount) {
        this.calCount = calCount;
    }


    @Column
    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    @Column
    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @Column
    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    @ManyToOne
    @JoinColumn(name = "meal_id")
    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
