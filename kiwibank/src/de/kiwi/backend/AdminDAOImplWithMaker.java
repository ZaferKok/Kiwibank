package de.kiwi.backend;

import java.util.List;

/** AdminDAOImplWithMaker must apply the methods of Interface-AdminDAO 
 *  In this way the List of Admins can be obtained 
 *  and can be new Admin into the List added 
 *  or old Admin can be deleted*/

public class AdminDAOImplWithMaker implements AdminDAO {

	/** "Placeholder for database" */
	private AdminMaker dataOfAdmins;
	private List<Admin> allAdmins;

	/** Produce Admins according to the selected number */
	public AdminDAOImplWithMaker(int numberOfClients) {
		dataOfAdmins = new AdminMaker(numberOfClients);
	}

	@Override /* Transfer the admin objects to the List */
	public List<Admin> getAllAdmins() {

		try {
			allAdmins = dataOfAdmins.getAllAdmins();
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("Admin DataBase is EMPTY");
		}

		return allAdmins;
	}

	@Override /* This method add admin object to the List */
	public void addAdmin(Admin admin) {
		allAdmins.add(admin);
	}

	@Override /* This method represent uptade admin object, but no need here */
	public void updateAdmin(Admin admin) {
		// You can do it by Setter!
	}

	@Override /* This method delete client object from the list */
	public void deleteAdmin(Admin admin) {
		allAdmins.remove(admin);
	}
}
