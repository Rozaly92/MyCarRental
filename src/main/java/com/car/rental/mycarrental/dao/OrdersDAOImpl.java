package com.car.rental.mycarrental.dao;

import com.car.rental.mycarrental.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OrdersDAOImpl implements OrdersDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Orders> getAllOrders() {
        Session session = entityManager.unwrap(Session.class);
        List<Orders> allOrders = session.createQuery("from Orders", Orders.class)
                .getResultList();
        return allOrders;
    }
}
