/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import lib.interfaces.*;
import lib.utilities.*;

/**
 * @author Wamiq Bashir
 * 
 */
public class AccountTest {

	@Test
	public void testSetBalance() {
		IAccount account = new Account();
		double amount = 0;
		account.setBalance(amount);
		double balance = account.getBalance();

		assertTrue(amount == balance);
	}

	@Test
	public void testCredit() {

		IAccount account = new Account();
		double amount = 100;
		double existingbalance = account.getBalance();

		account.credit(amount);

		double newbalance = account.getBalance();

		assertTrue(newbalance == existingbalance + amount);

	}
}
