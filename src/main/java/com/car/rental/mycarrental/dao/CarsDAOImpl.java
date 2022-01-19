package com.car.rental.mycarrental.dao;

import com.car.rental.mycarrental.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CarsDAOImpl implements CarsDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Car> getAllCars() {
        Session session = entityManager.unwrap(Session.class);
        List<Car> allCars = session.createQuery("from Car", Car.class)
                .getResultList();

        return allCars;
    }

    @Override
    public void saveCars(Car car) {

    }
//
//    @Override
//    public void saveCars(Car car) {
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(car);
//    }
}

