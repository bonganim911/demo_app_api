package demo.integration.Builder;

import demo.domain.Car;

public class CarBuilder {

    private Car car = new Car("VW Golf 7 R", "2015", "Dual shift",  "Petrol");

    public CarBuilder() {
        car.setId(0L);
    }

    public CarBuilder(String id) {
        car.setId(Long.parseLong(id));

    }

    public CarBuilder make(String make){
        car.setMake(make);
        return this;
    }

    public CarBuilder model(String model){
        car.setModel(model);
        return this;
    }

    public CarBuilder fuelType(String fuelType){
        car.setFuelType(fuelType);
        return this;
    }

    public CarBuilder transmission(String transmission){
        car.setTransmission(transmission);
        return this;
    }

    public Car build(){
        return car;
    }
}
