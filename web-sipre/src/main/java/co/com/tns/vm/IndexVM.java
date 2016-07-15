package co.com.tns.vm;

import org.zkoss.bind.annotation.Init;

import co.com.tns.bs.cuenta.Cliente;
import co.com.tns.bs.cuenta.Cuenta;

public class IndexVM {
	private Cliente cliente;
	private Cuenta cuenta;
	private String cuentaTransferir;
	private Double valorTransferir;

	@Init
	public void init() {
		this.cliente = new Cliente();
		this.cuenta = new Cuenta();
	}

	public Double getValorTransferir() {
		return valorTransferir;
	}

	public void setValorTransferir(Double valorTransferir) {
		this.valorTransferir = valorTransferir;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String getCuentaTransferir() {
		return cuentaTransferir;
	}

	public void setCuentaTransferir(String cuentaTransferir) {
		this.cuentaTransferir = cuentaTransferir;
	}

}
