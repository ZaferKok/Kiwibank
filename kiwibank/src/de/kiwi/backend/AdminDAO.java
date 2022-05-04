package de.kiwi.backend;

import java.util.List;

/** DAO: Data Access Object 
 * 	Generalizes access to any type of data storage
 *  Methods: match database access */
public interface AdminDAO {
	
	/** Here takes place the data production 
	 *  in the implementation
	 *  @return List of all admins*/
	List<Admin> getAllAdmins();

	/** An object is saved in the data list */
	void addAdmin(Admin admin);

	/** Das Object in der Datenhaltung wird akuallisiert */
	void updateAdmin(Admin admin);

	/** Object is being deleted */
	void deleteAdmin(Admin admin);
}
