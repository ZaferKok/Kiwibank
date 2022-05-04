package de.kiwi.backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Compiles the data of a Admin to make sample Admin-Object.
 * Placeholder-List function like a DataBank of Admins.
 */

public class AdminMaker {

	private List	<Admin> allAdmins 	= new ArrayList<Admin>();
	
	/** Here are sample names to 
	 *  create admin for DataBank */
	private String	[] 	 names 			= {"Zafer Kok","Tarik Tar","Serena Sar"};
	
	/** Here are sample accountNumbers 
	 *  to create admin for DataBank */
	private int 	[] 	 accountNumbers	= {999999999,888888888,777777777};
	
	/** Here are sample passwords to 
	 *  create admin for DataBank */
	private int 	[] 	 passwords		= {9999,8888,7777};
	
	/* This method create specified number 
	 * of admins orderly, 
	 * which are located above */ 
	public AdminMaker(int numberOfClient) {
		
		for(int i = 0; i<numberOfClient; i++ ) {
			
			String 		name 		= names			[i]; 
			int			accountNum	= accountNumbers[i];
			int		 	password 	= passwords		[i];
			
			Admin admin = new Admin(name, accountNum, password);
			allAdmins.add(admin);
		}
	}
	
	/** @return the allAdmins */
	public List<Admin> getAllAdmins() {
		return allAdmins;
	}
	
}
