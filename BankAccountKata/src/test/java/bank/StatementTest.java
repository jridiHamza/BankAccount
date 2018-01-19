package bank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;

import Utils.PrintMessageUtilities;

public class StatementTest {

	@Test
	public void addTrnsactionWithDateAndAmount() {
		// Given
		final Statement statement = new Statement();
		// When
		statement.addTransaction(new Transaction(100, LocalDateTime.parse("2018-01-03T00:00:00.000")));
		statement.addTransaction(new Transaction(-30, LocalDateTime.parse("2018-01-04T00:00:00.000")));
		// Then
		assertThat(2, is(statement.getstatementLines().size()));
		assertEquals(70, statement.getBalance(), 0.0);
	}

	@Test
	public void printOperations() {
		// Given
		final Statement statement = new Statement();
		// When
		statement.addTransaction(new Transaction(100, LocalDateTime.parse("2018-01-03T00:00:00.000")));
		statement.addTransaction(new Transaction(-30, LocalDateTime.parse("2018-01-04T00:00:00.000")));
		// Then
		assertThat(2, is(statement.getstatementLines().size()));
		assertEquals(70, statement.getBalance(), 0.0);
		assertEquals(statement.printOperations(),
				PrintMessageUtilities.HEADER + PrintMessageUtilities.lineSeparator()
						+ "2018-01-03T00:00 || DEPOSIT || 100.0 || 100.0" + PrintMessageUtilities.lineSeparator()
						+ "2018-01-04T00:00 || WITHDRAWAL || -30.0 || 70.0" + PrintMessageUtilities.lineSeparator());
	}

}
