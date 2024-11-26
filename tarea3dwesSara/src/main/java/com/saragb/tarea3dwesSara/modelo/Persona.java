package com.saragb.tarea3dwesSara.modelo;

import java.io.Serializable;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="personas")
public class Persona implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column(unique=true)
	private String email;
	
	@OneToOne(mappedBy= "persona", cascade= CascadeType.ALL)
	private Credenciales credenciales;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	private List<Mensaje> mensajes = new LinkedList<Mensaje>();
	
	

}
