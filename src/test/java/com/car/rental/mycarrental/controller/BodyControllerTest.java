//package com.car.rental.mycarrental.controller;
//
//import com.car.rental.mycarrental.entity.Body;
//import com.car.rental.mycarrental.service.BodyService;
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
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class BodyControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BodyService bodyService;
//
//    @MockBean
//    private BodyController bodyController;
//
//    private Body mockBody;
//
//    private static Logger logger= LoggerFactory.getLogger(BodyControllerTest.class);
//
//    @BeforeEach
//    void init(){
//        logger.info(() -> ("== Log me BEFORE each test method =="));
//        this.mockBody = new Body(1, "sedan");
//    }
//
//    @Test
//    @DisplayName("GET /bodies WITH RESULTS")
//    void getBodiesWithResults() throws Exception {
//        List<Body> list = Arrays.asList(
//                new Body(1, "hatcback"),
//                new Body(2, "minivan"),
//                new Body(3, "limuzin"),
//                new Body(4, "cabriolet")
//        );
//        Mockito.when(bodyService.getAllBodies()).thenReturn(list);
//
//        mockMvc.perform(get("/bodies"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.[0].id").value(1))
//                .andExpect(jsonPath("$.[0].body").value(list.get(0).getBody()));
//    }
//
//    @Test
//    @DisplayName("GET /bodies WITH NO RESULTS")
//    void getBodies_NoResults() throws Exception {
//        Mockito.when(bodyService.getAllBodies()).thenReturn(new ArrayList<>());
//
//        mockMvc.perform(get("/bodies"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().string("[]"));
//    }
//
//@Test
//    @DisplayName("GET /bodies/1 is FOUND")
//    void getBodyById_Found() throws Exception {
//        Mockito.when(bodyService.getBody(1)).thenReturn(this.mockBody);
//
//        mockMvc.perform(get("/bodies/{id}", 1))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.body").value(mockBody.getBody()));
//}
//
//////develop
////    @Test
////    @DisplayName("POST /bodies is SUCCESSFUL")
////    void addBody_Success() throws Exception{
////
////    }
////
////    //develop
//    @Test
//    @DisplayName("DELETE /bodies/1 is FOUND and DELETED")
//    void deleteBodyById_Found() throws Exception {
////        bodyService.saveBody(new Body(1, "kkk"));
//        Mockito.when(bodyService.getBody(1)).thenReturn(mockBody);
//        Mockito.doNothing().when(bodyService).deleteBody(1);
//
//
//        mockMvc.perform(delete("/bodies/{id}", 1))
//                .andExpect(status().isNoContent());
//
//}
//
//
//
//}
