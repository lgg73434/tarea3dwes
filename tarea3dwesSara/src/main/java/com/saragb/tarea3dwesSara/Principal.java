package com.saragb.tarea3dwesSara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.saragb.tarea3dwesSara.modelo.Planta;
import com.saragb.tarea3dwesSara.servicios.ServiciosCredenciales;
import com.saragb.tarea3dwesSara.servicios.ServiciosEjemplar;
import com.saragb.tarea3dwesSara.servicios.ServiciosMensaje;
import com.saragb.tarea3dwesSara.servicios.ServiciosPersona;
import com.saragb.tarea3dwesSara.servicios.ServiciosPlanta;



public class Principal implements CommandLineRunner{
	
	@Autowired
	ServiciosPlanta svPlanta;
	
	@Autowired
	ServiciosEjemplar svEjemplar;

	
	//Esto viene a ser el 'main'
	@Override
	public void run(String... args) throws Exception {
		System.out.println("*** INICIO ****");
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("*** FIN ****");
		
	}

}
