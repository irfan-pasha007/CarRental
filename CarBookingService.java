package com.ito.carRental.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ito.carRental.CarBooking;
import com.ito.carRental.CarBookingRepository;

@Service
public class CarBookingService 
{
	@Autowired
	CarBookingRepository repo;
	
	public CarBooking createBooking(CarBooking carbooking) 
	{
		return repo.save(carbooking);
	}

	public Optional<CarBooking> getBookingDetails(Integer bookingid) {
		
		return repo.findById(bookingid);
	}



	public List<CarBooking> getbycontact(Long bookingPersonContantNumber) {
		
		return repo.findBybookingPersonContantNumber(bookingPersonContantNumber);
	}

	public List<CarBooking> getBookingByName(String bookingPersonName) {
		return repo.findBybookingPersonName(bookingPersonName);
	}

	public List<CarBooking> getbyEmail(String bookingPersonEmail) {
	
		return repo.findBybookingPersonEmail(bookingPersonEmail);
	}

	public void deleteBookingDetails(Integer bookingid) {
	
	 repo.deleteById(bookingid);
	}

	public Iterable<CarBooking> getAllBooking()
	{
		
		return repo.findAll();
	}

	public CarBooking updateBooking(CarBooking carbooking) {
		
		return repo.save(carbooking);
	}
	
	public List<Object> availableCar(Date bookingStartDate, Date bookingEndDate) 
	{
	
		return repo.viewCarsBetweenDate(bookingStartDate, bookingEndDate);
	}

	

	

	
}
