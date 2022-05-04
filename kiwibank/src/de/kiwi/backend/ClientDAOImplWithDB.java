package de.kiwi.backend;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/** ClientDAOImplWithDB must apply the methods of Interface-ClientDAO 
 *  In this way the List of Clients can be obtained 
 *  and can be new Client into the SQL-Table added 
 *  or old Client can be out of the SQL-Table deleted*/
public class ClientDAOImplWithDB implements ClientDAO {

	//public static final String URL 			= "jdbc:mysql://localhost:3306/client";
	public static final String URL 			= "jdbc:mysql://127.0.0.1:3306/user_db?createDatabaseIfNotExist=true";
	public static final String USER 		= "root";
	public static final String PASSWORD 	= "";
	public static final String TABELLE 		= "client";

	@Override
	public List<Client> getAllClients() {
		
		List<Client> 		allClients 		= new ArrayList<Client>();
		String 		sqlReadAllClientsData 	= "SELECT * FROM " + TABELLE;
		
		try (Connection 	conn 			= DriverManager.getConnection(URL, USER, PASSWORD);
			 Statement  	forQuery 		= conn.createStatement();
			 ResultSet  	resultOfTheQuery= forQuery.executeQuery(sqlReadAllClientsData);) {
			
			while (resultOfTheQuery.next()) {
				
				Long		primaryKey		= resultOfTheQuery.getLong(1);
				String 		name 			= resultOfTheQuery.getString(2);
				LocalDate 	birthday 		= resultOfTheQuery.getDate(3).toLocalDate();
				int			accountNumber	= resultOfTheQuery.getInt(4);
				Double		moneySum		= resultOfTheQuery.getDouble(5);
				int			password		= resultOfTheQuery.getInt(6);
				
				Client gottenInfoOfClient 	= new Client(name, birthday, accountNumber, moneySum, password);
				gottenInfoOfClient.setPrimaryKey(primaryKey);
				allClients.add(gottenInfoOfClient);
				
			}
		}catch(SQLException databankProblem) {
			databankProblem.printStackTrace();
		}
		
		return allClients;
	}

	@Override
	public void addClient(Client client) {
		
		String sqlPrep = "INSERT INTO " + TABELLE + " VALUES(NULL,?,?,?,?,?)"; // Placeholder
		
		try(Connection 			conn 		= DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement 	adding 		= conn.prepareStatement(sqlPrep);){
			
			adding.setString(1, client.getName());
			adding.setDate  (2, Date.valueOf(client.getBirthdate()));
			adding.setInt   (3, client.getAccountNumber());
			adding.setDouble(4, client.getMoneySum());
			adding.setInt   (5, client.getPassword());
			adding.execute();
			
			String 				sqlForKey  	= "SELECT primaryKey FROM " + TABELLE + " ORDER BY primaryKey DESC";
			ResultSet 			answer  	= conn.createStatement().executeQuery(sqlForKey);
			answer.next();
			client.setPrimaryKey(answer.getLong(1));
			
			
		}catch(SQLException addingProblem) {
			addingProblem.printStackTrace();
		}
		
	}

	@Override
	public void updateClient(Client client) { 

		System.out.println("Das client data is updated with account_number of Client " + client.getAccountNumber());
		
//		String updating = "UPDATE client SET name='Tomy Tom' WHERE account_number=222222222";
		
		String updating = "UPDATE " 					+ TABELLE 								+ 
						  " SET " + "name='" 			+ client.getName() 						+"'" + 
						  ", date='" 					+ Date.valueOf(client.getBirthdate()) 	+"'" +
						  ", account_number=" 			+ client.getAccountNumber() 			+
						  ", money=" 					+ client.getMoneySum() 					+ 
						  ", password=" 				+ client.getPassword() 					+				
						  " WHERE account_number=" 		+ client.getAccountNumber();
		
		try (Connection 		conn 		= DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement 	updater 	= conn.prepareStatement(updating);) {

			updater.execute();
			
			
		} catch (SQLException datenbankProbleme) {
			datenbankProbleme.printStackTrace();
		}

		
	}

	@Override
	public void deleteClient(Client client) {
		// You must first Client's primaryKey set. Otherweise this Query don't find the Client. 
		System.out.println("Das client data is deleted with Account_Number of Client " + client.getAccountNumber());
		String deleting = "DELETE FROM " + TABELLE + " WHERE account_number=" + client.getAccountNumber();
		
		try (Connection 		conn 		= DriverManager.getConnection(URL, USER, PASSWORD);
			 Statement 			eraser 		= conn.createStatement();) {
			 
			eraser.execute(deleting);
			
		} catch (SQLException datenbankProbleme) {
			datenbankProbleme.printStackTrace();
		}
		
	}
	
}
