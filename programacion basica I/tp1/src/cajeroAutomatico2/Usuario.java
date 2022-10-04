package cajeroAutomatico2;

public class Usuario {
	private String nombre_apellido;
	private Long DNI;
	private Double sueldo;
	private int contrasena;
	
	public Usuario(String nombre_apellido, Long DNI, Double sueldo,int contrasena) {
		this.nombre_apellido = nombre_apellido;
		this.DNI = DNI;
		this.sueldo = sueldo;
		this.contrasena = contrasena;
	}

	public String getNombre_apellido() {
		return nombre_apellido;
	}

	public void setNombre_apellido(String nombre_apellido) {
		this.nombre_apellido = nombre_apellido;
	}

	public int getContrasena() {
		return contrasena;
	}

	public void setcontrasena(int contrasena) {
		this.contrasena = contrasena;
	}
	
	public Long getDNI() {
		return DNI;
	}

	public void setDNI(Long dNI) {
		DNI = dNI;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	
	public void setSumaSueldo(Double sueldo) {
		this.sueldo += sueldo;
	}
	
	public void setRestaSueldo(Double sueldo) {
		this.sueldo -= sueldo;
	}
	
}
