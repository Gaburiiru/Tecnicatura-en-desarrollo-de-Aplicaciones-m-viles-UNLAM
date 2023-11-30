package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Liga {

	private String nombre;
	private Set<Equipo> equiposincriptos;

	public Liga(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.equiposincriptos = new HashSet<Equipo>();

	}

	public Boolean agregarEquipo(Equipo nuevo) {
		return this.equiposincriptos.add(nuevo);

	}

	public Boolean agregarJugadoraEquipo(Integer numeroDeCamiseta, Jugador nuevo, Equipo destinoEquipo) {
		Boolean sePudo = false;
		if (this.equiposincriptos.contains(destinoEquipo)) {
			destinoEquipo.agregarJugador(numeroDeCamiseta, nuevo);
			sePudo = true;
		}
		return sePudo;
	}

	public Boolean agregarJugadoraEquipo(Integer numeroDeCamiseta, Jugador nuevo,Integer numeroDeEquipoDestino) { 
		Boolean sePudo=false;
		Equipo destinoEquipo = buscarEquipo(numeroDeEquipoDestino);
		
		if(destinoEquipo != null) {
			sePudo = destinoEquipo.agregarJugador(numeroDeCamiseta, nuevo);  
		} 
		return sePudo;
	}
	
	public Boolean TransferenciaJugador(Integer equipoOrigen, Integer equipoDestino, Integer numerodeCamiseta,
			Jugador jugador) {
		Boolean transferencia = false;
		Equipo equipoOrigenBuscado = buscarEquipo(equipoOrigen);
		Equipo equipoDestinoBuscado = buscarEquipo(equipoDestino);
		if (equipoOrigenBuscado != null && equipoDestinoBuscado != null) {
			if (ExisteJugadorEnEquipo(equipoOrigen, numerodeCamiseta)) {
				equipoOrigenBuscado.removerJugador(numerodeCamiseta);
				equipoDestinoBuscado.agregarJugador(numerodeCamiseta, jugador);
				return transferencia = true;
			}

		}
		return transferencia;

	}

	public Boolean ExisteJugadorEnEquipo(Integer equipoOrigen, Integer numerodeCamiseta) {
		Equipo buscado = null;
		buscado = buscarEquipo(equipoOrigen);
		if (buscado.existeJugador(numerodeCamiseta)) {
			return true;
		}
		return false;

	}

	public Equipo buscarEquipo(Integer id) {
		for (Equipo equipo : equiposincriptos) {
			if (equipo.getId().equals(id)) {
				return equipo;
			}
		}
		return null;
	}

}
