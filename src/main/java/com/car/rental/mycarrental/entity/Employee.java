package com.car.rental.mycarrental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empl_id")
    private int cusId;
    @Column(name = "empl_name")
    private String emplName;
    @Column(name = "location")
    private String location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonIgnore
    private List<Order> ordersList;

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    public Employee() {
    }

    public Employee(String emplName, String location) {
        this.emplName = emplName;
        this.location = location;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getEmplName() {
        return emplName;
    }

    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addEmployeeToOrders(Order order) {
        if (ordersList == null) {
            ordersList = new ArrayList<>();
        }
        ordersList.add(order);
        order.setEmployee(this);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emplName='" + emplName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

