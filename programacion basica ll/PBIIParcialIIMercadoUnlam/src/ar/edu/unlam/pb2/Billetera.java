package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Billetera {
	private String nombre;
	private Set<Comercio> ListaDeComercio = new HashSet<>();
	private Set<Consumidor> ListaDeConsumidor = new HashSet<>();
	private Map<Integer, List<Pagadora>> mediosDePagoPorUsuario = new HashMap<>();

	public Billetera(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getListaDeComercio() {
		return ListaDeComercio.size();
	}

	public void agregarComercio(Comercio comercio) {
		if (comercio != null) {
			ListaDeComercio.add(comercio);
		}
	}

	public void agregarConsumidor(Consumidor consumidor) {
		if (consumidor != null) {
			ListaDeConsumidor.add(consumidor);
		}
	}

	public Integer getDNIConsumidor(Integer dniConsumidor) {
		if (dniConsumidor != null) {
			for (Consumidor consumidor : ListaDeConsumidor) {
				if (dniConsumidor.equals(consumidor.DNI_ESPERADO)) {
					return consumidor.DNI_ESPERADO;
				}
			}
		}
		return dniConsumidor;
	}
	public Consumidor getConsumidor(Integer dniConsumidor) {
		if (dniConsumidor != null) {
			for (Consumidor consumidor : ListaDeConsumidor) {
				if (dniConsumidor.equals(consumidor.DNI_ESPERADO)) {
					return consumidor;
				}
			}
		}
		return null;
	}

	
	public Integer getListaDeConsumidor() {
		return ListaDeConsumidor.size();
	}

	public void agregarMedioDePago(Integer idUser, Pagadora medioDePago) {
	    if (!idUser.equals(null) && !medioDePago.equals(null)) {
	        // Obtener la lista de medios de pago para el usuario
	        List<Pagadora> pagadoras = mediosDePagoPorUsuario.computeIfAbsent(idUser, k -> new ArrayList<>());

	        // Verificar si el medio de pago ya existe en la lista
	        boolean medioDePagoExistente = pagadoras.stream()
	            .anyMatch(p -> p.getClass() == medioDePago.getClass()); // Compara por tipo

	        if (!medioDePagoExistente) {
	            pagadoras.add(medioDePago);
	        }
	    }
	}
	
	public List<Pagadora> getMediosDePagoPorUsuario(Integer idUser) {
	    List<Pagadora> mediosDePagoUsuario = mediosDePagoPorUsuario.get(idUser);
	    return mediosDePagoUsuario;
	}

	public Pagadora getMedioPagadorPorNumeroTarjeta(Integer idUser, Long numeroTarjeta) {
	    List<Pagadora> mediosDePagoUsuario = getMediosDePagoPorUsuario(idUser);
	    if (mediosDePagoUsuario != null) {
	        for (Pagadora medio : mediosDePagoUsuario) {
	            if (medio instanceof TarjetaDeDebito || medio instanceof TarjetaDeCredito) {
	                Long numero = medio.getNUMERO_ESPERADO();
	                if (numero.equals(numeroTarjeta)) {
	                    return medio;
	                }
	            }
	        }
	    }
	    return null;
	}
	
	public Integer getCantidadDeMediosDePago(Integer idUser) {
		List<Pagadora> mediosDePago = mediosDePagoPorUsuario.get(idUser);
		return mediosDePago != null ? mediosDePago.size() : 0;
	}
	public Comercio buscarComercio(long comercio){
		for(Comercio comercioABuscar : ListaDeComercio) {
			if(comercioABuscar.CUIT_ESPERADO.equals(comercio)) {
				return comercioABuscar;
			}
		}
		return null;
	}
	public Compra generarCodigoQR(long comercio, double monto){
	    if (comercio <= 0 || monto <= 0.0) {
	        throw new IllegalArgumentException();
	    }
	    Comercio comercioEncontrado = buscarComercio(comercio);
	    	
	    Compra compra = new Compra(monto,comercioEncontrado);
	    return compra;
	}

	public boolean pagar(Compra codigoQR, Pagadora medioPagador) throws SaldoInsuficienteException, ExcedeLimiteDeCompraException {
	    if (!codigoQR.equals(null) || !medioPagador.equals(null)) {
	    	if (medioPagador instanceof TarjetaDeCredito) {
	    		// Pago con tarjeta de crédito
	    		TarjetaDeCredito tarjeta = (TarjetaDeCredito) medioPagador;
	    		return tarjeta.realizarPagoCredito(codigoQR.getMonto(), tarjeta.getLIMITE_COMPRA_EN_PESOS(), tarjeta.getLIMITE_DE_COMPRA_EN_DOLARES());
	    	} else if (medioPagador instanceof TarjetaDeDebito) {
	    		// Pago con tarjeta de débito
	    		TarjetaDeDebito tarjeta = (TarjetaDeDebito) medioPagador;
	    		return tarjeta.realizarPagoDebito(codigoQR.getMonto(), tarjeta.getSaldo());
	    	} else {
	    		return false;
	    	}
	    }else {
	    	return false;
	    }
	}
	
//	No hace falta usar esto
//	public Pagadora getMedioPagadorPorCuentaDeBanco(Integer idUser,String tITULAR_ESPERADO) {
//	    List<Pagadora> mediosDePagoUsuario = getMediosDePagoPorUsuario(idUser);
//	    if (mediosDePagoUsuario != null) {
//	        for (Pagadora nombreTitular : mediosDePagoUsuario) {
//	            if (nombreTitular instanceof CuentaVirtual || nombreTitular instanceof CuentaBancaria) {
//	                String name = nombreTitular.getTITULAR_ESPERADO();
//	                if (name.equals(tITULAR_ESPERADO)) {
//	                    return nombreTitular;
//	                }
//	            }
//	        }
//	    }
//	    return null;
//	}
	
	public Boolean transferir(Double saldo, Transferible cuentaOrigen, Transferible cuentaDestino) throws SaldoInsuficienteException{
	    if (saldo > 0.0 && cuentaOrigen != null && cuentaDestino != null) {
	        if (cuentaOrigen.getSaldo() >= saldo) {
	            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - saldo);
	            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + saldo);
	            return true;
	        }else {
	        	throw new SaldoInsuficienteException();
	        }
	    }
	    return false;
	}
}
