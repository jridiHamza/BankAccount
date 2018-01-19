package bank;

public class StatementLine {

	private Transaction transaction;
	private double balance;

	/**
	 * @param transaction
	 * @param balance
	 */
	public StatementLine(Transaction transaction, double balance) {
		super();
		this.transaction = transaction;
		this.balance = balance;
	}

	/**
	 * @return transaction
	 */
	public Transaction getTransaction() {
		return transaction;
	}

	/**
	 * @param transaction
	 */
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	/**
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
