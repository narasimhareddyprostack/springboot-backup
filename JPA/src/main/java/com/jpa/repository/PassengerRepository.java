package com.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
	Passenger findByEmailId(String email);//Query Creation by Method Name
	
	@Query("select p from Passenger p where p.firstName=?1 and p.lastName=?2")
	List<Passenger> getPassengers(String fname, String lname); //Query creation by @Query - annotation
	
	
	
}
