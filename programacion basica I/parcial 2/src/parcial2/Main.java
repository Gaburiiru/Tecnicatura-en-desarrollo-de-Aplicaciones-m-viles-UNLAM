package parcial2;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int posicion = 0;
		int menu = 0;
		int i = 0;
		int cajero = 0;
		int intentos = 0;
		final int MAX = 1;    
		int validacion = 0;
		String DNI;
		int e=0;
		int w=0;
		String sexo;
		
	    int uppercaseCounter=0;
        int lowercaseCounter=0;
	    int digitCounter=0;
	    int specialCounter=0;
		
		
		do {
			System.out.println("*************Menu Alta Vector************\n"
								+"**Ingrese el tamaño del vector Personas**");
			System.out.println("******personas a cargar entre 2 y 10*****");
			posicion = teclado.nextInt();
		} while (posicion < 2 || posicion > 10);
		Persona[] Personas = new Persona[posicion];
	
		do {
			System.out.println("************Opciones Menu#1***********\n"
					+ "************Menu Principal*************\n"
					+ "*1- Alta Nueva Persona******************\n"
					+ "*2- Consulta Persona con Mayor Saldo******\n"
					+ "*3- Imprimir Listado Personas*************\n"
					+ "*4- Cargar saldo a la cuenta de una persona*\n"
					+ "*5- INGRESO AL CAJERO (DNI y Contraseña)**\n"
					+ "*6- SALIR ****\n"
					+ "***************************************\n"
					+ "");
			int opcion = teclado.nextInt();
			
			switch(opcion) {
				case 1:
					for(i=0;i<Personas.length;i++) {
						System.out.println("ingrese su nombre: ");
						String nombre = teclado.next();
						System.out.println("ingrese su apellido: ");
						String apellido = teclado.next();
						do {
							System.out.println("ingrese su sexo: ");
							sexo = teclado.next();
							switch(sexo) {
								case "M":
									e=1;
									break;
								case "m":
									e=1;
									break;
								case "F":
									e=1;
									break;
								case "f":
									e=1;
									break;
								default:
									e=0;
									break;
							}
						}while(e==0);
						do {
							validacion=1;
							DNI="";
							System.out.println("ingrese su DNI: ");
							DNI = teclado.next();
						    for (int d=0; d < DNI.length(); d++ ) {
						    	char c = DNI.charAt(d);
						        if(Character.isUpperCase(c)) 
						        	uppercaseCounter++;
						        else if(Character.isLowerCase(c)) 
						        	lowercaseCounter++;
						        else if(Character.isDigit(c)) 
						        	digitCounter++;     
						        if(c>=33&&c<=46||c==64){
						        	specialCounter++;
						        }
						                    
						    }
					    	if (lowercaseCounter == 0 && uppercaseCounter == 0 && specialCounter == 0 && DNI.length() >= MAX) {
							    System.out.println("DNI valido");
							    validacion = 1;
					    	}
					    	else {
						    	System.out.println("ingrese un DNI numerico");
						    	validacion = 0;
						    	lowercaseCounter = 0;
						    	uppercaseCounter = 0;
						    	specialCounter = 0;
						    	digitCounter=0;
						    }
						}while(validacion==0);
						
						Long DNIConvertido = Long.parseLong(DNI);
						
						System.out.println("ingrese su contrase�a: ");
						int contrasenia = teclado.nextInt();
						System.out.println("");
						Personas[i] = new Persona(nombre,apellido,sexo,DNIConvertido,0,contrasenia);
					}
					menu=0;
					break;
				case 2:
					int mayorMonto = 0;
					double monto = 0;
					for (int m = 0; m < Personas.length; m++) {
						if (Personas[m].getSaldo() > monto) {
							mayorMonto = m;
							monto = Personas[m].getSaldo();
							}
					}
					System.out.println("La persona con mayor saldo es: " + Personas[mayorMonto].getNombre() + " " + Personas[mayorMonto].getApellido() + " su DNI es: " + Personas[mayorMonto].getDNI() + " y su saldo es: " + Personas[mayorMonto].getSaldo());
					menu=0;
					break;
				case 3:
					for (i = 0; i < posicion; i++) {
						if (Personas[i] != null) {
							System.out.println(" el nombre es:" + Personas[i].getNombre()
									+ " el apellido es:"+ Personas[i].getApellido()
									+ " el dni es:" + Personas[i].getDNI());
						}
					}
					menu=0;
					break;
				case 4:
					int bandera=0;
					int bandera2=0;
					do {
						System.out.println("ingrese el dni del usuario a depositar: ");
						long DNITempSueldo = teclado.nextLong();
						for(i = 0; i<Personas.length; i++) {
							if(DNITempSueldo == Personas[i].getDNI()) {
								System.out.println("ingese el saldo: ");
								double saldoTemp = teclado.nextDouble();
								if(saldoTemp>0) {	 
									Personas[i].setSumaSueldo(saldoTemp);							
									w=1;
									bandera=0;
									bandera2=0;
									System.out.println("su saldo actual es de: "+Personas[i].getSaldo());
									break;
								}else {
									w=0;
									bandera=0;
									bandera2=1;
									break;
								}
							}else {
								w=0;
								bandera=1;
								bandera2=0;
							}
						}
						if(bandera==1) {
							System.out.println("DNI invalido");
						}
						if(bandera2==1) {
							System.out.println("no se puede ingresar un deposito negativo o 0");
						}
					}while(w==0);
					break;
				case 5:
					do {
						System.out.println("*********Opciones Menu#2*********");
						System.out.print("ingrese su DNI para iniciar sesion: ");
						long DNITemp = teclado.nextLong();
						for(i = 0; i<Personas.length; i++) {
							if(DNITemp == Personas[i].getDNI()) {
								do {
									int contador=3;
									for(int j=0;j<contador;j++) {
										System.out.print("ingrese su contraseña tiene 3 intentos: ");
										int contraTemp = teclado.nextInt();
										if(contraTemp == Personas[i].getContrasenia()) {
											posicion=i;
											intentos=1;
											cajero=1;
											break;
										}else{
											cajero=0;
											intentos=0;
										}
									}
									intentos =1;
								}while(intentos==0);

								break;
								
							}else {
								cajero=0;
							}
						}
					}while(cajero==0);
					int menu3=0;
					do {
						System.out.println("**Opciones Menu#3***\n"
								+ "****Menu Cajero*****\n"
								+ "*1- DEPOSITAR $$ *****\n"
								+ "*2- EXTRAER $$ *******\n"
								+ "*3- CONSULTAR SALDO*\n"
								+ "*4- TRANSFERIR $$ *\n"
								+ "*5- Cambiar contraseña *\n"
								+ "*6- SALIR *********\n"
								+ "*****************");
						int eligio = teclado.nextInt();
						switch(eligio) {
							case 1:
								int g=0;
								do {
									System.out.print("ingrese monto a depositar: ");
									monto = teclado.nextFloat();
									if(monto>0) {	
										Personas[posicion].setSumaSueldo(monto);
										menu3=0;
										System.out.println("su saldo actual es de: "+Personas[posicion].getSaldo());
										g=1;
									}else {
										System.out.println("no puede depositar saldo negativo");
										g=0;
									}
								}while(g==0);
								menu3=0;
								break;
							case 2:
								int extra=0;
								do {
									System.out.print("ingrese el monto a extraer: ");
									monto = teclado.nextFloat();
									if(monto>0 && monto<Personas[posicion].getSaldo()) {
										Personas[posicion].setRestaSueldo(monto);
										System.out.println("su saldo actual es de: "+Personas[posicion].getSaldo());
										extra=1;
									}else {
										System.out.println("no puede extraer saldo negativo o que supere lo que tenga en su cuenta");
										extra=0;
									}
								}while(extra==0);								
								menu3=0;
								break;
							case 3:
								System.out.println("su saldo es de: "+Personas[posicion].getSaldo());
								menu3=0;
								break;
							case 4:
								int depo=0;
								int Noencontrado=0;
								int n = 0;
								do {
									System.out.println("ingrese el DNI del usuario a depositar: ");
									long dnitemp = teclado.nextLong();
									for(int t=0; t<Personas.length; t++) {
										if(dnitemp == Personas[t].getDNI()) {
											do {
												System.out.println("ingrese el monto a depositar: ");
												double deposito = teclado.nextDouble();
												if(deposito>0 && deposito <= Personas[posicion].getSaldo()) {
													Personas[t].setSumaSueldo(deposito);
													Personas[posicion].setRestaSueldo(deposito);
													System.out.println("operacion realizada con exito, su saldo actual es de "+Personas[posicion].getSaldo());
													System.out.println("el saldo de la cuenta a la que le deposito es de: "+Personas[t].getSaldo());
													n=1;
												}else{
													System.out.println("saldo insuficiente");
													n=0;
													System.out.println("ingrese nuevamente");
												}
											}while(n==0);
											break;
										}else {
											Noencontrado=1;
										}
									}
									if(Noencontrado==1) {
										System.out.println("el usuario no existe");
										depo=0;
									}
									depo=1;
								}while(depo==0);
								menu3=0;
								break;
							case 5:
								int cam =0;
								do {
									System.out.println("biemvenido");
									System.out.println("ingrese la nueva contraseña: ");
									int contraNueva = teclado.nextInt();
									System.out.println("ingrese la nueva contraseña nuevamente: ");
									int contraNuevaNueva = teclado.nextInt();
									if(contraNueva ==contraNuevaNueva) {
										System.out.println("contraseña cambiada correctamente");
										Personas[posicion].setContrasenia(contraNueva);
										cam=1;
									}else {
										System.out.println("contraseña invalida :(");
										cam=0;
									}
								}while(cam==0);
								break;
							case 6:
								menu3=1;
								break;
							default:
								menu3=0;
								break;
						}
					}while(menu3==0);
					menu=0;
					break;
				case 6:
					menu=1;
					System.out.println("sayonara");
					break;
				default:
					menu=0;
					break;
			}
		}while(menu==0);
	teclado.close();
	}
}