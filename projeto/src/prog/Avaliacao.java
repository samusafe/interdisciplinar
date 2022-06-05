package prog;

public class Avaliacao {

	private int rate;
	private Conta user;
	
	public Avaliacao(int rate, Conta user) {
		this.rate = rate;
		this.user = user;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Conta getUser() {
		return user;
	}

	public void setUser(Conta user) {
		this.user = user;
	}
	

}
