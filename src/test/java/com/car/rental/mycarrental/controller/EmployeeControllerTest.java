//package com.car.rental.mycarrental.controller;
//
//import com.car.rental.mycarrental.entity.Employee;
//import com.car.rental.mycarrental.service.EmployeeService;
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
//public class EmployeeControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EmployeeService employeeService;
//
//    private Employee employee;
//
//    private Employee mockEmployee;
//
//    private static Logger logger = LoggerFactory.getLogger(EmployeeControllerTest.class);
//
//    @BeforeEach
//    void init(){
//        logger.info(() -> ("== Log me BEFORE each test method =="));
//        this.mockEmployee = new Employee(1, "Roza", "Chisinau");
//    }
//
//    @Test
//    @DisplayName("GET /employee WITH RESULTS")
//    void getEmployeeWithResults() throws Exception {
//        List<Employee> list = Arrays.asList(
//                new Employee(1, "Roza", "Chisinau"),
//                new Employee(2, "Ivan", "Chisinau")
//        );
//        Mockito.when(employeeService.getAllEmployees()).thenReturn(list);
//
//
//        mockMvc.perform(get("/employees"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.[0].empId").value(1))
//                .andExpect(jsonPath("$.[0].emplName").value(list.get(0).getEmplName()));
//    }
//
//    @Test
//    @DisplayName("GET /employee WITH NO RESULTS")
//    void getEmployee_NoResults() throws Exception {
//        Mockito.when(employeeService.getAllEmployees()).thenReturn(new ArrayList<>());
//
//        mockMvc.perform(get("/employees"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().string("[]"));
//    }
//
//    @Test
//    @DisplayName("GET /employee/1 is FOUND")
//    void getEmployeeById_Found() throws Exception {
//        Mockito.when(employeeService.getEmployee(1)).thenReturn(this.mockEmployee);
//
//        mockMvc.perform(get("/employees/{id}", 1))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.empId").value(1))
//                .andExpect(jsonPath("$.emplName").value(mockEmployee.getEmplName()));
//    }
//}
