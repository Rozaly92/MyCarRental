//package com.car.rental.mycarrental.service;
//
//
//import com.car.rental.mycarrental.dao.CustomerRepository;
//import com.car.rental.mycarrental.entity.Customer;
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
//public class CustomerServiceTest {
//    @Autowired
//    private CustomerService customerService;
//
//    @MockBean
//    private CustomerRepository repo;
//
//    private Customer mockCustomer;
//    private List<Customer> customerList;
//
//    private static Logger logger= LoggerFactory.getLogger(CustomerServiceTest.class);
//
//    @BeforeEach
//    void init(){
//        logger.info(()->("== Log me BEFORE each test method =="));
//
//        this.mockCustomer = new Customer(1, "Roza", 4432, "068180194");
//
//  List<Customer> list = Arrays.asList(
//          new Customer(1, "Roza", 4432, "068180194"),
//          new Customer(2, "Ivan", 4433,"069999999"),
//          new Customer(3, "Inga",2345,"068111111")
//  );
//  customerList=list;
//    }
//
//    @Test
//    @DisplayName("TEST getCustomersWithResult")
//    void getCustomersWithResult() {
//
//
//        Mockito.when(repo.findAll()).thenReturn(customerList);
//
//        List<Customer> returnedList = customerService.getAllCustomers();
//
//        Assertions.assertFalse(returnedList.isEmpty(),"");
//        Assertions.assertEquals("Roza", returnedList.get(0).getCusName());
//        Assertions.assertEquals("Ivan", returnedList.get(1).getCusName());
//        Assertions.assertEquals("Inga", returnedList.get(2).getCusName());
//        Assertions.assertEquals(2, returnedList.get(1).getCusId());
//    }
//
//
//
//    @Test
//    @DisplayName("TEST getCustomerById Found")
//    void getBodyById_Found() throws Exception {
//        Mockito.when(repo.existsById(1)).thenReturn(true);
//        Mockito.when(repo.findById(1)).thenReturn(Optional.of(this.mockCustomer));
//
//        // Call the service
//        Optional<Customer> returnedBody = Optional.ofNullable(customerService.getCustomer(1));
//
//        // Validate the result
//        Assertions.assertEquals(this.mockCustomer, returnedBody.get());
//
//    }
//
//
//
//    @Test
//    @DisplayName("TEST post customer")
//    void saveCustomer(){
//        Mockito.when(repo.save(this.mockCustomer)).thenReturn(this.mockCustomer);
//
//        customerService.saveCustomer(this.mockCustomer);
//        Integer customerId = mockCustomer.getCusId();
//
//        Assertions.assertEquals(1, customerId);
//    }
//
//
//
//
//
//    @Test
//    @DisplayName("TEST delete customer")
//    public void deleteCustomerById(){
//        Mockito.when(repo.existsById(1)).thenReturn(true);
//        Mockito.doNothing().when(repo).deleteById(1);
//
//        customerService.deleteCustomer(1);
//    }
//
//
//
//
//
//
//
//}
