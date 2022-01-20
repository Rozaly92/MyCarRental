package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Order;
import com.car.rental.mycarrental.exception_handling.NoSuchFuelException;
import com.car.rental.mycarrental.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrdersService ordersService;


    @GetMapping("/orders")
    public List<Order> showOrders() {
        List<Order> allOrders = ordersService.getAllOrders();
        return allOrders;
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable int id) {
        Order order = ordersService.getOrder(id);
        if (order == null) {
            throw new NoSuchFuelException("There is no order with ID = " + id + " in database");
        }
        return order;
    }

    @PostMapping("/orders")
    public Order addNewOrder(@RequestBody Order order) {
        ordersService.saveOrder(order);
        return order;
    }

    @PutMapping("/orders")
    public Order updateOrder(@RequestBody Order order) {
        ordersService.saveOrder(order);
        return order;
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable int id) {
        Order order = ordersService.getOrder(id);
        if (order == null) {
            throw new NoSuchFuelException("There is no order with ID = " + id + " in database");
        }
        ordersService.deleteOrder(id);
        return "Order with id = " + id + " was deleted!";
    }
}
