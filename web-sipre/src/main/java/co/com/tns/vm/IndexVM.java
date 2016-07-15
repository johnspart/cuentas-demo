package co.com.tns.vm;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

import co.com.tns.bs.cuenta.Cliente;
import co.com.tns.bs.cuenta.Cuenta;
import co.com.tns.bs.cuenta.ManejadorCuentas;
import co.com.tns.bs.cuenta.Usuarios;

public class IndexVM {
	private Cliente cliente;
	private Cuenta cuenta;
	private String cuentaTransferir;
	private Double valorTransferir;
	private boolean transFerenciaExitosa;
	private boolean saldoIn;

	@Init
	public void init() {
		Cliente cliente = (Cliente) Executions.getCurrent().getSession()
				.getAttribute("cliente");

		if (cliente == null)
			Executions.sendRedirect("/login.zul");

		this.cliente = Usuarios.getInstance().getUsuarios()
				.get(cliente.getUsuario());
		this.cuenta = cliente.getCuenta();
		this.transFerenciaExitosa = false;
	}

	@NotifyChange("*")
	@Command("transferir")
	public void transferir() {
		ManejadorCuentas manejadorCuentas = new ManejadorCuentas();
		Cliente clienteDestino = new Cliente();
		Cuenta cuentaDestino = new Cuenta();
		cuentaDestino.setNumero(this.cuentaTransferir);
		clienteDestino.setCuenta(cuentaDestino);

		try {
			manejadorCuentas.transferir(this.cliente, clienteDestino,
					this.getValorTransferir());
			this.transFerenciaExitosa = true;
			saldoIn = false;
		} catch (Exception e) {
			transFerenciaExitosa = false;
			saldoIn = true;
		}
		// this.cuenta.setSaldo(this.cuenta.getSaldo() -
		// this.getValorTransferir());

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

	public boolean isTransFerenciaExitosa() {
		return transFerenciaExitosa;
	}

	public void setTransFerenciaExitosa(boolean transFerenciaExitosa) {
		this.transFerenciaExitosa = transFerenciaExitosa;
	}

	public boolean isSaldoIn() {
		return saldoIn;
	}

	public void setSaldoIn(boolean saldoIn) {
		this.saldoIn = saldoIn;
	}

}
