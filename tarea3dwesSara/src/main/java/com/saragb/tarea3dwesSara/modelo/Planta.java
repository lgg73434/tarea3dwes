package com.saragb.tarea3dwesSara.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="plantas")
public class Planta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String codigo;
	
	
	private String nombreComun;
	
	
	private String nombreCientifico;
	
	
	public Planta() {
	}

	public Planta(String codigo, String nombreComun, String nombrecientifico) {
		this.codigo = codigo;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombrecientifico;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombrecientifico(String nombrecientifico) {
		this.nombreCientifico = nombrecientifico;
	}

	@Override
	public String toString() {
		return "Planta [codigo=" + codigo + ", nombreComun=" + nombreComun + ", nombrecientifico=" + nombreCientifico
				+ "]";
	}
	
	
	
	

}
