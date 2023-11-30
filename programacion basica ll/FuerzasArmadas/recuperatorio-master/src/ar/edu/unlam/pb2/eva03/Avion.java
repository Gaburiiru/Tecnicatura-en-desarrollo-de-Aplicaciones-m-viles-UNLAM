package ar.edu.unlam.pb2.eva03;

public class Avion extends Vehiculo implements Volador {

	private double altura = 0.0;
	
	public Avion(Integer codigo, String nombre) {
		super(codigo, nombre);
	}
	
	public Avion(String codigo, String nombre) {
		super(codigo, nombre);
	}

	@Override
	public double getAltura() {
		return this.altura;
	}
	
	@Override
	public void setAltura(double altura) {
		this.altura = altura;
	}
}
