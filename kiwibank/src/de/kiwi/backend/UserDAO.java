package de.kiwi.backend;

import java.util.List;

public interface UserDAO {
	
	List<Client> getAllClients();
	
	void addClient(Client client);
	
	void updateClient(Client client);
	
	void deleteClient(Client client);
	
}
