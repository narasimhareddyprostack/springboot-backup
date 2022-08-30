package com.jpa.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.entity.Passenger;
import com.jpa.repository.PassengerRepository;


@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	PassengerRepository passengerRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Passenger p = new Passenger();
		p.setPassengerId(103);
		p.setFirstName("Priyanka");
		p.setLastName("Gandhi");
		p.setEmailId("pri@gmail.com");
		p.setSeatNo(3);
		passengerRepo.save(p);
		
		//display all passenger recors
		List<Passenger> passengerList = passengerRepo.findAll();
		passengerList.forEach(passenger->{
			System.out.println(passenger.getFirstName()+"------"+passenger.getLastName()+"-----"+passenger.getEmailId());
		});
		//display data based id
		Optional<Passenger> opt=passengerRepo.findById(103);
		Passenger p1 = opt.get();
		System.out.println(p1.getFirstName()+"-----"+p1.getLastName());
		
		//display data based methodName
		Passenger p2=passengerRepo.findByEmailId("Rahul@gmail.com");
		System.out.println(p);
		System.err.println(p2.getFirstName()+"----"+p2.getLastName());
		
		//dispay data based first Name and last Name
		List<Passenger> p3 = passengerRepo.getPassengers("Rahul", "Gandhi");
		p3.forEach(passenger->{
			System.out.println("Passenger Email Id:....."+passenger.getEmailId());
		});
	}

}
