package banco.tela;

import java.awt.JobAttributes;

import javax.swing.JOptionPane;

import banco.modelo.Cliente;
import banco.modelo.Conta;

public class Principal {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome(JOptionPane.showInputDialog("Cliente:"));
		cliente.setCidade(JOptionPane.showInputDialog("Cidade:"));
		cliente.setEstado(JOptionPane.showInputDialog("Estado:"));
		
		JOptionPane.showMessageDialog(null, "Dados dos Clientes: \n\n " + cliente.listarDados());
		
		Conta conta = new Conta(cliente);
		
		JOptionPane.showMessageDialog(null, "Dados da Conta: \\n\\n" + conta.listarContas());
		
		int opcao = 0;
		String ret;
		do {
			String mensagem = "SALDO EM CONTA: " + conta.getSaldoFormatado() + "\n\n" +
					"OPÇÔES: \n1 - Depositar Valor\n2 - Sacar Valor\n3 - Finalizar";
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem));
				switch (opcao) {
					case 1:
						ret = JOptionPane.showInputDialog(null, "Valor do Depósito: ");
						conta.depositar(Double.parseDouble(ret));
						JOptionPane.showMessageDialog(null,  "Depósito realizado!");
						break;
					case 2:
						ret = JOptionPane.showInputDialog(null, "Valor do Saque: ");
						if (conta.sacar(Double.parseDouble(ret))) {
							JOptionPane.showMessageDialog(null, "Saque Realizado");
						}else {
							JOptionPane.showMessageDialog(null, "FALHA NO SAAQUE");
						}
				}
				
			} catch (NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "NÚMERO INVÁLIDO" );				
			}
		} while ((opcao == 1) || (opcao==2));		
	}
}
