package com.saragb.tarea3dwesSara.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saragb.tarea3dwesSara.modelo.Ejemplar;
import com.saragb.tarea3dwesSara.modelo.Mensaje;
import com.saragb.tarea3dwesSara.modelo.Persona;



//Argumentos <Mensaje, Long>:
//- Mensaje: clase con la que va a trabajar
//- Long: Tipo de dato que corresponde al atributo de Planta que lleva la anotación @Id  (clave primaria)
public interface MensajeRepository  extends JpaRepository <Mensaje, Long>{

	List<Mensaje> findByEjemplar(Ejemplar ejemplar);

	List<Mensaje> findByPersona(Persona persona);
	
	@Query("SELECT m FROM Mensaje m WHERE m.fechaHora BETWEEN :fechaHora1 AND :fechaHora2")
	List<Mensaje> findMensajesPorFechas(@Param("fechaHora1") LocalDateTime fechaHora1, @Param("fechaHora2") LocalDateTime fechaHora2);
	 
	 @Query("SELECT m FROM Mensaje m WHERE m.ejemplar.planta.nombreComun = :nombreComun") 
	List<Mensaje> findMensajesByNombrePlanta(String nombreComun);

}
