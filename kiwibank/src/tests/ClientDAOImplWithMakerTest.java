package tests;

import java.time.LocalDate;
import java.util.List;
import de.kiwi.backend.Client;
import de.kiwi.backend.ClientDAOImplWithMaker;

/** Testing how functions the ClientDAOImplWithMaker-Class
 *  Control the  data of sample DataBank-Objects */

public class ClientDAOImplWithMakerTest {

	public static void main(String[] args) {
		
		ClientDAOImplWithMaker generator = new ClientDAOImplWithMaker(5);
		List<Client> bankClients = generator.getAllClients();
		System.out.println("********************** FIRST LIST CREATED ********************");
		bankClients.forEach(Client -> System.out.println(Client));
		
		
		generator.addClient(new Client("Zamba Zulu", 
									   LocalDate.of(1950,5,5), 
									   345678901, 
									   1500.0, 
									   9999));
		System.out.println("********************** AFTER ADDING ************************");
		bankClients.forEach(Client -> System.out.println(Client));
		


		
		System.out.println("************************ DELETING **************************");
		
		for(int i = 0; i<bankClients.size(); i++) {
		
			if(bankClients.get(i).getName().equals("Burny Burn")) {
				System.out.println("Burny DELETED");
				bankClients.remove(i);
			}
		}
//		for(int i = 0; i<bankClients.size(); i++) {
//			if(bankClients.get(i).getName().equals("Burny Burn")) {
//				generator.deleteClient(new Client(bankClients.get(i).getName(), 
//												  bankClients.get(i).getBirthdate(), 
//												  bankClients.get(i).getAccountNumber(), 
//												  bankClients.get(i).getMoneySum(),
//												  bankClients.get(i).getPassword()));
//				
//			}	
//		}
		
		System.out.println("********************** AFTER DELETING ***********************");
		bankClients.forEach(Client -> System.out.println(Client));
	}
}
