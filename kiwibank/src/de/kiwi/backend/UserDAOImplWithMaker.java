package de.kiwi.backend;

import java.util.List;

public class UserDAOImplWithMaker implements UserDAO{

	private ClientMaker dataOfClients;
	private List<Client> allClients;
	
	public UserDAOImplWithMaker(int numberOfClients) {
		dataOfClients = new ClientMaker(numberOfClients);
	}
	
	@Override
	public List<Client> getAllClients() {
		allClients = dataOfClients.getAllClients();
		return allClients;
	}

	@Override
	public void addClient(Client client) {
		allClients.add(client);
	}

	@Override
	public void updateClient(Client client) {
		// You can do it by Setter!
		
	}

	@Override
	public void deleteClient(Client client) {
		allClients.remove(client);	
	}



}
