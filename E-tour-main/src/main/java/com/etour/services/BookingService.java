package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.entities.Booking;
//import com.etour.entities.EmailDetails;

public interface BookingService
{
	List<Booking> getBookings();
	Optional<Booking> getBookingsbyid(int id);	
	

	String sendSimpleMail1(Booking bookingdetails);
}
