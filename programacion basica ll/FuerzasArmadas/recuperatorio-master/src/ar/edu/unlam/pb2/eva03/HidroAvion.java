package ar.edu.unlam.pb2.eva03;

public class HidroAvion extends Vehiculo implements Volador, Acuatico {

	private double profundidad = 0.0;
	private double altura = 0.0;
	
	public HidroAvion(Integer codigo, String nombre) {
		super(codigo, nombre);
	}
	
	public HidroAvion(String codigo, String nombre) {
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
	public double getAltura() {
		return this.altura;
	}
	
	@Override
	public void setAltura(double altura) {
		this.altura = altura;
	}

}
