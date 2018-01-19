package bank;

import java.time.LocalDateTime;

public class Transaction {

	private final double amount;
	private final LocalDateTime date;
	private final TransactionType operation;

	/**
	 * check the type of operation and the date and the amount
	 * 
	 * @param amount
	 * @param date
	 */
	public Transaction(double amount, LocalDateTime date) {
		this.amount = amount;
		this.date = date;
		if (amount >= 0)
			this.operation = TransactionType.DEPOSIT;
		else
			this.operation = TransactionType.WITHDRAWAL;
	}

	/**
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @return
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @return
	 */
	public TransactionType getOperation() {
		return operation;
	}

}
