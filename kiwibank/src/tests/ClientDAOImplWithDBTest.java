package tests;

import java.time.LocalDate;

import de.kiwi.backend.Client;
import de.kiwi.backend.ClientDAOImplWithDB;

public class ClientDAOImplWithDBTest {

	public static void main(String[] args) {


		ClientDAOImplWithDB allClients = new ClientDAOImplWithDB();
		
//		Client kunden = new Client();
//		System.out.println(kunden);
//		
		Client kunden1 = new Client("Adami Axen", LocalDate.of(2001,01,01), 111111111, 1000, 1111);
		Client kunden2 = new Client("Cony Conit", LocalDate.of(2002,02,02), 222222222, 2000, 2222);
		Client kunden3 = new Client("Burny Burn", LocalDate.of(2003,03,03), 333333333, 3000, 3333);
		Client kunden4 = new Client("David Dune", LocalDate.of(2004,04,04), 444444444, 4000, 4444);
		Client kunden5 = new Client("Emily Ente", LocalDate.of(2005,05,05), 555555555, 5000, 5555);
		Client kunden6 = new Client("Ricar Rich", LocalDate.of(2006,06,06), 666666666, 6000, 6666);
		Client kunden7 = new Client("Bugs Bunny", LocalDate.of(2007,07,07), 777777777, 7000, 7777);
		
		allClients.addClient(kunden1);
		//allClients.addClient(kunden2);
		allClients.addClient(kunden3);
		allClients.addClient(kunden4);
		allClients.addClient(kunden5);
		allClients.addClient(kunden6);
		allClients.addClient(kunden7);
		
//		System.out.println(kunden2);
//		kunden2.setPrimaryKey(4322);
		//allClients.updateClient(kunden2);
		
//		allClients.addClient(kunden2);
//		System.out.println("----------geschrieben--------------");
//		System.out.println(allClients.getAllClients());
//		
//		System.out.println("***************************");
//		
//		allClients.getAllClients().forEach(eve->System.out.println(eve));
//		
//		//allClients.deleteClient(kunden2);
//		
//		System.out.println("***** Update ******");
//		
		allClients.updateClient(kunden2);
//		
//		allClients.getAllClients().forEach(eve->System.out.println(eve));
		
		
	}

}
