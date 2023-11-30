package ar.unlam.pb2;

import java.io.Serializable;

public class ClaveParaLaConfiguracion implements Serializable, Comparable{

	private String clave;
	
	public ClaveParaLaConfiguracion(String clave) {
		this.clave = clave;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClaveParaLaConfiguracion other = (ClaveParaLaConfiguracion) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		ClaveParaLaConfiguracion objetoAComparar = (ClaveParaLaConfiguracion)o;
		return clave.compareTo(objetoAComparar.getClave());
	}
	
	
}
