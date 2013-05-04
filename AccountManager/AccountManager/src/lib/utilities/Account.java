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
	private static boolean accountLocked;

	public Account() {
		accountLocked = false;
	}

	@Override
	public double getBalance() {

		// return the balance of the account
		return balance;

	}

	@Override
	public void credit(double amount) throws IllegalArgumentException {

		if (amount == 0 || amount < 0 || accountLocked) {
			throw new IllegalArgumentException(Double.toString(amount));
		}

		balance += amount;

	}

	@Override
	public void debit(double amount) throws IllegalArgumentException {

		if (amount == 0 || amount < 0 || accountLocked) {
			throw new IllegalArgumentException(Double.toString(amount));
		}

		balance -= amount;
	}

	@Override
	public void resetAccountBalance() {
		balance = 0;

	}

	@SuppressWarnings("unused")
	public boolean isAccountLocked() {
		return (true);

	}

	@Override
	public void Lock() {
		accountLocked = true;

	}

	@Override
	public void unlock() {
		accountLocked = false;

	}

	@Override
	public boolean getLockStatus() {
		return (accountLocked);
	}
}
