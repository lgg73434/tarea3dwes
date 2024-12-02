package com.saragb.tarea3dwesSara.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saragb.tarea3dwesSara.repositorios.CredencialesRepository;

@Service
public class ServiciosCredenciales {
	
	@Autowired
	CredencialesRepository credencialesRepo;

	public boolean login(String usuario, String contrasena) {
		if (credencialesRepo.findByUsuarioAndPassword(usuario, contrasena) != null){
			return true;
		}
       return false;     
	}

}
