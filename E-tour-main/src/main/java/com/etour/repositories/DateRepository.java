package com.etour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etour.entities.Date;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface DateRepository extends JpaRepository<Date,Integer>
{

}
