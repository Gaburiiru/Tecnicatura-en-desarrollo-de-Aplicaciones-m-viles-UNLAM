package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public class Vehiculo {
	
	private Integer codigo;
	private String nombre;	
	
	public Vehiculo(Integer codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public Vehiculo(String codigo, String nombre) {
		this.codigo = Integer.parseInt(codigo);
		this.nombre = nombre;
	}
		
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
