package co.com.tns.vm;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;

import co.com.tns.bs.cuenta.Cliente;
import co.com.tns.bs.cuenta.Usuarios;

public class LoginVM {

	@Command("login")
	public void login(@BindingParam("user") String user,
			@BindingParam("pass") String pass) {
		if (!user.equals(pass))
			return;

		Cliente cliente;
		if (Usuarios.getInstance().getUsuarios().containsKey(user))
			cliente = Usuarios.getInstance().getUsuarios().get(user);
		else
			return;
		Executions.getCurrent().getSession().setAttribute("cliente", cliente);
		Executions.sendRedirect("/index.zul");
	}
}
