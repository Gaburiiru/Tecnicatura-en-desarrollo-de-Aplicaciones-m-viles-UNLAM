package ej11;

public class Searcher {

	public Searcher() {
		// TODO Auto-generated constructor stub
	}

	public int binarySearch(int[] array, int key) {
		return this.binarySearch(array, 0, array.length - 1, key);
	}
	
	public int sequentialSearch(int[] array, int key) {
		for(int index = 0; index < array.length; index++) 
		{
			if (array[index]==key)
				return index;
		}
		return -1;
	}

	private int binarySearch(int array[], int first, int last, int key) {
		if (last >= first) {
			int middle = first + (last - first) / 2; //Se agrega este calculo para poder obtener la posicion real del elemento
			if (array[middle] == key) {
				return middle;
			}
			if (array[middle] > key) {
				return binarySearch(array, first, middle - 1, key);// busca en la mitad izquierda
			} else {
				return binarySearch(array, middle + 1, last, key);// busca en la mitad derecha
			}
		}
		return -1;
	}
}