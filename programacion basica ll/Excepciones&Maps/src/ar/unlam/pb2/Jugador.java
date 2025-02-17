package ar.unlam.pb2;

import java.util.Objects;

public class Jugador {
 
	private String nombre;
	private String apellido;
	private Integer dni;
	
	
	public Jugador(Integer dni, String nombre, String apellido) {
		super();
 
		this.dni=dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	 
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
	 
	
	

}
