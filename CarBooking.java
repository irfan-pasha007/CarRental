package com.ito.carRental;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CarBooking {
	@Id
	@GeneratedValue
	private Integer bookingid;
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date bookingStartDate;
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date bookingEndDate;
	@Column
	
	private String bookingPersonName;
	@Column
	private Long bookingPersonContantNumber;
	@Column
	private String bookingPersonEmail;

	@OneToMany()
    @JoinColumn(name = "bookingId")
    private List<Car> carDetails;
	
	public List<Car> getCarDetails() {
		return carDetails;
	}

	public void setCarDetails(List<Car> carDetails) {
		this.carDetails = carDetails;
	}

	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

	

	public Date getBookingStartDate() {
		return bookingStartDate;
	}

	public void setBookingStartDate(Date bookingStartDate) {
		this.bookingStartDate = bookingStartDate;
	}

	public Date getBookingEndDate() {
		return bookingEndDate;
	}

	public void setBookingEndDate(Date bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}

	public String getBookingPersonName() {
		return bookingPersonName;
	}

	public void setBookingPersonName(String bookingPersonName) {
		this.bookingPersonName = bookingPersonName;
	}

	public Long getBookingPersonContantNumber() {
		return bookingPersonContantNumber;
	}

	public void setBookingPersonContantNumber(Long bookingPersonContantNumber) {
		this.bookingPersonContantNumber = bookingPersonContantNumber;
	}

	public String getBookingPersonEmail() {
		return bookingPersonEmail;
	}

	public void setBookingPersonEmail(String bookingPersonEmail) {
		this.bookingPersonEmail = bookingPersonEmail;
	}

}
