package demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Make cannot be null")
    private String make;

    @NotNull(message = "Model cannot be null")
    private String model;

    private String transmission;

    private String fuelType;

    public Car(String make, String model, String transmission, String fuelType) {
        this.make = make;
        this.model = model;
        this.transmission = transmission;
        this.fuelType = fuelType;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return
                new StringBuilder().append("Car{")
                        .append("id=" + id)
                        .append(", make='" + make + '\'')
                        .append(", model='" + model + '\'')
                        .append(", transmission='" + transmission + '\'')
                        .append(", fuelType='" + fuelType + '\'')
                        .append('}').toString();


    }
}
