package ar.unlam.pb2;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class PruebaSistema {

	@Test
	public void queSePuedaGuardarUnaNuevaConfiguracion() {
		// Preparar los datos
		Sistema miel = new Sistema("Unlam");
		String clave = "Idioma", valor = "Español";
		// Ejecución
		miel.setConfiguracion(new ClaveParaLaConfiguracion(clave), valor);
		// Verificacion
		assertEquals(valor, miel.getConfiguracion(new ClaveParaLaConfiguracion(clave)));
		
	}

	@Test
	public void queSePuedaAlmacenarLaConfiguracion() {
		// Preparar los datos
		Sistema miel = new Sistema("Unlam");
		String clave = "Idioma", valor = "Español";
		// Ejecución
		miel.setConfiguracion(new ClaveParaLaConfiguracion(clave), valor);
		try {
			ManejoDeArchivos.guardarObjeto("C://tmp//desktop.config", miel);
			miel.setConfiguracion(new ClaveParaLaConfiguracion(clave), "Inglés");
			miel = (Sistema)ManejoDeArchivos.leerObjetos("C://tmp//desktop.config");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verificacion
		assertEquals("Español", miel.getConfiguracion(new ClaveParaLaConfiguracion("Idioma")));
	}
	
}
