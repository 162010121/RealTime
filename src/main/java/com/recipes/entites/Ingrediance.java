package com.recipes.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="INTREDIANCE")

public class Ingrediance {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String ingredianceList;
	
	public Ingrediance()
	{
		super();
		
	}

	public Ingrediance(int id, String ingredianceList) {
		super();
		this.id = id;
		this.ingredianceList = ingredianceList;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIngredianceList() {
		return ingredianceList;
	}

	public void setIngredianceList(String ingredianceList) {
		this.ingredianceList = ingredianceList;
	}
	
	
}
