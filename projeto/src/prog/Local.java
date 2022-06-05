package prog;

import java.util.ArrayList;

public class Local {
	
	public enum LocalTipo {
		MUSEU,
		MONUMENTO
	}
	// variáveis de instância
	private String nome;
	private String info;
	private String loc;
	private LocalTipo tipo;
	
	private ArrayList<Avaliacao> avaliacoes;
	/**
     * COnstrutor para objetos da classe Atividade
     * @param nome     nome do monumento
     * @param info     informação do local
     * @param loc      localização do espaço
     * @param rate     avaliaçao do monumento
     */
	public Local(String nome, String info, String loc, LocalTipo tipo) {
		this.nome = nome;
		this.info = info;
		this.loc = loc;
		this.tipo = tipo;
		avaliacoes = new ArrayList<>();
	}
	
	// métodos de acesso - metodos interrogadores e modificadores
	// metodos interrogadores
	public String getNome() {
		return nome;
	}
	
	// método modificador
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// metodos interrogadores
	public String getInfo() {
		return info;
	}
	
	// método modificador
	public void setInfo(String info) {
		this.info = info;
	}
	
	// metodos interrogadores
	public String getLoc() {
		return loc;
	}
	
	// método modificador
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	public LocalTipo getTipo() {
		return tipo;
	}
	
	public void setTipo(LocalTipo tipo) {
		this.tipo = tipo;
	}
	
	public ArrayList<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	
	
	public void addAvaliacao(Avaliacao avaliacao) {
		for (int i = 0; i < avaliacoes.size(); i++) {
			if (avaliacoes.get(i).getUser() == avaliacao.getUser()) {
				avaliacoes.set(i, avaliacao);
				return;
			}
		}
		avaliacoes.add(avaliacao);
	}
	
	public boolean hasAvaliacoes() {
		return avaliacoes.size() > 0;
	}
	
	public int getRate() {
		int media = 0;
		for (int i = 0; i < avaliacoes.size(); i++) {
			media += avaliacoes.get(i).getRate();
		}
		media /= avaliacoes.size();
		return media;
	}
	
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
