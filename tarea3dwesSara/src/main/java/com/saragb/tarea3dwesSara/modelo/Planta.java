package com.saragb.tarea3dwesSara.modelo;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="plantas")
public class Planta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String codigo;
	
	@Column
	private String nombreComun;
	
	@Column
	private String nombreCientifico;
	
	@OneToMany(mappedBy = "planta", cascade = CascadeType.ALL)
	private List<Ejemplar> ejemplares = new LinkedList<Ejemplar>();
	
	
	
	
	
	

}
