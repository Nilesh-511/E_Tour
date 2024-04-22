package com.etour.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.etour.entities.Iternary;
import com.etour.services.IternaryService;

@RestController
@CrossOrigin("*")
public class IternaryController 
{
	@Autowired
	IternaryService iternaryservice;
	
	@GetMapping("api/getiternaries")
	List<Iternary> getIternary()
	{
		return iternaryservice.getIternary();
	}
	
	@GetMapping("api/getIternaryById/{id}")
	Optional<Iternary> getIternaryById(@PathVariable int id)
	{
		return iternaryservice.getIternaryById(id);
		
	}

}
