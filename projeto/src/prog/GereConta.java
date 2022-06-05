package prog;
import java.util.Scanner;

import prog.Conta.ContaType;

import java.util.ArrayList;

public class GereConta {
	private static ArrayList<Conta> contas = new ArrayList<>();
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
	
	public void entrarConta() {
		if (contas.size() == 0) {
			System.out.println("-> Nenhuma conta criada");
		}
		else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("-> Nome?");
			String nome = scanner.nextLine();
			while (nome.length() < 1) {
				System.out.println("-> Nome?");
				nome = scanner.nextLine();
			}
			Conta conta = null;
			for (int i = 0; i < (contas.size()); i++) {
				if (nome.equals(contas.get(i).getNome())) {
					System.out.println("-> Password?");
					String password = scanner.nextLine();
					while (password.length() < 1) {
						System.out.println("-> Password?");
						password = scanner.nextLine();
					}
					while (!password.equals(contas.get(i).getPassword())) {
						System.out.println("-> Password?");
						password = scanner.nextLine();
					}
					conta = contas.get(i);
				}
			}
			
			if (conta == null) {
				return;
			}
			
			if (conta.getTipo() == ContaType.ADMIN) {
				Menu.menuAdmin(conta);
			}
			else {
				Menu.menuTurista(conta);
			}
		}
	}
}