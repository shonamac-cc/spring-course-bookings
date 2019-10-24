package com.codeclan.coursebookings.repositories.CustomerRepository;

import com.codeclan.coursebookings.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom{
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> findCustomerByCourseIgnoreCase(Long courseId){
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.createAlias("bookings", "bookingsAlias");
            criteria.add(Restrictions.eq("bookingsAlias.course.id",courseId));
            result = criteria.list();
        }
        catch(HibernateException exception) {
            System.out.println("You broke it, you fool! ヽ(｀Д´)ﾉ");
            exception.printStackTrace();
        }
        return result;
    }

    @Transactional
    public List<Customer>findCustomerByTownAndCourseIgnoreCase(String town, Long courseId){
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.add(Restrictions.eq("town", town.toLowerCase()));
            criteria.createAlias("bookings", "bookingsAlias");
            criteria.add(Restrictions.eq("bookingsAlias.course.id", courseId ));
            result = criteria.list();
        }
        catch(HibernateException exception) {
            System.out.println("You broke it, you fool! ヽ(｀Д´)ﾉ");
            exception.printStackTrace();
        }
        return result;

    }

    @Transactional
    public List<Customer> findCustomersOverCertainAgeByTownAndCourseIgnoreCase(int age, String town, Long courseId){
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.add(Restrictions.gt("age", age));
            criteria.add(Restrictions.eq("town", town.toLowerCase()));
            criteria.createAlias("bookings", "bookingsAlias");
            criteria.add(Restrictions.eq("bookingsAlias.course.id", courseId));
            result = criteria.list();
        }
        catch(HibernateException exception) {
            System.out.println("You broke it, you fool! ヽ(｀Д´)ﾉ");
            exception.printStackTrace();
        }
        return result;
    }
}
