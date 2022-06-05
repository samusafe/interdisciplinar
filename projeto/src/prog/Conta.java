package prog;

public class Conta {
	
	public enum ContaType {
		ADMIN,
		TURISTA
	}
	// variáveis de instância 
	private String nome;
	private String password;
	private ContaType tipo;
	/**
     * COnstrutor para objetos da classe Atividade
     * @param nome     nome de utilizador
     * @param password palavra-chave da conta
     * @param tipo     tipo de utilizador ( turista ou admin )
     */
	public Conta(String nome, String password, ContaType tipo) {
		this.nome = nome;
		this.password = password;
		this.tipo = tipo;
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
	public String getPassword() {
		return password;
	}
	// método modificador
	public void setPassword(String password) {
		this.password = password;
	}
	// metodos interrogadores
	public ContaType getTipo() {
		return tipo;
	}
	// método modificador
	public void setTipo(ContaType tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof Conta)) {
            return false;
        }
         
        Conta c = (Conta) o;
      
        return c.getNome().equals(getNome())
        		&& c.getPassword().equals(getPassword())
        		&& c.getTipo() == getTipo();
	}
	
	public String toString() {
		return nome;
	}
}
