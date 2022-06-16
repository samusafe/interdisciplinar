package prog;

import prog.Conta.ContaType;

import java.util.ArrayList;

public class GereConta {
	private ArrayList<Conta> contas = new ArrayList<>();
	
	public GereConta() {
		contas.add(new Conta("admin", "admin", ContaType.ADMIN));
		contas.add(new Conta("user", "user", ContaType.TURISTA));
	}
	
	public boolean hasContas() {
		return contas.size() > 0;
	}
	
	public boolean criarConta(String nome, char[] password, ContaType tipo) {
		Conta conta = new Conta(nome, joinCharArray(password), tipo);
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).equals(conta)) {
				return false;
			}
		}
		return contas.add(conta);
	}
	
	public Conta entrarConta(String nome, char[] password) {
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNome().equals(nome) 
					&& contas.get(i).getPassword().equals(joinCharArray(password))) {
					return contas.get(i);
			}
		}
		return null;
	}
	
	private String joinCharArray(char[] password) {
		String pw = "";
		for (int i = 0; i < password.length; i++) {
			pw += password[i];
		}
		
		return pw;
	}
}