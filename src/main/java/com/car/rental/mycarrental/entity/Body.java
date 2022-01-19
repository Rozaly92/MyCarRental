package com.car.rental.mycarrental.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "body")
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "body_id")
    private int id;
    @Column(name = "body")
    private String body;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuel")
    private List<Car> carsList;

    public List<Car> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<Car> carsList) {
        this.carsList = carsList;
    }

    public Body() {
    }

    public Body(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return body;
    }

    public void addBodyToCars(Car car) {
        if (carsList == null) {
            carsList = new ArrayList<>();
        }
        carsList.add(car);
        car.setBody(this);
    }
}
