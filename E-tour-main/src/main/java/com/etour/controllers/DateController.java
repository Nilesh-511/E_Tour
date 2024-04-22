package com.etour.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.etour.entities.Date;
import com.etour.services.DateService;

@RestController
@CrossOrigin("*")
public class DateController 
{
	@Autowired
	DateService dateservice ;
	
	@GetMapping("api/getdate")
    public List<Date> getDate() {
		
		return dateservice.getDate();
	}

	@GetMapping("api/getDateByid/{id}")
	public Optional<Date> getDateById(@PathVariable int id) 
	{
		
		return dateservice.getDateById(id);
	}

}
