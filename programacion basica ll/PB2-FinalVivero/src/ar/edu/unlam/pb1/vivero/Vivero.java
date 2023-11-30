package ar.edu.unlam.pb1.vivero;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.List;
import java.util.Map;

public class Vivero {

	private String nombre;
	private List<Planta> plantas;
	private List<Planta> ventas;

	public Vivero(String nombre) {
		this.nombre = nombre;
	}

	public Boolean agregarPlanta(Planta planta) {
		if (!plantas.contains(planta)) {
			plantas.add(planta);
			return true;
		}
		return false; // Planta duplicada
	}

	public void venderPlanta(Integer codigoPlanta, Integer cantidadAVender) throws PlantaInexistenteException, ProductoSinStockException {
		Planta planta = null;
		for (Planta p : plantas) {
			if (p.getCodigo() == codigoPlanta) {
				planta = p;
				break;
			}
		}

		if (planta == null) {
			throw new PlantaInexistenteException(); // Planta inexistente
		}

		if (planta.getStock() >= cantidadAVender) {
			// Realizar la venta y actualizar el stock
			int stockActual = planta.getStock();
			planta.setStock(stockActual - cantidadAVender);
			ventas.add(planta); // Agregar la planta vendida a la lista de ventas
		} else {
			throw new ProductoSinStockException(); // Producto sin stock
		}
	}

	public List<Planta> obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta() {
		// Implementar la lógica para obtener las ventas de arboles ordenadas por valor total
		// y devolver la lista
		return null;
	}

	public Map<String, List<Planta>> obtenerReporteDePlantasAgrupadasPorTipo() {
		// Implementar la lógica para agrupar las plantas por tipo y devolver el reporte
		return null;
	}

	public List<Florales> obtenerTodasLasPlantasFlorales() {
		// Implementar la lógica para obtener todas las plantas que implementen la interfaz Florales
		return null;
	}

	public Object getPlantas() {
		// TODO Auto-generated method stub
		return null;
	}
}

	/**
	 * Se deberan realizar los siguientes tests
	 * 
	 * - 1 test para el metodo agregarPlanta() que arroje la excepcion de validacion
	 * - 1 test para el metodo venderPlanta() que arroje una excepcion a eleccion
	 * - 1 test para el metodo obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta()
	 * - 1 test para el metodo obtenerReporteDePlantasAgrupadasPorTipo()
	 * - 1 test para el metodo obtenerTodasLasPlantasFlorales()
	 * - 1 test para el metodo obtenerPrecio() de la clase Planta 
	 * - 1 test para el metodo obtenerPrecio() de alguna clase que implemente la interfaz Florales en estado de floracion
	 * - 1 test para el metodo obtenerPrecio() de alguna clase que implemente la interfaz Florales en estado de produccion
	 * */
	// No se pueden registrar plantas duplicadas. 2 plantas son iguales cuando tiene el mismo Id
	// No puede haber 2 plantas con el mismo Id , Si se duplica lanza una Exception Planta Duplicada Exception
	/*
	 * Registra una venta y descuenta del stock de la planta la cantidad deseada. Si no se encuentra la planta lanza
	 * una exception Planta Inexistente. Si no hay Stock Lanza Una Exception
	 * ProdutoSinStockException
	 */
	/*
	 * Obtener un listado de todos los arboles vendidos ordenados por el total de
	 * venta (Cantidad * precioDeLaPlanta)
	 * 
	 */
	/*
	 * Obtener Un reporte de las plantas vendidas agrupados por tipo Plantas
	 * 
	 * Ejemplo: para una key "arbol", debemos completar las plantas de este tipo
	 * 
	 */
	/**
	 * Obtener una lista de plantas que implementen la interfaz correspondiente
	 * */