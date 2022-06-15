package prog;
import java.util.Scanner;

import prog.Local.LocalTipo;

import java.util.ArrayList;

public class GereLocal {
	public static ArrayList<Local> locais = new ArrayList<>();
	
	public GereLocal() {
		locais.add(new Local("museu 1", "info 1", "loc 1", LocalTipo.MUSEU));
		locais.add(new Local("museu 2", "info 2", "loc 2", LocalTipo.MUSEU));
		locais.add(new Local("museu 3", "info 3", "loc 3", LocalTipo.MUSEU));
		locais.add(new Local("museu 4", "info 4", "loc 4", LocalTipo.MUSEU));
		locais.add(new Local("museu 5", "info 5", "loc 5", LocalTipo.MUSEU));
		locais.add(new Local("museu 6", "info 6", "loc 6", LocalTipo.MUSEU));
		locais.add(new Local("museu 7", "info 7", "loc 7", LocalTipo.MUSEU));
		locais.add(new Local("museu 8", "info 8", "loc 8", LocalTipo.MUSEU));
		
		locais.add(new Local("monumento 1", "info 1", "loc 1", LocalTipo.MONUMENTO));
		locais.add(new Local("monumento 2", "info 2", "loc 2", LocalTipo.MONUMENTO));
		locais.add(new Local("monumento 3", "info 3", "loc 3", LocalTipo.MONUMENTO));
	}
	
	public boolean criarLocal(String nome, String info, String loc, LocalTipo tipo) {
		Local local = new Local(nome, info, loc, tipo);
		for (int i = 0; i < locais.size(); i++) {
			if (local.equals(locais.get(i))) {
				return false;
			}
		}
		return locais.add(local);
	}
	
	public void printLocal(Conta user, int escolha) {
		LocalTipo tipo = escolha == 1 ? LocalTipo.MUSEU : LocalTipo.MONUMENTO;
		ArrayList<Local> locaisFiltrados = filterByType(tipo);
		
		if (locaisFiltrados.size() == 0) {
			System.out.println("Nenhum " + tipo.toString().toLowerCase() + " criado");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("-> Escolha para ver informa��o mais detalhada");
		int save = 0;
		for (int i = 0; i < (locaisFiltrados.size()); i++) {
			System.out.println("[" + (i + 1) + "] " + locais.get(i).getNome());
			save = i;
		}
		System.out.println("[0] para sair");
		int in = scanner.nextInt();
		while (in > save && in < 0) {
			in = scanner.nextInt();
		}
		if (in > 0 && in <= locaisFiltrados.size()) { //TODO Validar que existe
			Local local = locaisFiltrados.get(in - 1);
			System.out.println("Sobre -> " + local.getInfo() + "\nLocaliza��o -> " + local.getLoc());
			if (local.hasAvaliacoes()) {
				System.out.println("-> Classifica��o do " + tipo.toString().toLowerCase() + " - " + local.getRate());
			}
			System.out.println("[0] para sair\n[1] avaliar local");
			in = scanner.nextInt();
			if (in == 1) {
				System.out.println("-> De uma avalia�ao de 1 a 5");
				int rate = scanner.nextInt();
				while (rate < 0 && rate > 5) {
					System.out.println("-> De uma avalia�ao de 1 a 5");
					rate = scanner.nextInt();
				}
				Avaliacao avaliacao = new Avaliacao(rate, user);
				local.addAvaliacao(avaliacao);
				replaceLocal(local);
			}
		}
	}
	
	public void printAtividade() {
		for (int i = 0; i < locais.size(); i++) {
			for (int j = 0; j < locais.get(i).getAvaliacoes().size(); j++) {
				System.out.println("-> " + locais.get(i).getAvaliacoes().get(j).getUser().getNome() 
						+ " deu uma avalia��o de " + locais.get(i).getAvaliacoes().get(j).getRate()
						+ " ao " + locais.get(i).getNome());
			}
		}
	}
	
	public void pesquisaLocal() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-> Nome?");
		String nome = scanner.nextLine();
		while (nome.length() < 1) {
			System.out.println("-> Nome?");
			nome = scanner.nextLine();
		}
		if (locais.size() == 0)
			System.out.println("Nenhum local criado");
		
		for (int i = 0; i < locais.size(); i++) {
			if (nome.equals(locais.get(i).getNome())) {
				System.out.println("Sobre -> " + locais.get(i).getInfo() + "\nLocaliza��o -> " + locais.get(i).getLoc());
				if (locais.get(i).getRate() > 0) {
					System.out.println("-> Classifica��o do " + locais.get(i).getTipo().toString().toLowerCase() 
							+ " - " + locais.get(i).getRate());
				}
			}
		}
	}
	
	public void editLocal() {
		if (locais.size() > 0) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("-> Escolha para ver informa��o mais detalhada");
			for (int i = 0; i < (locais.size()); i++) {
				System.out.println("[" + (i + 1) + "] " + locais.get(i).getNome());
			}
			System.out.println("[0] para sair");
			int escolha = scanner.nextInt();
			int menu;
			do { //TODO validar numeros igual la em cima
				int i = escolha - 1;
				Local local = locais.get(i);
				System.out.println("Nome -> " + local.getNome()
						+ "\nSobre -> " + local.getInfo() 
						+ "\nLocaliza��o -> " + local.getLoc());
				System.out.println("[0] para sair\n[1] editar nome\n[2] editar informa��o\n[3] editar localiza��o");
				menu = scanner.nextInt();
				if (menu != 0) {
					Scanner scan = new Scanner(System.in);
					if (menu == 1) {
						System.out.println("-> Nome novo?");
						String novoNome = scan.nextLine();
						if (novoNome.equals(local.getLoc())) {
							System.out.println("Conv�m mudares o nome");
						}
						else {
							locais.get(i).setNome(novoNome);
							System.out.println("-> Nome alterado com sucesso");
						}
					}
					if (menu == 2) {
						System.out.println("-> Informacao nova?");
						String novaInfo = scan.nextLine();
						if (novaInfo.equals(local.getLoc())) {
							System.out.println("Convem mudares a info");
						}
						else {
							locais.get(i).setInfo(novaInfo);
							System.out.println("-> Informacao alterada com sucesso");
						}
					}
					if (menu == 3) {
						System.out.println("-> Localizacao nova?");
						String novaLoc = scan.nextLine();
						if (novaLoc.equals(local.getLoc())) {
							System.out.println("Convem mudares a localiza��o");
						}
						else {
							locais.get(i).setLoc(novaLoc);
							System.out.println("-> Localizacao alterada com sucesso");
						}
					}
				}
			} while (menu != 0);
		} else {
			System.out.println("-> Nenhum local criado");
		}
	}

	
	private void replaceLocal(Local local) {
		for (int i = 0; i < locais.size(); i++) {
			if (locais.get(i).equals(local)) {
				locais.set(i, local);
			}
		}
	}
	
	ArrayList<Local> filterByType(LocalTipo type) {
		ArrayList<Local> locaisFiltrados = new ArrayList<>();
		for(Local local: locais) {
			if (local.getTipo() == type)
				locaisFiltrados.add(local);
		}
		return locaisFiltrados;
	}
}
