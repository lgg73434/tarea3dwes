package com.saragb.tarea3dwesSara.vista;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.saragb.tarea3dwesSara.modelo.Ejemplar;
import com.saragb.tarea3dwesSara.modelo.Mensaje;
import com.saragb.tarea3dwesSara.modelo.Planta;
import com.saragb.tarea3dwesSara.servicios.Controlador;
import com.saragb.tarea3dwesSara.servicios.SesionActiva;
import com.saragb.tarea3dwesSara.utilidades.Validar;

@Controller
public class MenuEjemplares {
	
	Scanner scanner = new Scanner(System.in);
	
	@Autowired
	Controlador controlador;
	

	public void mostrarMenuGestionarEjemplares(SesionActiva sesion) {

		
		
		int opcion = 0;
		do {
			System.out.println("\n------------------------------");
			System.out.println("**   Gestionar ejemplares   **");
			System.out.println("------------------------------");
			System.out.println("Seleccione una opción:");
			System.out.println("1.  Registrar un nuevo ejemplar");
			System.out.println("2.  Ver ejemplares de una planta");
			System.out.println("3.  Ver mensajes de seguimiento de un ejemplar");
			System.out.println("4.  Volver atrás");

			try {
				opcion = scanner.nextInt();
				scanner.nextLine();

			} catch (InputMismatchException e) {
				System.err.println("Opción no válida. Debes introducir un número entero.");
				scanner.nextLine(); // Limpiar el buffer de entrada
				continue; // Volver a pedir la opción
			}

			switch (opcion) {
			case 1:
				System.out.println("\n--------------------------------");
				System.out.println("**  Registrar nuevo ejemplar  **");
				System.out.println("--------------------------------");

				List<Planta> plantas = controlador.getServiciosPlanta().mostrarPlantas();
				if (!plantas.isEmpty()) {

					System.out.println("____ Plantas registradas en el vivero ____");

					for (int i = 0; i < plantas.size(); i++) {
						System.out.println(i + 1 + ". " + plantas.get(i).getNombreComun());
					}

					System.out.println("\n");
					int numFinalLista = plantas.size();
					int numPlanta = 0;
					do {
						try {
							System.out.println("Introduce el numero de la planta de la que quieres registrar un ejemplar:");
							numPlanta = scanner.nextInt();
							scanner.nextLine();

							if (numPlanta < 1 || numPlanta > numFinalLista) {
								System.err.println("Debes introducir un número entre 1 y " + numFinalLista);
								
							} else {
								Planta planta = plantas.get(numPlanta-1);
								Ejemplar ejemplar = controlador.getServiciosEjemplar().crearEjemplar(planta);
								
								if (ejemplar != null) {
									String mensaje = "Ejemplar registrado por: " + sesion.getUsuario() + " a las "
											+ Validar.formatoFecha(LocalDateTime.now());
									Mensaje m = new Mensaje(LocalDateTime.now(), mensaje,
											controlador.getServiciosCredenciales().findByUsuario(sesion.getUsuario()), ejemplar);

									if (controlador.getServiciosEjemplar().registrarEjemplarAndMensaje(ejemplar, m)) {
										System.out.println("\nEjemplar y mensaje inicial registrados con éxito.");
									} else {
										System.out.println(
												"\nEjemplar registrado, pero no se ha podido añadir el mensaje inicial.");
									}

								} else {
									System.err.println("\nError al registrar el nuevo ejemplar.");
								}
							}
						} catch (InputMismatchException e) {
							System.err.println("Debes introducir un número entero.");
							scanner.nextLine();
						}
						
					} while (numPlanta < 1 || numPlanta > numFinalLista);
					
				} else {
					System.out.println("\nAún no hay plantas registradas en el vivero.");
				}

				break;

			case 2:
				System.out.println("\n--------------------------------");
				System.out.println("**   Ejemplares de planta/s   **");
				System.out.println("--------------------------------");
				
				List<Planta> plantas1 = controlador.getServiciosPlanta().mostrarPlantas();
				if (!plantas1.isEmpty()) {

					System.out.println("____ Plantas existentes en el vivero ____");
					for (int i = 0; i < plantas1.size(); i++) {
						System.out.println(i + 1 + ". " + plantas1.get(i).getNombreComun());
					}

					System.out.println("\n");
					int numeroFinalLista = plantas1.size();
					int numeroPlanta = 0;
					List<Planta> plantasElegidas = new ArrayList<Planta>();

					do {
						System.out.println("Introduce el número de la planta de la que quieres ver los ejemplares o introduce 0 para salir:");
						try {
							numeroPlanta = scanner.nextInt();
							scanner.nextLine();
						} catch (InputMismatchException e) {
							System.err.println("Debes introducir un número entero.");
							scanner.nextLine();
						}

						if (numeroPlanta > numeroFinalLista || numeroPlanta < 0) {
							System.err.println("Debes introducir un número entre 0 y " + numeroFinalLista);
							continue;
						}

						if (numeroPlanta != 0) {
							plantasElegidas.add(plantas1.get(numeroPlanta - 1));
						}

					} while (numeroPlanta != 0);

					if (!plantasElegidas.isEmpty()) {
						for (int a = 0; a < plantasElegidas.size(); a++) {
							System.out.println(
									"\n\t\t*-*- Ejemplares de " + plantasElegidas.get(a).getNombreComun() + " -*-*");
							List<Ejemplar> ejemplares = controlador.getServiciosEjemplar().mostrarEjemplaresPlanta(plantasElegidas.get(a));

							if (!ejemplares.isEmpty()) {
								System.out.printf("%-20s %-20s %-20s%n", "NOMBRE", "Nº MENSAJES", "ULTIMO MENSAJE");
								System.out.println("---------------------------------------------------------------");
								for (int b = 0; b < ejemplares.size(); b++) {
									List<Mensaje> mensajes = controlador.getServiciosMensaje().getMensajesPorEjemplar(ejemplares.get(b));
									System.out.printf("%-20s %-20d %-20s%n", ejemplares.get(b).getNombre(),
											mensajes.size(), Validar.formatoFecha(mensajes.get(0).getFechaHora()));

								}
							} else {
								System.out.println("\nNo existen ejemplares registrados de "
										+ plantasElegidas.get(a).getNombreComun() + ".");
							}

						}

					} else {
						System.out.println("\nNo has seleccionado ninguna planta de la que ver sus ejemplares.");
					}

				} else {
					System.out.println("\nAún no hay plantas registradas en el vivero.");
				}
				break;

			case 3:
				System.out.println("\n--------------------------------");
				System.out.println("**   Mensajes de seguimiento   **");
				System.out.println("--------------------------------");
				List<Ejemplar> ejemplares = controlador.getServiciosEjemplar().mostrarEjemplares();
				if (!ejemplares.isEmpty()) {

					System.out.println("____ Ejemplares existentes en el vivero ____");
					for (int i = 0; i < ejemplares.size(); i++) {
						System.out.println(i + 1 + ". " + ejemplares.get(i).getNombre());
					}

					int numEjemplar = 0;
					int finEjemplares = ejemplares.size();
					do {
						System.out.println("Introduce el número de ejemplar del que quieres ver su seguimiento:");
						try {
							numEjemplar = scanner.nextInt();
							scanner.nextLine();
						} catch (InputMismatchException e) {
							System.err.println("Debes introducir un número entero.");
							scanner.nextLine();
						}

						if (numEjemplar > finEjemplares || numEjemplar < 0) {
							System.err.println("Debes introducir un número entre 1 y " + finEjemplares);
							continue;
						} else {
							break;
						}

					} while (true);
 
					List<Mensaje> mensajesEjemplar = controlador.getServiciosMensaje().getMensajesPorEjemplar(ejemplares.get(numEjemplar-1));
					if (mensajesEjemplar.isEmpty()) {
						System.out.println("\nEl ejemplar " + ejemplares.get(numEjemplar - 1).getNombre() +" aún no tiene mensajes.");
					} else {
						System.out.println(
								"\n____ Mensajes del ejemplar: " + ejemplares.get(numEjemplar - 1).getNombre()+" ____");
						for (Mensaje m : mensajesEjemplar) {
							System.out.println(Validar.formatoFecha(m.getFechaHora()) + "\t"
									+ m.getPersona().getNombre() + "\n\t" + m.getMensaje()
									+ "\n");
						}
					}

				} else {
					System.out.println("\nAún no hay ejemplares registrados en el vivero.");
				}

				break;

			case 4:
				return;

			default:
				System.err.println("Opción incorrecta.");
			}
		} while (opcion != 4);
	}

}
