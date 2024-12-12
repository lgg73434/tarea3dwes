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

	/**
	 * Devuelve una lista de ejemplares filtrando por planta
	 * @param planta
	 * @return Lista de ejemplares
	 */
	@Query("SELECT e FROM Ejemplar e WHERE e.planta = :planta")
	List<Ejemplar> findByPlanta(@Param("planta") Planta planta);

	
	/**
	 * Devuelve todos los ejemplares registrados en orden alfabético
	 * @return lista de ejemplares
	 */
	List<Ejemplar> findAllByOrderByNombreAsc();

	
	/**
	 * Busca un ejemplar a partir de un nombre
	 * @param nombre
	 * @return Ejemplar
	 */
	Ejemplar findByNombre(String nombre);


	

}
