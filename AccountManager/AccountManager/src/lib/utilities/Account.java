/**
 * 
 */
package lib.utilities;

import lib.interfaces.IAccount;

/**
 * @author Wamiq Bashir
 * 
 */
public class Account implements IAccount {

	private static double balance = 0;
	private static boolean isAccountLocked;

	public Account() {
		isAccountLocked = false;
	}

	@Override
	public double getBalance() {

		// return the balance of the account
		return balance;

	}

	@Override
	public void credit(double amount) throws IllegalArgumentException {

		if (amount == 0 || amount < 0 || isAccountLocked) {
			throw new IllegalArgumentException(Double.toString(amount));
		}

		balance += amount;

	}

	@Override
	public void debit(double amount) throws IllegalArgumentException {

		if (amount == 0 || amount < 0 || isAccountLocked) {
			throw new IllegalArgumentException(Double.toString(amount));
		}

		balance -= amount;
	}

	@Override
	public void resetAccountBalance() {
		balance = 0;

	}

	@Override
	public void lock() throws IllegalStateException {
		if (isAccountLocked == true)
			throw new IllegalStateException("Account is not locked");

		isAccountLocked = true;

	}

	@Override
	public void unlock() throws IllegalStateException {
		if (isAccountLocked == false)
			throw new IllegalStateException("Account is not locked");

		isAccountLocked = false;

	}

	@Override
	public boolean getLockStatus() {
		return (isAccountLocked);
	}
}
