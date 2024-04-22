package com.etour.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etour.entities.Iternary;
import com.etour.repositories.IternaryRepository;

@Service
public class IternaryServiceImpl implements IternaryService
{
	@Autowired
	private IternaryRepository iternaryrepository ;
	
	@Override
	public List<Iternary> getIternary() {
		
		return iternaryrepository.findAll();
	}

	@Override
	public Optional<Iternary> getIternaryById(int packid) {
		
		return iternaryrepository.findById(packid);
	}

}
