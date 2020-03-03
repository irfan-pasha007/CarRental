package com.ito.carRental;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface CarBookingRepository extends JpaRepository<CarBooking, Integer> 
{
	// creating custom methods for searching
	public List<CarBooking> findBybookingid(Integer bookingid);

	public List<CarBooking> findBybookingPersonName(String bookingPersonName);

	public List<CarBooking> findBybookingPersonContantNumber(Long bookingPersonContantNumber);

	public List<CarBooking> findBybookingPersonEmail(String bookingPersonEmail);
	
	 
    @Query(value = "select distinct cars.* from cars, car_booking where cars.booking_id is null OR (car_booking.bookingid=cars.booking_id AND ((:bookingStartDate NOT BETWEEN car_booking.booking_start_date AND car_booking.booking_end_date) AND (:bookingEndDate NOT BETWEEN car_booking.booking_start_date AND car_booking.booking_end_date)))", nativeQuery = true)
    public List<Object> viewCarsBetweenDate(Date bookingStartDate, Date bookingEndDate);

	
}
