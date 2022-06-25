package prog;

public class Avaliacao {

	private int rate;
	private Conta user;
	
	public Avaliacao(int rate, Conta user) {
		this.rate = rate;
		this.user = user;
	}

	/**
	 * get rate
	 * @return rate
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * set rate
	 * @param rate
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * get user
	 * @return user
	 */
	public Conta getUser() {
		return user;
	}

	/**
	 * set user
	 * @param user
	 */
	public void setUser(Conta user) {
		this.user = user;
	}
}
