package de.kiwi.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Compiles the data of a Client to make sample Client-Object.
 * Placeholder-List function like a DataBank of Clients.
 */

public class ClientMaker {

	/** Filled in the constructors 
	 *  of Client*/
	private List	<Client> allClients 	= new ArrayList<Client>();
	
	/** Here are sample names to 
	 *  create Client for DataBank */
	private String		[] 	 names 			= {"Adami Axen","Burny Burn","David Dune","Emily Ente","Ricar Rich"};
	
	/** Here are sample birthdates 
	 *  to create Client for DataBank */
	private LocalDate 	[] 	 birthdates 	= {LocalDate.of(1960, 6, 6),
									   		   LocalDate.of(1970, 7, 7),
									   		   LocalDate.of(1980, 8, 8),
									   		   LocalDate.of(1990, 9, 9),
									   		   LocalDate.of(2000, 10, 10)};
	
	/** Here are sample money to 
	 *  create Client for DataBank */
	private Double		[] 	 moneySums 		= {1000.0, 2000.0, 3000.0, 4000.0, 5000.0}; // Java make Autoboxing here.
	
	/* This method create specified number 
	 * of clients with rondom data, 
	 * which are located above */ 
	public ClientMaker(int numberOfClient) {
		Random dice = new Random();
		for(int i = 0; i<numberOfClient; i++ ) {
			
			String 		name 		= names			[dice.nextInt(names.length)]; 
			LocalDate 	birthdate 	= birthdates	[dice.nextInt(birthdates.length)];
			int			accountNum	= 				 dice.nextInt(999999998);
			Double		moneySum	= moneySums		[dice.nextInt(moneySums.length)];
			int		 	password 	= 				 dice.nextInt(9998);
			
			if(password<1000) {
				password = password + 1000;
			}
			
			if(accountNum<100000000) {
				accountNum = accountNum + 100000000;
			}
			
			Client newClient = new Client(name, birthdate, accountNum, moneySum, password);
			allClients.add(newClient);
		}
	}
	
	/** @return the allClients */
	public List<Client> getAllClients() {
		return allClients;
	}
}
