package demo.integration.service;

import demo.domain.Car;
import demo.repository.CarRepository;
import demo.service.CarService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;


public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;
    public static final Car CAR = new Car("VW Golf 7 R", "2015", "Petrol", "Dual shift");

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(carRepository.saveAndFlush(new Car())).thenReturn(new Car());
    }

    @Test
    public void should_return_a_list_of_cars_when_calling_get_cars() {
        List<Car> carList = new ArrayList<>();
        carList.add(CAR);

        when(carRepository.findAll()).thenReturn(carList);

        assertThat(carService.getCars().size(), is(1));
    }

    @Test
    public void test_should_save_car_given_car_object() throws Exception {
        when(carRepository.saveAndFlush(CAR)).thenReturn(CAR);

        assertThat(carService.saveAndFlush(CAR).getId(), is(CAR.getId()));
    }

    @Test
    public void test_should_not_save_null_object_given_null_as_car_object() throws Exception {

        assertThat(carService.saveAndFlush(null), is(nullValue()));
    }

    @Test
    public void test_should_update_car_given_car() throws Exception {

        when(carRepository.saveAndFlush(CAR)).thenReturn(CAR);
        CAR.setMake("updated Maker");
        when(carRepository.findOne(CAR.getId())).thenReturn(CAR);
        when(carRepository.save(CAR)).thenReturn(CAR);

        assertThat(carService.update(CAR).getMake(), is(CAR.getMake()));

    }
}
