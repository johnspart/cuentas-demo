package co.com.tns.bs.cuenta;

public class ManejadorCuentas {

	public boolean saldoSuficiente(Cliente cliente, int monto) {
		boolean sedebito = false;
		if (cliente.getCuenta().getSaldo() > monto) {			
			sedebito = true;
		}
		return sedebito;
	}

	public double consultarSaldo(Cliente cliente) {

		return cliente.getCuenta().getSaldo();
	}

	public void transferir(Cliente clienteOrigen, Cliente clienteDestino, int monto) {
		if(saldoSuficiente(clienteOrigen,monto)){
			clienteOrigen.getCuenta().debitar(monto);
			clienteDestino.getCuenta().adicionar(monto);	
		}
		
		
	}

}
