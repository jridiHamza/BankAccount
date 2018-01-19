package bank;

import java.util.ArrayList;
import java.util.List;

import Utils.PrintMessageUtilities;

public class Statement {
	private final List<StatementLine> statementLines = new ArrayList<>();

	/**
	 * add a statement line in each transaction
	 * @param transaction
	 */
	public void addTransaction(Transaction transaction) {
		this.statementLines.add(new StatementLine(transaction, getBalance() + transaction.getAmount()));
	}

	/**
	 * get balance of the account
	 * @return
	 */
	public double getBalance() {
		if (this.statementLines.isEmpty()) {
			return 0;
		} else {
			return this.statementLines.get(this.statementLines.size() - 1).getBalance();
		}
	}


	/**
	 * get history operations of the client
	 * @return operationsHistory
	 */
	public String printOperations() {
		final StringBuilder operationsHistory = new StringBuilder();
		operationsHistory.append(PrintMessageUtilities.HEADER);
		operationsHistory.append(PrintMessageUtilities.lineSeparator());
		for (StatementLine statementLine : this.statementLines) {
			operationsHistory.append(statementLine.getTransaction().getDate()).append(PrintMessageUtilities.SEPARATOR);
			operationsHistory.append(statementLine.getTransaction().getOperation()).append(PrintMessageUtilities.SEPARATOR);
			operationsHistory.append(statementLine.getTransaction().getAmount()).append(PrintMessageUtilities.SEPARATOR);
			operationsHistory.append(statementLine.getBalance());
			operationsHistory.append(PrintMessageUtilities.lineSeparator());
		}
		return operationsHistory.toString();
	}

	public List<StatementLine> getstatementLines() {
		return statementLines;
	}

}
