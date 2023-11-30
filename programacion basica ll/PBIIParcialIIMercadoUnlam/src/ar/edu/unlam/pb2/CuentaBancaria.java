package ar.edu.unlam.pb2;

public class CuentaBancaria extends Transferible{

	public CuentaBancaria(Double saldo,String cBU_ESPERADO, String eNTIDAD_ESPERADA, String tITULAR_ESPERADO) {
		super(saldo,cBU_ESPERADO,null, eNTIDAD_ESPERADA, tITULAR_ESPERADO);
	}
}
