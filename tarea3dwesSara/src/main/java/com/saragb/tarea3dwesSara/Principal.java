package com.saragb.tarea3dwesSara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.saragb.tarea3dwesSara.servicios.ServiciosEjemplar;
import com.saragb.tarea3dwesSara.vista.ViveroFachada;



public class Principal implements CommandLineRunner{
	
	@Autowired
	ViveroFachada portalVivero;
	
	//Esto viene a ser el 'main'
	@Override
	public void run(String... args) throws Exception {
		portalVivero.iniciarPrograma();
		
		portalVivero.cerrarScanner();
		
	}

}
