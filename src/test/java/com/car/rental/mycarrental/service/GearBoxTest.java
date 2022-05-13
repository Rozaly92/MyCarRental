//package com.car.rental.mycarrental.service;
//
//import com.car.rental.mycarrental.dao.GearBoxRepository;
//import com.car.rental.mycarrental.entity.GearBox;
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
//public class GearBoxTest {
//    @Autowired
//    private GearBoxService gearBoxService;
//
//    @MockBean
//    private GearBoxRepository repo;
//
//
//    private GearBox mockGearBox;
//    private List<GearBox> gearBoxList;
//
//    private static Logger logger = LoggerFactory.getLogger(GearBoxTest.class);
//
//    @BeforeEach
//
//    void init(){
//        logger.info(()->("== Log me BEFORE each test method =="));
//
//        this.mockGearBox = new GearBox(1, "automat");
//
//        List<GearBox> list = Arrays.asList(
//                new GearBox(1, "automat"),
//                new GearBox(2, "manual")
//        );
//
//        gearBoxList = list;
//    }
//
//    @Test
//    @DisplayName("TEST getGearBoxexsWithResult")
//    public void getGearBoxesWithResult(){
//        Mockito.when(repo.findAll()).thenReturn(gearBoxList);
//
//        List<GearBox> returnedList = gearBoxService.getAllGearBoxes();
//
//        Assertions.assertFalse(returnedList.isEmpty(),"");
//        Assertions.assertEquals("automat", returnedList.get(0).getGearBox());
//        Assertions.assertEquals("manual", returnedList.get(1).getGearBox());
//        Assertions.assertEquals(1, returnedList.get(0).getId());
//    }
//
//
//    @Test
//
//    @DisplayName("TEST getGearBoxById Found")
//    void getBodyById_Found(){
//        Mockito.when(repo.existsById(1)).thenReturn(true);
//        Mockito.when(repo.findById(1)).thenReturn(Optional.of(this.mockGearBox));
//
//        Optional<GearBox> returnedGearBox = Optional.ofNullable(gearBoxService.getGearBox(1));
//
//        Assertions.assertEquals(this.mockGearBox, returnedGearBox.get());
//    }
//
//
//    @Test
//    @DisplayName("TEST post gearBox")
//    public void saveGearBox(){
//        Mockito.when(repo.save(this.mockGearBox)).thenReturn(this.mockGearBox);
//
//
//        gearBoxService.saveGearBox(this.mockGearBox);
//        Integer gearBoxId = mockGearBox.getId();
//
//        Assertions.assertEquals(1, gearBoxId);
//    }
//
//    @Test
//    @DisplayName("TEST delete gearBox")
//    public void deleteBodyById(){
//        Mockito.when(repo.existsById(1)).thenReturn(true);
//        Mockito.doNothing().when(repo).deleteById(1);
//
//        gearBoxService.deleteGearBox(1);
//    }
//
//}
