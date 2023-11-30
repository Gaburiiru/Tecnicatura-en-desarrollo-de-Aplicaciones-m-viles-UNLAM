package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Set;

public class Batalla {
	
	private Double latitud;
	private Double longitud;
	private TipoDeBatalla tipo;
	Set<Vehiculo> vehiculosEnLaBatalla;
	
	public Batalla(Double latitud, Double longitud, TipoDeBatalla tipo) {
		this.latitud = latitud;
		this.longitud = longitud;
		this.tipo = tipo;
		this.vehiculosEnLaBatalla = new HashSet<>();
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public TipoDeBatalla getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeBatalla tipo) {
		this.tipo = tipo;
	}

	public Set<Vehiculo> getVehiculosEnLaBatalla() {
		return vehiculosEnLaBatalla;
	}

	public void setVehiculosEnLaBatalla(Set<Vehiculo> vehiculosEnLaBatalla) {
		this.vehiculosEnLaBatalla = vehiculosEnLaBatalla;
	}	
	
	
}
