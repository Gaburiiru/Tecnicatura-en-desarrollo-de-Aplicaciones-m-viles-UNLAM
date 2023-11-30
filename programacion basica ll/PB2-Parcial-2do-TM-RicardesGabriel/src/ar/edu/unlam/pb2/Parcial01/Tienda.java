package ar.edu.unlam.pb2.Parcial01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tienda {

	/**
	 * En esta ocasion deberemos resolver un producto software que nos permita
	 * administrar la venta de productos o servicios de nuestra tienda. Venderemos
	 * entonces, productos como mouse o teclados y servicios como el soporte tecnico
	 * a domicilio. Sabemos que la tienda cuenta con items Vendibles que pueden ser
	 * del tipo Producto o Servicio. Ademas, podemos registrar el stock de los
	 * productos, los clientes a quienes les vendemos algun producto o servicio, las
	 * ventas y los vendedores de la tienda. Antes de realizar alguna operacion, se
	 * debera obtener el elemento correspondiente de las colecciones. Ejemplo: Si
	 * quisiera realizar alguna operacion con un cliente, el mismo debe obtenerse de
	 * la coleccion de clientes.
	 * 
	 * Cada Venta contiene renglones los cuales representa a los productos o
	 * servicios que se incluyen en la misma. Tambien cuenta con el Cliente y
	 * Vendedor que participan en la Venta. Cuando agregamos un vendible a una
	 * venta, lo haremos con 1 unidad. En una version posterior, admitiremos
	 * cantidades variables.
	 * 
	 * Cada Item debe compararse por nombre y precio, en caso de ser necesario.
	 * Recordar que los items deben ser Vendibles.
	 */

	private String cuit;
	private String nombre;
	private Set<Vendible> vendibles;
	private List<Producto> productos;
	private Map<Producto, Integer> stock;
	private List<Cliente> clientes;
	private Set<Venta> ventas;
	private Set<Vendedor> vendedores;

	public Tienda(String cuit, String nombre) {
		this.cuit = cuit;
		this.nombre = nombre;
		this.stock = new HashMap<>();
		this.productos = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.vendibles = new HashSet<>();
		this.ventas = new HashSet<>();
	}

	// TODO: Completar con los getters y setters necesarios

	public Vendible getVendible(Integer codigo) {
		// TODO: Obtiene un producto o servicio de la coleccion de vendibles utilizando
		// el codigo. En caso de no existir devuelve null.
		for (Vendible SPAConsultar : vendibles) {
			if (SPAConsultar.getCodigo().equals(codigo)) {
				return SPAConsultar;
			}
		}
		return null;
	}

	public void agregarProducto(Producto producto) {
		this.agregarProducto(producto, 0);
	}

	public void agregarProducto(Producto producto, Integer stockInicial) {
		// TODO: Agrega un producto a la coleccion de vendibles y pone en la coleccion
		// de stocks al producto con su stock inicial
		vendibles.add(producto);
		stock.put(producto, stockInicial);
		productos.add(producto);
	}

	public void agregarServicio(Servicio servicio) {
		// TODO: Agrega un servicio a la coleccion de vendibles
		vendibles.add(servicio);
	}

	public Integer getStock(Producto producto) {
		return stock.get(producto);
	}

	public Producto productoExistencia(Producto producto) {
		for (Vendible vendible : vendibles) {
			if (vendible instanceof Producto) {
				if (vendible.getCodigo().equals(producto.getCodigo())) {
					return producto;
				}
			}
		}
		return null;
	}

	public void agregarStock(Producto producto, Integer incremento) {
		Producto productoEncontrado = productoExistencia(producto);
		// TODO: se debe agregar stock a un producto existente
		if (productoEncontrado != null) {
			for (Map.Entry<Producto, Integer> entry : stock.entrySet()) {
				entry.setValue(incremento);
			}
		}

	}

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void agregarVendedor(Vendedor vendedor) {
		vendedores.add(vendedor);
	}

	public void agregarVenta(Venta venta) throws VendedorDeLicenciaException {
		// TODO: Agrega una venta a la coleccion correspondiente. En caso de que el
		// vendedor este de licencia, arroja una
		// VendedorDeLicenciaException
		for (Vendedor vendedorAConsultar : vendedores) {
			if (vendedorAConsultar.isDeLicencia() == true) {
				throw new VendedorDeLicenciaException();
			}
		}
		ventas.add(venta);
	}

	public Producto obtenerProductoPorCodigo(Integer codigo) {
		// TODO: Obtiene un producto de los posibles por su codigo. En caso de no
		// encontrarlo se debera devolver null
		Producto producto;
		for (Vendible SPAConsultar : vendibles) {
			if (SPAConsultar.getCodigo().equals(codigo)) {
				return producto = productoExistencia((Producto) SPAConsultar);
			}
		}
		return null;
	}

	public void agregarProductoAVenta(String codigoVenta, Producto producto) {

		// TODO: Agrega un producto a una venta. Si el vendible no existe (utilizando su
		// codigo), se debe lanzar una VendibleInexistenteException
		// Se debe actualizar el stock en la tienda del producto que se agrega a la
		// venta
	}

	public void agregarServicioAVenta(String codigoVenta, Servicio servicio) {
		// TODO: Agrega un servicio a la venta. Recordar que los productos y servicios
		// se traducen en renglones
	}

	public List<Producto> obtenerProductosCuyoStockEsMenorOIgualAlPuntoDeReposicion() {
		// TODO: Obtiene una lista de productos cuyo stock es menor o igual al punto de
		// reposicion. El punto de reposicion, es un valor que
		// definimos de manera estrategica para que nos indique cuando debemos reponer
		// stock para no quedarnos sin productos
		List<Producto> listaDeProductos = new ArrayList<>();
		// Recorremos todos los productos de la tienda
		for (Producto producto : productos) {
			if (producto.getPuntoDeReposicion() <= producto.getPuntoDeReposicion()) {
				listaDeProductos.add(producto);
			}
		}
		return listaDeProductos;
	}

	public List<Cliente> obtenerClientesOrdenadosPorRazonSocialDescendente() {
		// TODO: obtiene una lista de clientes ordenados por su razon social de manera
		// descendente
		List<Cliente> copiaClientes = new ArrayList<>(clientes);
		// Crear un comparador para ordenar la copia por razon social en orden
		// descendente
		Comparator<Cliente> comparadorRazonSocial = new Comparator<Cliente>() {
			@Override
			public int compare(Cliente cliente1, Cliente cliente2) {
				return cliente2.getRazonSocial().compareTo(cliente1.getRazonSocial());
			}
		};

		// Ordenar la copia de la lista de clientes utilizando el comparador
		Collections.sort(copiaClientes, comparadorRazonSocial);

		// Devolver la lista ordenada
		return copiaClientes;
	}

	public Map<Vendedor, Set<Venta>> obtenerVentasPorVendedor() {
		// TODO: Obtiene un mapa que contiene las ventas realizadas por cada vendedor.
		return null;
	}

	public Double obtenerTotalDeVentasDeServicios() {
		// TODO: obtiene el total acumulado de los vendibles que son servicios incluidos
		// en todas las ventas.
		// Si una venta incluye productos y servicios, solo nos interesa saber el total
		// de los servicios
		return null;
	}
}
