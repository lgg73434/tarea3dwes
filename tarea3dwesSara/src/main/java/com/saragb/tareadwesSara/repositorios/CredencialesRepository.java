package com.saragb.tareadwesSara.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saragb.tarea3dwesSara.modelo.Credenciales;


@Repository
//Argumentos <Credenciales, Long>:
//- Credenciales: clase con la que va a trabajar
//- Long: Tipo de dato que corresponde al atributo de Planta que lleva la anotación @Id  (clave primaria)
public interface CredencialesRepository extends JpaRepository <Credenciales, Long> {

}