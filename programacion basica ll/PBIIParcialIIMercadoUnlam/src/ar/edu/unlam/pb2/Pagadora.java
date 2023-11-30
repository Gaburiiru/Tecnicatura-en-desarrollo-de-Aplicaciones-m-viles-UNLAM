package ar.edu.unlam.pb2;

public class Pagadora {
    private Double saldo;
    private Long NUMERO_ESPERADO;
    private String TITULAR_ESPERADO;
    private Integer CODIGO_DE_SEGURIDAD_ESPERADO;
    private String FECHA_DE_VENCIMIENTO_ESPERADO;

    public Pagadora(Double saldo, Long numero, String titular, Integer codigoDeSeguridad, String fechaDeVencimiento) {
        this.saldo = saldo;
        this.NUMERO_ESPERADO = numero;
        this.TITULAR_ESPERADO = titular;
        this.CODIGO_DE_SEGURIDAD_ESPERADO = codigoDeSeguridad;
        this.FECHA_DE_VENCIMIENTO_ESPERADO = fechaDeVencimiento;
    }

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Long getNUMERO_ESPERADO() {
		return NUMERO_ESPERADO;
	}

	public void setNUMERO_ESPERADO(Long nUMERO_ESPERADO) {
		NUMERO_ESPERADO = nUMERO_ESPERADO;
	}

	public String getTITULAR_ESPERADO() {
		return TITULAR_ESPERADO;
	}

	public void setTITULAR_ESPERADO(String tITULAR_ESPERADO) {
		TITULAR_ESPERADO = tITULAR_ESPERADO;
	}

	public Integer getCODIGO_DE_SEGURIDAD_ESPERADO() {
		return CODIGO_DE_SEGURIDAD_ESPERADO;
	}

	public void setCODIGO_DE_SEGURIDAD_ESPERADO(Integer cODIGO_DE_SEGURIDAD_ESPERADO) {
		CODIGO_DE_SEGURIDAD_ESPERADO = cODIGO_DE_SEGURIDAD_ESPERADO;
	}

	public String getFECHA_DE_VENCIMIENTO_ESPERADO() {
		return FECHA_DE_VENCIMIENTO_ESPERADO;
	}

	public void setFECHA_DE_VENCIMIENTO_ESPERADO(String fECHA_DE_VENCIMIENTO_ESPERADO) {
		FECHA_DE_VENCIMIENTO_ESPERADO = fECHA_DE_VENCIMIENTO_ESPERADO;
	}

	public boolean realizarPagoCredito(double monto, double limiteDeComprasEnPesos, double limiteDeComprasEnDolares) throws ExcedeLimiteDeCompraException {
	    if (monto <= limiteDeComprasEnPesos && monto <= limiteDeComprasEnDolares) {
	        // Realizar la lógica de pago y actualización del saldo
	        return true;
	    } else {
	        throw new ExcedeLimiteDeCompraException();
	    }
	}

	public boolean realizarPagoDebito(double saldoCuenta,double saldoPago) throws SaldoInsuficienteException{
		if(saldoCuenta < saldoPago) {			
			return true;
		}else {
			throw new SaldoInsuficienteException();
		}
	}
}
