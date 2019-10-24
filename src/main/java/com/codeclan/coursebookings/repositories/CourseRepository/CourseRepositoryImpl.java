package com.codeclan.coursebookings.repositories.CourseRepository;

import com.codeclan.coursebookings.models.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> findAllCoursesByCustomer(Long customerId){
        List<Course> result = null;
        Session session  = entityManager.unwrap(Session.class);

        try{
            Criteria criteria = session.createCriteria(Course.class);
            criteria.createAlias("bookings", "bookingsAlias");
            criteria.add(Restrictions.eq("bookingsAlias.customer.id", customerId));
            result = criteria.list();
        }
        catch(HibernateException exception) {
            System.out.println("You broke it, you fool! ヽ(｀Д´)ﾉ");
            exception.printStackTrace();
        }
        return result;
    }
}
