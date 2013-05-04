/**
 * 
 */
package tests;

import static org.junit.Assert.assertTrue;

import lib.interfaces.IAccount;
import lib.utilities.Account;

import org.junit.Test;

/**
 * @author Wamiq Bashir
 * 
 */
public class AccountTest {

	public void testResetAccountBalance() {
		IAccount account = new Account();
		account.resetAccountBalance();
		double existingBalance = account.getBalance();

		assertTrue(0 == existingBalance);
	}

	public void testCreditAccount() {

		IAccount account = new Account();
		double existingBalance = account.getBalance();

		account.credit(100);

		double newBalance = account.getBalance();

		assertTrue(newBalance == existingBalance + 100);

	}

	public void testDebitAccount() {
		IAccount account = new Account();
		double existingBalance = account.getBalance();

		account.debit(100);
		double newBalance = account.getBalance();

		assertTrue(newBalance == existingBalance - 100);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeArgumentsToCredit() {

		IAccount account = new Account();
		account.credit(-1);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testZeroAsAnArgumentToCredit() {

		IAccount account = new Account();
		account.credit(0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeArgumentsToDebit() {

		IAccount account = new Account();
		account.debit(-1);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testZeroAsAnArgumentToDebit() {

		IAccount account = new Account();
		account.debit(0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testLockedAccountCredit() {

		IAccount account = new Account();
		account.lock();
		account.credit(100);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testLockedAccountDebit() {

		IAccount account = new Account();
		account.lock();
		account.debit(100);

	}


	@Test
	public void testUnlockAccount() {
		IAccount account = new Account();
		account.lock();
		account.unlock();
		assertTrue(account.getLockStatus() == false);

	}

 	@Test(expected = IllegalStateException.class)
	public void testUnlockOperationOnAnUnLockedAccount() {
		IAccount account = new Account();
		account.unlock();
		
	}

 	@Test
	public void testLockAccount() {
		IAccount account = new Account();
		account.lock();
		assertTrue(account.getLockStatus() == true);

	}

 	@Test(expected = IllegalStateException.class)
	public void testlockOperationOnALockedAccount() {
		IAccount account = new Account();
		account.lock();
		account.lock();
		
	}

}
