package ejercicios;

import java.time.LocalDate;

/**
 * A. Crear una clase Alumnno con los siguientes campos
 * (con sus respectivos getters, setters y constructor)
 *
 * Persona
 * Legajo - Integer
 *
 *
 * @author examen
 *
 */
public class Ejercicio3 {
	/**
	 *
	 */
	public Ejercicio3() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno a1 = new Alumno(
				   Persona.TipoDocumento.DNI,
				  34420302,
				  "Iván",
				  "Ordóñez Giovannazzi",
				  LocalDate.of(1989,3,9),
				  99999
		);

		System.out.printf("%s\n", a1.getNombre());
		System.out.printf("%s\n", a1.getApellido());
		System.out.printf("%s\n", a1.getTipoDocumento());
		System.out.printf("%s\n", a1.getNroDocumento());
		System.out.printf("%s\n", a1.getFehaNacimiento());
		System.out.printf("%s\n", a1.getLegajo());
	}

}
