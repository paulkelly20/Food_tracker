import db.DBHelper;
import models.Course;
import models.Student;

public class Runner {

    public static void main(String[] args) {
        Course courseOne;
        Course courseTwo;
        Student studentOne;
        Student studentTwo;

        courseOne = new Course("Baking 101", "PHD");
        courseTwo = new Course("Rocket Science", "Master");
        DBHelper.save(courseOne);
        DBHelper.save(courseTwo);

        studentOne = new Student("Chris Marshall", 25, 23781, courseOne);
        studentTwo = new Student("Toby Harris", 20,38472, courseTwo);
        DBHelper.save(studentOne);
        DBHelper.save(studentTwo);

    }
}
