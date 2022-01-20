package com.car.rental.mycarrental.dao;



import com.car.rental.mycarrental.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdersRepository extends JpaRepository<Order, Integer> {

}
