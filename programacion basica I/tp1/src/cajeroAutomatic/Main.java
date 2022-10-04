package cajeroAutomatic;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int x=0;
		System.out.println("ingrese la cantidad de personas a cargar: ");
		int cantP = teclado.nextInt();
		//genera_el_vector
		Cliente[]User = new Cliente[cantP];
		
		//inserta_datos
		for(int i=0 ; i<User.length ; i++) {
			System.out.println("ingrese el nombre: ");
			String nombre = teclado.next();
			System.out.println("ingrese el apellido: ");
			String apellido = teclado.next();
			System.out.println("ingrese el DNI: ");
			Long DNI = teclado.nextLong();
			System.out.println("ingrese el sueldo: ");
			Double sueldo = teclado.nextDouble();
			System.out.println("------------------xd------------------");
			User[i] = new Cliente(nombre,apellido,DNI,sueldo);
		}
		//comprueba_si_el_dni_esta_cargado
		System.out.println("inicie sesion con su num de DNI plis xd: ");
		Long DNITemp = teclado.nextLong();

		for(int j=0 ; j<User.length ; j++) {
			if(DNITemp == User[j].getDNI()) {
				System.out.println("benbenuto usuario "+User[j].getNombre());
				do {
					System.out.println("ingrese una de las siguientes opciones: \n 1.DEPOSITAR\n 2.EXTRAER\n 3.CONSULTAR\n 4.SALIR");
					int opcion = teclado.nextInt();
					switch(opcion){
						case 1:
							System.out.println("ingrese el monto a depositar: ");
							Double monto = teclado.nextDouble();
							User[j].setSumaSueldo(monto);
							System.out.println("su sueldo es: "+User[j].getSueldo());
							x=0;
							break;
						case 2:
							System.out.println("ingrese el monto a extraer: ");
							monto = teclado.nextDouble();
							User[j].setRestaSueldo(monto);
							System.out.println("su saldo es: "+User[j].getSueldo());
							x=0;
							break;
						case 3:
							System.out.println("estado de su cuenta: \n"+User[j].toString()+"\n");
							x=0;
							break;
						case 4:
							System.out.println("FINISHIM");
							x=1;
							break;
						default:
							System.out.println("mijo usted esta pendejo");
							x=0;
							break;
					}
				}while(x==0);
			}
		}
		teclado.close();
	}
}
