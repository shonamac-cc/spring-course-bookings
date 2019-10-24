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
    public List<Customer> findCustomerByCourse(Long courseId){
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
}
