package unlam.buclewhile.ej5;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("----------------------------------------------------");

		int i = 0;
		while (i < 9) {
			i++;
			System.out.println("El valor de 'i' es: " + i);
		}

		System.out.println("----------------------------------------------------");

		i = 0;
		while (i < 100) {
			i++;
			System.out.println("El valor de 'i' es: " + i);
			if (i >= 9)
				break;
		}

		System.out.println("----------------------------------------------------");

		while (i < 9) {
			i++;
			System.out.println("SARAZA QUE NUNA SALE POR PANTALLA"); // ¿Por que?
		}

		System.out.println("----------------------------------------------------");

		System.out.println("----------------------------------------------------");

		while (true) {
			i++;
			System.out.println("El valor de 'i' es: " + i);
			if (i >= 9)
				break;
		}

		System.out.println("----------------------------------------------------");

		while (i == 9) {
			i++;
			System.out.println("El valor de 'i' es: " + i);
			if (i >= 9)
				break;
		}

		System.out.println("----------------------------------------------------");
		int j = 0;
		while (i == 10 && j != 1000) {
			j++;
			System.out.println("El valor de 'j' es: " + j);
		}

		System.out.println("----------------------------------------------------");

	}

}
