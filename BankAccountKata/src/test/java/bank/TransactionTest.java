package bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class TransactionTest {

	private LocalDateTime date;
	private double delta;

	@Before
	public void setUp() {
		delta = 0.0;
		date = LocalDateTime.now();
	}

	@Test
	public void depositTransactionByDateAndAmount() {
		// Given
		final double amount = 100.0;
		// When
		final Transaction transaction = new Transaction(amount, date);
		// then
		assertNotNull(transaction);
		assertEquals(amount, transaction.getAmount(), delta);
		assertEquals(date, transaction.getDate());
		assertEquals(TransactionType.DEPOSIT, transaction.getOperation());
		assertNotSame(TransactionType.WITHDRAWAL, transaction.getOperation());
	}

	@Test
	public void depositTransactionByDateAndAmountZERO() {
		// Given
		final double amount = 0.0;
		// When
		final Transaction transaction = new Transaction(amount, date);
		// Then
		assertNotNull(transaction);
		assertEquals(amount, transaction.getAmount(), delta);
		assertEquals(date, transaction.getDate());
		assertEquals(TransactionType.DEPOSIT, transaction.getOperation());
		assertNotSame(TransactionType.WITHDRAWAL, transaction.getOperation());
	}

	@Test
	public void withdrawTransactionByDateAndAmount() {
		// Given
		final double amount = -120.0;
		// When
		final Transaction transaction = new Transaction(amount, date);
		// Then
		assertNotNull(transaction);
		assertEquals(amount, transaction.getAmount(), delta);
		assertEquals(date, transaction.getDate());
		assertEquals(TransactionType.WITHDRAWAL, transaction.getOperation());
		assertNotSame(TransactionType.DEPOSIT, transaction.getOperation());
	}
}
