package com.justin.mvcDojosAndNinjas.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justin.mvcDojosAndNinjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	
	List<Ninja>findAll();
	
	List<Ninja> findByDojoId(Long id);

}

