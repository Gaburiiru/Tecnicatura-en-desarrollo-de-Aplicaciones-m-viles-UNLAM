package tp1_version_2;
import java.util.Scanner;

import tp1.Persona;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int i = 0;
		int cantP = 0;
		int x = 0;
		int z = 0;
		int c = 0;
		String temp = "";
		
		do {
			System.out.println("ingrese la cantidad de personas a cargar: ");
			cantP = teclado.nextInt();
		}while(!(cantP>=1 && cantP<=20));
		
		Persona []Personas = new Persona[cantP];
		
		do {
			System.out.println("bienvenido al menu, seleccione una opcion: \n 1.agregar personas \n 2.mostrar totalidad de personas \n 3.mostrar persona mas grande \n 4.litar por localidad \n 5.buscar por DNI \n 6.Ordenar por DNI \n 7.Salir");
			int opcion = teclado.nextInt();
			switch(opcion) {
				case 1:
					for(i=0;i<Personas.length;i++) {
						System.out.println("ingrese su Nombre: ");
						String nombre = teclado.next();
						System.out.println("ingrese su Apellido: ");
						String apellido = teclado.next();
						System.out.println("ingrese su DNI: ");
						Long DNI = teclado.nextLong();
						System.out.println("ingrese su Edad: ");
						int edad = teclado.nextInt();
						
						do {
							System.out.println("ingrese su Localidad: ");
							System.out.println("	1.Haedo\r\n	2.Ramos Mejia\r\n	3.San Justo\r\n	4.Moron\r\n");
							int localidad = teclado.nextInt();
							switch(localidad) {
								case 1:
									temp="Haedo";
									x=0;
									break;
								case 2:
									temp="Ramos mejia";
									x=0;
									break;
								case 3:
									temp="San justo";
									x=0;
									break;
								case 4:
									temp="Moron";
									x=0;
									break;
								default:
									x=1;
									break;
							}
						}while(x==1);
						System.out.println("ingrese su numero de telefono: ");
						int telefono = teclado.nextInt();
						System.out.println("---------------------------------------------- \n");
						
						Personas[i] = new Persona(nombre,apellido,DNI,edad,temp,telefono);
					}
					z=1;
					break;
				case 2:
					System.out.println("Personas cargadas: ");
					for(i=0;i<Personas.length;i++) {
						System.out.println("	nombre: "+Personas[i].getNombre()+" apellido: "+Personas[i].getApellido()+" DNI: "+Personas[i].getDNI()+" edad: "+Personas[i].getEdad()+" telefono: "+Personas[i].getTelefono());
					}
					z=1;
					System.out.println();
					break;
				case 3:
					Long menorDNI = Personas[0].getDNI();
					int contador = 0;
					for(i=1;i<Personas.length;i++) {
						if(menorDNI<Personas[i].getDNI()) {
							menorDNI = Personas[i].getDNI();
							contador ++;
						}
					}
					System.out.println("la persona mas vieja es: "+Personas[contador].toString());
					
					z=1;
					System.out.println("");
					break;
				case 4:
					do {
						System.out.println("selecciona la localidad : ");
						System.out.println("	1.Haedo\r\n	2.Ramos Mejia\r\n	3.San Justo\r\n	4.Moron\r\n");
						int localidadTemp = teclado.nextInt();
						switch(localidadTemp) {
							case 1:
								temp="Haedo";
								c=0;
								break;
							case 2:
								temp="Ramos mejia";
								c=0;
								break;
							case 3:
								temp="San justo";
								c=0;
								break;
							case 4:
								temp="Moron";
								c=0;
								break;
							default:
								c=1;
								break;
						}
						for(i=0;i<Personas.length;i++) {
							if(temp==Personas[i].getLocalidad()) {
								System.out.println("	"+Personas[i].toString());
								System.out.println("");
							}
						}
					}while(c==1);
					z=1;
					break;
				case 5:
					System.out.println("ingrese el dni que desea saber: ");
					long DNITemp = teclado.nextLong();
					for(i=0;i<Personas.length;i++) {
						if(DNITemp==Personas[i].getDNI()) {
							System.out.println("	"+Personas[i].toString());
							System.out.println("");
						}else {
							System.out.println("Manito esa persona no existe");
							System.out.println("");
							break;
						}
					}
					z=1;
					break;
				case 6:
					Personas = bubbleSort(Personas);
					int p = 0;
					
					while(p < 1){
						System.out.println("mostrar Dni de: \n 1-Menor a Mayor \n 2-Mayor a Menor");
						opcion = teclado.nextInt();
						switch (opcion) {
							case 1:
								for(i=0; i<Personas.length; i++) {
									System.out.println(Personas[i].toString());
								}
								p = 1;
								break;
							case 2:
								for(i = Personas.length - 1; i >= 0; i--) {
									System.out.println(Personas[i].toString());
								}
								p = 1;
								break;
							default:
								p = 0;
								break;
						}
					}
					z=1;
					break;
				case 7:
					int g=0;
					do {
						System.out.println("desea salir? 'S' para si. 'N' para no");
						String desicion = teclado.next();
						switch(desicion) {
							case "N":
								System.out.println("a sos un cagon");
								g=0;
								z=1;
								break;
							case "n":
								System.out.println("a sos un cagon");
								g=0;
								z=1;
								break;
							case "s":
								g=0;
								z=0;
								System.out.println("arrivederchi...");
								break;
							case "S":
								g=0;
								z=0;
								System.out.println("arrivederchi...");
								break;
							default:
								g=1;
								break;
						}
					}while(g==1);
					break;
				default:
					z=1;
					break;
			}
		}while(z==1);
	
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
