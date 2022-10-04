package tp1_version_2;

public class Persona {
	private String Nombre;
	private String Apellido;
	private Long DNI;
	private int Edad;
	private String Localidad;
	private int telefono;
	
	public Persona(String Nombre,String Apellido,Long DNI,int Edad,String Localidad,int telefono) {
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.DNI = DNI;
		this.Edad = Edad;
		this.Localidad = Localidad;
		this.telefono = telefono;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public Long getDNI() {
		return DNI;
	}

	public void setDNI(Long dNI) {
		DNI = dNI;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String toString() {
		return "Persona [Nombre=" + Nombre + ", Apellido=" + Apellido + ", DNI=" + DNI + ", Edad=" + Edad
				+ ", Localidad=" + Localidad + ", telefono=" + telefono + "]";
	}
	
}
