package tests;

import java.util.List;

import de.kiwi.backend.Client;
import de.kiwi.backend.ClientMaker;

/** Testing how functions the ClientMaker-Class 
 * 	Control the status after money transfer */

public class ClientMakerTest {

	public static void main(String[] args) {

		ClientMaker generator = new ClientMaker(5);
		List<Client> allClients = generator.getAllClients();
		allClients.forEach(client -> System.out.println(client)); // CLIENT LIST

		for (int i = 0; i<allClients.size(); i++) {
			if(allClients.get(i).getMoneySum()<2500) {
				allClients.get(i).setMoneySum(allClients.get(i).getMoneySum() + 499.0);
			}
		}
		
		System.out.println("-------------------------------After money transfer----------------------------");
		allClients.forEach(client -> System.out.println(client));
	
	}
}
