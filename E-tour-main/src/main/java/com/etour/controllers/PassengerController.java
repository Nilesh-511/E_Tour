package com.etour.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etour.entities.Passenger;
import com.etour.services.PassengerService;
@RestController
@CrossOrigin("*")
public class PassengerController 
{ 	
	@Autowired
	PassengerService passengerservice;
	
	@GetMapping("api/passengers")
    public List<Passenger> getAllPassengers()
	{
   	 	return passengerservice.getAll();
    }
	
	@GetMapping("api/getpassengerByid/{id}")
	public Optional<Passenger>getPassengersById(@PathVariable int id)
	{
		Optional<Passenger> passenger= passengerservice.getPassengerById(id);
		return passenger;
	}
	
	/*@GetMapping("api/getpassengerinfo/{id}/info")
	public Optional<Passenger>getPassengerInfo(@PathVariable int id)
	{
		Optional<Passenger> passengerinfo = passengerservice.getPassInfoByCustid(id);
		return passengerinfo;
	}
	
	@PostMapping("/api/passenger")
	public void addPass(@RequestBody Passenger pass)
	{
		passengerservice.addPassengers(pass);
	}*/
	
	
}
