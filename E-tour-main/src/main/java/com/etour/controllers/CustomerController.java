package com.etour.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etour.entities.Customers;
import com.etour.securityconfig.JwtRepository;
import com.etour.securityconfig.JwtResponse;
import com.etour.services.CustomerService;
import com.etour.services.CustomerServiceImple;

@RestController
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private CustomerServiceImple customerserviceimple;
	
	
	
	  @Autowired 
	  private JwtRepository repository;
	 
	
	/*
	 * @Autowired private CustomUserDetailsService customuserdetailsservice;
	 */
	
	@PostMapping("/public/token")
	public ResponseEntity<?> generateToken(@RequestBody Customers myuser)
	{
		try
		{
		System.out.println("inside token method");
		System.out.println(myuser);
		boolean result=repository.findUser(myuser);
		if(result==false)
		{
			throw new UsernameNotFoundException("credentials don't match");
		}
		customerserviceimple.setPassword(myuser.getPassword());
		UserDetails userdetails=customerserviceimple.loadUserByUsername(myuser.getUsername());
		String token=this.customerserviceimple.generateToken(userdetails);
		System.out.println("JWT "+token);
		return ResponseEntity.ok(new JwtResponse(token));
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			return null;
		}
	}
	
	
	
	
	@GetMapping("/api/customer")
	List<Customers> getallcustomer()
	{
		return customerservice.getcustomers();
	}
	
	
	@GetMapping("/api/customerbyid/{id}")
	public Optional<Customers> getcustomerbyid(@PathVariable int id)
	{
		return customerservice.getcustomerbyid(id);
	}
	
	/*
	 * @PostMapping("/api/CustomerController") public void createCustomer(Customers
	 * customers) { customerservice.createCustomer(customers); }
	 * 
	 * @DeleteMapping("/api/CustomerController/{id}") void deleteCustomer(int id) {
	 * customerservice.deleteCustomer(id); }
	 */

	/*
	 * @GetMapping("/api/customer/bookingid/") Optional<Customers>
	 * getCustomerbyBookingId(int id) {
	 * 
	 * return customerservice.getCustomerbyBookingId(id); }
	 */

}
