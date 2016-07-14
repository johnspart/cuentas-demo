package co.com.tns.atdd;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestLogin {
	WebDriver webDriver;

	@After
	public void after() {
		webDriver.close();
	}

	@Given("^Ingreso a la sucursal virtual$")
	public void ingreso_a_la_sucursal_virtual() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// System.setProperty("webdriver.chrome.driver",
		// "C:/Users/jimmy.muchachasoy/Downloads/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "./resources/test/drivers/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get("http://localhost:8080/login.zul");

	}

	@When("^Ingreso login \"([^\"]*)\"$")
	public void ingreso_login(String usuario) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement input = webDriver.findElement(By.xpath(".//*[contains(@id,'username')]"));
		input.sendKeys(usuario);
	}

	@When("^Ingreso password \"([^\"]*)\"$")
	public void ingreso_password(String password) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement input = webDriver.findElement(By.xpath(".//*[contains(@id,'password')]"));
		input.sendKeys(password);

	}

	@When("^Seleccion ingresar$")
	public void seleccion_ingresar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement button = webDriver.findElement(By.xpath(".//*[contains(@id,'button')]"));
		button.click();

	}

	@Then("^Ingreso a la pagina de transferencias$")
	public void ingreso_a_la_pagina_de_transferencias() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement button = webDriver.findElement(By.xpath(".//*[contains(@id,'Cuentas')]"));
	}
}
