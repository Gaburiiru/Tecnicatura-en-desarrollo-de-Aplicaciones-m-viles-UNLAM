package ar.edu.unlam.pb2;

public class TarjetaDeCredito extends Pagadora {
	
	Double LIMITE_COMPRA_EN_PESOS;
	Double LIMITE_DE_COMPRA_EN_DOLARES;
    public TarjetaDeCredito(Long numero, String titular, String fechaDeVencimiento, Integer codigoDeSeguridad, double limiteDeComprasEnPesos,double limiteDeComprasEnDolares) {
        super(null,numero, titular, codigoDeSeguridad, fechaDeVencimiento);
        this.LIMITE_COMPRA_EN_PESOS=limiteDeComprasEnPesos;
        this.LIMITE_DE_COMPRA_EN_DOLARES=limiteDeComprasEnDolares;
    }
	public Double getLIMITE_COMPRA_EN_PESOS() {
		return LIMITE_COMPRA_EN_PESOS;
	}
	public void setLIMITE_COMPRA_EN_PESOS(Double lIMITE_COMPRA_EN_PESOS) {
		LIMITE_COMPRA_EN_PESOS = lIMITE_COMPRA_EN_PESOS;
	}
	public Double getLIMITE_DE_COMPRA_EN_DOLARES() {
		return LIMITE_DE_COMPRA_EN_DOLARES;
	}
	public void setLIMITE_DE_COMPRA_EN_DOLARES(Double lIMITE_DE_COMPRA_EN_DOLARES) {
		LIMITE_DE_COMPRA_EN_DOLARES = lIMITE_DE_COMPRA_EN_DOLARES;
	}
    
}