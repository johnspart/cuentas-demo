@tag
Feature: Transferir a otra cuenta

#@tag1
#Scenario: Ingresa Cuenta, Saldo y   cuenta a transferir
#	Given En la pantalla de cuentas
#	When Exista mi numero de cuenta	
#	And Ingrese el saldo 12000
#	And Ingrese Cuenta a transferir 120023456
#	And Selecciono Aceptar
#	Then Veo mi nuevo saldo

@tag1	
Scenario: Transferir dinero desde sucursal 
Given mi saldo actual es "10000" 
And estoy en la pantalla de cuentas
When ingreso el saldo a transferir de "2000" 
And ingreso la cuenta destino "109434565443"
And seleccion la opcion Transferir
Then veo el mensaje "Transferencia exitosa"
And  mi nuevo saldo es "8000"