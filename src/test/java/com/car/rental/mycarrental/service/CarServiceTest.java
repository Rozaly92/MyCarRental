package com.car.rental.mycarrental.service;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarServiceTest {
//    @Autowired
//    private CarsService carsService;
//
//    @MockBean
//    private CarRepository repo;
//
//    private Car mockCar;
//    private List<Car> carList;
//
//    private static Logger logger= LoggerFactory.getLogger(CarServiceTest.class);
//
//    @BeforeEach
//    void init(){
//        logger.info(()->("== Log me BEFORE each test method =="));
//
//        this.mockCar= new Car();
//
//        List<>
//
//
//
//
//        List<Car> list = Arrays.asList(
//                new Employee(1, "Roza", "Chisinau"),
//                new Employee(2, "Ioana", "Chisinau"),
//                new Employee(3, "Lora", "Chisinau")
//        );
//        carList=list;
//    }
//
//    @Test
//    @DisplayName("TEST getEmployeesWithResult")
//    void getEmployeesWithResult() {
//
//
//        Mockito.when(repo.findAll()).thenReturn(employeeList);
//
//        List<Employee> returnedList = employeeService.getAllEmployees();
//
//        Assertions.assertFalse(returnedList.isEmpty(),"");
//        Assertions.assertEquals("Roza", returnedList.get(0).getEmplName());
//        Assertions.assertEquals("Ioana", returnedList.get(1).getEmplName());
//        Assertions.assertEquals("Lora", returnedList.get(2).getEmplName());
//        Assertions.assertEquals(2, returnedList.get(1).getEmpId());
//    }
//
//
//
//    @Test
//    @DisplayName("TEST getEmployeeById Found")
//    void getEmployeeById_Found() throws Exception {
//        Mockito.when(repo.existsById(1)).thenReturn(true);
//        Mockito.when(repo.findById(1)).thenReturn(Optional.of(this.mockEmployee));
//
//        // Call the service
//        Optional<Employee> returnedBody = Optional.ofNullable(employeeService.getEmployee(1));
//
//        // Validate the result
//        Assertions.assertEquals(this.mockEmployee, returnedBody.get());
//
//    }
//
//
//
//    @Test
//    @DisplayName("TEST post employee")
//    void saveEmployee(){
//        Mockito.when(repo.save(this.mockEmployee)).thenReturn(this.mockEmployee);
//
//        employeeService.saveEmployee(this.mockEmployee);
//        Integer employeeId = mockEmployee.getEmpId();
//
//        Assertions.assertEquals(1, employeeId);
//    }
//
//
//
//
//
//    @Test
//    @DisplayName("TEST delete employee")
//    public void deleteEmployeeById(){
//        Mockito.when(repo.existsById(1)).thenReturn(true);
//        Mockito.doNothing().when(repo).deleteById(1);
//
//        employeeService.deleteEmployee(1);
//    }
}
