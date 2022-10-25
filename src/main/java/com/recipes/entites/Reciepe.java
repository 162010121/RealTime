package com.recipes.entites;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="Reciepe")
@Data
public class Reciepe {

	@Id
	@GeneratedValue
	private int reciepeId;
	
	@Column
	private String reciepeName;
	
	@Column
	@JsonFormat
	private LocalDate created;
	
	@Column
	private boolean veg;
	
	@Column
	private int serving;
	
	@Column
	private String instructions;
	
	@OneToMany(targetEntity =Ingrediance.class )
	@JoinColumn(name="RI_fk",referencedColumnName = "reciepeId")
	private List<Ingrediance> ingredianceList;
	
	public Reciepe()
	{
		super();
	}

	public Reciepe(String reciepeName, LocalDate created, boolean veg, int serving, String instructions,
			List<Ingrediance> ingredianceList) {
		super();
		this.reciepeName = reciepeName;
		this.created = created;
		this.veg = veg;
		this.serving = serving;
		this.instructions = instructions;
		this.ingredianceList = ingredianceList;
	}
	
	
	
	
}


