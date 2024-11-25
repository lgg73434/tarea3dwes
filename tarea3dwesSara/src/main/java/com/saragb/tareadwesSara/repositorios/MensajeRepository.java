package com.saragb.tareadwesSara.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saragb.tarea3dwesSara.modelo.Mensaje;


@Repository
//Argumentos <Mensaje, Long>:
//- Mensaje: clase con la que va a trabajar
//- Long: Tipo de dato que corresponde al atributo de Planta que lleva la anotación @Id  (clave primaria)
public interface MensajeRepository  extends JpaRepository <Mensaje, Long>{

}
