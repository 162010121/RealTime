package com.recipes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.recipes.entites.Reciepe;

public interface RecipeService {
	
	public List<Reciepe> getAllRecipes();
	
	public Reciepe saveRecipe(Reciepe recipe);
	
	public void updateReciepe(Reciepe reciepe);
	
	public void deleteReciepe(int reciepId);
	
	public Reciepe getReciepeDetails(int reciepId);

}
