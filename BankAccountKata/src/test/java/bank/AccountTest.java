package bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import Utils.PrintMessageUtilities;

public class AccountTest {

	private LocalDateTime date;
	private Account account;
	private double delta;

	@Before
	public void setUp() {
		delta = 0.0;
		account = new Account();
		date = LocalDateTime.now();
	}

	/**
	 * US1 In order to save money As a bank client I want to make a deposit in
	 * my account
	 */
	@Test
	public void depositAccount() {
		// Given
		final double aDeposit = 10;
		// When
		final Account expectedAccount = account.deposit(aDeposit, date);
		// Then
		assertNotNull(expectedAccount);
		assertNotNull(expectedAccount.getStatement());
		assertEquals(aDeposit, expectedAccount.getStatement().getBalance(), delta);
	}

	/**
	 * US2 In order to retrieve some or all of my savings ,As a bank client i
	 * want to make a withdrawal from my account
	 */
	@Test
	public void withdrawAccount() {
		// Given
		final double aWithdraw = -100;
		// When
		final Account expectedAccount = account.deposit(aWithdraw, date);
		// Then
		assertNotNull(expectedAccount);
		assertNotNull(expectedAccount.getStatement());
		assertEquals(aWithdraw, expectedAccount.getStatement().getBalance(), delta);
	}

	/**
	 * US1 and US2
	 */
	@Test
	public void depositAndWithdraw() {
		// Given
		final double aWithdraw = 50;
		final double aDeposit = 100;
		// When
		final Statement statement = account.deposit(aDeposit, date).withdraw(aWithdraw, date).getStatement();
		// Then
		assertNotNull(statement);
		assertNotNull(statement.getstatementLines());
		assertEquals(statement.getstatementLines().size(), 2);
		assertEquals(statement.getBalance(), 50, delta);
	}

	/**
	 * US3 In order to check my operations As a bank client I want to see the
	 * history (operation, date, amount, balance) of my operations
	 */
	@Test
	public void seeHistory() {
		// Given
		final double aWithdraw = -100;
		// When
		final Account expectedAccount = account.deposit(aWithdraw, date);
		// Then
		assertNotNull(expectedAccount);
		assertNotNull(expectedAccount.getStatement());
		assertEquals(expectedAccount.getStatement().getstatementLines().size(), 1);
		assertEquals(expectedAccount.getStatement().printOperations(),
				PrintMessageUtilities.HEADER + PrintMessageUtilities.lineSeparator() + date.toString()
						+ " || WITHDRAWAL || -100.0 || -100.0" + PrintMessageUtilities.lineSeparator());
	}

}
