package com.saragb.tarea3dwesSara.modelo;

import java.io.Serializable;
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
public class Mensaje  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Atributos
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaHora;
	
	@Column(length = 500, nullable = false)
	@Lob
	private String mensaje;
	
	@ManyToOne
	@JoinColumn(name="idPersona", nullable = false)
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name="idEjemplar", nullable = false)
	private Ejemplar ejemplar;

	
	/**
	 * Constructores
	 */
	public Mensaje() {
	}

	public Mensaje(LocalDateTime fechaHora, String mensaje, Persona persona, Ejemplar ejemplar) {
		this.fechaHora = fechaHora;
		this.mensaje = mensaje;
		this.persona = persona;
		this.ejemplar = ejemplar;
	}

	
	/**
	 * Getters and Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}
	
	
	
	
	
	
	

}
