package cajeroAutomatico2;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		Scanner teclado = new Scanner(System.in);
		System.out.print("ingrese la cantidad de personas a cargar: ");
		int cantP = teclado.nextInt();
		int x=0;
		Usuario [] vectorClientes = new Usuario[cantP];
		
		for( i=0; i<vectorClientes.length ; i++) {
			System.out.print("\n");
			System.out.print("ingrese el nombre y el apellido: ");
			String nombre_y_apellido = teclado.next();
			System.out.print("ingrese el DNI: ");
			Long DNI = teclado.nextLong();
			System.out.print("ingrese el sueldo: ");
			Double sueldo = teclado.nextDouble();
			System.out.print("ingrese una contrase�a (numerica): ");
			int contrasena = teclado.nextInt();
			
			vectorClientes[i] = new Usuario(nombre_y_apellido,DNI,sueldo,contrasena);
		}
		
		for( i=0; i<vectorClientes.length; i++) {
			System.out.print("\n");
			System.out.print("ingrese su contrase�a para acceder al sistema: ");
			int contraTemp = teclado.nextInt();
			
			if(contraTemp == vectorClientes[i].getContrasena()) {
				do{
					System.out.print("\n");
					System.out.print("ingrese una de las siguientes opnciones: \n 1-Depositar \n 2-Extraer \n 3-Consultar \n 4-Salir \n =>");
					int opcion = teclado.nextInt();
				
					switch(opcion) {
						case 1:
							System.out.print("ingrese el monto a depositar: ");
							Double monto = teclado.nextDouble();
							vectorClientes[i].setSumaSueldo(monto);
							System.out.print("deposito exitoso, su saldo es: "+vectorClientes[i].getSueldo());
							x=0;
							break;
						case 2:
							System.out.print("ingrese el monto a extraer: ");
							monto = teclado.nextDouble();
							vectorClientes[i].setRestaSueldo(monto);
							System.out.print("extraccion exitosa, su saldo es: "+vectorClientes[i].getSueldo());
							x=0;
							break;
						case 3:
							System.out.print("su saldo disponible es: "+vectorClientes[i].getSueldo());
							x=0;
							break;
						case 4:
							System.out.print("saliendo...");
							x=1;
							break;
						default:
							x=0;
							break;
					}
				}while(x==0);
			}
		}
		teclado.close();
	}
}