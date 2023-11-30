package ar.edu.unlam.pb1.vivero;

public class Arbol extends Planta {
    private final double GANANCIA_ARBOL = 2.3;
    private double estadoFloracion;
    private int madurezFrutos;

    public Arbol(int codigo, String nombre, double precio, int stock) {
        super(codigo, nombre, precio, stock);
        this.estadoFloracion = 0.0; // Inicialmente sin floración
        this.madurezFrutos = 0; // Inicialmente sin frutos
    }

    // Método para incrementar la floración
    public void crecerFlores(double crecimiento) {
        if (estadoFloracion < 100.0) {
            estadoFloracion += crecimiento;
            if (estadoFloracion > 100.0) {
                estadoFloracion = 100.0;
            }
        }
    }

    // Método para producir frutos
    public void producirFrutos(int produccion) {
        if (estadoFloracion == 100.0) {
            madurezFrutos += produccion;
            if (madurezFrutos > 5) {
                madurezFrutos = 5;
            }
        }
    }

    // Método para calcular el precio del árbol
    public double calcularPrecio() {
        double precio = precioBase;

        if (estadoFloracion < 33.0) {
            precio *= 1.05; // Incremento del 5% para menos del 33% de floración
        } else if (estadoFloracion >= 34.0 && estadoFloracion <= 66.0) {
            precio *= 1.075; // Incremento del 7.5% para floración entre 34% y 66%
        } else if (estadoFloracion > 66.0 && estadoFloracion < 100.0) {
            precio *= 1.085; // Incremento del 8.5% para floración entre 66% y 99%
        }

        if (madurezFrutos > 0) {
            precio *= 1 + (madurezFrutos * 0.03); // Aumento del precio por madurez de frutos
        }
        return precio * GANANCIA_ARBOL;
    }
}

	/**
	 * Los arboles pueden dar flores, las que posteriormente se convertiran en frutos. 
	 * Las flores tienen un rango de crecimiento, siendo 0 (el valor inicial) cuando no tiene flores aun y 100 cuando ya estan aptas para dar frutos.
	 * El precio del arbol se incrementa de acuerdo al avance de la floracion:
	 * - Menos de 33% de floracion incrementa un 5% su precio. 
	 * - Entre 34% y 66% incrementa un 7.5% su precio.
	 * - Mas del 66% y menos de 100% incrementa un 8.5% su precio.
	 * - Cuando el estado de floracion llega al 100%, se comienza la produccion de frutos
	 * */

	/**
	 * Para poder producir frutos, el estado de floracion debe ser 100%.
	 * La produccion de frutos se mide entre 1 y 5 siendo 5 el mejor escenario.
	 * Cuando un arbol produce frutos, su precio aumenta 10% inicialmente (por tener el estado de floracion al 100%) y
	 * agrega al precio, el porcentaje de madurez. Ejemplo: precioBase = 100 + 10% (por floracion) + 3% (madurez actual de los frutos)
	 * */
