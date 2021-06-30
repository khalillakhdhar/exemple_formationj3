package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Formation;
import com.example.demo.exception.ResourceNotFoundException;
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
	@GetMapping("/{id}")
	public Formation getFormationById(@PathVariable(value = "id") Long idformation)
	{
	return formationRepository.findById(idformation).orElseThrow(()->new ResourceNotFoundException("formation", "id", idformation));	
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFormation(@PathVariable(value="id") Long idformation)
	{
		Formation formation=formationRepository.findById(idformation).orElseThrow(()->new ResourceNotFoundException("formation", "id", idformation));
		formationRepository.delete(formation);
		return ResponseEntity.ok().build();
	}
}
