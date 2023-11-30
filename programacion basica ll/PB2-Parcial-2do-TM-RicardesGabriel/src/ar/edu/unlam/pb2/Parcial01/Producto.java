package ar.edu.unlam.pb2.Parcial01;

public class Producto extends Item implements Vendible {

	private Integer puntoDeReposicion;

	public Producto(Integer codigo, String nombre, Double precio, Integer puntoDeReposicion) {
		super(codigo, nombre, precio);
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.puntoDeReposicion = puntoDeReposicion;
	}

	public Integer getPuntoDeReposicion() {
		return puntoDeReposicion;
	}

	public void setPuntoDeReposicion(Integer puntoDeReposicion) {
		this.puntoDeReposicion = puntoDeReposicion;
	}

	@Override
	public Integer getCodigo() {
		return codigo;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public Double getPrecio() {
		return precio;
	}
}