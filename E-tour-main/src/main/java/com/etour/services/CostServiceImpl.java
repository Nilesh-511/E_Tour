package com.etour.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etour.entities.Cost;
import com.etour.repositories.CostRepository;

@Service
public class CostServiceImpl implements CostService {

	@Autowired
	CostRepository costRepository;

	@Autowired
	public List<Cost> getAllCost() {
		List<Cost> ls = costRepository.findAll();
		return ls;
	}

	@Override
	public Optional<Cost> getCostById(int id) {
		Optional<Cost> ls = costRepository.findById(id);
		return ls;
	}

	@Override
	public Cost getCostByPackageId(int id) {
		Cost cost = costRepository.getCostByPackageId(id);
		return cost;
	}

	
//	List<Cost> ls = costRepository.findAll();
//	return ls;
	
//	Optional<Cost> ls = costRepository.findById(id);
//	return ls;
}
