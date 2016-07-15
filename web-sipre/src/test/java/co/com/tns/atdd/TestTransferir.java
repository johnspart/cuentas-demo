package co.com.tns.atdd;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import co.com.tns.bs.cuenta.Cliente;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestTransferir {
	WebDriver webDriver;
	Cliente cliente; 
	@After
	public void after() {
		webDriver.close();
	}
	@Given("^mi saldo actual es \"([^\"]*)\"$")
	public void mi_saldo_actual_es(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "./resources/test/drivers/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get("http://localhost:8080/index.zul");
		WebElement input = webDriver.findElement(By.xpath(".//*[contains(@id,'miSaldo')]"));
		cliente= new Cliente();
		cliente.setUsuario("admin");
		cliente.setPassword("123");
	}

	@Given("^estoy en la pantalla de cuentas$")
	public void estoy_en_la_pantalla_de_cuentas() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		webDriver.get("http://localhost:8080/login.zul");
		WebElement usuario = webDriver.findElement(By.xpath(".//*[contains(@id,'username')]"));
		usuario.sendKeys(cliente.getUsuario());
		WebElement password = webDriver.findElement(By.xpath(".//*[contains(@id,'password')]"));
		password.sendKeys(cliente.getPassword());
		WebElement button = webDriver.findElement(By.xpath(".//*[contains(@id,'button')]"));
		button.click();
	}

	@When("^ingreso el saldo a transferir de \"([^\"]*)\"$")
	public void ingreso_el_saldo_a_transferir_de(String monto) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement saldo = webDriver.findElement(By.xpath(".//*[contains(@id,'miSaldo')]"));
		saldo.sendKeys(String.valueOf(monto));
	}

	@When("^ingreso la cuenta destino \"([^\"]*)\"$")
	public void ingreso_la_cuenta_destino(String cuenta) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement cuentaDestino = webDriver.findElement(By.xpath(".//*[contains(@id,'cuentaTransferir')]"));
		cuentaDestino.sendKeys(String.valueOf(cuenta));
	}

	@When("^seleccion la opcion Transferir$")
	public void seleccion_la_opcion_Transferir() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement button = webDriver.findElement(By.xpath(".//*[contains(@id,'btnAceptar')]"));		 
		button.click();
	}

	@Then("^veo el mensaje \"([^\"]*)\"$")
	public void veo_el_mensaje(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^mi nuevo saldo es \"([^\"]*)\"$")
	public void mi_nuevo_saldo_es(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
