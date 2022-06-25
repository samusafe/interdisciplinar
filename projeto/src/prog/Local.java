package prog;

import java.util.ArrayList;

public class Local {
	
	public enum LocalTipo {
		MUSEU,
		MONUMENTO
	}

	private String nome;
	private String info;
	private String loc;
	private LocalTipo tipo;
	
	private ArrayList<Avaliacao> avaliacoes;

	public Local(String nome, String info, String loc, LocalTipo tipo) {
		this.nome = nome;
		this.info = info;
		this.loc = loc;
		this.tipo = tipo;
		avaliacoes = new ArrayList<>();
	}
	
	/**
	 * get nome do local
	 * @return nome do local
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * set nome do local
	 * @param nome do local
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * get info do local
	 * @return info do local
	 */
	public String getInfo() {
		return info;
	}
	
	/**
	 * set info do local
	 * @param info do local
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	
	/**
	 * get localizaçao do local
	 * @return loc do local
	 */
	public String getLoc() {
		return loc;
	}
	
	/**
	 * set loc do local
	 * @param loc do local
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	/**
	 * get tipo do local
	 * @return tipo do local
	 */
	public LocalTipo getTipo() {
		return tipo;
	}
	
	/**
	 * set tipo do local
	 * @param tipo do local
	 */
	public void setTipo(LocalTipo tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * get das avaliaçoes dos locais
	 * @return um array de avaliaçoes
	 */
	public ArrayList<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	
	/**
	 * cria uma avaliaçao de um determinado local a partir da conta de uma pessoa
	 * @param avaliaçao
	 */
	public void addAvaliacao(Avaliacao avaliacao) {
		for (int i = 0; i < avaliacoes.size(); i++) {
			if (avaliacoes.get(i).getUser() == avaliacao.getUser()) {
				avaliacoes.set(i, avaliacao);
				return;
			}
		}
		avaliacoes.add(avaliacao);
	}
	
	/**
	 * verifica se existem avaliaçoes
	 * @return que existem mais de 0
	 */
	public boolean hasAvaliacoes() {
		return avaliacoes.size() > 0;
	}
	
	/**
	 * get da media de avaliaçoes de um local (soma as avaliaçoes de cada pessoa e divide pelo total de avaliaçoes)
	 * @return da media de avaliaçoes do local
	 */
	public int getRate() {
		int media = 0;
		for (int i = 0; i < avaliacoes.size(); i++) {
			media += avaliacoes.get(i).getRate();
		}
		media /= avaliacoes.size();
		return media;
	}
	
	public String toString() {
		return nome;
	}
	
	/**
	 * faz a comparaçao de contas para que nao existam repetidas
	 */
	@Override
	public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof Local)) {
            return false;
        }
         
        Local c = (Local) o;
      
        return c.getNome().equals(getNome())
        		&& c.getTipo() == getTipo();
	}
}
