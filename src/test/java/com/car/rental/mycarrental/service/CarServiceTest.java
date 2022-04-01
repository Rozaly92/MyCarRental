package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.CarRepository;
import com.car.rental.mycarrental.entity.Body;
import com.car.rental.mycarrental.entity.Car;
import com.car.rental.mycarrental.entity.Fuel;
import com.car.rental.mycarrental.entity.GearBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CarServiceTest {
    @Autowired
    private CarsService carsService;

    @MockBean
    private CarRepository repo;

    private Car mockCar;
    private List<Car> carList;

    private static Logger logger= LoggerFactory.getLogger(CarServiceTest.class);

    @BeforeEach
    void init(){
        logger.info(()->("== Log me BEFORE each test method =="));

        this.mockCar= new Car(1, "bmw", "abs",234, 2019,new Fuel(1, "diesel"), new GearBox(1,"manual"),
                new Body(1, "sedan"));



        List<Car> list = Arrays.asList(
                new Car(1, "bmw", "abs",234, 2019,new Fuel(1, "diesel"), new GearBox(1,"manual"),
                        new Body(1, "sedan")),
                new Car(2, "ford", "abs",254, 2017,new Fuel(2, "diesel"), new GearBox(2,"manual"),
                        new Body(2, "sedan"))
        );
        carList=list;
    }

    @Test
    @DisplayName("TEST getCarsWithResult")
    void getCarsWithResult() {


        Mockito.when(repo.findAll()).thenReturn(carList);

        List<Car> returnedList = carsService.getAllCars();

        Assertions.assertFalse(returnedList.isEmpty(),"");
        Assertions.assertEquals("bmw", returnedList.get(0).getCarModel());
        Assertions.assertEquals("ford", returnedList.get(1).getCarModel());
        Assertions.assertEquals(2, returnedList.get(1).getId());
    }



    @Test
    @DisplayName("TEST getCarById Found")
    void getCarById_Found() throws Exception {
        Mockito.when(repo.existsById(1)).thenReturn(true);
        Mockito.when(repo.findById(1)).thenReturn(Optional.of(this.mockCar));

        // Call the service
        Optional<Car> returnedBody = Optional.ofNullable(carsService.getCar(1));

        // Validate the result
        Assertions.assertEquals(this.mockCar, returnedBody.get());

    }



    @Test
    @DisplayName("TEST post car")
    void saveCar(){
        Mockito.when(repo.save(this.mockCar)).thenReturn(this.mockCar);

        carsService.saveCar(this.mockCar);
        Integer carId = mockCar.getId();

        Assertions.assertEquals(1, carId);
    }



    @Test
    @DisplayName("TEST delete car")
    public void deleteCarById(){
        Mockito.when(repo.existsById(1)).thenReturn(true);
        Mockito.doNothing().when(repo).deleteById(1);

        carsService.deleteCar(1);
    }
}
