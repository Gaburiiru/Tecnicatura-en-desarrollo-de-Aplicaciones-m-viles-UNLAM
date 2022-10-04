package unlam.bucledowhile.ej6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("----------------------------------------------------");

		int i = 0;
		do {
			System.out.println("El valor de 'i' es: " + i);
		} while (i != 0);

		System.out.println("----------------------------------------------------");

//		i = 0;
//		do {
//			System.out.println("El valor de 'i' es: " + i);
//			i++;
//		} while (i != 0);

		System.out.println("----------------------------------------------------");

		i = 0;
		do {
			System.out.println("El valor de 'i' es: " + i);
			i++;
			if (i > 1000) // ¿ Esto esta bien ?
				break;
		} while (i != 0);

		System.out.println("----------------------------------------------------");

		i = 0;
		do {
			System.out.println("El valor de 'i' es: " + i);
		} while (++i < 10);

		System.out.println("----------------------------------------------------");

		i = 0;
		do {
			System.out.println("El valor de 'i' es: " + i);
		} while (i++ < 10); // ¿Que diferencia hay con el anterior? ¿Donde impacta?

		System.out.println("----------------------------------------------------");

		i = 0;
		int k = 0, j = 0;
		do {
			k = ++j % 5;
			System.out.println("El valor de 'k' es: " + k + " y es el resultado de " + j + "%" + 5);
		} while (i++ < 10 && k != 3);

		System.out.println("----------------------------------------------------");
	}

}
