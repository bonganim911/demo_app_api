package demo.controller;

import demo.domain.Car;
import demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> carList(){
        return carService.getCars();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Car create(@RequestBody Car car){
        return carService.saveAndFlush(car);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id){
        carService.delete(Long.parseLong(id));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Car update(@RequestBody Car car){
        return carService.update(car);
    }
}
