package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.OrdersRepository;
import com.car.rental.mycarrental.entity.*;
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
public class OrdersServiceTest {
    @Autowired
    private OrdersService ordersService;

    @MockBean
    private OrdersRepository repo;

    private Order mockOrder;
    private List<Order> orderList;

    private static Logger logger= LoggerFactory.getLogger(OrdersServiceTest.class);

    @BeforeEach
    void init(){
        logger.info(()->("== Log me BEFORE each test method =="));

        this.mockOrder= new Order(1, "2", new Customer(1, "Roza",4444,"068180194"),
        new Employee(1, "Ivan", "Chisinau"),
        new Car(1, "bmw", "abs", 250, 2019, new Fuel(1, "diesel"), new GearBox(1, "manual"),
                new Body(1, "sedan")));



        List<Order> list = Arrays.asList(
                new Order(1, "2", new Customer(1, "Roza",4444,"068180194"),
                        new Employee(1, "Ivan", "Chisinau"),
                        new Car(1, "bmw", "abs", 250, 2019, new Fuel(1, "diesel"), new GearBox(1, "manual"),
                                new Body(1, "sedan"))),

                new Order(1, "4", new Customer(2, "Tamara",4444,"067687404"),
                        new Employee(2, "Sergiu", "Chisinau"),
                        new Car(2, "ford", "abs", 250, 2019, new Fuel(2, "benzin"), new GearBox(2, "automat"),
                                new Body(1, "hetchback")))

        );
        orderList=list;
    }

    @Test
    @DisplayName("TEST getOrdersWithResult")
    void getOrdersWithResult() {


        Mockito.when(repo.findAll()).thenReturn(orderList);

        List<Order> returnedList = ordersService.getAllOrders();

        Assertions.assertFalse(returnedList.isEmpty(),"");
        Assertions.assertEquals("2", returnedList.get(0).getArendTime());
        Assertions.assertEquals(1, returnedList.get(0).getId());
    }



    @Test
    @DisplayName("TEST getOrderById Found")
    void getOrderById_Found() throws Exception {
        Mockito.when(repo.existsById(1)).thenReturn(true);
        Mockito.when(repo.findById(1)).thenReturn(Optional.of(this.mockOrder));

        // Call the service
        Optional<Order> returnedBody = Optional.ofNullable(ordersService.getOrder(1));

        // Validate the result
        Assertions.assertEquals(this.mockOrder, returnedBody.get());

    }



    @Test
    @DisplayName("TEST post order")
    void saveOrder(){
        Mockito.when(repo.save(this.mockOrder)).thenReturn(this.mockOrder);

        ordersService.saveOrder(this.mockOrder);
        Integer orderId = mockOrder.getId();

        Assertions.assertEquals(1, orderId);
    }



    @Test
    @DisplayName("TEST delete order")
    public void deleteOrderById(){
        Mockito.when(repo.existsById(1)).thenReturn(true);
        Mockito.doNothing().when(repo).deleteById(1);
        ordersService.deleteOrder(1);
    }
}
