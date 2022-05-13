//package com.car.rental.mycarrental.service;
//
//import com.car.rental.mycarrental.dao.FuelRepository;
//import com.car.rental.mycarrental.entity.Fuel;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.platform.commons.logging.Logger;
//import org.junit.platform.commons.logging.LoggerFactory;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//public class FuelServiceTest {
//    @Autowired
//    private FuelService fuelService;
//
//    @MockBean
//    private FuelRepository repo;
//
//    private Fuel mockFuel;
//    private List<Fuel> fuelList;
//
//    private static Logger logger = LoggerFactory.getLogger(FuelServiceTest.class);
//
//
//    @BeforeEach
//    void init(){
//        logger.info(()->("Log me BEFORE each test method =="));
//
//        this.mockFuel = new Fuel(1, "benzin");
//
//        List<Fuel> list= Arrays.asList(
//                new Fuel(1, "benzin"),
//                new Fuel(2, "diesel")
//        );
//        fuelList=list;
//    }
//
//
//    @Test
//    @DisplayName("TEST getFuelsWithResult")
//    public void getFuelsWithResult(){
//
//        Mockito.when(repo.findAll()).thenReturn(fuelList);
//
//        List<Fuel> returnedList = fuelService.getAllFuels();
//
//        Assertions.assertFalse(returnedList.isEmpty(),"");
//        Assertions.assertEquals("benzin", returnedList.get(0).getFuel());
//        Assertions.assertEquals("diesel", returnedList.get(1).getFuel());
//        Assertions.assertEquals(1, returnedList.get(0).getId());
//    }
//
//
//    //failed
//    @Test
//    @DisplayName("TEST getFuelById Found")
//    public void getFuelById_Found() throws Exception{
//        Mockito.when(repo.existsById(1)).thenReturn(true);
//        Mockito.when(repo.findById(1)).thenReturn(Optional.ofNullable(this.mockFuel));
//
//        Optional<Fuel> returnedFuel = Optional.ofNullable(fuelService.getFuel(1));
//
//        Assertions.assertEquals(this.mockFuel, returnedFuel.get());
//    }
//
//
//
//    @Test
//    @DisplayName("TEST post fuel")
//    public void saveFuel(){
//        Mockito.when(repo.save(this.mockFuel)).thenReturn(this.mockFuel);
//
//        fuelService.saveFuel(this.mockFuel);
//        Integer fuelId = mockFuel.getId();
//
//        Assertions.assertEquals(1, fuelId);
//    }
//
//@Test
//    @DisplayName("TEST delete fuel")
//    public void deleteFuelById(){
//        Mockito.when(repo.existsById(1)).thenReturn(true);
//        Mockito.doNothing().when(repo).deleteById(1);
//
//        fuelService.deleteFuel(1);
//}
//
//
//}
