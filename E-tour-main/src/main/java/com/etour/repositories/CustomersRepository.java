package com.etour.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.etour.entities.Cost;
import com.etour.entities.Customers;

@Repository  //This annotation marks the interface as a Spring repository bean.
@Transactional  //This annotation marks the interface as transactional, meaning methods within it will be executed within a transaction.
public interface CustomersRepository extends JpaRepository<Customers,Integer>//Customers is the entity class that this repository manages. It represents the data model for the database table associated with the repository.
//Integer is the type of the primary key of the entity (Customers). In this case, it indicates that the primary key is of type Integer.
{
	
	/*
	 * @Query(value
	 * ="select email,firstname,lastname,total_amount from Booking join Customers on Customers.customer_id=Booking.customer_id order by Booking.booking_id desc limit 1"
	 * ,nativeQuery=true) public Optional<Customers> getCustomerbyBookingId();
	 */
	
	/*   default boolean findUser(Customers myuser)
	   {
		System.out.println("inside findUser method");
		String uname=myuser.getUsername();
		String pwd=myuser.getPassword();
		return uname.equalsIgnoreCase("scott") && pwd.equals("tiger");
		
	   }*/
}
