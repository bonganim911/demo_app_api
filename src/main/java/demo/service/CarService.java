package demo.service;

import demo.domain.Car;
import demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Repository
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @PostConstruct
    @Transactional
    public void populate(){
        Car car1 = new Car("VW Scirrocco","2015","Petrol","Dual shift");
        carRepository.saveAndFlush(car1);

        Car car2 = new Car("VW Golf 7 R","2015", "Petrol", "Dual shift");
        carRepository.saveAndFlush(car2);

        Car car3 = new Car("VW Golf 6 R", "2015", "Petrol", "Dual shift");
        carRepository.saveAndFlush(car3);

        Car car4 = new Car("VW Golf 7 GTI", "2015", "Petrol", "Dual shift");
        carRepository.saveAndFlush(car4);

    }

    @Transactional(readOnly = true)
    public List<Car> getCars(){
        return carRepository.findAll();
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    @Transactional
    public Car saveAndFlush(Car car){
        if(car != null){
            carRepository.saveAndFlush(car);
        }

        return car;
    }

    @Transactional
    public void delete(long id){
        carRepository.delete(id);
    }

    @Transactional
    public Car update(Car car){
        Car updateCar =  carRepository.findOne(car.getId());
        updateCar.setMake(car.getMake());
        updateCar.setModel(car.getModel());
        updateCar.setTransmission(car.getTransmission());
        updateCar.setFuelType(car.getFuelType());
        return carRepository.save(updateCar);
    }
}
