import db.DBDay;
import db.DBHelper;
import db.DBMeal;
import models.calander.Day;
import models.food.*;
import models.person.Person;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {

        Calendar today = Calendar.getInstance();
        today.set(Calendar.YEAR, 2018);
        today.set(Calendar.MONTH, 5);
        today.set(Calendar.DAY_OF_MONTH, 16);

        Calendar monday = Calendar.getInstance();
        monday.set(Calendar.YEAR, 2018);
        monday.set(Calendar.MONTH, 5);
        monday.set(Calendar.DAY_OF_MONTH, 16);


        Person person = new Person("Chris Marshall", 25, 210, 180);
        DBHelper.save(person);

        Person person2 = new Person("Paul Kelly", 32, 170, 168);
        DBHelper.save(person);

//        Day day2 = new Day(monday, person2);
//        DBHelper.save(day2);

        Day day = new Day(today, person);
        DBHelper.save(day);

        Food food = new Grain("Cheese", 90, 20, 10, 10);
        DBHelper.save(food);

        Food food2 = new Grain("Cheese", 90, 20, 10, 10);
        DBHelper.save(food2);

        Food food3 = new Grain("Rice", 90, 20, 10, 10);
        DBHelper.save(food3);

        Food food4 = new Fruit("Banana", 20, 10, 30, 10);
        DBHelper.save(food4);

        Meal meal2 = new Meal(MealType.DINNER, day);
        DBHelper.save(meal2);

        Meal meal = new Meal(MealType.BREAKFAST, day);
        DBHelper.save(meal);

        Meal meal3 = new Meal(MealType.SNACK, day);
        DBHelper.save(meal3);

        food.setMeal(meal);
        food2.setMeal(meal);
        food3.setMeal(meal2);
        food4.setMeal(meal3);


        DBMeal.addMeal(meal, food);
        DBMeal.addMeal(meal, food2);
        DBMeal.addMeal(meal2, food3);
        DBMeal.addMeal(meal3, food4);


        DBHelper.save(food);
        DBHelper.save(food2);
        DBHelper.save(food3);
        DBHelper.save(food4);

        day.addMeal(meal);
        day.addMeal(meal2);
        day.addMeal(meal3);
//        day2.addMeal(meal3);

        DBHelper.save(day);
//        DBHelper.save(day2);


        List<Day> allDays = DBHelper.getAll(Day.class);


        Meal foundMeal = DBHelper.find(Meal.class, meal.getId());
        List<Meal> allMeals = DBHelper.getAll(Meal.class);
        List<Meal> totalDailyMeals = DBMeal.totalMealsInADay(day);

        int totalDaysCalories = DBMeal.getTotalCalsForDay(day);

        Person foundPerson = DBHelper.find(Person.class, person.getId());

        List<Day> personsDays = DBDay.AllDaysBelongingToAPerson(person);

        List<Meal> foundMeals = DBDay.AllMealsForADay(person);

        List<Food> personTotalDailyFoods = DBDay.foodsForADayFromAPerson(person);
    }
}
