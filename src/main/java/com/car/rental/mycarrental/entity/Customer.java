package com.car.rental.mycarrental.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_id")
    private int cusId;
    @Column(name = "cus_name")
    private String cusName;
    @Column(name = "card_num")
    private int cardNum;
    @Column(name = "phone_num")
    private String phoneNum;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Orders> ordersList;

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public Customer() {
    }

    public Customer(String cusName, int cardNum, String phoneNum) {
        this.cusName = cusName;
        this.cardNum = cardNum;
        this.phoneNum = phoneNum;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusName='" + cusName + '\'' +
                ", cardNum=" + cardNum +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public void addCustomerToOrders(Orders order) {
        if (ordersList == null) {
            ordersList = new ArrayList<>();
        }
        ordersList.add(order);
        order.setCustomer(this);
    }
}