package tests;

import java.time.LocalDate;

import de.kiwi.backend.Client;

/** Checks the Client Object whether or not suitable. */

public class ClientTest {

	public static void main(String[] args) {

		Client newClientDefault = new Client();
		System.out.println(newClientDefault);  // OHNE PARAMETER CLIENT
		
		Client newClientWithParameter = new Client("Tom Cruise", 
												   LocalDate.of(1965, 05, 15),
												   678901234, 
												   6000.0, 
												   8888);
		System.out.println(newClientWithParameter); // MIT PARAMETER CLIENT
	}
}
