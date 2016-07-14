package co.com.tns.vm;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;

public class LoginVM {
	@Command("login")
	public void login(@BindingParam("user") String usuarios, @BindingParam("pass") String pass) {
		System.out.println("Bien");
	}
}
