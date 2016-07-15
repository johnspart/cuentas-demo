package co.com.tns.vm;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;

import co.com.tns.bs.cuenta.Cliente;
import co.com.tns.bs.cuenta.Cuenta;

public class LoginVM {
	@Command("login")
	public void login(@BindingParam("user") String user, @BindingParam("pass") String pass) {
		if (user != pass)
			return;
		Cliente cliente = new Cliente();
		Cuenta cuenta = new Cuenta();
		cuenta.setSaldo(1000);
		cuenta.setFecha("2015-12-5");
		cliente.setCuenta(cuenta);
		Executions.getCurrent().setAttribute("cliente", cliente);
		Executions.sendRedirect("/index.zul");
	}
}
