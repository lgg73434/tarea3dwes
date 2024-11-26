package com.saragb.tarea3dwesSara.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;




@Entity
@Table(name="mensajes")
public class Mensaje {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaHora;
	
	@Column
	@Lob
	private String mensaje;
	
	@ManyToOne
	@JoinColumn(name="idPersona")
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name="idEjemplar")
	private Ejemplar ejemplar;
	
	
	
	
	
	
	

}
