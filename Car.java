package com.ito.carRental;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cars")
public class Car {
	@Id
	@Column(name = "car_id")
	private Integer car_id;

	@Column(name = "type")
	private String type;

	@Column(name = "model_name")
	private String modelname;

	@Column(name = "year_of_registration")
	private Integer year_of_registration;

	@Column(name = "seating_capacity")
	private Integer seating_capacity;

	@Column(name = "cost_per_day")
	private Double costPerDay;

	@Column(name = "mileage")
	private Double mileage;

	@Column(name = "pin_code")
	private Integer pin_code;

	@Column(name = "contact_number")
	private Long contact_number;

	@Column(name = "contact_email_address")
	private String contact_email_address;
	
	@Transient
	@ManyToOne(cascade = CascadeType.MERGE)
	private CarBooking carBooking;
	

	@ManyToOne(cascade = CascadeType.MERGE)
	private Location location;
	
	
	

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public CarBooking getCarBooking() {
		return carBooking;
	}

	public void setCarBooking(CarBooking carBooking) {
		this.carBooking = carBooking;
	}

	public Integer getCar_id() {
		return car_id;
	}

	public void setCar_id(Integer car_id) {
		this.car_id = car_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public Integer getYear_of_registration() {
		return year_of_registration;
	}

	public void setYear_of_registration(Integer year_of_registration) {
		this.year_of_registration = year_of_registration;
	}

	public Integer getSeating_capacity() {
		return seating_capacity;
	}

	public void setSeating_capacity(Integer seating_capacity) {
		this.seating_capacity = seating_capacity;
	}

	public Double getCostPerDay() {
		return costPerDay;
	}

	public void setCostPerDay(Double costPerDay) {
		this.costPerDay = costPerDay;
	}

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public Integer getPin_code() {
		return pin_code;
	}

	public void setPin_code(Integer pin_code) {
		this.pin_code = pin_code;
	}

	public Long getContact_number() {
		return contact_number;
	}

	public void setContact_number(Long contact_number) {
		this.contact_number = contact_number;
	}

	public String getContact_email_address() {
		return contact_email_address;
	}

	public void setContact_email_address(String contact_email_address) {
		this.contact_email_address = contact_email_address;
	}
	

	public Car() {
		super();
	}

	public Car(Integer car_id, String type, String modelname, Integer year_of_registration, Integer seating_capacity,
			Double costPerDay, Double mileage, Integer pin_code, Long contact_number, String contact_email_address,
			CarBooking carBooking, Location location) {
		super();
		this.car_id = car_id;
		this.type = type;
		this.modelname = modelname;
		this.year_of_registration = year_of_registration;
		this.seating_capacity = seating_capacity;
		this.costPerDay = costPerDay;
		this.mileage = mileage;
		this.pin_code = pin_code;
		this.contact_number = contact_number;
		this.contact_email_address = contact_email_address;
		this.carBooking = carBooking;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", type=" + type + ", modelname=" + modelname + ", year_of_registration="
				+ year_of_registration + ", seating_capacity=" + seating_capacity + ", costPerDay=" + costPerDay
				+ ", mileage=" + mileage + ", pin_code=" + pin_code + ", contact_number=" + contact_number
				+ ", contact_email_address=" + contact_email_address + "]";
	}

}
