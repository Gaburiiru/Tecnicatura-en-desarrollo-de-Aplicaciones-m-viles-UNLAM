package ej11;

public class Main {

	public static void main(String[] args) {
		final int TOPE = 500;
		final int valorBuscado = 499;

		int[] array = new int[TOPE];
		for (int i = 0; i < TOPE; i++)
			array[i] = i;

		Searcher searcher = new Searcher();

		long startTime = System.nanoTime();
		int index = searcher.binarySearch(array, valorBuscado);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		if (index != -1)
			System.out.println("Valor encontrado en la posicion " + index);
		else
			System.out.println("No se encontro el valor.!");
		System.out.println("Busqueda binaria -> " + duration + " nano segundos");

		startTime = System.nanoTime();
		index = searcher.sequentialSearch(array, valorBuscado);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		if (index != -1)
			System.out.println("Valor encontrado en la posicion " + index);
		else
			System.out.println("No se encontro el valor.!");
		System.out.println("Busqueda secuencial -> " + duration + " nano segundos");
	}
}
