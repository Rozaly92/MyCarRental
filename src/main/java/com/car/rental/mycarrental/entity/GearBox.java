package com.car.rental.mycarrental.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gearbox")
public class GearBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gear_id")
    private int id;
    @Column(name = "gear_box")
    private String gearBox;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gearBox")
    private List<Car> carsList;

    public GearBox() {
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<Car> carsList) {
        this.carsList = carsList;
    }

    public GearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public void addGearBoxToCars(Car car) {
        if (carsList == null) {
            carsList = new ArrayList<>();
        }
        carsList.add(car);
        car.setGearBox(this);
    }

    @Override
    public String toString() {
        return gearBox;
    }
}
