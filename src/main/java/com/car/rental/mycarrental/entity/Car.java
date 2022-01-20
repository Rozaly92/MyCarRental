package com.car.rental.mycarrental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "equipment")
    private String equipment;
    @Column(name = "price_per_day")
    private int pricePerDay;
    @Column(name = "year")
    private int year;
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "fuel_id")
    private Fuel fuel;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "gear_id")
    private GearBox gearBox;


    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "body_id")
    private Body body;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonIgnore
    private List<Order> ordersList;

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Car() {
    }

    public Car(String carModel, String equipment, int pricePerDay, int year) {
        this.carModel = carModel;
        this.equipment = equipment;
        this.pricePerDay = pricePerDay;
        this.year = year;
    }

//    public List<Fuel> getFuel() {
//        return fuel;
//    }
//
//    public void setFuel(List<Fuel> fuel) {
//        this.fuel = fuel;
//    }


//    public Fuel getFuel() {
//        return fuel;
//    }
//
//    public void setFuel(Fuel fuel) {
//        this.fuel = fuel;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addCustomerToOrders(Order order) {
        if (ordersList == null) {
            ordersList = new ArrayList<>();
        }
        ordersList.add(order);
        order.setCar(this);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", equipment='" + equipment + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", year=" + year +
                ", fuel=" + fuel +
                ", gearBox=" + gearBox +
                ", body=" + body +
                '}';
    }
}
