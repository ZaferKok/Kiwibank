package de.kiwi.backend;

/**
 * Compiles the data of a Admin, which is the manager of the bank-app.
 * But Admin get required primitives and methods from his parent class-user
 */

public class Admin extends User{

	public Admin(String name, int adminNumber, int password) {
		super(name, adminNumber, password);

	}

	@Override
	public String toString() {
		return "Admin [name=" + getName() + ", accountNumber=" + getAccountNumber() + ", password="
				+ getPassword() + "]";
	}
}
