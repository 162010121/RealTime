package com.recipes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipes.entites.Reciepe;
import com.recipes.exception.ReciepeNotFoundException;
import com.recipes.repository.ReciepeRepository;
import com.recipes.services.RecipeService;

@RestController
@RequestMapping(value="/recipes")
public class ReciepeController {

	@Autowired
	private ReciepeRepository repository;
	
	@Autowired
	private RecipeService service;
	
	@GetMapping("/allRecipes")
	public ResponseEntity<?> getAllReciepes() throws ReciepeNotFoundException
	{
		if(!repository.findAll().isEmpty())
		{
			return new ResponseEntity<>(service.getAllRecipes(), HttpStatus.OK);
		}
		else
		{
			throw new ReciepeNotFoundException("No Recipe Not Found");
		}
		
	}
	
	@PostMapping("/addReciepe")
	public ResponseEntity<?> insertReciepe(@RequestBody Reciepe reciepe)throws ReciepeNotFoundException
	{
		
		Optional<Reciepe> opt=repository.findByName(reciepe.getReciepeName());
		if(opt.isPresent())
		{
			throw new ReciepeNotFoundException("Reciepe Already Exits ");
		}
		else
		{
			repository.save(reciepe);
			return new ResponseEntity<>("Reciepe Is Added in the list",HttpStatus.CREATED);
		}
	}
	
	@PutMapping("/updateReciepe/{reciepeId}")
	public ResponseEntity<?> updateReciepe(@RequestBody Reciepe reciepe ) throws ReciepeNotFoundException
	{
		
		if(repository.existsById(reciepe.getReciepeId()))
		{
			service.updateReciepe(reciepe);
			
			return new ResponseEntity<>("ReciepeId"+reciepe.getReciepeId()+"is updated Successfully",HttpStatus.ACCEPTED);
		}
		
		throw new ReciepeNotFoundException("ReciepeId"+reciepe.getReciepeId()+"is not found");
		
	}
	
	@DeleteMapping("/deleteReciepe/{reciepeId}")
	public ResponseEntity<String> deleteReciepe(@PathVariable ("reciepeId") int reciepeId) throws ReciepeNotFoundException
	{
		Optional<Reciepe> opt=repository.findById(reciepeId);
		
		if(opt.isPresent())
		{
			service.deleteReciepe(reciepeId);
			
			return new ResponseEntity<>("ReciepeId:"+reciepeId+"Is Deleted Succesfully",HttpStatus.OK);
		}
		throw new ReciepeNotFoundException(" ReciepeId	"+reciepeId+"is Not Found");
		
	}
	
	
}
