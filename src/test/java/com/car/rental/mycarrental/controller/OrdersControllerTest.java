package com.car.rental.mycarrental.controller;

import com.car.rental.mycarrental.entity.Order;
import com.car.rental.mycarrental.service.OrdersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class OrdersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrdersService ordersService;

    private Order mockOrder;

    private static Logger logger= LoggerFactory.getLogger(OrdersControllerTest.class);

    @BeforeEach
    void init(){
        logger.info(()->("== Log me BEFORE each test method =="));
        this.mockOrder = new Order();
    }





}
