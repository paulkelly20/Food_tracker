package db;

import models.calander.Day;
import models.food.Food;
import models.food.Meal;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBMeal {
    private static Session session;


    public static int getTotalCalsForDay(Day day){
        int result = 0;
        List<Meal> foundMeals = totalMealsInADay(day);
        for(Meal meal : foundMeals){
         result += totalCals(meal);}
        return result;
    }

    public static List<Meal> totalMealsInADay(Day day) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Meal> result = null;
        try {
            Criteria cr = session.createCriteria(Meal.class);
            cr.add(Restrictions.eq("day", day));
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static Long totalCals(Meal meal) {
        session = HibernateUtil.getSessionFactory().openSession();
        Long result = null;

        try {
            Criteria cr = session.createCriteria(Food.class);
            cr.add(Restrictions.eq("meal", meal));
            cr.add(Restrictions.eq("meal.id", meal.getId()));
            cr.setProjection(Projections.sum("calCount"));
            result = (Long)cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }


    public static void addMeal(Meal meal, Food food) {
        meal.addFood(food);
        DBHelper.save(meal);
    }
}
