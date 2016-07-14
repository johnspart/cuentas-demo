package co.com.tns.bs.cuenta;

public class Cuenta {
	private double saldo;
	private double monto;
	private String fecha;

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void debitar(int monto2) {
		this.saldo= saldo -monto2;
		
	}

	public void adicionar(int monto2) {
		this.saldo= saldo +monto2;
		
	}

}
