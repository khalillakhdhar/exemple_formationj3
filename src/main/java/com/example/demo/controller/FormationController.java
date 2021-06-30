package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Formation;
import com.example.demo.repository.FormationRepository;

@RestController
@RequestMapping("formation")
public class FormationController {

	@Autowired
	FormationRepository formationRepository;
	@GetMapping
	public List<Formation> getAllFormations()
	{
		return (List<Formation>) formationRepository.findAll();
	}
	@PostMapping
	public Formation addFormation(@Valid @RequestBody Formation formation)
	{
		return formationRepository.save(formation);
		
	}
}
