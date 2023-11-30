package ar.edu.unlam.pb1.vivero;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
	public void testQueSePuedaAgregarUnaPlanta() {
		 // Preparación
        Vivero vivero = new Vivero("Mi Vivero");
        Planta planta = new Arbol(1, "Pino", 50.0, 10);

        // Ejecución
        boolean agregada = vivero.agregarPlanta(planta);

        // Verificación
        assertTrue(agregada);
        // Asegurarse de que la planta esté presente en el vivero
        //assertTrue(vivero.getPlantas().contains(planta));
	}

}
