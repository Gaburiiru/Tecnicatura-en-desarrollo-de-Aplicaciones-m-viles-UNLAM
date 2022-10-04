package tp1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int posicion = 0;
		String temp = "";
		int x = 1;
		int b = 1;
		String salir = "";
		Persona[] vector;

		do {
			System.out.println("ingrese un valor del 10 al 20");
			posicion = teclado.nextInt();

		} while (posicion < 1 || posicion > 20);
		vector = new Persona[posicion];
		do {
			System.out.println(
					" Menu \n 1-Cargar personas \n 2-Listar totalidad de personas \n 3-Mostrar persona mas grande \n 4-Listar personas por localidad \n 5-Buscar persona por DNI \n 6-Ordenar persona por DNI \n 7-Salir");
			int opcion = teclado.nextInt();
			switch (opcion) {
			case 1:// ----------------CARGAR-----------------------
				for (int i = 0; i < posicion; i++) {
					System.out.println("ingrese el nombre: ");
					String nombre = teclado.next();
					System.out.println("ingrese el apellido: ");
					String apellido = teclado.next();
					System.out.println("ingrese el DNI: ");
					long dni = teclado.nextLong();
					System.out.println("ingrese la edad: ");
					int edad = teclado.nextInt();

					do {
						System.out.println("Seleccione la localidad: \n 1-Haedo \n 2-Moron \n 3-S.J. \n 4-R.M.");
						int localidad = teclado.nextInt();
						switch (localidad) {
						case 1:
							temp = "Haedo";
							x = 0;
							break;
						case 2:
							temp = "Moron";
							x = 0;
							break;
						case 3:
							temp = "S.J.";
							x = 0;
							break;
						case 4:
							temp = "R.M.";
							x = 0;
							break;
						default:
							x = 1;
							break;
						}
					} while (x == 1);
					System.out.println("ingrese el telefono: ");
					long telefono = teclado.nextLong();
					System.out.println("-------------------------");
					vector[i] = new Persona(nombre, apellido, dni, edad, temp, telefono);

				}

				break;
			case 2:// ----------------MostarPersonas-----------------------
				for (int i = 0; i < posicion; i++) {
					if (vector[i] != null) {
						System.out.println(" el nombre es:" + vector[i].getNombre() + "\n el apellido es:"
								+ vector[i].getApellido() + "\n el dni es:" + vector[i].getDNI() + "\n el telefono es:"
								+ vector[i].getTelefono() +"\n");
					}
				}
				break;
			case 3:// ----------------MostrarPvieja-----------------------
				long menorDNI = vector[0].getDNI();
				int contador = 0;
				for (int i = 1; i < posicion; i++) {
					if (vector[i].getDNI() < menorDNI) {
						menorDNI = vector[i].getDNI();
						contador = i;
					}
				}
				System.out.println(" La persona mas grande es: " + "\n " + vector[contador].toString());
				break;
			case 4:// ----------------LOCALIDAD-----------------------
				do {
					System.out.println("Seleccione la localidad: \n 1-Haedo \n 2-Moron \n 3-S.J. \n 4-R.M.");
					int localidad = teclado.nextInt();
					switch (localidad) {
					case 1:
						temp = "Haedo";
						x = 0;
						break;
					case 2:
						temp = "Moron";
						x = 0;
						break;
					case 3:
						temp = "S.J.";
						x = 0;
						break;
					case 4:
						temp = "R.M.";
						x = 0;
						break;
					default:
						x = 1;
						break;
					}
				} while (x == 1);

				for (int i = 0; i < vector.length; i++) {

					if (temp == vector[i].getLocalidad()) {
						System.out.println(" el nombre es: " + vector[i].getNombre() + "\n el apellido es: " + vector[i].getApellido() + "\n la edad es: " + vector[i].getEdad() + "\n el DNI es: " + vector[i].getDNI()+ "\n el telefono es: " + vector[i].getTelefono()+ "\n --------------------------------");

					}
				}
				break;
			case 5:// ----------------BuscarPorDni-----------------------
				int d = 0;
				do { 
					System.out.println("ingrese el DNI a buscar: ");
					long buscarDni = teclado.nextLong();
					
					for(int i=0; i < vector.length; i++) {
						if(buscarDni == vector[i].getDNI()) {
							d=1;
							System.out.println("la persona es: "+ vector[i].toString());
							break;
						}else {
							d=0;
						}
					}
					if(d == 0) {
						System.out.println("La persona que busca no existe");
					}
				}while(d == 0);
				break;
			case 6:// ----------------OrdenarPorDni-----------------------
				vector = bubbleSort(vector); {
	
					int p = 0;
					//while
					while(p < 1){
						System.out.println("mostrar Dni de: \n 1-Menor a Mayor \n 2-Mayor a Menor");
						opcion = teclado.nextInt();
						switch (opcion) {
						case 1:
							for (int i = 0; i < vector.length; i++) {
								System.out.println(vector[i].toString());
							}
							p = 1;
							break;
						case 2:
							for (int i = vector.length - 1; i >= 0; i--) {
								System.out.println(vector[i].toString());
							}
							p = 1;
							break;
	
						default:
							p = 0;
						}
	
					}
				}

				break;
			case 7:// ----------------SALIR-----------------------
				
				do {
					salir = "";
					System.out.println("desea salir s o n?: ");
					salir = teclado.next();
					switch (salir) {
					case "s":
						System.out.println("FINISHIM");
						b = 0;
						break;
					case "n":
						b = 1;
						break;
					default:
						b = 1;
						break;
					}
				} while (!(salir.equals("s") || salir.equals("n")));
				break;

			}

		} while (b == 1);
		teclado.close();

	}

	public static Persona[] bubbleSort(Persona[] array) {
		for (int i = array.length - 1; i < 0; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j].getDNI() < array[j + 1].getDNI()) {
					Persona value = array[j + 1];
					array[j + 1] = array[j];
					array[j] = value;
				}
			}
		}
		return array;
	}

}