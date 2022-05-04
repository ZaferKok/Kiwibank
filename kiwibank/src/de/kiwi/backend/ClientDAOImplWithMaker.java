package de.kiwi.backend;

import java.util.List;

/** ClientDAOImplWithMaker must apply the methods of Interface-ClientDAO 
 *  In this way the List of Clients can be obtained 
 *  and can be new Client into the List added 
 *  or old Client can be deleted*/
public class ClientDAOImplWithMaker implements ClientDAO {

	/** "Placeholder for database" */
	private ClientMaker dataOfClients;
	private List<Client> allClients;

	/** Produce Clients according to the selected number */
	public ClientDAOImplWithMaker(int numberOfClients) {
		dataOfClients = new ClientMaker(numberOfClients);
	}

	@Override /* Transfer the client objects to the List */
	public List<Client> getAllClients() {

		try {
			allClients = dataOfClients.getAllClients();
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("Client DataBase is EMPTY");
		}

		return allClients;
	}

	@Override /* This method Add client object to the List */
	public void addClient(Client client) {
		allClients.add(client);
	}

	@Override /* This method represent uptade client object, but no need here */
	public void updateClient(Client client) {
		// You can do it by Setter!
	}

	@Override /* This method delete client object from the list */
	public void deleteClient(Client client) {
		allClients.remove(client);
	}
}
