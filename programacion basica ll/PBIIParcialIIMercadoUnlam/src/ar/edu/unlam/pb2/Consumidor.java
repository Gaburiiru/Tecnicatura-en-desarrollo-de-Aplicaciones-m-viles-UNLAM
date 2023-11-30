package ar.edu.unlam.pb2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Consumidor {
	Integer DNI_ESPERADO;
	String NOMBRE_ESPERADO;
	public Map<Long, Pagadora> mediosDePago;
	public Consumidor(Integer dNI_ESPERADO, String nOMBRE_ESPERADO) {
		super();
		DNI_ESPERADO = dNI_ESPERADO;
		NOMBRE_ESPERADO = nOMBRE_ESPERADO;
		this.mediosDePago = new HashMap<>();
	}
	public Integer getDNI_ESPERADO() {
		return DNI_ESPERADO;
	}
	public void setDNI_ESPERADO(Integer dNI_ESPERADO) {
		DNI_ESPERADO = dNI_ESPERADO;
	}
	public String getNOMBRE_ESPERADO() {
		return NOMBRE_ESPERADO;
	}
	public void setNOMBRE_ESPERADO(String nOMBRE_ESPERADO) {
		NOMBRE_ESPERADO = nOMBRE_ESPERADO;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumidor consumidor = (Consumidor) o;
        return Objects.equals(DNI_ESPERADO, consumidor.DNI_ESPERADO) &&
               Objects.equals(NOMBRE_ESPERADO, consumidor.NOMBRE_ESPERADO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DNI_ESPERADO, NOMBRE_ESPERADO);
    }
}
