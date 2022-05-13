package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.OrdersRepository;
import com.car.rental.mycarrental.entity.Order;
import com.car.rental.mycarrental.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;


    @Override
    public List<Order> getOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        if(!ordersRepository.existsById(id))
            throw new NotFoundException(id);
        return ordersRepository.findById(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return ordersRepository.save(order);
    }

    @Override
    public void updateOrder(Order order, Integer id) {
        if(!ordersRepository.existsById(id))
            throw new NotFoundException(id);

        Order current = ordersRepository.getById(id);
        current.updateOrer(order);
        ordersRepository.save(current);
    }

    @Override
    public void deleteOrder(Integer id) {
        if(!ordersRepository.existsById(id))
            throw new NotFoundException(id);
        ordersRepository.deleteById(id);
    }
}

