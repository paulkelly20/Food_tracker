import db.DBDay;
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

        Calendar today = Calendar.getInstance();
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

        Food food3 = new Grain("Rice", 90, 20, 10, 10);
        DBHelper.save(food3);


        Meal meal2 = new Meal(MealType.DINNER, day);
        DBHelper.save(meal2);
        Meal meal = new Meal(MealType.BREAKFAST, day);
        DBHelper.save(meal);
        food.setMeal(meal);
        food2.setMeal(meal);
        food3.setMeal(meal2);


        DBMeal.addMeal(meal, food);
        DBMeal.addMeal(meal, food2);
        DBMeal.addMeal(meal2, food3);

        DBHelper.save(food);
        DBHelper.save(food2);
        DBHelper.save(food3);

        day.addMeal(meal);
        day.addMeal(meal2);

        DBHelper.save(day);


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
