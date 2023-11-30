package ar.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class EquipoTest {

	@Test
	public void queNoSepuedaAgregarDosJugadoresConLaMismaCamiseta() {
		Equipo river = new Equipo("River", 1235);

		Jugador j1 = new Jugador(25000,"juan" , "perez");


		Jugador j2 = new Jugador(32000,"pedro" , "perez");
		
		
		river.agregarJugador(1,j1);

		  
		
		assertFalse(river.agregarJugador(1,j1));
	}

	@Test
	public void quePuedaAgrgarEquipoAlaAfa() {
		Liga afa=new Liga("afa");
		Equipo river = new Equipo("River", 100);
		Equipo boca = new Equipo("Boca", 1);

		Jugador j1 = new Jugador(25000,"juan" , "perez");


		Jugador j2 = new Jugador(32000,"pedro" , "quiroga");
		
		
		river.agregarJugador(1,j1);
		
		river.agregarJugador(2,j2);

		
		  
		  Boolean sepudo= afa.agregarEquipo(river);
		 assertTrue(sepudo);
	}
	@Test
	public void quePuedaAgrgarUnJugadorAunEquipoinscriptoenlaAfa() {
		Liga afa=new Liga("afa");
		Equipo river = new Equipo("River", 100);
		Equipo boca = new Equipo("Boca", 1);

		Jugador j1 = new Jugador(25000,"juan" , "perez");


		Jugador j2 = new Jugador(32000,"pedro" , "quiroga");
		
	
		river.agregarJugador(1,j1);
		
		river.agregarJugador(2,j2);

		 
		  afa.agregarEquipo(river);
		 
		  Boolean sepudo=  afa.agregarJugadoraEquipo(1, j1, river);
		 assertTrue(sepudo);
	}

	@Test
	public void queNoPuedaAgrgarUnJugadorAunEquipoQueNoEstaInscriptoEnLaAfa() {
		Liga afa=new Liga("afa");
		Equipo river = new Equipo("River", 100);
		Equipo boca = new Equipo("Boca", 1);

		Jugador j1 = new Jugador(25000,"juan" , "perez");


		Jugador j2 = new Jugador(32000,"pedro" , "quiroga");
		
	
		river.agregarJugador(1,j1);
		
		river.agregarJugador(2,j2);

		 
		  //afa.agregarEquipo(river);
		 
		  Boolean sepudo=  afa.agregarJugadoraEquipo(1, j1, river);
		 assertFalse(sepudo);
		 
	}
	@Test
	public void quePuedaTranferirUnJugadorDeUnEquipoAOtroEquipo() {
		Liga afa=new Liga("afa");
		Equipo river = new Equipo("River", 100);
		Equipo boca = new Equipo("Boca", 1);

		Jugador j1 = new Jugador(25000,"juan" , "perez");


		Jugador j2 = new Jugador(32000,"pedro" , "quiroga");
		
		
		river.agregarJugador(1,j1);
		
		river.agregarJugador(2,j2);

		
		  afa.agregarEquipo(river);
		  afa.agregarEquipo(boca);
		  afa.agregarJugadoraEquipo(1, j1, river);
		
		  Boolean sepudo=  afa.TransferenciaJugador(100, 1, 1, j1);
		 assertTrue(sepudo);
		
		
	}
	@Test
	public void queNosePuedaTranferirUnJugadorDeUnEquipoAOtroEquipoSiNoEstaRegistradoEnElEquipoOrigen() {
		Liga afa=new Liga("afa");
		Integer idRiver=100;
		Integer idBoca=1;
		Equipo river = new Equipo("River", idRiver);
		Equipo boca = new Equipo("Boca", idBoca);

		Jugador j1 = new Jugador(25000,"juan" , "perez");
		Jugador j2 = new Jugador(32000,"pedro" , "quiroga");
		
		//agrego jugador a plantel
		
		river.agregarJugador(2,j2);

		//agrego equipo a afa -liga 
		  afa.agregarEquipo(river);
		  afa.agregarEquipo(boca);
		  //agrego jugador a equipo ya incripto 
		  afa.agregarJugadoraEquipo(1, j1, boca);
		
		  Boolean sepudo=  afa.TransferenciaJugador(idRiver, idBoca, 1, j1);
		  
		 Boolean encontrado= afa.ExisteJugadorEnEquipo(idRiver, 1);
		  assertFalse(sepudo);
		  assertFalse(encontrado);
		 
		
		
	}
	
	
	
	
}
