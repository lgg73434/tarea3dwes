package com.saragb.tarea3dwesSara.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Controlador {
	
	@Autowired
	ServiciosPlanta svPlanta;
	
	@Autowired
	ServiciosEjemplar svEjemplar;
	
	@Autowired
	ServiciosPersona svPersona;
	
	@Autowired
	ServiciosCredenciales svCredenciales;
	
	@Autowired
	ServiciosMensaje svMensaje;
	
	public ServiciosPlanta getServiciosPlanta() {
		return svPlanta;
	}

	public ServiciosEjemplar getServiciosEjemplar() {
		return svEjemplar;
	}
	
	public ServiciosPersona getServiciosPersona() {
		return svPersona;
	}
	
	public ServiciosCredenciales getServiciosCredenciales() {
		return svCredenciales;
	}
	
	public ServiciosMensaje getServiciosMensaje() {
		return svMensaje;
	}

}
