package com.ito.carRental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ito.carRental.CarRepository;
import com.ito.carRental.Car;

@Service
public class CarService {
	@Autowired
	CarRepository carRepository;

	public Car addCars(Car car) {
		return carRepository.save(car);
	}

	public Iterable<Car> getAllcars() {
		return carRepository.findAll();

	}

	public Optional<Car> getOnecar(Integer car_id) {
		return carRepository.findById(car_id);
	}

	public void deleteCar(Integer car_id) {
		carRepository.deleteById(car_id);
	}

	public Car updateCars(Car car) {
		return carRepository.save(car);
	}

	public List<Car> getCartype(String type) {

		return carRepository.findBytype(type);

	}

	public List<Car> getByModelName(String modelname) {

		return carRepository.findBymodelname(modelname);
	}

	public List<Car> getByCostPerDay(Double costPerDay) {
		return carRepository.findBycostPerDay(costPerDay);
	}

	

}
