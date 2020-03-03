package com.ito.carRental;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
	public List<Car> findBytype(String type);
	public List<Car> findBymodelname(String modelname);

	@Query("from Car where costPerDay <= :costPerDay")
	public List<Car> findBycostPerDay(Double costPerDay);
}
