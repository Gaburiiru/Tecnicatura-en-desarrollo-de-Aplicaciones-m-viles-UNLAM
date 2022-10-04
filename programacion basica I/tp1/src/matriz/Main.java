package matriz;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int tempMax=0;
		int [][][][] matriz = new int[4][4][8][8];
	
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				for(int k=0;k<matriz[j].length;k++) {
					for(int n=0;n<matriz[k].length;n++) {
						System.out.println("ingrese la temperatura del area del salon: ");
						int temp = teclado.nextInt();
						matriz[i][j][k][n] = temp;
						
						System.out.println(matriz[n].length);
						//tempMax = matriz[i][j][k][�];
						
						//if(tempMax > matriz[�].length) {
							
						//}
					}
				}
			}
		}
	}
}