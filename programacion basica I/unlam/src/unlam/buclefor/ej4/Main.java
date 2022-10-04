package unlam.buclefor.ej4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("----------------------------------------------------");

		for (int i = 0; i <= 9; i++) {
			System.out.println("El valor de 'i' es: " + i);
		}

		System.out.println("----------------------------------------------------");

		for (int i = 9; i >= 0; i--) {
			System.out.println("El valor de 'i' es: " + i);
		}

		System.out.println("----------------------------------------------------");

		for (int i = 0; i <= 9;) {
			i++;
			System.out.println("El valor de 'i' es: " + i);
		}

		System.out.println("----------------------------------------------------");

		for (int i = 0;; i++) {
			System.out.println("El valor de 'i' es: " + i);
			if (i >= 9)
				break;
		}

		System.out.println("----------------------------------------------------");

		int i = 0;
		for (;;) {
			i++;
			System.out.println("El valor de 'i' es: " + i);
			if (i >= 9)
				break;
		}

		System.out.println("----------------------------------------------------");
		i = 0;
		for (int j = 1, k = 0; i <= 99999999 && k != 3; j++) {
			i++;
			k = j % 5;
			System.out.println("El valor de 'k' es: " + k + " y es el resultado de " + j + "%" + 5);
		}

		System.out.println("----------------------------------------------------");
		
		for (int x = 0; x <= 9; x++, i++) 
			System.out.println("El valor de 'x' es: " + x + " y el de 'i' es " + i);
				
		System.out.println("----------------------------------------------------");
		
		System.out.println("----------------------------------------------------");
		for (int x = 0; x <= 9; x++);
		System.out.println("Meti la pata!!!!");
		System.out.println("----------------------------------------------------");
	}

}
