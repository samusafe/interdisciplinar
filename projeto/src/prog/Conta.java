package prog;

public class Conta {
	
	public enum ContaType {
		ADMIN,
		TURISTA
	}
	
	private String nome;
	private String password;
	private ContaType tipo;

	public Conta(String nome, String password, ContaType tipo) {
		this.nome = nome;
		this.password = password;
		this.tipo = tipo;
	}

	/**
	 * get nome da conta
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * set nome da conta
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * get password da conta
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * set password da conta
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get tipo da conta
	 * @return tipo
	 */
	public ContaType getTipo() {
		return tipo;
	}

	/**
	 * set tipo da conta
	 * @param tipo
	 */
	public void setTipo(ContaType tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * faz a comparaçao de contas para que nao existam repetidas
	 */
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
