package ejercicios;

import java.time.LocalDate;
import java.time.Month;

/**
 * A. Crear una clase Persona con los siguientes campos
 * (con sus respectivos getters, setters y constructor)
 *
 * TipoDocumento - enum (dni/libretacivica)
 * NroDocumento - Integer
 * Nombre - String
 * Apellido - String
 * FechaNacimiento - Date
 *
 * B. En el método main de la clase "Ejercicio2" crear una nueva instancia
 * de la clase persona y settearle valores reales con tus datos
 *
 *
 * C. En el método main de la clase "Ejercicio 2" imprimir los valores en
 * consola
 * (crear método main e imprimir valores)
 *
 * @author examen
 *
 */
public class Ejercicio2 {

	/**
	 *
	 */
	public Ejercicio2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Persona persona1 = new Persona(
				  Persona.TipoDocumento.DNI,
				  34420302,
				  "Iván",
				  "Ordóñez Giovanazzi",
				  LocalDate.of(1989, Month.MARCH,9)
		);

		System.out.printf("Tipo de documento:   %s\n", persona1.getTipoDocumento());
		System.out.printf("Número de documento: %s\n", persona1.getNroDocumento());
		System.out.printf("Nombre:              %s\n", persona1.getNombre());
		System.out.printf("Apellido:            %s\n", persona1.getApellido());
		System.out.printf("Fecha de nacimiento: %s\n", persona1.getFehaNacimiento());
	}

}
