package com.justin.mvcDojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.justin.mvcDojosAndNinjas.models.Dojo;
import com.justin.mvcDojosAndNinjas.models.Ninja;
import com.justin.mvcDojosAndNinjas.services.MyService;

@Controller
public class MyController {
	
	private final MyService service;
	
	public MyController(MyService service) {
		this.service=service;
	}
//	FORM PAGE FOR DOJOS
	@GetMapping("/dojos")
	public String index(@ModelAttribute("newdojo") Dojo newdojo) {
		return "/views/index.jsp";
	}
	
//	CREATING DOJO
	@PostMapping("/dojos")
	public String create(@Valid @ModelAttribute("newdojo") Dojo newdojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/views/index.jsp";
		}else {
			service.createDojo(newdojo);
			return "redirect:/dojos";
		}
	}
//	SHOW ALL NINJAS PER DOJO
	@GetMapping("/dojos/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		Dojo dojo = service.findDojo(id);
		List<Ninja> ninjas=service.findNinjasByDojo(id);
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("dojo", dojo);
		return "/views/dojo.jsp";
	}
//	FORM PAGE FOR NINJAS
	@GetMapping("/ninjas")
	public String ninja(@ModelAttribute("newninja") Ninja newninja,Model model) {
		List<Dojo> dojos = service.allDojos();
		model.addAttribute("dojos", dojos);
		return "/views/ninja.jsp";
	}
//	CREATE NINJA
	@PostMapping("/ninjas")
	public String create(@ModelAttribute("newninja") Ninja newninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/views/ninja.jsp";
		}else {
			service.createNinja(newninja);
			return "redirect:/ninjas";
		}
	}
	
	
	
}
