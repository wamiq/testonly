/**
 * 
 */
package tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import lib.interfaces.IAccount;
import lib.utilities.Account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Wamiq Bashir
 * 
 */
@RunWith(value = Parameterized.class)
public class AccountTest {

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection creditAmount() {
		return Arrays.asList(new Object[][] { { 2 }, { 6 }, { 19 }, { 22 },
				{ 23 } });
	}

	private double amount;

	public AccountTest(double amount) {
		this.amount = amount;
	}

	public void testResetAccountBalance() {
		IAccount account = new Account();
		account.resetAccountBalance();
		double existingBalance = account.getBalance();

		assertTrue(0 == existingBalance);
	}

	public void testCreditAccount() {

		IAccount account = new Account();
		double existingBalance = account.getBalance();

		account.credit(amount);

		double newBalance = account.getBalance();

		assertTrue(newBalance == existingBalance + amount);

	}

	public void testDebitAccount() {
		IAccount account = new Account();
		double existingBalance = account.getBalance();

		account.debit(amount);
		double newBalance = account.getBalance();

		assertTrue(newBalance == existingBalance - amount);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeArgumentsToCredit(){
		
		IAccount account = new Account();
		account.credit(-1);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testZeroAsAnArgumentToCredit(){
		
		IAccount account = new Account();
		account.credit(0);

	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeArgumentsToDebit(){
		
		IAccount account = new Account();
		account.debit(-1);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testZeroAsAnArgumentToDebit(){
		
		IAccount account = new Account();
		account.debit(0);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLockedAccountCredit(){
		
		IAccount account = new Account();
		account.Lock();
		account.credit(100);
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLockedAccountDebit(){
		
		IAccount account = new Account();
		account.Lock();
		account.debit(100);
		
		

	}

	@Test(expected = IllegalArgumentException.class)
	public void testLockedAccountDebit2(){
		
		IAccount account = new Account();
		account.Lock();
		account.debit(100);
		
		

	}


}
