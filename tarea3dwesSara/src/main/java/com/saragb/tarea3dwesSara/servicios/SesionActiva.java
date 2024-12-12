package com.saragb.tarea3dwesSara.servicios;

import org.springframework.stereotype.Component;

@Component
public class SesionActiva {

	
	private String usuario;

	public SesionActiva() {
		this.usuario = "";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public void cerrarSesion() {
		this.setUsuario("");
	}

}
