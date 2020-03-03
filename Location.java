package com.ito.carRental;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;

@Entity
public class Location
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="location_id")
    private int locationId;
	@Column(unique=true)
	private String locationName;
	@Column
	private String address;
	
	@OneToMany()
    @JoinColumn(name = "carAvailable", nullable = true)
    private List<Car> carAvailable;
	
	
	public List<Car> getCarAvailable() {
		return carAvailable;
	}
	public void setCarAvailable(List<Car> carAvailable) {
		this.carAvailable = carAvailable;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Location(int locationId, String locationName, String address) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.address = address;
	}
	
	
	public Location() {
		super();
	}
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", address=" + address + "]";
	}
	
}
