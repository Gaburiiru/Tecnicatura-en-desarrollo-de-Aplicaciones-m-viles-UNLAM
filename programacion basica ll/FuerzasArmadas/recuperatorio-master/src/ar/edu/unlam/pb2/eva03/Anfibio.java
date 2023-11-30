package ar.edu.unlam.pb2.eva03;

public class Anfibio extends Vehiculo implements Terrestre, Acuatico {

	private double profundidad = 0.0;
	private Double velocidad = 0.0;
	
	public Anfibio(Integer codigo, String nombre) {
		super(codigo, nombre);
	}
	
	public Anfibio(String codigo, String nombre) {
		super(codigo, nombre);
	}

	@Override
	public double getProfundidad() {
		return this.profundidad;
	}
	
	@Override
	public void setProfundidad(double profundidad) {
		this.profundidad = profundidad;
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
