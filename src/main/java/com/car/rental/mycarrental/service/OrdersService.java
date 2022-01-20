package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService {

   public  List<Order> getAllOrders();
   public void saveOrder(Order order);
   public Order getOrder(int id);
   public void deleteOrder(int id);
}
