package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Fuel;
import com.car.rental.mycarrental.service.FuelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class FuelControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FuelService fuelService;

    private Fuel mockFuel;

    private static Logger logger = LoggerFactory.getLogger(FuelControllerTest.class);

    @BeforeEach
    void init(){
        logger.info(() -> ("== Log me BEFORE each test method =="));
        this.mockFuel = new Fuel(1, "diesel");
    }

    @Test
    @DisplayName("GET /fuels WITH RESULTS")
    void getFuelsWithResults() throws Exception {
        List<Fuel> list = Arrays.asList(
                new Fuel(1, "diesel"),
                new Fuel(2, "benzin")
        );
        Mockito.when(fuelService.getAllFuels()).thenReturn(list);


        mockMvc.perform(get("/fuels"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[0].fuel").value(list.get(0).getFuel()));
    }

    @Test
    @DisplayName("GET /fuels WITH NO RESULTS")
    void getFuels_NoResults() throws Exception {
        Mockito.when(fuelService.getAllFuels()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/fuels"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[]"));
    }

    @Test
    @DisplayName("GET /fuels/1 is FOUND")
    void getFuelById_Found() throws Exception {
        Mockito.when(fuelService.getFuel(1)).thenReturn(this.mockFuel);

        mockMvc.perform(get("/fuels/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.fuel").value(mockFuel.getFuel()));
    }

    ////develop
//    @Test
//    @DisplayName("POST /fuels is SUCCESSFUL")
//    void addFuel_Success() throws Exception{
//
//    }

//    //develop
//    @Test
//    @DisplayName("DELETE /fuels/1 is FOUND and DELETED")
//    void deleteBodyById_Found() throws Exception {
//        Mockito.doNothing().when(fuelService).deleteFuel(1);
//
//        mockMvc.perform(delete("/fuels/{id}", 1))
//                .andExpect(status().isNoContent());
//}
}
