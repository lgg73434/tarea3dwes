package com.saragb.tarea3dwesSara.servicios;

import org.springframework.stereotype.Controller;


public class SesionActiva {
	
private String usuario;
	
	

	public SesionActiva(String usu) {
		this.usuario = usu;
	}


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
