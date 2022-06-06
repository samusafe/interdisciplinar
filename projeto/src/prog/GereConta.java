package prog;

import prog.Conta.ContaType;

import java.util.ArrayList;

public class GereConta {
	static ArrayList<Conta> contas = new ArrayList<>();
	public boolean criarConta(String nome, char[] password, ContaType tipo) {
		String pw = "";
		for (int i = 0; i < password.length; i++) {
			pw += password[i];
		}
		Conta conta = new Conta(nome, pw, tipo);
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).equals(conta)) {
				return false;
			}
		}
		return contas.add(conta);
	}
	
	public ContaType entrarConta(String nome, char[] password, ContaType tipo) {
		String pw = "";
		for (int i = 0; i < password.length; i++) {
			pw += password[i];
		}
		Conta conta = new Conta(nome, pw, tipo);
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNome().equals(conta.getNome())) {
				if (contas.get(i).getPassword().equals(conta.getPassword())) {
					return contas.get(i).getTipo();
				}
			}
		}
		return tipo;
	}
}