package com.ito.carRental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ito.carRental.Car;
import com.ito.carRental.Location;
import com.ito.carRental.LocationRepository;

@Service
public class LocationService
{
	@Autowired
	LocationRepository repo;
	public Location addlocation(Location location) 
	{
		return repo.save(location);
	}

	public void updatelocation(Car car) {
		
	repo.deleteCarFromlocation(car.getType());
	}

	public void addlocation(Car car,Location loc)
	{
		
repo.addCarLocation(loc.getLocationId(),car.getType());

		
	}

}
