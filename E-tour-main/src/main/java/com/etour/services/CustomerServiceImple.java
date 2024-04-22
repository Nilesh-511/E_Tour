package com.etour.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.etour.entities.Customers;
import com.etour.repositories.CustomersRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class CustomerServiceImple implements CustomerService ,UserDetailsService
{

	@Autowired
	CustomersRepository customersrepository;
	
	public CustomersRepository getCustomersrepository() {
		return customersrepository;
	}

	public void setCustomersrepository(CustomersRepository customersrepository) {
		this.customersrepository = customersrepository;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	private String password;
	
	@Override
	public List<Customers> getcustomers() {
		
		return customersrepository.findAll();
	}
	
	@Override
	public void createCustomer(Customers customers) {
		
		
		customersrepository.save(customers);
	}

	@Override
	public void deleteCustomer(int id) {
		
		customersrepository.deleteById(id);
	}

	@Override
	public Optional<Customers> getcustomerbyid(int id) {
		Optional<Customers> ls = customersrepository.findById(id);
		return ls;
	}

	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
	
		
		System.out.println("inside loaduserbyname method");
		if (password == null) {
            throw new IllegalArgumentException("Password cannot be null. Make sure to set the password before calling loadUserByUsername.");
        }
		return User.withUsername(username)
                .password(password)
                .roles("USER")
                .build();
		
	}

	@Value("${jwt.secret}")
    private String secret; 

    public String getUsernameFromToken(String token) {
        System.out.println("inside getUsernameFromToken method");
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        System.out.println("inside getClaimFromToken method");
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        System.out.println("inside getAllClaimsFromToken method");
        SecretKey secretkey = Keys.hmacShaKeyFor(secret.getBytes()); 
        return Jwts.parserBuilder().setSigningKey(secretkey).build().parseClaimsJws(token).getBody();		 
    }
    public String generateToken(UserDetails userDetails) {
        System.out.println("inside generateToken method");
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }
    private String createToken(Map<String, Object> claims, String subject) {
        System.out.println("inside createToken method");
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) // 10 minutes
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

	/*
	 * @Override public Optional<Customers> getCustomerbyBookingId() {
	 * 
	 * return customersrepository.getCustomerbyBookingId();
	 * 
	 * }
	 */
	


}
