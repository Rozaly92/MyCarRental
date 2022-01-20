package com.car.rental.mycarrental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fuel")
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fuel_id")
    private int id;
    @Column(name = "fuel")
    private String fuel;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuel")
    @JsonIgnore
    private List<Car> carsList;

    public Fuel() {
    }

    public Fuel(String fuel) {
        this.fuel = fuel;
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<Car> carsList) {
        this.carsList = carsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }


    public void addFuelToCars(Car car) {
        if (carsList == null) {
            carsList = new ArrayList<>();
        }
        carsList.add(car);
        car.setFuel(this);
    }

    @Override
    public String toString() {
        return fuel;

    }
}
