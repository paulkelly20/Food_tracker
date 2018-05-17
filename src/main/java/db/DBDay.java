package db;

import models.calander.Day;
import models.food.Food;
import models.food.Meal;
import models.person.Person;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DBDay {

    private static Session session;

    public static List<Meal> AllMealsForADay(Person person){
        List<Meal> results = new ArrayList<Meal>();
        List<Day> daysResults = AllDaysBelongingToAPerson(person);
        for(Day day : daysResults){
            results.addAll(allMealsForADay(day));

        } return results;
    }

    public static List<Food> foodsForADayFromAPerson(Person person){
        List<Food> foodResult = new ArrayList<Food>();
        List<Meal> result = AllMealsForADay(person);
        for(Meal meal: result){
            foodResult.addAll(allFoodsForADay(meal));

        } return foodResult;
    }

    public static List<Day> AllDaysBelongingToAPerson(Person person) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Day> result = null;
        try {
            Criteria cr = session.createCriteria(Day.class);
            cr.add(Restrictions.eq("person", person));
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }


    public static List<Meal> allMealsForADay(Day day) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Meal> result = null;

        try {
            Criteria cr = session.createCriteria(Meal.class);
            cr.add(Restrictions.eq("day", day));
            cr.add(Restrictions.eq("day.id", day.getId()));

            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }


    public static List<Food> allFoodsForADay(Meal meal) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Food> result = null;

        try {
            Criteria cr = session.createCriteria(Food.class);
            cr.add(Restrictions.eq("meal", meal));
            cr.add(Restrictions.eq("meal.id", meal.getId()));

            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
