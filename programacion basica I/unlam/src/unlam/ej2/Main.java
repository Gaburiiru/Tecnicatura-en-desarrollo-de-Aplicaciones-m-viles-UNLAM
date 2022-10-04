package unlam.ej2;

import unlam.classes.Auto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Auto auto1 = new Auto(); //Aca se instancia un objeto de la clase Auto
		auto1.marca = "FIAT"; //Esto viola el encapsulamiento, ¿Como se soluciona?
		Auto auto2; //Aca se declara una vatiable del tipo auto, auto2 aun no es un objeto y su valor inicial es null.
		
		System.out.println("La marca de auto1 es: " + auto1.getMarca());
		
		auto2 = auto1;
		
		System.out.println("La marca de auto2 es: " + auto2.getMarca()); //¿Por que sale esa marca por consola? ¿Cuantos objetos tengo instanciados? Pensalo
		
		auto2.setMarca("FORD");
		
		System.out.println("La marca de auto1 es: " + auto1.getMarca()); //¿Por que sale esa marca por consola? ¿Cuantos objetos tengo instanciados? Pensalo
		System.out.println("La marca de auto2 es: " + auto1.getMarca()); //¿Por que sale esa marca por consola? ¿Cuantos objetos tengo instanciados? Pensalo
		
		Auto auto3 = new Auto("FERRARI", 600);
		System.out.println("La marca de auto3 es: " + auto3.getMarca() + " y tiene " + auto3.getHorsePower() + " caballos de fuerza.");
		
		auto3.turnRight();
		System.out.println("La posicion del volante de auto3 es: " + auto3.getDegrees() + " grados");
		
		auto3.turnRight();
		auto3.turnRight();
		auto3.turnRight();
		System.out.println("La posicion del volante de auto3 es: " + auto3.getDegrees() + " grados");
		
		auto3.turnRight(25);
		System.out.println("La posicion del volante de auto3 es: " + auto3.getDegrees() + " grados");
		
		auto3.turnLeft();
		System.out.println("La posicion del volante de auto3 es: " + auto3.getDegrees() + " grados");
		
		auto3.turnLeft(45);
		System.out.println("La posicion del volante de auto3 es: " + auto3.getDegrees() + " grados");
	}

}
