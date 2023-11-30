package ar.unlam.pb2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaIngresoTeclado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		Integer numero = 0 ;
		
		System.out.println("Ingresar un valor entero:");
		numero = teclado.nextInt();
		try {
			
		}catch(NullPointerException E) {
			System.err.println("El numero ingresado no es un entero. Ingreselo nuevamente");
		}catch(InputMismatchException E3) {
			System.err.println("Entró por InputMismatchException");
		}catch(Exception E2) {
			System.err.println("Entró por EXCEPTION");
		}

		
		System.out.println("El valor ingresado es:"+ numero);
	}

}
