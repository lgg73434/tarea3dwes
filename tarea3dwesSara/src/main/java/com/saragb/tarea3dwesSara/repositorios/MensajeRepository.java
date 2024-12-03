package com.saragb.tarea3dwesSara.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saragb.tarea3dwesSara.modelo.Ejemplar;
import com.saragb.tarea3dwesSara.modelo.Mensaje;



//Argumentos <Mensaje, Long>:
//- Mensaje: clase con la que va a trabajar
//- Long: Tipo de dato que corresponde al atributo de Planta que lleva la anotación @Id  (clave primaria)
public interface MensajeRepository  extends JpaRepository <Mensaje, Long>{

	List<Mensaje> findByEjemplar(Ejemplar ejemplar);

}
