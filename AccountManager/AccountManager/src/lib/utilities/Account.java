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

	static double balance = 0;

	@Override
	public void resetAccountBalance() {

		balance = 0;

	}

	@Override
	public double getBalance() {

		return balance;
	}

	@Override
	public void credit(double amount) throws IllegalArgumentException {

		if (amount == 0 || amount < 0) {
			throw new IllegalArgumentException(Double.toString(amount));
		}

		balance += amount;

	}
	
	private void postToAudit(){
		
	}

	@Override
	public void debit(double amount) throws IllegalArgumentException {

		if (amount == 0 || amount < 0) {
			throw new IllegalArgumentException(Double.toString(amount));
		}

		balance -= amount;
	}

}
