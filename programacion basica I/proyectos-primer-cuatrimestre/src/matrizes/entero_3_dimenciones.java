package matrizes;

import java.util.Scanner;

public class entero_3_dimenciones {
//array_de_3_dimenciones_,_cargar_enetro_y_sacar_el_max
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int mayor = 0;
		System.out.println("Ingrese valor de I");
		int valor1 = teclado.nextInt();
		System.out.println("Ingrese valor de J");
		int valor2 = teclado.nextInt();
		System.out.println("Ingrese valor de K");
		int valor3 = teclado.nextInt();
		int [][][]tresD = new int [valor1][valor2][valor3];
		
		for(int i = 0; i<tresD.length;i++ ) {
			for(int j = 0; j < tresD[i].length; j++) {
				for (int k = 0; k<tresD[i][j].length; k++) {
					System.out.println("Ingrese el valor a guardar en la posicion: [" + i + "] [" + j + "] [" + k + "]");
					int valorDeclarado = teclado.nextInt();
					tresD[i][j][k] = valorDeclarado;
					if(tresD[i][j][k]>mayor) {
						mayor = tresD[i][j][k];
					}
				}
			}
		}
		
		for(int i = 0; i<tresD.length;i++ ) {
			for(int j = 0; j < tresD[i].length; j++) {
				for (int k = 0; k<tresD[i][j].length; k++) {
					System.out.println(tresD[i][j][k]);
				}
			}
		}
		System.out.println("El valor mas grande es: " + mayor);
		
		

	}

}