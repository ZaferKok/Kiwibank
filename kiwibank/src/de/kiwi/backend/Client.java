package de.kiwi.backend;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Compiles the data of a Client, which is in the Table of SQL-DataBank.
 */

public class Client {

	/** Assigned by the database: Auto-Increment*/
	private long primaryKey;
	/** Name of the Client, cannot be changed.*/
	private final String name;
	/** Birthdate of the Client, cannot be changed.*/
	private final LocalDate birthdate;
	/** Account Number of the Client, cannot be changed.*/
	private final int accountNumber;
	/** Total amount of Money of the Client, can change.*/
	private Double moneySum;
	/** Password of the Client, can change.*/
	private int password;
	
	/** Default Client Information */
	public Client() {
		name = "Client Client";
		birthdate = LocalDate.of(2000, 1, 1);
		accountNumber = 112233445;
		moneySum = 0.0;
		password = 1000;
	}
	/**
	 * @param name
	 * @param birthdate
	 * @param accountNumber
	 * @param moneySum
	 * @param password
	 */
	public Client(String name, LocalDate birthdate, int accountNumber, double moneySum, int password) {
		this.name = name;
		this.birthdate = birthdate;
		this.accountNumber = accountNumber;
		this.moneySum = moneySum;
		this.password = password;
	}
	
	/** @return the primaryKey */
	public long getPrimaryKey() {
		return primaryKey;
	}
	/** @param primaryKey the primaryKey to set */
	public void setPrimaryKey(long primaryKey) {
		this.primaryKey = primaryKey;
	}
	/** @return the moneySum */ 
	public double getMoneySum() {
		return moneySum;
	}
	/**  @param moneySum the moneySum to set */
	public void setMoneySum(double moneySum) {
		this.moneySum = moneySum;
	}
	/** @return the name */ 
	public String getName() {
		return name;
	}
	/** @return the birthdate */ 
	public LocalDate getBirthdate() {
		return birthdate;
	}
	/** @return the accountNumber */ 
	public int getAccountNumber() {
		return accountNumber;
	}
	/** @return the password */ 
	public int getPassword() {
		return password;
	}
	/**  @param password the password to set */
	public void setPassword(int password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Client [primaryKey=" + primaryKey + ", name=" + name + ", birthdate=" + birthdate
				+ ", accountNumber=" + accountNumber + ", moneySum=" + moneySum + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, birthdate, name, password, primaryKey);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return accountNumber == other.accountNumber && Objects.equals(birthdate, other.birthdate)
				&& Objects.equals(name, other.name) && password == other.password && primaryKey == other.primaryKey;
	}
}
