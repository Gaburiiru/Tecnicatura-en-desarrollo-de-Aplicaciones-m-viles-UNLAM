package ar.unlam.pb2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Equipo {

	//private Set<Jugador> equipo;
	private Integer id;
	private String nombre;
	
	private Map<Integer, Jugador> plantel;
	
	public Equipo (String nombre,Integer id) {
		plantel=new HashMap<>();
		this.id=id;
		this.nombre=nombre;
		
	}
	
	
	public Boolean agregarJugador (Integer numeroCamiseta, Jugador jugador) {
		//return this.equipo.add(jugado);
		Boolean agrego = false;
		if ((!existeJugador(numeroCamiseta))) {
		this.plantel.put(numeroCamiseta, jugador);
		agrego=  true;
	}
		return agrego;
	}


	public Boolean existeJugador (Integer numeroCamiseta) {
		
		Boolean existe = false;
		if (this.plantel.containsKey(numeroCamiseta)) {
		
		existe=  true;
	}
		return existe;
	}

	

	
	public Jugador removerJugador(Integer numeroDeCamiseta) {
		return this.plantel.remove(numeroDeCamiseta);
		
		
		
	}

	public Collection<Jugador> obtenerJugadores() {
		return  this.plantel.values();
		
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}	
