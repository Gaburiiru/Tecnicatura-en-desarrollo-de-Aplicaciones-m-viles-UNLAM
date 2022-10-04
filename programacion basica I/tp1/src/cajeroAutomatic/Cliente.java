package cajeroAutomatic;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private Long DNI;
	private Double sueldo;
	
	public Cliente(String nombre,String apellido,Long DNI,Double sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.sueldo = sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getDNI() {
		return DNI;
	}

	public void setDNI(Long DNI) {
		this.DNI = DNI;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setRestaSueldo(Double restasueldo) {
		this.sueldo -= restasueldo;
	}
	
	public void setSumaSueldo(Double sumasueldo) {
		this.sueldo += sumasueldo;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + DNI + ", sueldo=" + sueldo + "]";
	}
	
}
