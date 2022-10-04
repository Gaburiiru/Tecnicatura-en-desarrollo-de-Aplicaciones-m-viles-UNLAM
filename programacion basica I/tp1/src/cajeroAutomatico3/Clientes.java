package cajeroAutomatico3;

public class Clientes {
	
	private String nombre;
	private String apellido;
	private int pin;
	private Float sueldo;
	
	public Clientes(String nombre,String apellido,int pin,Float sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.pin = pin;
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

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public Float getSueldo() {
		return sueldo;
	}

	public void setSueldo(Float sueldo) {
		this.sueldo = sueldo;
	}
	
	public void setSumaSueldo(Float sueldo) {
		this.sueldo += sueldo;
	}
	
	public void setRestaSueldo(Float sueldo) {
		this.sueldo -= sueldo;
	}
	
}
