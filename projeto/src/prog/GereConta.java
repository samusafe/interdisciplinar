package prog;

import prog.Conta.ContaType;

import java.util.ArrayList;

public class GereConta {
	private ArrayList<Conta> contas = new ArrayList<>();
	
	/**
	 * verifica se existem contas criadas
	 * @return que existem mais de 0
	 */
	public boolean hasContas() {
		return contas.size() > 0;
	}
	
	/**
	 * cria conta caso a conta nao exista ainda, retorna false caso exista
	 * @param nome da conta
	 * @param password da conta
	 * @param tipo da conta (turista ou admin)
	 * @return true se a conta foi criada, false caso contrario
	 */
	public boolean criarConta(String nome, char[] password, ContaType tipo) {
		Conta conta = new Conta(nome, joinCharArray(password), tipo);
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).equals(conta)) {
				return false;
			}
		}
		return contas.add(conta);
	}
	
	/**
	 * entra na conta caso as credenciais estejam corretas, retorna null caso estejam incorretas
	 * @param nome da conta
	 * @param password da conta
	 * @return true se as credenciais estiverem corretas, null caso contrario
	 */
	public Conta entrarConta(String nome, char[] password) {
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNome().equals(nome) 
					&& contas.get(i).getPassword().equals(joinCharArray(password))) {
					return contas.get(i);
			}
		}
		return null;
	}
	
	/**
	 * converte a password guardada num array de char numa String
	 * @param password
	 * @return pw apos ter sido convertida para string
	 */
	private String joinCharArray(char[] password) {
		String pw = "";
		for (int i = 0; i < password.length; i++) {
			pw += password[i];
		}
		
		return pw;
	}
}