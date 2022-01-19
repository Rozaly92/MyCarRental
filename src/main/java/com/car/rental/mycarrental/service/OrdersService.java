package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.entity.Orders;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface OrdersService {
    @Transactional
    List<Orders> getAllOrders();
}
