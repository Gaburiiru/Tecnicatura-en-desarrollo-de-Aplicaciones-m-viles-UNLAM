package ar.edu.unlam.pb2.Parcial01;

import java.util.HashMap;
import java.util.Map;

public class Venta {

	private String codigo;
	private Cliente cliente;
	private Vendedor vendedor;
	private Map<Vendible, Integer> renglones;

	public Venta(String codigo, Cliente cliente, Vendedor vendedor) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.renglones = new HashMap<>();
	}

	// TODO: Completar con los getters y setters necesarios

	public void agregarRenglon(Vendible vendible, Integer cantidad) {
		// TODO: Agregar el vendible a la venta
	}

	@Override
	public String toString() {
		return "Venta: " + codigo + "\n" + "Cliente" + cliente + "\n" + "Vendedor" + vendedor + "\n";
	}

}
