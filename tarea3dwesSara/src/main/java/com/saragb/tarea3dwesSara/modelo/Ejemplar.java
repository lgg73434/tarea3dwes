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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ejemplares")
public class Ejemplar implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="idPlanta", nullable = false)
	private Planta planta;
	
	@OneToMany(mappedBy = "ejemplar", cascade = CascadeType.ALL)
	private List<Mensaje> mensajes = new LinkedList<Mensaje>();



	
	
}
