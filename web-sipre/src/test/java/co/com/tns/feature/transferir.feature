@tag
Feature: Transferir a otra cuenta

@tag1
Scenario: Ingresa Cuenta, Saldo y   cuenta a transferir
	Given En la pantalla de cuentas
	When Exista mi numero de cuenta	
	And Ingrese el saldo
	And Ingrese Cuenta a transferir
	And Selecciono Aceptar
	Then Transfiere el saldo a la otra cuenta