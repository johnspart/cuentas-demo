package co.com.tns.atdd;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import co.com.tns.bs.cuenta.Cliente;
import co.com.tns.bs.cuenta.Cuenta;
import co.com.tns.bs.cuenta.Usuarios;
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
	public void mi_saldo_actual_es(String saldo) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"./src/test/resources/drivers/chromedriver.exe");

		webDriver = new ChromeDriver();

		cliente = Usuarios.getInstance().getUsuarios().get("jimmy");
	}

	@Given("^estoy en la pantalla de cuentas$")
	public void estoy_en_la_pantalla_de_cuentas() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		webDriver.get("http://localhost:8080/web-sipre/login.zul");
		List<WebElement> inputs = webDriver.findElements(By.tagName("input"));

		// WebElement usuario = webDriver.findElement(By
		// .xpath(".//*[contains(@id,'username')]"));
		inputs.get(0).sendKeys(cliente.getUsuario());
		// WebElement password = webDriver.findElement(By
		// .xpath(".//*[contains(@id,'password')]"));
		inputs.get(1).sendKeys(cliente.getPassword());

		WebElement button = webDriver.findElement(By.tagName("button"));
		button.click();

	}

	@When("^ingreso el saldo a transferir de \"([^\"]*)\"$")
	public void ingreso_el_saldo_a_transferir_de(String monto) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
		List<WebElement> inputs = webDriver.findElements(By.tagName("input"));
		inputs.get(0).sendKeys(String.valueOf(monto));

	}

	@When("^ingreso la cuenta destino \"([^\"]*)\"$")
	public void ingreso_la_cuenta_destino(String cuenta) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<WebElement> inputs = webDriver.findElements(By.tagName("input"));
		inputs.get(1).sendKeys(String.valueOf(cuenta));

	}

	@When("^seleccion la opcion Transferir$")
	public void seleccion_la_opcion_Transferir() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement button = webDriver.findElement(By.tagName("button"));
		button.click();
	}

	@Then("^veo el mensaje \"([^\"]*)\"$")
	public void veo_el_mensaje(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<WebElement> inputs = webDriver.findElements(By.tagName("input"));
		inputs.get(2);
	}

	@Then("^mi nuevo saldo es \"([^\"]*)\"$")
	public void mi_nuevo_saldo_es(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<WebElement> inputs = webDriver.findElements(By.tagName("span"));
		
		Assert.assertEquals(Double.valueOf(arg1),
				Double.valueOf(inputs.get(4).getText()));

	}
}
