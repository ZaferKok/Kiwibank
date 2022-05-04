package de.kiwi.backend;

import java.util.List;

/** DAO: Data Access Object 
 * 	Generalizes access to any type of data storage
 *  Methods: match database access */
public interface ClientDAO {
	
	/** Here takes place the data production 
	 *  in the implementation
	 *  @return List of all clients */
	List<Client> getAllClients();
	
	/** An object is saved in the data list */
	void addClient(Client client);
	
	/** Das Object in der Datenhaltung wird akuallisiert */
	void updateClient(Client client);
	
	/** Object is being deleted */
	void deleteClient(Client client);
	
}
