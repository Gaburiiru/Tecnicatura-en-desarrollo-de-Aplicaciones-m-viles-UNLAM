package tp1;

public class Persona {

	private String nombre;
	private String apellido;
	private long DNI;
	private int edad;
	private String localidad;
	private long telefono;

	public Persona (String nombre, String apellido, long DNI, int edad, String localidad, long telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.edad = edad;
		this.localidad = localidad;
		this.telefono = telefono;
		
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

	public long getDNI() {
		return DNI;
	}

	public void setDNI(long dNI) {
		DNI = dNI;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + DNI + ", edad=" + edad
				+ ", localidad=" + localidad + ", telefono=" + telefono + "]";
	}
	
}