package com.saragb.tarea3dwesSara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tarea3dwesSaraApplication {

	@Bean
	public Principal applicationStartupRunner() {
		return new Principal();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Tarea3dwesSaraApplication.class, args);
	}

}
