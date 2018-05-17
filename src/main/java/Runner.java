import db.DBHelper;
import db.DBMeal;
import models.calander.Day;
import models.food.Food;
import models.food.Grain;
import models.food.Meal;
import models.food.MealType;
import models.person.Person;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {

        Calendar today =  Calendar.getInstance();
        today.set(Calendar.YEAR, 2018);
        today.set(Calendar.MONTH, 5);
        today.set(Calendar.DAY_OF_MONTH, 16);


        Person person = new Person("Chris Marshall", 25, 210, 180);
        DBHelper.save(person);

        Day day = new Day(today, person);
        DBHelper.save(day);

        Food food = new Grain("Cheese", 90, 20, 10, 10);

        DBHelper.save(food);

        Food food2 = new Grain("Cheese", 90, 20, 10, 10);
        DBHelper.save(food2);


        Meal meal = new Meal(MealType.BREAKFAST, day);
        DBHelper.save(meal);
        food.setMeal(meal);
        food2.setMeal(meal);

        DBMeal.addMeal(meal, food);
        DBMeal.addMeal(meal, food2);

        DBHelper.save(food);
        DBHelper.save(food2);

        day.addMeal(meal);
        DBHelper.save(day);




        List<Day> allDays = DBHelper.getAll(Day.class);


        Meal foundMeal = DBHelper.find(Meal.class, meal.getId());
        List<Meal> allMeals = DBHelper.getAll(Meal.class);
        List<Meal> totalDailyMeals = DBMeal.totalMealsInADay(day);

        int totalDaysCalories = DBMeal.getTotalCalsForDay(day);

    }
}
