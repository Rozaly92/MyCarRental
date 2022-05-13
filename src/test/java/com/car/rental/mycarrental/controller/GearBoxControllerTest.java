//package com.car.rental.mycarrental.controller;
//
//import com.car.rental.mycarrental.entity.GearBox;
//import com.car.rental.mycarrental.service.GearBoxService;
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
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class GearBoxControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private GearBoxService gearBoxService;
//
//    private GearBox mockGearBox;
//
//    private static Logger logger = LoggerFactory.getLogger(GearBoxControllerTest.class);
//
//    @BeforeEach
//    void init(){
//        logger.info(() -> ("== Log me BEFORE each test method =="));
//        this.mockGearBox = new GearBox(1, "manual");
//    }
//
//    @Test
//    @DisplayName("GET /gearBox WITH RESULTS")
//    void getGearBoxWithResults() throws Exception {
//        List<GearBox> list = Arrays.asList(
//                new GearBox(1, "automat"),
//                new GearBox(2, "manual")
//        );
//        Mockito.when(gearBoxService.getAllGearBoxes()).thenReturn(list);
//
//
//        mockMvc.perform(get("/gearboxes"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.[0].id").value(1))
//                .andExpect(jsonPath("$.[0].gearBox").value(list.get(0).getGearBox()));
//    }
//
//    @Test
//    @DisplayName("GET /gearBox WITH NO RESULTS")
//    void getGearBox_NoResults() throws Exception {
//        Mockito.when(gearBoxService.getAllGearBoxes()).thenReturn(new ArrayList<>());
//
//        mockMvc.perform(get("/gearboxes"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().string("[]"));
//    }
//
//    @Test
//    @DisplayName("GET /gearBox/1 is FOUND")
//    void getGearBoxById_Found() throws Exception {
//        Mockito.when(gearBoxService.getGearBox(1)).thenReturn(this.mockGearBox);
//
//        mockMvc.perform(get("/gearboxes/{id}", 1))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.gearBox").value(mockGearBox.getGearBox()));
//    }
//
//    ////develop
////    @Test
////    @DisplayName("POST /fuels is SUCCESSFUL")
////    void addFuel_Success() throws Exception{
////
////    }
//
////    //develop
////    @Test
////    @DisplayName("DELETE /fuels/1 is FOUND and DELETED")
////    void deleteBodyById_Found() throws Exception {
////        Mockito.doNothing().when(fuelService).deleteFuel(1);
////
////        mockMvc.perform(delete("/fuels/{id}", 1))
////                .andExpect(status().isNoContent());
////}
//}
