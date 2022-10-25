package com.recipes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipes.entites.Reciepe;
import com.recipes.repository.ReciepeRepository;
import com.recipes.services.RecipeService;


@Service
public class ReciepeServiceImpl implements RecipeService {

	@Autowired
	private ReciepeRepository repository;
	
	
	
	@Override
	public List<Reciepe> getAllRecipes() {
	
		return repository.findAll() ;
	}

	@Override
	public Reciepe saveRecipe(Reciepe recipe) {
		
		return repository.save(recipe);
	}

	@Override
	public void updateReciepe(Reciepe reciepe) {
	
		repository.save(reciepe);
	}

	@Override
	public void deleteReciepe(int reciepId) {
	
		
		repository.deleteById(reciepId);;
	}

	@Override
	public Reciepe getReciepeDetails(int reciepId) {
	
		return repository.findById(reciepId).get();
	}

}
