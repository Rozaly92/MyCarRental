package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.OrdersRepository;
import com.car.rental.mycarrental.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;


    @Override
    public List<Order> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
 ordersRepository.save(order);
    }

    @Override
    public Order getOrder(int id) {
        Order order = null;
        Optional<Order> newOrder = ordersRepository.findById(id);
        if(newOrder.isPresent()){
            order = newOrder.get();
        }
        return order;
    }

    @Override
    public void deleteOrder(int id) {
ordersRepository.deleteById(id);
    }
}

