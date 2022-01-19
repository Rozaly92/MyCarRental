package com.car.rental.mycarrental.dao;

import com.car.rental.mycarrental.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private EntityManager entityManager;

    @Override

    public List<Customer> getAllCustomers() {
        Session session = entityManager.unwrap(Session.class);
        List<Customer> allCustomers = session.createQuery("from Customer", Customer.class)
                .getResultList();
        return allCustomers;

    }

}
