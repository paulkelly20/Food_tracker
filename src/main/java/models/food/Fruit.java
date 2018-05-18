package models.food;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fruits")
public class Fruit extends Food{


    public Fruit() {
    }

    public Fruit(String name, int calCount, double protein, double fat, double carbs) {
        super(name, calCount, protein, fat, carbs);
    }



}
