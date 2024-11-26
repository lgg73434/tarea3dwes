package com.saragb.tarea3dwesSara.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saragb.tarea3dwesSara.modelo.Planta;
import com.saragb.tarea3dwesSara.repositorios.PlantaRepository;



@Service
public class ServiciosPlanta {
	
	@Autowired
	PlantaRepository plantaRepo;
	
	@Autowired
	ServiciosEjemplar svEjemplar;
	
	public void addPlanta (Planta p) {
		plantaRepo.save(p);
		
		
	}

}
