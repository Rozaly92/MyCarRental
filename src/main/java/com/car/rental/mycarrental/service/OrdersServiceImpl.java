package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.OrdersDAO;
import com.car.rental.mycarrental.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDAO ordersDAO;

    @Override
    @Transactional
    public List<Orders> getAllOrders() {
        return ordersDAO.getAllOrders();
    }
}
