package co.com.tns.bs.cuenta.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.tns.bs.cuenta.Cliente;
import co.com.tns.bs.cuenta.Cuenta;
import co.com.tns.bs.cuenta.ManejadorCuentas;

public class ManejadorCuentaTest {
	private Cliente clienteOrigen;
	private Cliente clienteDestino;
	private ManejadorCuentas manejadorCuentas;

	@Before
	public void init() {
		clienteOrigen = new Cliente();
		clienteOrigen.setNombre("Jimmy");
		clienteOrigen.setDireccion("Barrio Manila");
		Cuenta cuenta = new Cuenta();
		cuenta.setFecha(new Date().toString());
		cuenta.setSaldo(10000);
		clienteOrigen.setCuenta(cuenta);
		clienteDestino = new Cliente();
		clienteDestino.setNombre("John");
		clienteDestino.setDireccion("Barrio Manila");
		Cuenta cuentaDestino = new Cuenta();
		cuentaDestino.setFecha(new Date().toString());
		cuentaDestino.setSaldo(2000);
		clienteDestino.setCuenta(cuentaDestino);

		manejadorCuentas = new ManejadorCuentas();
	}

	@Test
	public void transferirSaldoTest() {

		manejadorCuentas.transferir(clienteOrigen, clienteDestino, 2000);
		//
		double saldo = manejadorCuentas.consultarSaldo(clienteOrigen);
		double saldoNuevoCliente = manejadorCuentas.consultarSaldo(clienteDestino);
		// Assert
		Assert.assertEquals(8000.0, saldo);
		Assert.assertEquals(4000.0, saldoNuevoCliente);
	}

	@Test
	public void saldoInsuficienteTest() {
		// Arrange
		clienteOrigen.getCuenta().setSaldo(2000);
		// Act
		manejadorCuentas.transferir(clienteOrigen, clienteDestino, 10000);
		double saldo = manejadorCuentas.consultarSaldo(clienteOrigen);
		// Assert
		Assert.assertEquals(2000.0, saldo);
	}
}
