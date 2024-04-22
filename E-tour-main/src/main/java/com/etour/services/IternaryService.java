package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.entities.Iternary;

public interface IternaryService 
{
	List<Iternary> getIternary();
	Optional<Iternary> getIternaryById(int packid);

}
