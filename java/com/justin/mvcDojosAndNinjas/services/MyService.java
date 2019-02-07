package com.justin.mvcDojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.mvcDojosAndNinjas.models.Dojo;
import com.justin.mvcDojosAndNinjas.models.Ninja;
import com.justin.mvcDojosAndNinjas.repositories.DojoRepository;
import com.justin.mvcDojosAndNinjas.repositories.NinjaRepository;

@Service
public class MyService {
	
	private final DojoRepository dojoRepo;
	
	private final NinjaRepository ninjaRepo;
	
	public MyService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo=dojoRepo;
		this.ninjaRepo=ninjaRepo;
	}
//	CREATE A DOJO
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
//	FIND ALL DOJOS
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
//	FIND DOJO BY ID
	public Dojo findDojo(Long id) {
		Optional<Dojo> dojo=dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}else {
			return null;
		}
	}
//	FIND NINJAS PER DOJO
	public List<Ninja> findNinjasByDojo(Long id){
		return ninjaRepo.findByDojoId(id);

	}
//	CREATE NINJA
	public Ninja createNinja(Ninja newninja) {
		return ninjaRepo.save(newninja);
		
	}


}
