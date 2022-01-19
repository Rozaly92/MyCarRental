package com.car.rental.mycarrental.dao;

import com.car.rental.mycarrental.entity.Fuel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FuelDAOImpl implements FuelDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Fuel> getAllFuels() {
        Session session = entityManager.unwrap(Session.class);
        List<Fuel> allFuels = session.createQuery("from Fuel", Fuel.class)
               .getResultList();

        return allFuels;
    }

    @Override
    public void saveFuel(Fuel fuel) {
        Session session = entityManager.unwrap(Session.class);
      session.saveOrUpdate(fuel);
    }
}
