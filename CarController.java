package com.ito.carRental.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ito.carRental.Car;
import com.ito.carRental.service.CarService;

@RestController
public class CarController {
	@Autowired
	private CarService carService;

	// add a car
	@PostMapping(path = "cars/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Car addCar(@RequestBody Car car) {
		return carService.addCars(car);
	}

	// update a car
	@PutMapping(path = "cars/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Car updatecar(@RequestBody Car car) {
		return carService.updateCars(car);

	}

	// get all the cars details
	@GetMapping(path = "/cars")
	public Iterable<Car> getallcars() {
		return carService.getAllcars();
	}

	// search car details
	@RequestMapping(method = RequestMethod.GET, value = "/cars/{car_id}")
	public Optional<Car> getonecar(@PathVariable Integer car_id) {
		return carService.getOnecar(car_id);

	}

	// Delete car details
	@RequestMapping(method = RequestMethod.DELETE, value = "/cars/{car_id}")
	public void deletecar(@PathVariable Integer car_id) {
		carService.deleteCar(car_id);
	}

	// search car based on car type
	@RequestMapping(method = RequestMethod.GET, value = "/cars/search/type/{type}")
	public List<Car> getcartype(@PathVariable String type) {
		return carService.getCartype(type);
	}

	// search car based on car model
	@RequestMapping(method = RequestMethod.GET, value = "/cars/search/model/{modelname}")
	public List<Car> getbymodelname(@PathVariable String modelname) {
		return carService.getByModelName(modelname);

	}

	// search car whose cost per day is <= given cost per day
	@RequestMapping(method = RequestMethod.GET, value = "/cars/search/costlessthan/{costPerDay}")
	public List<Car> getbycostperday(@PathVariable Double costPerDay) {
		return carService.getByCostPerDay(costPerDay);

	}
	


}
