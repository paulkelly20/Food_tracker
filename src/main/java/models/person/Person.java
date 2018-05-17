package models.person;

import models.calander.Day;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="person")
public class Person {
    private int id;
    private String name;
    private int age;
    private double weight;
    private double height;
    private List<Day> days;

    public Person(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public Person() {

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

    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Column
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @OneToMany(mappedBy = "person")
    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }
}
