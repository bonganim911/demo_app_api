package demo.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import demo.domain.Car;
import demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(basePath = "/cars", value = "Cars", description = "This is about the CRUD for cars.", produces = "application/json")
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "List the available cars", notes = "This is a list of cars.")
    public List<Car> carList(){
        return carService.getCars();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a car", notes = "Handles the creation  of a new car.")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "") })
    public Car create(@Valid @RequestBody Car car){
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
