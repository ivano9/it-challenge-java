package ejercicios;

import java.time.LocalDate;

public class Persona {

	enum TipoDocumento {
		DNI,
		LIBRETACIVICA
	}

	private TipoDocumento tipoDocumento;
	private int nroDocumento;
	private String nombre;
	private String apellido;
	private LocalDate fehaNacimiento;

	public Persona(TipoDocumento tipoDocumento, int nroDocumento, String nombre, String apellido, LocalDate fehaNacimiento) {
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fehaNacimiento = fehaNacimiento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public int getNroDocumento() {
		return nroDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFehaNacimiento() {
		return fehaNacimiento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setFehaNacimiento(LocalDate fehaNacimiento) {
		this.fehaNacimiento = fehaNacimiento;
	}
}
