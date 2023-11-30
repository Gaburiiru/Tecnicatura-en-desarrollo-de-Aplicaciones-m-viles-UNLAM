package ar.edu.unlam.pb2.Parcial01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TiendaTest {

	/**
	 * Resolver los siguientes tests
	 */

	@Test
	public void queAlIntentarAgregarUnaVentaParaUnVendedorDeLicenciaSeLanceUnaVendedorDeLicenciaException() {
	}

	@Test
	public void queAlIntentarAgregarUnVendibleInexistenteAUnaVentaSeLanceUnaVendibleInexistenteException() {
	}

	@Test
	public void queSePuedaObtenerUnaListaDeProductosCuyoStockEsMenorOIgualAlPuntoDeReposicion() {
		Tienda tienda = new Tienda("0001", "software tech");
		Cliente cliente1 = new Cliente("0220","Robotica");
		tienda.agregarCliente(cliente1);
		Producto producto1 = new Producto(0001,"mouse",200.0,10);
		Producto producto2 = new Producto(0002,"teclado",500.0,5);
		tienda.agregarProducto(producto1);
		tienda.agregarProducto(producto2);
		tienda.agregarStock(producto1, 1);
	    // Obtener la lista de productos cuyo stock es menor o igual al punto de reposición
	    List<Producto> listaDeProductos = tienda.obtenerProductosCuyoStockEsMenorOIgualAlPuntoDeReposicion();
	    // Verificar que la lista no esté vacía
	    assertFalse(listaDeProductos.isEmpty());
	    // Verificar que la lista contenga el producto producto1
	    assertTrue(listaDeProductos.contains(producto1));
	}

	@Test
	public void queSePuedaObtenerUnSetDeClientesOrdenadosPorRazonSocialDescendente() {
        // Crear una instancia de la tienda
        Tienda tienda = new Tienda("0001", "software tech");

        // Agregar algunos clientes desordenados
        Cliente cliente1 = new Cliente("0220", "Robotica");
        Cliente cliente2 = new Cliente("0330", "Metalurgica");
        Cliente cliente3 = new Cliente("0440", "Cine");
        Cliente cliente4 = new Cliente("0550", "Avogacia");

        tienda.agregarCliente(cliente1);
        tienda.agregarCliente(cliente2);
        tienda.agregarCliente(cliente3);
        tienda.agregarCliente(cliente4);

        // Llamar al método que ordena los clientes por razón social en orden descendente
        List<Cliente> clientesOrdenados = tienda.obtenerClientesOrdenadosPorRazonSocialDescendente();

        // Verificar si la lista está ordenada correctamente
        assertEquals(cliente4, clientesOrdenados.get(0)); // Avogacia
        assertEquals(cliente2, clientesOrdenados.get(1)); // Metalurgica
        assertEquals(cliente3, clientesOrdenados.get(2)); // Cine
        assertEquals(cliente1, clientesOrdenados.get(3)); // Robotica
	}

	@Test
	public void queSePuedaObtenerUnMapaDeVentasRealizadasPorCadaVendedor() {
		// TODO: usar como key el vendedor y Set<Venta> para las ventas
	}

	@Test
	public void queSePuedaObtenerElTotalDeVentasDeServicios() {
	}

	@Test
	public void queAlRealizarLaVentaDeUnProductoElStockSeActualiceCorrectamente() {
	}
}
