package Parcial2;

public class Persona {
	private String nombre;
	private String apellido;
	private String sexo;
	private long DNI;
	private double saldo;
	private int contrasenia;
	
	public Persona(String nombre, String apellido,String sexo,long  DNI, double saldo, int contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.DNI = DNI;
		this.saldo = saldo;
		this.contrasenia = contrasenia;
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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(int contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void setSumaSueldo(double saldo) {
		this.saldo += saldo;
	}
	
	public void setRestaSueldo(double saldo) {
		this.saldo -= saldo;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}