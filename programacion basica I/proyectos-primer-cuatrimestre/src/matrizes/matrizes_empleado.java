package matrizes;
import java.util.Scanner;
public class matrizes_empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sector=0;
		int empleados=0;
		int sueldo=0;
		int mayor=0;
		int posSector=0;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("ingrese la cantidad de sectores: ");
		sector = teclado.nextInt();
		int [][]empresa = new int [sector][];
		
		for(int i=0; i < empresa.length; i++){
			System.out.println("ingrese la cantidad de empleados del sector "+i+": ");
			empleados = teclado.nextInt();
			empresa[i] = new int [empleados];
			for(int j=0; j < empresa[i].length;j++){
				System.out.println("ingrese el sueldo del empleado: ");
				sueldo = teclado.nextInt();
				empresa[i][j]=sueldo;
				if(empresa[i][j]>mayor) {
					mayor = empresa[i][j];
					posSector = i;
				}
				
			}
		}
		System.out.println("el empleado con el sueldo mas alto esta en el sector: "+ posSector);
	}

}
