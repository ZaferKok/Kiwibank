package de.kiwi.backend;

import java.util.Objects;

/**
 * Compiles the data of a User as a Parent, which can be admin or other person in bank-app.
 * User class supplies the required parameter and methods for child classes.
 */

public class User { // Parent class for every User
	
	/** Name of the User, cannot be changed.*/
	private final String name;
	/** Account Number of the User, cannot be changed.*/
	private final int accountNumber;
	/** Password of the User, can change.*/
	private int password;

	/** User Constructor with all parameters */
	public User(String name, int accountNumber, int password) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.password = password;
	}

	/** @return the name of User */ 
	public String getName() {
		return name;
	}

	/** @return the account number of User */ 
	public int getAccountNumber() {
		return accountNumber;
	}

	/** @return the password of User */ 
	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", accountNumber=" + accountNumber + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return accountNumber == other.accountNumber && Objects.equals(name, other.name) && password == other.password;
	}

}
