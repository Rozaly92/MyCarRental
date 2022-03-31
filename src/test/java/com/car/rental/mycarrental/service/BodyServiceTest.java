package com.car.rental.mycarrental.service;

import com.car.rental.mycarrental.dao.BodyRepository;
import com.car.rental.mycarrental.entity.Body;
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
public class BodyServiceTest {
    @Autowired
    private BodyService bodyService;

    @MockBean
    private BodyRepository repo;


    private Body mockBody;
    private List<Body> bodyList;

    private static Logger logger = LoggerFactory.getLogger(BodyServiceTest.class);


    @BeforeEach
    void init(){
        logger.info(()->("== Log me BEFORE each test method =="));

        this.mockBody = new Body(1, "sedan");

        List<Body> list = Arrays.asList(
                new Body(1, "hatcback"),
                new Body(2, "minivan"),
                new Body(3, "limuzin"),
                new Body(4, "cabriolet")
        );
        bodyList=list;
    }




    @Test
    @DisplayName("TEST getBodiesWithResult")
    void getBodiesWithResult() {


      Mockito.when(repo.findAll()).thenReturn(bodyList);

      List<Body> returnedList = bodyService.getAllBodies();

        Assertions.assertFalse(returnedList.isEmpty(),"");
        Assertions.assertEquals("hatcback", returnedList.get(0).getBody());
        Assertions.assertEquals("minivan", returnedList.get(1).getBody());
        Assertions.assertEquals("limuzin", returnedList.get(2).getBody());
        Assertions.assertEquals("cabriolet", returnedList.get(3).getBody());
        Assertions.assertEquals(2, returnedList.get(1).getId());
    }

    @Test
    @DisplayName("TEST getBodyById Found")
    void getBodyById_Found() throws Exception{
        Mockito.when(repo.existsById(1)).thenReturn(true);
        Mockito.when(repo.findById(1)).thenReturn(Optional.of(this.mockBody));

        // Call the service
        Optional<Body> returnedBody = Optional.ofNullable(bodyService.getBody(1));

        // Validate the result
        Assertions.assertEquals(this.mockBody, returnedBody.get());

    }


    //error
//    @Test
//    @DisplayName("TEST getBodyById Not_Found")
//    void getActorById_NotFound() throws Exception{
//        Mockito.when(repo.existsById(100)).thenReturn(false);
//
//        Assertions.assertThrows(NoSuchBodyException.class, () -> bodyService.getBody(100));
//    }


    //don't have this method
//    @Test
//    @DisplayName("TEST get Bodies by name ")
//    void getActorsByName() throws Exception {
//
//        String bodyName = mockBody.getBody();
//
//        Mockito.when(bodyService.getBody(bodyName)).thenReturn((Body) List.of(this.mockBody));
//
//        List<Body> returnedMovies = bodyService.getBody(bodyName);
//
//        Assertions.assertEquals(this.mockBody, returnedMovies.get(0));
//
//    }


    @Test
    @DisplayName("TEST post body")
    void saveBody(){
        Mockito.when(repo.save(this.mockBody)).thenReturn(this.mockBody);

        bodyService.saveBody(this.mockBody);
        Integer bodyId = mockBody.getId();

        Assertions.assertEquals(1, bodyId);
    }


//
//@Test
//    @DisplayName("TEST update body")
//    void updateBodyId(){
//        Body b = Mockito.mock(Body.class);
//        Mockito.when(repo.existsById(mockBody.getId())).thenReturn(true);
//        Mockito.when(repo.getById(mockBody.getId())).thenReturn(b);
//
//
//}


    @Test
    @DisplayName("TEST delete body")
    public void deleteBodyById(){
        Mockito.when(repo.existsById(1)).thenReturn(true);
        Mockito.doNothing().when(repo).deleteById(1);

        bodyService.deleteBody(1);
    }





}
