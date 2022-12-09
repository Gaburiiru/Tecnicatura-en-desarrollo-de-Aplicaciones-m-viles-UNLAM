package ej18;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//int[] array = { 10, 1, 5, 40, 12, 34, 44, 12, 11, 9 };
		int[] array = { 1, 5, 6, 12, 55, 64, 74, 92, 110, 900 };
		if (binarySearch(array, 900))
			System.out.println("Valor encontrado");			
		else
			System.out.println("No se encontro el valor.!");
		int index = binarySearch(array, 64, 0);
		if (index != -1)
			System.out.println("Valor encontrado en la posicion: " + index);			
		else
			System.out.println("No se encontro el valor.!");
		
		int[] array2 = Arrays.copyOf(array, array.length * 2);
	}

	public static boolean binarySearch(int[] numbers, int numberToSearch) {
		int size = numbers.length; // Nï¿½mero de elementos
		int middle = size / 2; // Mitad del array
		if (numbers[middle] == numberToSearch)
			return true; // Lo encontre
		else if (size == 1)
			return false;// No lo encontre
		else if (numbers[middle] > numberToSearch)
			return binarySearch(Arrays.copyOfRange(numbers, 0, middle - 1), numberToSearch);
		else
			return binarySearch(Arrays.copyOfRange(numbers, middle + 1, size), numberToSearch);
	}
	
	public static int binarySearch(int[] numbers, int numberToSearch, int offset) {
		int size = numbers.length; // Nï¿½mero de elementos
		int middle = size / 2; // Mitad del array
		if (numbers[middle] == numberToSearch)
			return middle + offset; // Lo encontre y retorno la posicion exacta del vector original
		else if (size == 1)
			return -1;// No lo encontre
		else if (numbers[middle] > numberToSearch)
			return binarySearch(Arrays.copyOfRange(numbers, 0, middle - 1), numberToSearch, 0);
		else
			return binarySearch(Arrays.copyOfRange(numbers, middle + 1, size), numberToSearch, middle + 1 + offset);
	}
}