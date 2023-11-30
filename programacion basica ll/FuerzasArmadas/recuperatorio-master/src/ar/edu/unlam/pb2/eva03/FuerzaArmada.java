package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FuerzaArmada {

	private Set<Vehiculo> convoy;
	private Map<String, Batalla> batallas;	
	
	
	public FuerzaArmada() {
		super();
		this.convoy = new HashSet<>();
		this.batallas = new HashMap<>();
	}

	public Set<Vehiculo> getConvoy() {
		return convoy;
	}

	public void setConvoy(Set<Vehiculo> convoy) {
		this.convoy = convoy;
	}

	public Batalla getBatalla(String nombre) throws BatallaInexistente{   //Este método se puede anular y usar directamente "batallas.get(nombreDeLaBatalla);" para encontrar una batalla en el map
		for (Map.Entry<String, Batalla> entry : batallas.entrySet()) {
			if(entry.getKey().equals(nombre)) {
				return entry.getValue();
			}
		}
		throw new BatallaInexistente();
	}

	public void setBatalla(Map<String, Batalla> batallas) {
		this.batallas = batallas;
	}
	
	public void agregarVehiculo(Vehiculo vehiculo) {
		convoy.add(vehiculo);
	}

	public Integer getCapacidadDeDefensa() {
		if(!convoy.isEmpty()) {
			return convoy.size();
		}
		return 0;
	}
	
	public void crearBatalla(String nombre, TipoDeBatalla tipo, double latitud, double longitud) {
		Batalla batalla = new Batalla(latitud,longitud,tipo);
		batallas.put(nombre, batalla);
	}

	public void crearBatalla(String tipo, double latitud, double longitud, String nombre) {	
		TipoDeBatalla tipoDeBatalla = TipoDeBatalla.valueOf(tipo.toUpperCase());
		crearBatalla(nombre, tipoDeBatalla, latitud, longitud);
//		Batalla batalla = new Batalla(latitud,longitud,tipoDeBatalla);
//		batallas.put(nombre, batalla);	
	}
	
	private Vehiculo buscarVehiculoPorCodigo(Integer codigoDeVehiculo) throws VehiculoInexistente{
		for (Vehiculo vehiculo : convoy) {
			if(vehiculo.getCodigo() == codigoDeVehiculo) {
				return vehiculo;
			}
		}
		throw new VehiculoInexistente();
	}

	public boolean enviarALaBatalla(String nombreDeLaBatalla, Integer codigoDeVehiculo) throws VehiculoIncompatible, VehiculoInexistente, BatallaInexistente{
		Batalla batalla = getBatalla(nombreDeLaBatalla);  //El método se puede reemplazar por la línea de abajo
		//batalla = batallas.get(nombreDeLaBatalla);
		Vehiculo vehiculo = buscarVehiculoPorCodigo(codigoDeVehiculo);
		
		switch(batalla.getTipo()) {
			case TERRESTRE:{
				if(vehiculo instanceof Terrestre) {
					batalla.vehiculosEnLaBatalla.add(vehiculo);
					return true;
				}throw new VehiculoIncompatible();
			}
			case NAVAL:{
				if(vehiculo instanceof Acuatico) {
					batalla.vehiculosEnLaBatalla.add(vehiculo);
					return true;
				}throw new VehiculoIncompatible();
			}
			case AEREA:{
				if(vehiculo instanceof Volador) {
					batalla.vehiculosEnLaBatalla.add(vehiculo);
					return true;
				}throw new VehiculoIncompatible();
			}
		}
		return false;
	}
}
