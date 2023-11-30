package ar.edu.unlam.pb2.eva03;

public class Tanque extends Vehiculo implements Terrestre {
	
	private Double velocidad = 0.0;   

	public Tanque(Integer codigo, String nombre) {
		super(codigo, nombre);
	}
	
	public Tanque(String codigo, String nombre) {
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
