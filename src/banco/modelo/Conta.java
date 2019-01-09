package banco.modelo;

import java.text.DecimalFormat;

public class Conta {
	protected int numero;
	protected Cliente cliente;
	protected double saldo;
	
	private static int contador;
	
	public Conta(Cliente cliente) {
		contador++;
		numero = contador;
		saldo = 0;
		this.cliente = cliente;
	}
	
	public String listarContas() {
		return 	"NUMERO: " + numero + "\n" +
				"CLIENTE: " + cliente.getNome() + "\n" +
				"SALDO: " + DecimalFormat.getCurrencyInstance().format(saldo) + "\n" ;				
	}
	
	public String getSaldoFormatado() {
		return DecimalFormat.getNumberInstance().format(saldo);
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public boolean sacar(double valor) {
		if (saldo>=valor) {
			saldo -= valor;
			return true;
		}else {
			return false;
		}
	}
	
	
}
