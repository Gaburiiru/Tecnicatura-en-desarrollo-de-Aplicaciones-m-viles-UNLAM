package cajeroAutomatico3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int i=0;
		int menu=0;
		int posicion=0;
		int inicio=0;
		
		System.out.print("ingrese la cantidad de personas a cargar: ");
		int cantP = teclado.nextInt();
		System.out.println();
		
		Clientes [] vectorCli = new Clientes[cantP];
		
		for(i=0;i<vectorCli.length;i++) {
			System.out.print("ingrese el nombre: ");
			String nombre = teclado.next();
			System.out.print("ingrese el apellido: ");
			String apellido = teclado.next();
			System.out.print("ingrese el pin: ");
			int pin = teclado.nextInt();
			System.out.print("ingrese el sueldo: ");
			Float sueldo = teclado.nextFloat();
			System.out.println();
			
			vectorCli[i] = new Clientes(nombre,apellido,pin,sueldo);
		}
		do {
			System.out.print("ingrese su pin para iniciar sesion: ");
			int pinTemp = teclado.nextInt();
			for(i=0;i<vectorCli.length;i++) {
				if(pinTemp == vectorCli[i].getPin()) {
					posicion=i;
					inicio=1;
					break;
				}else {
					inicio=0;
				}
			}
			do {
				System.out.println();
				System.out.print("ingrese una de las siguientes opciones: \n 1-Depositar \n 2-Extraer \n 3-consultar saldo \n 4-sueldo mas alto \n 5-ordenar secuencialmente \n 6-cerrar sesion \n 7-apagar maquinoli \n=>");
				int opcion = teclado.nextInt();
				switch(opcion) {
					case 1:
						System.out.print("ingrese monto a depositar: ");
						Float monto = teclado.nextFloat();
						vectorCli[posicion].setSumaSueldo(monto);
						menu=0;
						inicio=1;
						break;
					case 2:
						System.out.print("ingrese el monto a extraer: ");
						monto = teclado.nextFloat();
						vectorCli[posicion].setRestaSueldo(monto);
						menu=0;
						inicio=1;
						break;
					case 3:
						System.out.print("su saldo es de: "+vectorCli[posicion].getSueldo());
						menu=0;
						inicio=1;
						break;
					case 4:
						menu=0;
						inicio=1;
						int masRico = 0;
						double dinero = 0;
						for (int w = 0; w < vectorCli.length; w++) {
							if (vectorCli[w].getSueldo() > dinero) {
								masRico = w;
								dinero = vectorCli[w].getSueldo();
								}
						}
						System.out.println("El mas rico es: " + vectorCli[masRico].getNombre() + " " + vectorCli[masRico].getApellido());
						break;
					case 5:
						menu=0;
						inicio=1;
						int p, j;
						Clientes aux;
						for (p = 0; p < vectorCli.length - 1; p++) {
							for (j = 0; j < vectorCli.length - p - 1; j++) {
								if (vectorCli[j + 1].getSueldo() < vectorCli[j].getSueldo()) {
									aux = vectorCli[j + 1];
									vectorCli[j + 1] = vectorCli[j];
									vectorCli[j] = aux;
								}
							}
						}
						for (p = 0; p < vectorCli.length; p++) {
							System.out.println("nombre: "+vectorCli[p].getNombre()+" sueldo: "+vectorCli[p].getSueldo());
						}
						break;
					case 6:
						System.out.print("cerrando sesion papuh");
						System.out.println();
						menu=1;
						inicio=0;
						break;
					case 7:
						System.out.println("adios :C");
						menu=1;
						inicio=1;
						break;
					default:
						menu=0;
						inicio=1;
						break;
				}
			}while(menu==0);
		}while(inicio==0);
		teclado.close();
	}
}