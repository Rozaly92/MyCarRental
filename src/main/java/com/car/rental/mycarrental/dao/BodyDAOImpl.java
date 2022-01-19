package com.car.rental.mycarrental.dao;

import com.car.rental.mycarrental.entity.Body;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BodyDAOImpl implements BodyDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Body> getAllBodies() {
        Session session = entityManager.unwrap(Session.class);
        List<Body> allBodies = session.createQuery("from Body", Body.class)
                .getResultList();

        return allBodies;
    }

    @Override
    public void saveBody(Body body) {

    }

//    @Override
//    public void saveBody(Body body) {
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(body);
//    }
}
