package com.saragb.tarea3dwesSara.modelo;

import java.io.Serializable;

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
public class Credenciales implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Atributos
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true, length=15, nullable = false)
	private String usuario;
	
	@Column(length=10,  nullable = false)
	private String password;
	
	@OneToOne
	@JoinColumn(name="idPersona", unique=true, nullable = false)
	private Persona persona;

	
	
	/**
	 * Constructores
	 */
	public Credenciales() {
	}

	public Credenciales(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	public Credenciales(String usuario, String password, Persona persona) {
		this.usuario = usuario;
		this.password = password;
		this.persona = persona;
	}

	
	
	/**
	 * Getter and Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	





	
	
	

}
