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
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getLoc() {
		return loc;
	}
	
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
	
	public String toString() {
		return nome;
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
