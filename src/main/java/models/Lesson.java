package models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="lessons")
public class Lesson {
    private int id;
    private String title;
    private int classNumber;

    public Lesson(String title, int classNumber) {
        this.title = title;
        this.classNumber = classNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
