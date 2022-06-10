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
	
	public Conta entrarConta(String nome, String password) {
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNome().equals(nome)
					&& contas.get(i).getPassword().equals(password)) {
				ContaType tipo = contas.get(i).getTipo();
				return contas.get(i);
			}
		}
		return null;
	}
}