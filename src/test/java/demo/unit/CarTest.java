package demo.unit;

import demo.domain.Car;
import demo.integration.Builder.CarBuilder;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CarTest {


    @Test
    public void should_return_new_car_given_attribute_information(){
        Car car = new CarBuilder().build();

        assertNotNull(car);
        assertEquals(car.getMake(), "VW Golf 7 R");
        assertNotEquals(car.getMake(), "VW Golf 7 GTI");
        assertEquals(car.getModel(), "2015");
        assertEquals(car.getTransmission(), "Dual shift");
        assertEquals(car.getFuelType(), "Petrol");
        assertThat(car.toString(), is("Car{id=0, make='VW Golf 7 R', model='2015', transmission='Dual shift', fuelType='Petrol'}"));
    }
}
