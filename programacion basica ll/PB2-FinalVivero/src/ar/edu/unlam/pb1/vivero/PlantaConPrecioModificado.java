package ar.edu.unlam.pb1.vivero;

public class PlantaConPrecioModificado extends Planta implements PrecioModificable{
    private Double ganancia; // Valor de ganancia específico para este tipo de planta

    public PlantaConPrecioModificado(int codigo, String nombre, double precioBase, int stock, Double ganancia) {
        super(codigo, nombre, precioBase, stock);
        this.ganancia = ganancia;
    }

    // Implementación del método obtenerPrecio
    @Override
    public Double obtenerPrecio() {
        return modificarPrecio(precioBase);
    }

    // Implementación del método de la interfaz PrecioModificable
    @Override
    public Double modificarPrecio(Double precioBase) {
        return precioBase * (1 + ganancia);
    }
}
