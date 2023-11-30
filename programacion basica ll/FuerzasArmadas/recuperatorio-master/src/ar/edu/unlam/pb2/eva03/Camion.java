package ar.edu.unlam.pb2.eva03;

public class Camion extends Vehiculo implements Terrestre {

	private Double velocidad = 0.0;
	
	public Camion(Integer codigo, String nombre) {
		super(codigo, nombre);
	}
	
	public Camion(String codigo, String nombre) {
		super(codigo, nombre);
	}

	@Override
	public double getVelocidad() {
		return this.velocidad;
	}
	
	@Override
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

}
