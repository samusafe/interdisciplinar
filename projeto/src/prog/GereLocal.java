package prog;

import prog.Local.LocalTipo;

import java.util.ArrayList;

public class GereLocal {
	private ArrayList<Local> locais = new ArrayList<>();
	
	/**
	 * cria local caso o local nao exista ainda, retorna false caso exista
	 * @param nome do local
	 * @param info do local
	 * @param localizaçao do local
	 * @param tipo do local (museu ou monumento)
	 * @return true se o local foi criado, false caso contrario
	 */
	public boolean criarLocal(String nome, String info, String loc, LocalTipo tipo) {
		Local local = new Local(nome, info, loc, tipo);
		for (int i = 0; i < locais.size(); i++) {
			if (local.equals(locais.get(i))) {
				return false;
			}
		}
		return locais.add(local);
	}
	
	/**
	 * verifica se existem locais criadas
	 * @return que existem mais de 0
	 */
	public boolean hasLocais() {
		return locais.size() > 0;
	}
	
	/**
	 * fazer pesquisa de um local pelo nome
	 * @param nome do local
	 * @return do local se encontrar, null caso contrario
	 */
	public Local getLocalByName(String name) {
		for (int i = 0; i < locais.size(); i++) {
			if (name.equals(locais.get(i).getNome())) {
				return locais.get(i);
			}
		}
		return null;
	}
	
	/**
	 * cria uma avaliaçao para um determinado local 
	 * @param rate do local
	 * @param conta da pessoa
	 * @param objeto local
	 */
	public void addAvaliacao(int rate, Conta conta, Local local) {
		Avaliacao avaliacao = new Avaliacao(rate, conta);
		for (int i = 0; i < locais.size(); i++) {
			if (local.equals(locais.get(i))) {
				locais.get(i).addAvaliacao(avaliacao);
			}
		}
	}
	
	/**
	 * fazer a lista de atividade do programa
	 * @return de um array que contem: o nome da pessoa, o quanto avaliou o local e o nome do local avaliado
	 */
	public ArrayList<String> getActivity() {
		ArrayList<String> activityList = new ArrayList<>();
		
		for (int i = 0; i < locais.size(); i++) {
			for (int j = 0; j < locais.get(i).getAvaliacoes().size(); j++) {
				activityList.add(locais.get(i).getAvaliacoes().get(j).getUser().getNome() + " avaliou com um " 
			+ locais.get(i).getAvaliacoes().get(j).getRate() + " o " + locais.get(i).getNome());
			}
		}
		return activityList;
	}
	
	/**
	 * fazer um array de locais organizados por um determinado tipo
	 * @param tipo do local
	 * @return de um array que contem: os locais todos de um determinado tipo
	 */
	public ArrayList<Local> filterByType(LocalTipo type) {
		ArrayList<Local> locaisFiltrados = new ArrayList<>();
		for(Local local: locais) {
			if (local.getTipo() == type)
				locaisFiltrados.add(local);
		}
		return locaisFiltrados;
	}
}
