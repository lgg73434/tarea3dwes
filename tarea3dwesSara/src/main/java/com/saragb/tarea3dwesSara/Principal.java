package com.saragb.tarea3dwesSara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class Principal implements CommandLineRunner{

	//Inyecta automáticamente dependencias. 
	//Permite que Spring resuelva e inyecte un bean (componente gestionado por el contenedor) en un punto específico del código.
	//@Autowired
	
	
	//Esto viene a ser el 'main'
	@Override
	public void run(String... args) throws Exception {
		System.out.println("*** INICIO ****");
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("*** FIN ****");
		
	}

}
