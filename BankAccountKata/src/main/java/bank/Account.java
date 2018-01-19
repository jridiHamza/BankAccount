package bank;

import java.time.LocalDateTime;

public class Account {

	private final Statement statement = new Statement();

	/**
	 * this method save the money in the account
	 * 
	 * @param amount
	 * @param date
	 * @return Account
	 */
	public Account deposit(double amount, LocalDateTime date) {
		this.statement.addTransaction(new Transaction(amount, date));
		return this;
	}

	/**
	 * this method retrieve the money from the account
	 * 
	 * @param amount
	 * @param date
	 * @return Account
	 */
	public Account withdraw(double amount, LocalDateTime date) {
		// I didn't check if the balance < 0
		this.statement.addTransaction(new Transaction(-amount, date));
		return this;
	}

	/**
	 * this method display operations history
	 * 
	 * @param amount
	 * @param date
	 * @return String operations
	 */
	public String checkMyOperations() {
		return this.statement.printOperations();
	}

	public Statement getStatement() {
		return this.statement;
	}

}
