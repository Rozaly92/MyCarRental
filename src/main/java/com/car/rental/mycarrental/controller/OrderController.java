package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Employee;
import com.car.rental.mycarrental.entity.Order;
import com.car.rental.mycarrental.exception.InternalServerException;
import com.car.rental.mycarrental.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrdersService ordersService;


    @GetMapping("/orders")
    public ResponseEntity<Object> getOrders() {
        return ResponseEntity.ok().body(ordersService.getOrders());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Object> getOrderById(
            @PathVariable("id") Integer id){
        return ResponseEntity.ok().body(ordersService.getOrderById(id));
    }

    @PostMapping("/orders")
    public ResponseEntity<Object> addNewOrder(@Valid @RequestBody Order order) {
        Order newOrder = ordersService.saveOrder(order);
        try{
            return ResponseEntity
                    .created(new URI(String.format("/orders/%s", newOrder)))
                    .build();
        } catch (URISyntaxException e) {
            throw new InternalServerException("The URI in the Location header in POST /orders has an error");
        }
    }


    @PatchMapping("/orders/{id}")
    public ResponseEntity<Object> updateOrder(@RequestBody Order order,
                                                 @PathVariable("id") Integer id) {
        ordersService.updateOrder(order,id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable("id") Integer id) {
        ordersService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
