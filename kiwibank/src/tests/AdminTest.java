package tests;

import de.kiwi.backend.Admin;

/** Checks the Client Object whether or not suitable. */

public class AdminTest {

	public static void main(String[] args) {

		Admin sampleAdmin = new Admin("Tom Cruise", 666666666, 6666);

		System.out.println(sampleAdmin);
	}
}