package com.ito.carRental.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ito.carRental.Car;
import com.ito.carRental.CarBooking;
import com.ito.carRental.Location;
import com.ito.carRental.service.LocationService;

@RestController
public class LocationController
{
	@Autowired
	LocationService locationservice;
	@PostMapping(path = "location/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Location addLocation(@RequestBody Location location)
    {
		return locationservice.addlocation(location);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/location1/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateLocation(@RequestBody Car car) 
	{
	
locationservice.updatelocation(car);
		
	}
	@Transactional
	@RequestMapping(method = RequestMethod.PUT, value = "/location2/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addLocation(@RequestBody  Car car,Location loc) 
	{
		
         locationservice.addlocation(car,loc);
		
	}
	
}
