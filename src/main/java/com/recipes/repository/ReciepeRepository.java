package com.recipes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.recipes.entites.Reciepe;

public interface ReciepeRepository extends JpaRepository<Reciepe, Integer> {
	
	
	  @Query("SELECT r from Reciepe r WHERE r.reciepeName=:reciepeName ")
	  public Optional<Reciepe> findByName(@Param("reciepeName") String reciepeName);
	 

}
