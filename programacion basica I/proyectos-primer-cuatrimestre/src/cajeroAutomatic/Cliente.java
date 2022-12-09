package cajeroAutomatic;

public class Cliente {
	private String nombre;
	private String apellido;
	private int pin;
	private double sueldo;
	
	public Cliente(String nombre, String apellido, int pin, double sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.pin = pin;
		this.sueldo = sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public long getPin() {
		return pin;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSumaSueldo(double sueldo) {
		this.sueldo += sueldo;
	}
	
	public void setRestaSueldo(double sueldo) {
		this.sueldo -= sueldo;
	}
		
}
