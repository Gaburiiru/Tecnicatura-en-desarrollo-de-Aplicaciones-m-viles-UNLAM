package matrizes;
import java.util.Scanner;

public class matriz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int acumulador=0;
		int cont=0;
		int max=0;
		int min=0;
		int[][]num = {{1,2,3},{1,2,3,4,5}};
		for(int i = 0; i< num.length; i++){
			for(int j=0;  j < num[i].length; j++) {
				System.out.println("ingrese la temperatura del dia: ");
				int temp = teclado.nextInt();
				num[i][j] = temp;
				acumulador+=temp;
				cont++;
				if(num[i][j]> max) {
					max=num[i][j];
				}
				if(num[i][j]< min) {
					min=num[i][j];	
				}
			}
		}
		int resultado= acumulador / cont;
		System.out.println("el promedio de las temperaturas es: "+resultado);
		System.out.println("temperatura mas alta: "+max);
		System.out.println("temperatura mas baja: "+min);
	}
}