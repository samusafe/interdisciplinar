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

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public ContaType getTipo() {
		return tipo;
	}

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
