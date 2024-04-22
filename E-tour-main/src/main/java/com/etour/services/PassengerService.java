package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.entities.Passenger;

public interface PassengerService
{
	
	List<Passenger> getAll();
	
	Optional< Passenger> getPassengerById(int id);
	
	//void addPassengers(Passenger passenger);
	//void delete(int id);
	//Optional<Passenger> getPassInfoByCustid(int id);
	
}
