package ar.edu.unlam.pb1.vivero;

public class Planta {

	private int codigo;
	private String nombre;
	private int stock;
	protected Double precioBase;

	public Planta(int codigo, String nombre, double precio, int stock) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.stock = stock;
		this.precioBase = precio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	/*
	 * Cada Planta tiene un valor denominadado ganancia y este se debe
	 * multiplicar por el precio base para el calculo del precio final. Considerar ademas la/s
	 * interfaces aplicadas a cada tipo de planta, las cuales modifican el precio final de la planta
	 */

	public Double obtenerPrecio(){
		return null;
	}
}