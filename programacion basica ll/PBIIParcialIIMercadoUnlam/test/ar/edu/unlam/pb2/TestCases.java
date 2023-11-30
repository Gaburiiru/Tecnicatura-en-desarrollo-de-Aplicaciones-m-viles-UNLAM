package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
	public void queSePuedaCrearUnaTarjetaDeDebito() throws NumeroDeTarjetaInvalidoException {
		// Preparación
		final Long NUMERO_ESPERADO = 5446789813221201L;
		final String TITULAR_ESPERADO = "CAMILA CIENFUEGOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 123;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2022";
		final Double SALDO_ESPERADO = 10000.0;

		// Ejecución
		TarjetaDeDebito tarjetaDeDebito = new TarjetaDeDebito(100.0,NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO,CODIGO_DE_SEGURIDAD_ESPERADO);
		tarjetaDeDebito.setSaldo(10000.0);

		// Verificación
		assertEquals(NUMERO_ESPERADO, tarjetaDeDebito.getNUMERO_ESPERADO());
		assertEquals(TITULAR_ESPERADO, tarjetaDeDebito.getTITULAR_ESPERADO());
		assertEquals(CODIGO_DE_SEGURIDAD_ESPERADO, tarjetaDeDebito.getCODIGO_DE_SEGURIDAD_ESPERADO());
		assertEquals(FECHA_DE_VENCIMIENTO_ESPERADO, tarjetaDeDebito.getFECHA_DE_VENCIMIENTO_ESPERADO());
		assertEquals(SALDO_ESPERADO, tarjetaDeDebito.getSaldo());
	}

	@Test
	public void queSePuedaCrearUnaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException {
		// Preparaci�n
		final Long NUMERO_ESPERADO = 4246789813221201L;
		final String TITULAR_ESPERADO = "SOFIA BARRIENTOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 567;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2025";
		final double LIMITE_COMPRA_EN_PESOS = 100000.0;
		final double LIMITE_COMPRA_EN_DOLARES = 1000.0;

		// Ejecuci�n
		TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito(NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO, LIMITE_COMPRA_EN_PESOS,LIMITE_COMPRA_EN_DOLARES);
		tarjetaDeCredito.setLIMITE_COMPRA_EN_PESOS(LIMITE_COMPRA_EN_PESOS);
		tarjetaDeCredito.setLIMITE_DE_COMPRA_EN_DOLARES(LIMITE_COMPRA_EN_DOLARES);

		// Verificaci�n
		assertEquals(NUMERO_ESPERADO, tarjetaDeCredito.getNUMERO_ESPERADO());
		assertEquals(TITULAR_ESPERADO, tarjetaDeCredito.getTITULAR_ESPERADO());
		assertEquals(CODIGO_DE_SEGURIDAD_ESPERADO, tarjetaDeCredito.getCODIGO_DE_SEGURIDAD_ESPERADO());
		assertEquals(FECHA_DE_VENCIMIENTO_ESPERADO, tarjetaDeCredito.getFECHA_DE_VENCIMIENTO_ESPERADO());
		assertEquals(LIMITE_COMPRA_EN_PESOS, tarjetaDeCredito.getLIMITE_COMPRA_EN_PESOS(), 0.0);
		assertEquals(LIMITE_COMPRA_EN_DOLARES, tarjetaDeCredito.getLIMITE_DE_COMPRA_EN_DOLARES(), 0.0);
	}

	@Test
	public void queSePuedaCrearUnaCuentaBancaria() throws CBUInvalidoException {

		// Preparaci�n
		final String CBU_ESPERADO = "01702046600000087865";
		final String ENTIDAD_ESPERADA = "Santander";
		final String TITULAR_ESPERADO = "Vicente De La Pradera";

		// Ejeruci�n
		CuentaBancaria cuentaBancaria = new CuentaBancaria(0.0,CBU_ESPERADO, ENTIDAD_ESPERADA, TITULAR_ESPERADO);

		// Verificaci�n
		assertEquals(CBU_ESPERADO, cuentaBancaria.getCBU_ESPERADO());
		assertEquals(ENTIDAD_ESPERADA, cuentaBancaria.getENTIDAD_ESPERADA());
		assertEquals(TITULAR_ESPERADO, cuentaBancaria.getTITULAR_ESPERADO());
	}

	@Test
	public void queSePuedaCrearUnaCuentaVirtual() throws CVUInvalidoException {
		// Preparaci�n
		final String CVU_ESPERADO = "46467898132212011234552";
		final String ENTIDAD_ESPERADA = "Mercado Pago";
		final String TITULAR_ESPERADO = "Leticia Bridgeton";

		// Ejecuci�n
		Transferible cuentaVirtual = new CuentaVirtual(CVU_ESPERADO, ENTIDAD_ESPERADA, TITULAR_ESPERADO);

		// Verificaci�n
		assertEquals(CVU_ESPERADO, cuentaVirtual.getCVU_ESPERADO());
		assertEquals(ENTIDAD_ESPERADA, cuentaVirtual.getENTIDAD_ESPERADA());
		assertEquals(TITULAR_ESPERADO, cuentaVirtual.getTITULAR_ESPERADO());
	}

	@Test
	public void queSePuedaCrearUnComercio() throws CuitInvalidoException {
		// Preparaci�n
		final String NOMBRE_ESPERADO = "El almacen de la esquina";
		final Long CUIT_ESPERADO = 30215654124L;

		// Ejecuci�n
		Comercio elAlmacen = new Comercio(CUIT_ESPERADO, NOMBRE_ESPERADO);
		elAlmacen.setNOMBRE_ESPERADO(NOMBRE_ESPERADO);
		elAlmacen.setCUIT_ESPERADO(CUIT_ESPERADO);

		// Verificaci�n
		assertEquals(CUIT_ESPERADO, elAlmacen.getCUIT_ESPERADO());
		assertEquals(NOMBRE_ESPERADO, elAlmacen.getNOMBRE_ESPERADO());
	}

	@Test
	public void queSePuedaCrearUnConsumidor() {
		// Preparaci�n
		final String NOMBRE_ESPERADO = "Erika Romeo";
		final Integer DNI_ESPERADO = 33458712;

		// Ejecuci�n
		Consumidor nuevoConsumidor = new Consumidor(DNI_ESPERADO, NOMBRE_ESPERADO);
		nuevoConsumidor.setDNI_ESPERADO(DNI_ESPERADO);
		nuevoConsumidor.setNOMBRE_ESPERADO(NOMBRE_ESPERADO);
		// Verificaci�n
		assertEquals(DNI_ESPERADO, nuevoConsumidor.getDNI_ESPERADO());
		assertEquals(NOMBRE_ESPERADO, nuevoConsumidor.getNOMBRE_ESPERADO());
	}

	@Test
	public void queSePuedanAgregarComerciosALaBilletera() throws CuitInvalidoException {
		// Preparaci�n
		final Integer CANTIDAD_DE_COMERCIOS_ESPERADOS = 2;

		// Ejecuci�n
		Billetera mataGalan = new Billetera("Ank");

		mataGalan.agregarComercio(new Comercio(30456213545L, "Supermercado"));
		mataGalan.agregarComercio(new Comercio(30215654124L, "Panader�a"));
		mataGalan.agregarComercio(new Comercio(30215654124L, "Panader�a"));

		// Verificaci�n
		assertEquals(CANTIDAD_DE_COMERCIOS_ESPERADOS, mataGalan.getListaDeComercio());
	}

	@Test 
	public void queSePuedanAgregarConsumidoresALaBilletera() { 
		//Preparaci�n 
		final Integer CANTIDAD_DE_CONSUMIDORES_ESPERADOS = 2;
	  
		// Ejecuci�n 
		Billetera mataGalan = new Billetera("Bna+");

		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarConsumidor(new Consumidor(36541231, "Sofia Molina"));
	  
		// Verificaci�n 
		assertEquals(CANTIDAD_DE_CONSUMIDORES_ESPERADOS,mataGalan.getListaDeConsumidor()); 
	}

	@Test public void queSePuedanAgregarDistintosMediosDePagoALaBilleteraDeUnConsumidor() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, NoCoincideTitularException{ 
		// Preparaci�n 
		final Integer CANTIDAD_DE_MEDIOS_EN_LA_BILLETERA_ESPERADOS = 4;
		final double LIMITE_COMPRA_EN_PESOS = 100000.0;
		final double LIMITE_COMPRA_EN_DOLARES = 1000.0;
		// Ejecuci�n
		Billetera mataGalan = new Billetera("MercadoPago");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
	  
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeDebito(100.0,48332562153254623L, "Luis Gomez", "10/10/2026", 265));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeDebito(100.0,48332562153254623L, "Luis Gomez", "10/10/2026", 312));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeCredito(5423542385612354L, "Luis Gomez", "10/10/2026", 153,LIMITE_COMPRA_EN_PESOS,LIMITE_COMPRA_EN_DOLARES));
		mataGalan.agregarMedioDePago(27541231, new CuentaBancaria(0.0,"01702046600000087865", "Naci�n", "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new CuentaVirtual("0000003100036521571806", "Mercado Pago", "Luis Gomez"));
	  
		// Verificaci�n 
		assertEquals(CANTIDAD_DE_MEDIOS_EN_LA_BILLETERA_ESPERADOS,mataGalan.getCantidadDeMediosDePago(27541231)); 
	}
	  
	@Test
	public void queSePuedaPagarConUnaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, ExcedeLimiteDeCompraException, SaldoInsuficienteException{
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ank");
		Consumidor consumidor = new Consumidor(27541231, "Luis Gomez");
		TarjetaDeCredito tarjeta = new TarjetaDeCredito(48332562153254623L, "Luis Gomez", "10/10/2026", 265, 100000.0, 1000.0);
		mataGalan.agregarConsumidor(consumidor);	
		mataGalan.agregarMedioDePago(27541231,tarjeta);
		mataGalan.agregarComercio(new Comercio(30456213545L, "Panader�a"));	
		// Ejecuci�n	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 1000.0);
		Boolean resultado = mataGalan.pagar(codigoQR,mataGalan.getMedioPagadorPorNumeroTarjeta(consumidor.getDNI_ESPERADO(),tarjeta.getNUMERO_ESPERADO()));
		
		// Verificaci�n
		assertTrue(resultado);
	}
	
	@Test
	public void queSePuedaPagarConUnaTarjetaDeDebito() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, ExcedeLimiteDeCompraException, SaldoInsuficienteException{
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ank");
		Consumidor consumidor = new Consumidor(27541231, "Luis Gomez");
		TarjetaDeDebito tarjeta = new TarjetaDeDebito(1000.0 ,48332562153254623L, "Luis Gomez", "10/10/2026", 265);
		mataGalan.agregarConsumidor(consumidor);	
		mataGalan.agregarMedioDePago(27541231,tarjeta);
		mataGalan.agregarComercio(new Comercio(30456213545L, "Panader�a"));	
		// Ejecuci�n	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 200.0);
		Boolean resultado = mataGalan.pagar(codigoQR,mataGalan.getMedioPagadorPorNumeroTarjeta(consumidor.getDNI_ESPERADO(),tarjeta.getNUMERO_ESPERADO()));
		
		// Verificaci�n
		assertTrue(resultado);
	}
	
	@Test 
	public void queSePuedaTransferirDeUnaCuentaAOtra() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException,SaldoInsuficienteException{ 
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ual�");
		Transferible cuentaOrigen = new
		CuentaBancaria(1000.0,"01702046600000087865", "Naci�n", "Luis Gomez");
		Consumidor consumidorOrigen = new Consumidor(27541231, "Luis Gomez");
		mataGalan.agregarConsumidor(consumidorOrigen);
		mataGalan.agregarMedioDePago(27541231, cuentaOrigen);
	  
		Transferible cuentaDestino = new CuentaBancaria(0.0,"01744046600000087335","Galicia", "Sandra Bustos"); 
		Consumidor consumidorDestino = new Consumidor(33896541, "Sandra Bustos");
		mataGalan.agregarConsumidor(consumidorDestino);
		mataGalan.agregarMedioDePago(33896541, cuentaDestino);
		Double saldoATransferir = 200.0;
		// Ejecuci�n
		Boolean resultado = mataGalan.transferir(saldoATransferir,cuentaOrigen,cuentaDestino);
	  
		// Verificaci�n
		assertTrue(resultado); 
	}
	
	@Test (expected=SaldoInsuficienteException.class)
	public void queNoSePuedaTransferirSiElSaldoNoEsSuficiente() throws SaldoInsuficienteException {
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ual�");
		Transferible cuentaOrigen = new
		CuentaBancaria(0.0,"01702046600000087865", "Naci�n", "Luis Gomez");
		Consumidor consumidorOrigen = new Consumidor(27541231, "Luis Gomez");
		mataGalan.agregarConsumidor(consumidorOrigen);
		mataGalan.agregarMedioDePago(27541231, cuentaOrigen);
	  
		Transferible cuentaDestino = new CuentaBancaria(0.0,"01744046600000087335","Galicia", "Sandra Bustos"); 
		Consumidor consumidorDestino = new Consumidor(33896541, "Sandra Bustos");
		mataGalan.agregarConsumidor(consumidorDestino);
		mataGalan.agregarMedioDePago(33896541, cuentaDestino);
		Double saldoATransferir = 200.0;
		// Ejecuci�n
		Boolean resultado = mataGalan.transferir(saldoATransferir,cuentaOrigen,cuentaDestino);
	  
		// Verificaci�n
		assertFalse(resultado);
	}
	  
	@Test (expected=SaldoInsuficienteException.class)
	public void queNoSePuedaComprarSiElSaldoDeLaTarjetaDeDebitoEsInsuficiente() throws SaldoInsuficienteException, ExcedeLimiteDeCompraException {
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ank");
		Consumidor consumidor = new Consumidor(27541231, "Luis Gomez");
		TarjetaDeDebito tarjeta = new TarjetaDeDebito(1000.0 ,48332562153254623L, "Luis Gomez", "10/10/2026", 265);
		mataGalan.agregarConsumidor(consumidor);	
		mataGalan.agregarMedioDePago(27541231,tarjeta);
		mataGalan.agregarComercio(new Comercio(30456213545L, "Panader�a"));	
		// Ejecuci�n	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 2000.0);
		mataGalan.pagar(codigoQR,mataGalan.getMedioPagadorPorNumeroTarjeta(consumidor.getDNI_ESPERADO(),tarjeta.getNUMERO_ESPERADO()));
	}
	  
	@Test (expected=ExcedeLimiteDeCompraException.class) 
	public void queNoSePuedaComprarSiSeExcedeElLimiteDeCompraDeLaTarjetaDeCredito() throws SaldoInsuficienteException, ExcedeLimiteDeCompraException {
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ank");
		Consumidor consumidor = new Consumidor(27541231, "Luis Gomez");
		TarjetaDeCredito tarjeta = new TarjetaDeCredito(48332562153254623L, "Luis Gomez", "10/10/2026", 265, 100000.0, 1000.0);
		mataGalan.agregarConsumidor(consumidor);	
		mataGalan.agregarMedioDePago(27541231,tarjeta);
		mataGalan.agregarComercio(new Comercio(30456213545L, "Panader�a"));	
		// Ejecuci�n	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 3000.0);
		mataGalan.pagar(codigoQR,mataGalan.getMedioPagadorPorNumeroTarjeta(consumidor.getDNI_ESPERADO(),tarjeta.getNUMERO_ESPERADO()));
	}
}
