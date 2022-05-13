package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrdersService {

   List<Order> getOrders();
   Optional<Order> getOrderById(Integer id);
   Order saveOrder(Order order);
   void updateOrder(Order order, Integer id);
   void deleteOrder(Integer id);
}
