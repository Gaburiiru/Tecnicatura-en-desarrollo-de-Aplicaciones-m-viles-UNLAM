package ar.unlam.pb2;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Sistema implements Serializable{

	private String nombre;
	private Map<ClaveParaLaConfiguracion, String> configuracion;

	public Sistema(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre; 
		this.configuracion = new TreeMap<ClaveParaLaConfiguracion, String>();
		/*HashMap -> HashCode
		TreeMap -> comparteTo(Comparable)*/
	}

	public void setConfiguracion(ClaveParaLaConfiguracion clave, String valor) {
		// TODO Auto-generated method stub
		configuracion.put(clave, valor);
	}

	public String getConfiguracion(ClaveParaLaConfiguracion clave) {
		// TODO Auto-generated method stub
		return configuracion.get(clave);
	}

}
