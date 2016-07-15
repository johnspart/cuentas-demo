package co.com.tns.tdd;

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
	public void transferirSaldoTest() throws Exception {
		double saldoVerificar = 8000.0;
		double saldoVerificarNuevoCliente = 4000.0;
		manejadorCuentas.transferir(clienteOrigen, clienteDestino, 2000);
		//
		double saldo = manejadorCuentas.consultarSaldo(clienteOrigen);
		double saldoNuevoCliente = manejadorCuentas.consultarSaldo(clienteDestino);
		// Assert
		Assert.assertTrue("El saldo no coincide", saldoVerificar == saldo);
		Assert.assertTrue("El saldo del nuevo cliente nocoincide", saldoVerificarNuevoCliente == saldoNuevoCliente);
	}

	@Test	
	public void saldoInsuficienteTest() throws Exception {
		double saldoVerificar = 2000;
		// Arrange
		clienteOrigen.getCuenta().setSaldo(2000D);
		// Act
		manejadorCuentas.transferir(clienteOrigen, clienteDestino, 10000);
		double saldo = manejadorCuentas.consultarSaldo(clienteOrigen);
		// Assert
		Assert.assertTrue("El saldo no conincide", saldoVerificar == saldo);
	}
}
