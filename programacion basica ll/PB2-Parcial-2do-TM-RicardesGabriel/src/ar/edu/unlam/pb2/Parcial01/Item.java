package ar.edu.unlam.pb2.Parcial01;

public abstract class Item {

	protected Integer codigo;
	protected String nombre;
	protected Double precio;
	
	public Item(Integer codigo, String nombre, Double precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	// TODO: Completar con los getters y setters necesarios
}
