package com.saragb.tarea3dwesSara.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="credenciales")
public class Credenciales {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true, length=15)
	private String usuario;
	
	@Column(length=10,  nullable = false)
	private String password;
	
	@OneToOne
	@JoinColumn(name="idPersona", unique=true)
	private Persona persona;
	





	
	
	

}
