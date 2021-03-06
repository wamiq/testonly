/**
 * 
 */
package lib.interfaces;

/**
 * @author wamiq
 * 
 */
public interface IAccount {

	void resetAccountBalance();

	double getBalance();

	void credit(double amount) throws IllegalArgumentException;

	void debit(double amount) throws IllegalArgumentException;

	void lock() throws IllegalArgumentException;

	void unlock() throws IllegalStateException;

	boolean getLockStatus();

	
	
}
