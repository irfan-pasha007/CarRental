package com.ito.carRental;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Integer> {

	
	@Modifying
	@Transactional
	@Query(value = "update  cars set cars.car_available=null where cars.type=:type  ", nativeQuery = true)
	public void deleteCarFromlocation(String type);

 //@Query(value="insert into cars(location_id) values((select location_id from Location where location.location_id=:locationId AND cars.type=:type)) ",nativeQuery = true)
	@Modifying
   @Transactional
	@Query(value = "update cars,location set cars.car_available =:locationId where cars.type=:type And location.location_id=:locationId ", nativeQuery = true)
	public void addCarLocation(int locationId, String type);
}
