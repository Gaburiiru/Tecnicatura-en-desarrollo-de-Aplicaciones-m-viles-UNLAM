package ar.edu.unlam.pb2;

import java.util.Objects;

public class Comercio {
	Long CUIT_ESPERADO;
	String NOMBRE_ESPERADO;
	public Comercio(Long cUIT_ESPERADO, String nOMBRE_ESPERADO) {
		super();
		CUIT_ESPERADO = cUIT_ESPERADO;
		NOMBRE_ESPERADO = nOMBRE_ESPERADO;
	}
	public Long getCUIT_ESPERADO() {
		return CUIT_ESPERADO;
	}
	public void setCUIT_ESPERADO(Long cUIT_ESPERADO) {
		CUIT_ESPERADO = cUIT_ESPERADO;
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
	    Comercio comercio = (Comercio) o;
	    return Objects.equals(CUIT_ESPERADO, comercio.CUIT_ESPERADO) &&
	           Objects.equals(NOMBRE_ESPERADO, comercio.NOMBRE_ESPERADO);
	}

    @Override
    public int hashCode() {
        return Objects.hash(CUIT_ESPERADO, NOMBRE_ESPERADO);
    }
}
