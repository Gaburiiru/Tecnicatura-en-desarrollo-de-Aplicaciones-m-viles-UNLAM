package ar.edu.unlam.pb2.Parcial01;

public class Servicio extends Item implements Vendible {

	private String fechaDeInicio;
	private String fechaDeFinalizacion;

	public Servicio(Integer codigo, String nombre, Double precio, String fechaDeInicio, String fechaDeFinalizacion) {
		super(codigo, nombre, precio);
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeFinalizacion = fechaDeFinalizacion;
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

	public String getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(String fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public String getFechaDeFinalizacion() {
		return fechaDeFinalizacion;
	}

	public void setFechaDeFinalizacion(String fechaDeFinalizacion) {
		this.fechaDeFinalizacion = fechaDeFinalizacion;
	}
}