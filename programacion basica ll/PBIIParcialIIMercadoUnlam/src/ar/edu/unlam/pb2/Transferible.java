package ar.edu.unlam.pb2;

public class Transferible extends Pagadora{
	private String CBU_ESPERADO;
	private String CVU_ESPERADO;
	private String ENTIDAD_ESPERADA;
	private String TITULAR_ESPERADO;
	 
	public Transferible(Double saldo ,String cBU_ESPERADO, String cVU_ESPERADO, String eNTIDAD_ESPERADA, String tITULAR_ESPERADO) {
		super(saldo, null, null, null, null);
		CBU_ESPERADO = cBU_ESPERADO;
		CVU_ESPERADO = cVU_ESPERADO;
		ENTIDAD_ESPERADA = eNTIDAD_ESPERADA;
		TITULAR_ESPERADO = tITULAR_ESPERADO;
	}
	public String getCBU_ESPERADO() {
		return CBU_ESPERADO;
	}
	public void setCBU_ESPERADO(String cBU_ESPERADO) {
		CBU_ESPERADO = cBU_ESPERADO;
	}
	public String getCVU_ESPERADO() {
		return CVU_ESPERADO;
	}
	public void setCVU_ESPERADO(String cVU_ESPERADO) {
		CVU_ESPERADO = cVU_ESPERADO;
	}
	public String getENTIDAD_ESPERADA() {
		return ENTIDAD_ESPERADA;
	}
	public void setENTIDAD_ESPERADA(String eNTIDAD_ESPERADA) {
		ENTIDAD_ESPERADA = eNTIDAD_ESPERADA;
	}
	public String getTITULAR_ESPERADO() {
		return TITULAR_ESPERADO;
	}
	public void setTITULAR_ESPERADO(String tITULAR_ESPERADO) {
		TITULAR_ESPERADO = tITULAR_ESPERADO;
	}
}
