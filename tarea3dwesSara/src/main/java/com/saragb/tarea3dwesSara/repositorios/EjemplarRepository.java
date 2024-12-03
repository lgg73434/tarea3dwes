package com.saragb.tarea3dwesSara.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saragb.tarea3dwesSara.modelo.Ejemplar;
import com.saragb.tarea3dwesSara.modelo.Planta;



@Repository
//Argumentos <Ejemplar, Long>:
//- Ejemplar: clase con la que va a trabajar
//- Long: Tipo de dato que corresponde al atributo de Planta que lleva la anotación @Id  (clave primaria)
public interface EjemplarRepository extends JpaRepository <Ejemplar, Long>{

	@Query("SELECT e FROM Ejemplar e WHERE e.planta = :planta")
	List<Ejemplar> findByPlanta(@Param("planta") Planta planta);


	

}
