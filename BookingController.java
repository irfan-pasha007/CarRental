package com.ito.carRental.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ito.carRental.CarBooking;
import com.ito.carRental.service.CarBookingService;

@RestController
public class BookingController 
{
	@Autowired
	CarBookingService carbookingservice;

	// create a booking
	@PostMapping(path = "booking/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer createbooking(@RequestBody CarBooking carbooking) {
		CarBooking c = carbookingservice.createBooking(carbooking);
		return c.getBookingid();
	}

	// get all the bookings
	@RequestMapping(method = RequestMethod.GET, value = "/booking")
	public Iterable<CarBooking> getallbooking() {
		return carbookingservice.getAllBooking();
	}

	// get all the bookings by name
	@RequestMapping(method = RequestMethod.GET, value = "/booking/name/{bookingPersonName}")
	public List<CarBooking> getbookingbynmae(@PathVariable String bookingPersonName) {
		return carbookingservice.getBookingByName(bookingPersonName);
	}

	// get all the bookings by booking id
	@RequestMapping(method = RequestMethod.GET, value = "/booking/id/{bookingid}")
	public Optional<CarBooking> getbookingdetails(@PathVariable Integer bookingid) {
		return carbookingservice.getBookingDetails(bookingid);

	}

	// get all the bookings by booking person contact number
	@RequestMapping(method = RequestMethod.GET, value = "/booking/contact/{bookingPersonContantNumber}")
	public List<CarBooking> getbookingbycontact(@PathVariable Long bookingPersonContantNumber) {
		return carbookingservice.getbycontact(bookingPersonContantNumber);

	}

	// get all the bookings by booking person email
	@RequestMapping(method = RequestMethod.GET, value = "/booking/email/{bookingPersonEmail}")
	public List<CarBooking> getbookingbyemail(@PathVariable String bookingPersonEmail) {
		return carbookingservice.getbyEmail(bookingPersonEmail);

	}

	// delete booking by book id
	@RequestMapping(method = RequestMethod.GET, value = "/booking/delete/{bookingid}")
	public void deletebookingdetails(@PathVariable Integer bookingid) {
		carbookingservice.deleteBookingDetails(bookingid);

	}
	//update car details
	@RequestMapping(method = RequestMethod.PUT, value = "/booking/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public CarBooking updatebooking(@RequestBody CarBooking carbooking ) 
	{
	return carbookingservice.updateBooking(carbooking);
	}
	
	
	//available cars in the given date
	@RequestMapping(method = RequestMethod.GET, value = "booking/available", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> availablecar(@RequestBody CarBooking carBooking)
	{
		return carbookingservice. availableCar(carBooking.getBookingStartDate(),carBooking.getBookingEndDate());

	}
}
