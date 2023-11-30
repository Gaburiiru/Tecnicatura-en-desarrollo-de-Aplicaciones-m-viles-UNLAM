package ar.edu.unlam.pb2.Parcial01;

public class Vendedor {

	private String dni;
	private String nombre;
	private boolean deLicencia;

	public Vendedor(String dni, String nombre, boolean deLicencia) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.deLicencia = deLicencia;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isDeLicencia() {
		return deLicencia;
	}

	public void setDeLicencia(boolean deLicencia) {
		this.deLicencia = deLicencia;
	}

}
