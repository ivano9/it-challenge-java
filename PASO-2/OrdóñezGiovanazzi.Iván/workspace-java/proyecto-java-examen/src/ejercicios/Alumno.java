package ejercicios;

import java.time.LocalDate;

public class Alumno extends Persona {

	private int legajo;

	public Alumno(TipoDocumento tipoDocumento, int nroDocumento, String nombre, String apellido, LocalDate fehaNacimiento, int legajo) {
		super(tipoDocumento, nroDocumento, nombre, apellido, fehaNacimiento);
		this.legajo = legajo;
	}

	public int getLegajo() {
		return this.legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
}
