package models.calander;

import models.food.Meal;
import models.person.Person;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "day")
public class Day {
    private int id;
    private Calendar date;
    private List<Meal> meals;
    private Person person;

    public Day(Calendar date, Person person) {
        this.date = date;
        this.meals = new ArrayList<Meal>();
        this.person = person;
    }

    public Day() {
    }

    @Temporal(TemporalType.DATE)
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @OneToMany(mappedBy = "day")
    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
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

    @ManyToOne
    @JoinColumn(name="person_id", nullable = false)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void addMeal(Meal meal){
        this.meals.add(meal);
    }
}
