package demo.integration.controller;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import demo.controller.CarController;
import demo.domain.Car;
import demo.integration.Builder.CarBuilder;
import demo.service.CarService;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.when;

public class CarControllerTest {

    public static final String CAR_RESOURCE = "/cars";
    @Mock
    private CarService carService;
    private List<Car> found_list;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        RestAssuredMockMvc.standaloneSetup(new CarController(carService));
        buildCarList();
    }

    private void buildCarList() {
        found_list = new ArrayList<>();

        Car car = new CarBuilder().build();
        found_list.add(car);

        car = new CarBuilder("1").make("VW Golf 6 R").build();
        found_list.add(car);

        car = new CarBuilder("2").make("VW Golf 5 R").build();
        found_list.add(car);
    }

    @Test
    public void test_car_resource_should_return_a_list_of_cars_in_the_body() throws Exception {

        when(carService.getCars()).thenReturn(found_list);

        given()
                .
        when()
                .get(CAR_RESOURCE).
        then()
                .statusCode(HttpStatus.SC_OK).
        assertThat()
                .body("make",hasItems(found_list.get(0).getMake()));
    }


    @Test
    public void test_add_car_should_return_bad_request_given_with_no_body() {
        when(carService.saveAndFlush(found_list.get(0))).thenReturn(found_list.get(0));

              given()
                      .
              when()
                      .post(CAR_RESOURCE).
              then()
                      .statusCode(HttpStatus.SC_BAD_REQUEST);
    }


    @Test
    public void test_car_resource_should_return_saved_car() throws Exception {

        when(carService.saveAndFlush(found_list.get(0))).thenReturn(found_list.get(0));

        given().
                post(CAR_RESOURCE).
          then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }


    @Test
    public void test_should_delete_car() {

        given()
                .params("{id}",found_list.get(0).getId()).contentType("application/json")
                .delete(CAR_RESOURCE).
        then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }


}
