package com.etour.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etour.entities.Booking;
import com.etour.entities.Customers;
//import com.etour.entities.EmailDetails;
import com.etour.services.BookingService;
import com.etour.services.CustomerServiceImple;

@RestController
@CrossOrigin("*")
public class BookingController 
{
	@Autowired
	private  BookingService bookingservice;
	
	@GetMapping(value = "api/booking")
	public List<Booking> showbookings()
	{
		return bookingservice.getBookings();
	}
	
	@GetMapping(value = "api/booking/{id}")
	public Optional<Booking> getbook(@PathVariable int id)
	{
		return bookingservice.getBookingsbyid(id);
		
	}
	 @PostMapping("/sendMail")
	 public ResponseEntity <String> sendMail(@RequestBody Booking bookingdetails)
	 {  	
		 System.out.println(bookingdetails);    
	     String status= bookingservice.sendSimpleMail1(bookingdetails);
	     return ResponseEntity.ok (status);
	 }
	
	/*
	 * CustomerServiceImple customerservice = new CustomerServiceImple();
	 * Optional<Customers> getbooking = customerservice.getCustomerbyBookingId();
	 * EmailDetails emaildetails = new EmailDetails();
	 * emaildetails.setRecipient(getbooking.zz);
	 */
	
	/*
	 * CustomerServiceImple customerservice = new CustomerServiceImple();
	 * Optional<Customers> getbooking = customerservice.getCustomerbyBookingId(); {
	 * if (getbooking.isPresent()) { Customers customer = getbooking.get();
	 * EmailDetails emailDetails = new EmailDetails();
	 * emailDetails.setRecipient(customer.email);
	 * emailDetails.setTotalAmount(customer.get)// Assuming email is stored in a
	 * field called 'email' } else { // Handle the case where the customer with the
	 * given booking ID is not found } }
	 */
}
