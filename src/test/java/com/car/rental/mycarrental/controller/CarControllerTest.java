//package com.car.rental.mycarrental.controller;
//
//
//import com.car.rental.mycarrental.entity.Body;
//import com.car.rental.mycarrental.entity.Car;
//import com.car.rental.mycarrental.entity.Fuel;
//import com.car.rental.mycarrental.entity.GearBox;
//import com.car.rental.mycarrental.service.CarsService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.platform.commons.logging.Logger;
//import org.junit.platform.commons.logging.LoggerFactory;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CarControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CarsService carsService;
//
//    @MockBean
//    private CarController carController;
//
//    private Car mockCar;
//
//    private static Logger logger= LoggerFactory.getLogger(CarControllerTest.class);
//
//    @BeforeEach
//    void init(){
//        logger.info(()->("== Log me BEFORE each test method =="));
//        this.mockCar = new Car(1, "bmw", "abs",234, 2019,new Fuel(1, "diesel"), new GearBox(1,"manual"),
//                new Body(1, "sedan"));
//    }
//
//    //error
//    @Test
//    @DisplayName("GET /cars WITH RESULT")
//    void getCarsWithResult() throws Exception {
//        List<Car> list = Arrays.asList(
//                new Car(1, "bmw", "abs",234, 2019,new Fuel(1, "diesel"), new GearBox(1,"manual"),
//                        new Body(1, "sedan")),
//                new Car(2, "ford", "abs",254, 2017,new Fuel(2, "diesel"), new GearBox(2,"manual"),
//                        new Body(2, "sedan"))
//        );
//
//        Mockito.when(carsService.getAllCars()).thenReturn(list);
//
//        mockMvc.perform(get("/cars"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.[0].id").value(1))
//                .andExpect(jsonPath("$.[0].equipment").value(list.get(0).getEquipment()));
//
//    }
//
//
//    @Test
//    @DisplayName("GET /cars WITH NO RESULT")
//    void getCars_NoResults() throws Exception {
//        Mockito.when(carsService.getAllCars()).thenReturn(new ArrayList<>());
//
//        mockMvc.perform(get("/cars"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().string("[]"));
//    }
//
//    //error
////    @Test
////    @DisplayName("GET /cars/1 is FOUND")
////    void getCarById_Found() throws Exception {
////        Mockito.when(carsService.getCar(1)).thenReturn(Optional.of(this.mockCar));
////
////        mockMvc.perform(get("/cars/{id}",1))
////                .andExpect(status().isOk())
////                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
////                .andExpect(jsonPath("$.id").value(1));
////                //.andExpect(jsonPath("#.carModel").value(mockCar.getCarModel()));
////    }
//
//
//}
