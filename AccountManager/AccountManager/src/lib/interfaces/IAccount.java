/**
 * 
 */
package lib.interfaces;

/**
 * @author wamiq
 * 
 */
public interface IAccount {

	double getBalance();

	void setBalance(double dAmount);

	void credit(double amount) throws IllegalArgumentException;

}
