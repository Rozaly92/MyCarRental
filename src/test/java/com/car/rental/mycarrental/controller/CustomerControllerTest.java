package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Customer;
import com.car.rental.mycarrental.service.CustomerService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private Customer customer;

    private Customer mockCustomer;

    private static Logger logger = LoggerFactory.getLogger(CustomerControllerTest.class);

    @BeforeEach
    void init(){
        logger.info(() -> ("== Log me BEFORE each test method =="));
        this.mockCustomer = new Customer(1, "Roza", 4444, "068180194");
    }

    @Test
    @DisplayName("GET /customer WITH RESULTS")
    void getCustomerWithResults() throws Exception {
        List<Customer> list = Arrays.asList(
                new Customer(1, "Roza", 4444, "068180194"),
                new Customer(2, "Ivan", 5555, "068111111")
        );
        Mockito.when(customerService.getAllCustomers()).thenReturn(list);


        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].cusId").value(1))
                .andExpect(jsonPath("$.[0].cusName").value(list.get(0).getCusName()));
    }

    @Test
    @DisplayName("GET /customer WITH NO RESULTS")
    void getCustomer_NoResults() throws Exception {
        Mockito.when(customerService.getAllCustomers()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[]"));
    }

    @Test
    @DisplayName("GET /customer/1 is FOUND")
    void getCustomerById_Found() throws Exception {
        Mockito.when(customerService.getCustomer(1)).thenReturn(this.mockCustomer);

        mockMvc.perform(get("/customers/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.cusId").value(1))
                .andExpect(jsonPath("$.cusName").value(mockCustomer.getCusName()));
    }
}
