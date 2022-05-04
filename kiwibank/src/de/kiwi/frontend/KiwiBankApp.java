package de.kiwi.frontend;

import java.time.LocalDate;
import java.util.List;
import de.kiwi.backend.Admin;
import de.kiwi.backend.AdminDAOImplWithMaker;
import de.kiwi.backend.Client;
import de.kiwi.backend.ClientDAOImplWithDB;
import de.kiwi.middle.methods.LetterTypeInsteadOfNumberException;
import de.kiwi.middle.methods.Utulities;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * With this class-App Admin can manage Clients Account and the Clients can also
 * manage Money-Transactions in his/her Account
 */
public class KiwiBankApp extends Application {

	@Override /**
				 * JavaFX Stage class is the top level JavaFX container. The primary Stage is
				 * constructed by the platform.
				 */
	public void start(Stage primaryStage) throws InterruptedException, LetterTypeInsteadOfNumberException { // IF USER
																											// TYPES
																											// SOMETHING
																											// OUT OF
																											// NUMBERS,
																											// IT THROWS
																											// EXCEPTION

		String styleLux30 = "-fx-font-family: 'Luxurious Roman', cursive;" + "-fx-font-size: 30;"
				+ "-fx-text-fill: darkslategray;" + "-fx-text-fill: darkblue;";
		String styleLux20 = "-fx-font-family: 'Luxurious Roman', cursive;" + "-fx-font-size: 20;"
				+ "-fx-text-fill: darkslategray;" + "-fx-text-fill: darkblue;";
		String styleLux12 = "-fx-font-family: 'Luxurious Roman', cursive;" + "-fx-font-size: 12;"
				+ "-fx-background-color: transparent;";
		String styleAri10 = "-fx-font-family: 'Arial', cursive;" + "-fx-font-size: 10;"
				+ "-fx-background-color: transparent;" + "-fx-text-fill: red;";
		String styleAri30 = "-fx-font-family: 'Arial', cursive;" + "-fx-font-size: 30;" + "-fx-font-weight: bold;"
				+ "-fx-text-fill: #C71585;";
		String styleDon30 = "-fx-font-family: 'Dongle', sans-serif;\r\n" + "-fx-font-size: 30;"
				+ "-fx-font-weight: bold;" + "-fx-text-fill: #F0FFFF;";
		String styleAri15 = "-fx-font-family: 'Arial', cursive;" + "-fx-font-size: 15;"
				+ "-fx-background-color: transparent;" + "-fx-text-fill: #7FFF00;";
		String styleAri17 = "-fx-font-family: 'Arial', cursive;" + "-fx-font-size: 15;"
				+ "-fx-background-color: transparent;" + "-fx-text-fill: red;";

		//////////////////////////////////////////// CLIENT DATA CREATION
		//////////////////////////////////////////// ////////////////////////////////////////////////
//		ClientDAOImplWithMaker generatorClient = new ClientDAOImplWithMaker(10);
//		List<Client> bankClients = generatorClient.getAllClients();
//		bankClients.forEach(eachClient -> System.out.println(eachClient));

		ClientDAOImplWithDB generatorClient = new ClientDAOImplWithDB();
		List<Client> bankClients = generatorClient.getAllClients();
		bankClients.forEach(eachClient -> System.out.println(eachClient));

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////// ADMIN DATA CREATION
		//////////////////////////////////////////// ////////////////////////////////////////////////
		AdminDAOImplWithMaker generatorAdmin = new AdminDAOImplWithMaker(1);
		List<Admin> bankAdmins = generatorAdmin.getAllAdmins();
		bankAdmins.forEach(eachAdmin -> System.out.println(eachAdmin));

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		///////////////////////////////////////////// MAIN MENU CREATION
		///////////////////////////////////////////// /////////////////////////////////////////////////
		/* LOGIN PAGE */
		BorderPane loginPage = new BorderPane();

		/* LOGIN PAGE DATE MENU */
		GridPane dateMenu = new GridPane();
		dateMenu.setVgap(15);
		dateMenu.setHgap(15);
		dateMenu.setGridLinesVisible(false);
		dateMenu.setAlignment(Pos.TOP_RIGHT);
		dateMenu.setPadding(new Insets(25, 25, 25, 25));

		/* DATE SHOW WITH ENUMS */
		Label dateOfTheDay = new Label();
		dateOfTheDay.setStyle(styleLux20);
		dateMenu.add(dateOfTheDay, 0, 0);
		Utulities tools = new Utulities();
		dateOfTheDay.setText(tools.giveDateAndTheNameOfTheDay()); // Contains method, which made with ENUMS in
																	// Utilities.class()

		/* LOGIN PAGE LOGIN MENU */
		GridPane loginMenu = new GridPane();
		loginMenu.setVgap(15);
		loginMenu.setHgap(15);
		loginMenu.setGridLinesVisible(false);
		loginMenu.setAlignment(Pos.BOTTOM_RIGHT);
		loginMenu.setPadding(new Insets(25, 25, 25, 25));

		primaryStage.setTitle("Kiwi Bank");
		Image icon = new Image("file:images/icon.png");
		primaryStage.getIcons().add(icon);

		Label heading = new Label("Personal Banking Login:      ");
		heading.setStyle(styleLux30);
		loginMenu.add(heading, 0, 0, 4, 1);

		Label accountNumber = new Label("Account Num.:");
		TextField accountInput = new TextField();
		accountNumber.setStyle(styleLux20);
		loginMenu.add(accountNumber, 1, 1);
		loginMenu.add(accountInput, 2, 1);

		Label pass = new Label("Password :");
		PasswordField passwordInput = new PasswordField();
		pass.setStyle(styleLux20);
		loginMenu.add(pass, 1, 2);
		loginMenu.add(passwordInput, 2, 2);

		Button loginButton = new Button("Log in");
		Button turnOffButton = new Button("Close!");
		Button passwordForgotLink = new Button("       Forgot Password?   ");
		passwordForgotLink.setStyle(styleLux12);
		loginMenu.add(loginButton, 2, 3);
		loginMenu.add(turnOffButton, 3, 3);
		loginMenu.add(passwordForgotLink, 2, 4);

		Scene mainMenu = new Scene(loginPage, 900, 500);
		mainMenu.getStylesheets()
				.add("https://fonts.googleapis.com/css2?family=Luxurious+Roman&family=Twinkle+Star&display=swap");
		mainMenu.getStylesheets().add("file:images/styleMainMenu.css");

		loginPage.setCenter(loginMenu);
		loginPage.setTop(dateMenu);

		accountInput.setText("999999999"); // AUTOMATIC FILL ACCOUNT NUMBER WITH ADMIN DATA
		passwordInput.setText("9999"); // AUTOMATIC FILL PASSWORD WITH ADMIN DATA

//		accountInput.setText("" + bankClients.get(0).getAccountNumber());	// AUTOMATIC FILL ACCOUNT NUMBER WITH CLIENT DATA
//		passwordInput.setText("" + bankClients.get(0).getPassword());		// AUTOMATIC FILL PASSWORD WITH CLIENT DATA
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////// CLOSE MENU CREATION
		//////////////////////////////////////////// /////////////////////////////////////////////////
		/* CLOSE PAGE */
		Button closeButton = new Button();
		closeButton.setText("See you again!");

		StackPane root = new StackPane();
		root.getChildren().add(closeButton);

		Scene turnOffScene = new Scene(root, 300, 200);
		turnOffScene.getStylesheets().add("file:images/styleCloseMenu.css");

		turnOffButton.setOnAction(eve -> primaryStage.setScene(turnOffScene));
		closeButton.setOnAction(eve -> Platform.exit());
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		///////////////////////////////////// LOGIN MENU -> DATA INPUT REAKTIONS
		///////////////////////////////////// /////////////////////////////////////////
		Label warningMessage1 = new Label();
		warningMessage1.setStyle(styleAri10);

		Label warningMessage2 = new Label();
		warningMessage2.setStyle(styleAri10);

		loginMenu.add(warningMessage1, 3, 1);
		loginMenu.add(warningMessage2, 3, 2);

		/* CLICK LOGIN BUTTON TO TRY LOGIN */
		loginButton.setOnAction(e -> {

			String userAccountNumberTyped = accountInput.getText();
			String userPasswordTyped = passwordInput.getText();

			int userAccountNumberParsed;
			int userPasswordParsed;

			if (userAccountNumberTyped.isEmpty() && userPasswordTyped.isEmpty()) {
				warningMessage1.setText("Mandatory!");
				warningMessage2.setText("Mandatory!");
			} else if (!userAccountNumberTyped.isEmpty() && userPasswordTyped.isEmpty()) {
				warningMessage1.setText("");
				warningMessage2.setText("Mandatory!");
			} else if (userAccountNumberTyped.isEmpty() && !userPasswordTyped.isEmpty()) {
				warningMessage1.setText("Mandatory!");
				warningMessage2.setText("");
			} else {

				userAccountNumberParsed = Integer.parseInt(userAccountNumberTyped);
				userPasswordParsed = Integer.parseInt(userPasswordTyped);

				for (Client client : bankClients) {

					//////////////////////////////////////////////////// ADMIN MENU
					//////////////////////////////////////////////////// //////////////////////////////////////////////////////
					if (generatorAdmin.getAllAdmins().get(0).getAccountNumber() == userAccountNumberParsed
							&& generatorAdmin.getAllAdmins().get(0).getPassword() == userPasswordParsed) {

						BorderPane adminPage = new BorderPane();
						primaryStage.setTitle("Kiwi Bank (ADMIN)");
						primaryStage.getIcons().add(icon);

						Scene adminMenu = new Scene(adminPage, 900, 500);
						adminPage.getStylesheets().add("file:images/styleAdminMenu.css");
						primaryStage.setScene(adminMenu);

						Label topMessage = new Label(">   Welcome Admin Zafer   <");
						adminPage.setTop(topMessage);
						BorderPane.setAlignment(topMessage, Pos.CENTER);
						topMessage.setMinHeight(150);
						topMessage.setStyle(styleDon30);
						Label left = new Label("");
						adminPage.setLeft(left);
						BorderPane.setAlignment(left, Pos.CENTER);
						left.setMinWidth(350); // This is just for balancing the page for design.

						/* ADMIN CAN CHOOSE ANY ACTION TO APPLY */
						GridPane administratorActionMenu = new GridPane();
						administratorActionMenu.setHgap(10);
						administratorActionMenu.setVgap(10);
						administratorActionMenu.setGridLinesVisible(false);

						Button newClientAddButton = new Button("Add New Client");
						Button deleteClientButton = new Button("Delete Client");
						Button settingsButton = new Button("Settings");
						Button helpButton = new Button("Help");
						administratorActionMenu.add(newClientAddButton, 0, 0);
						newClientAddButton.setMinHeight(50);
						newClientAddButton.setMinWidth(200);
						administratorActionMenu.add(deleteClientButton, 0, 1);
						deleteClientButton.setMinHeight(50);
						deleteClientButton.setMinWidth(200);
						administratorActionMenu.add(settingsButton, 0, 2);
						settingsButton.setMinHeight(50);
						settingsButton.setMinWidth(200);
						administratorActionMenu.add(helpButton, 0, 3);
						helpButton.setMinHeight(50);
						helpButton.setMinWidth(200);

						adminPage.setCenter(administratorActionMenu);
						BorderPane.setAlignment(administratorActionMenu, Pos.CENTER);
						administratorActionMenu.setMinWidth(250);

						//////////////////////////////////////////////////// ADD NEW CLIENT MENU
						//////////////////////////////////////////////////// //////////////////////////////////////////////////////

						/* CLICK TO ADD NEW CLIENT */
						newClientAddButton.setOnAction(eve -> {
							/* NEW CLIENT PAGE */
							BorderPane addNewClientPage = new BorderPane();
							primaryStage.setTitle("Kiwi Bank (ADMIN/addClient)");
							primaryStage.getIcons().add(icon);

							Scene clientMenu = new Scene(addNewClientPage, 900, 500);
							addNewClientPage.getStylesheets().add("file:images/styleAdminMenu.css");
							primaryStage.setScene(clientMenu);

							Label headingNewClient = new Label("..   Enter required data for NEW client   ..");
							addNewClientPage.setTop(headingNewClient);
							BorderPane.setAlignment(headingNewClient, Pos.CENTER);
							headingNewClient.setMinHeight(150);
							headingNewClient.setStyle(styleDon30);
							Label leftBalance = new Label("");
							addNewClientPage.setLeft(leftBalance);
							BorderPane.setAlignment(leftBalance, Pos.CENTER);
							leftBalance.setMinWidth(230); // Thise is for only balancing the page position for design.
							/* NEW CLIENT MENU */
							GridPane addClientMenu = new GridPane(); // ADMIN CAN ENTER THE REQUIRED INFORMATION FOR NEW
																		// CLIENT
							addClientMenu.setHgap(10);
							addClientMenu.setVgap(10);
							addClientMenu.setGridLinesVisible(false);

							Label newName = new Label("Name and Surname:");
							Label newBirthdate = new Label("Birthdate:");
							Label newAccountNumber = new Label("Account Number:");
							Label newBalance = new Label("Total Money:");
							addClientMenu.add(newName, 0, 0);
							newName.setMinHeight(50);
							newName.setMinWidth(200);
							newName.setStyle(styleLux20);
							addClientMenu.add(newBirthdate, 0, 1);
							newBirthdate.setMinHeight(50);
							newBirthdate.setMinWidth(200);
							newBirthdate.setStyle(styleLux20);
							addClientMenu.add(newAccountNumber, 0, 2);
							newAccountNumber.setMinHeight(50);
							newAccountNumber.setMinWidth(200);
							newAccountNumber.setStyle(styleLux20);
							addClientMenu.add(newBalance, 0, 3);
							newBalance.setMinHeight(50);
							newBalance.setMinWidth(200);
							newBalance.setStyle(styleLux20);

							TextField forNewName = new TextField();
							TextField forNewBirthdate = new TextField();
							TextField forNewAccountNumber = new TextField();
							TextField forNewBalance = new TextField();
							addClientMenu.add(forNewName, 1, 0);
							addClientMenu.add(forNewBirthdate, 1, 1);
							addClientMenu.add(forNewAccountNumber, 1, 2);
							addClientMenu.add(forNewBalance, 1, 3);

							addNewClientPage.setCenter(addClientMenu);
							BorderPane.setAlignment(addClientMenu, Pos.CENTER);
							addClientMenu.setMinWidth(250);

							/* ADMIN CAN COME BACK TO ADMIN MAIN MENU WITH THIS BUTTON */
							Button backToAdminPageButton = new Button("Back");
							backToAdminPageButton.setMinWidth(150);
							backToAdminPageButton.setMinHeight(50);
							BorderPane.setMargin(backToAdminPageButton, new Insets(10, 60, 25, 40));
							BorderPane.setAlignment(backToAdminPageButton, Pos.TOP_CENTER);
							addNewClientPage.setLeft(backToAdminPageButton);
							backToAdminPageButton.setOnAction(back -> primaryStage.setScene(adminMenu)); // COME BACK TO
																											// ADMIN
																											// PAGE

							/* ADMIN CAN SAVE NEW CLIENT WITH THIS BUTTON */
							Button saveNewClientButton = new Button("Save");
							saveNewClientButton.setMinWidth(150);
							saveNewClientButton.setMinHeight(50);
							BorderPane.setMargin(saveNewClientButton, new Insets(0, 30, 100, 70));
							BorderPane.setAlignment(saveNewClientButton, Pos.BOTTOM_CENTER);
							addNewClientPage.setRight(saveNewClientButton);
							saveNewClientButton.setOnAction(save -> { // SAVE THE ENTERED DATA TO THE DATABASE

								generatorClient.addClient(new Client(forNewName.getText(),
										LocalDate.of(Integer.parseInt(forNewBirthdate.getText().substring(0, 4)),
												Integer.parseInt(forNewBirthdate.getText().substring(5, 7)),
												Integer.parseInt(forNewBirthdate.getText().substring(8, 10))),
										Integer.parseInt(forNewAccountNumber.getText()),
										Double.parseDouble(forNewBalance.getText()), 1111));

								Label messageOfnewClient = new Label("New client\nSUCCESSFULLY\nadded!");
								messageOfnewClient.setStyle(styleAri15);
								addClientMenu.add(messageOfnewClient, 1, 5);

								/* ALL CLIENTS DATA WRITTEN ON CONSOLE AFTER ADDING */
								generatorClient.getAllClients().forEach(eachClient -> System.out.println(eachClient));
								bankAdmins.forEach(eachAdmin -> System.out.println(eachAdmin));// ADMINISTRATOR DATA
																								// WRITTEN ON CONSOLE

							});

							/* NEW CLIENT MENU BOTTOM BUTTON FOR LOG OUT! */
							Button addClientPageLogOutButton = new Button("Log Out!");
							addClientPageLogOutButton.setMaxWidth(Double.MAX_VALUE);
							addClientPageLogOutButton.setMaxHeight(Double.MAX_VALUE);
							addClientPageLogOutButton.setMinWidth(150);
							addClientPageLogOutButton.setMinHeight(30);
							addNewClientPage.setBottom(addClientPageLogOutButton);
							addClientPageLogOutButton.setOnAction(logOut -> {
								primaryStage.setScene(mainMenu);
								accountInput.setText("");
								passwordInput.setText("");
								warningMessage1.setText("");
								warningMessage2.setText("");
							});
						});

						///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

						/////////////////////////////////////////////// DELETE CLIENT MENU
						/////////////////////////////////////////////// ////////////////////////////////////////////////////////

						/* CLICK TO DELETE CLIENT */
						deleteClientButton.setOnAction(eve -> {

							/* DELETE CLIENT PAGE */
							BorderPane deleteClientPage = new BorderPane();
							primaryStage.setTitle("Kiwi Bank (ADMIN/deleteClient)");
							primaryStage.getIcons().add(icon);

							Scene clientMenu = new Scene(deleteClientPage, 900, 500);
							deleteClientPage.getStylesheets().add("file:images/styleAdminMenu.css");
							primaryStage.setScene(clientMenu);

							Label headingNewClient = new Label("..   Enter required data to DELETE client   ..");
							deleteClientPage.setTop(headingNewClient);
							BorderPane.setAlignment(headingNewClient, Pos.CENTER);
							headingNewClient.setMinHeight(150);
							headingNewClient.setStyle(styleDon30);
							Label leftBalance = new Label("");
							deleteClientPage.setLeft(leftBalance);
							BorderPane.setAlignment(leftBalance, Pos.CENTER);
							leftBalance.setMinWidth(230); // Thise is for only balancing the page position

							/* DELETE CLIENT MENU */
							GridPane deleteClientMenu = new GridPane();
							deleteClientMenu.setHgap(10);
							deleteClientMenu.setVgap(10);
							deleteClientMenu.setGridLinesVisible(false);

							Label deleteAccountNumber = new Label("Account Number:");
							deleteClientMenu.add(deleteAccountNumber, 0, 0);
							deleteAccountNumber.setMinHeight(50);
							deleteAccountNumber.setMinWidth(200);
							deleteAccountNumber.setStyle(styleLux20);

							TextField willBeDeletedAccountNumber = new TextField();
							deleteClientMenu.add(willBeDeletedAccountNumber, 1, 0);

							CheckBox approve = new CheckBox("Approve");
							approve.setSelected(false);
							deleteClientMenu.add(approve, 1, 2);

							deleteClientPage.setCenter(deleteClientMenu);
							BorderPane.setAlignment(deleteClientMenu, Pos.CENTER);
							deleteClientMenu.setMinWidth(250);

							Button backToAdminPageButton = new Button("Back");
							backToAdminPageButton.setMinWidth(150);
							backToAdminPageButton.setMinHeight(50);
							BorderPane.setMargin(backToAdminPageButton, new Insets(10, 60, 25, 40));
							BorderPane.setAlignment(backToAdminPageButton, Pos.TOP_CENTER);
							deleteClientPage.setLeft(backToAdminPageButton);
							backToAdminPageButton.setOnAction(back -> primaryStage.setScene(adminMenu));

							Button deteleOrderClientButton = new Button("Delete!");
							deteleOrderClientButton.setMinWidth(150);
							deteleOrderClientButton.setMinHeight(50);
							BorderPane.setMargin(deteleOrderClientButton, new Insets(0, 30, 100, 70));
							BorderPane.setAlignment(deteleOrderClientButton, Pos.BOTTOM_CENTER);
							deleteClientPage.setRight(deteleOrderClientButton);

							Label deleteClientSuccessMesseage = new Label();
							deleteClientMenu.add(deleteClientSuccessMesseage, 1, 5);

							deteleOrderClientButton.setOnAction(delete -> {

								for (int i = 0; i < bankClients.size(); i++) {

									if (bankClients.get(i).getAccountNumber() == Integer
											.parseInt(willBeDeletedAccountNumber.getText()) && approve.isSelected()) {

										generatorClient.deleteClient(bankClients.get(i));

										deleteClientSuccessMesseage.setStyle(styleAri15);
										deleteClientSuccessMesseage.setText("The client\nSUCCESSFULLY\ndeleted!");

									} else if (bankClients.get(i).getAccountNumber() != Integer
											.parseInt(willBeDeletedAccountNumber.getText()) || approve.isDisabled()) {

										deleteClientSuccessMesseage.setStyle(styleAri17);
										deleteClientSuccessMesseage
												.setText("Please enter\nvalid Account Number\nand Approve!");
									}
								}

								generatorClient.getAllClients().forEach(eachClient -> System.out.println(eachClient)); // ALLL
																														// CLIENTS
																														// DATA
																														// WRITTEN
																														// ON
																														// CONSOLE
																														// AFTER
																														// DELETING
								bankAdmins.forEach(eachAdmin -> System.out.println(eachAdmin));// ADMINISTRATOR DATA
																								// WRITTEN ON CONSOLE
							});
							/* DELETE CLIENT MENU BOTTOM BUTTON FOR LOG OUT! */
							Button deleteClientPageLogOutButton = new Button("Log Out!");
							deleteClientPageLogOutButton.setMaxWidth(Double.MAX_VALUE);
							deleteClientPageLogOutButton.setMaxHeight(Double.MAX_VALUE);
							deleteClientPageLogOutButton.setMinWidth(150);
							deleteClientPageLogOutButton.setMinHeight(30);
							deleteClientPage.setBottom(deleteClientPageLogOutButton);
							deleteClientPageLogOutButton.setOnAction(logOut -> {
								primaryStage.setScene(mainMenu);
								accountInput.setText("");
								passwordInput.setText("");
								warningMessage1.setText("");
								warningMessage2.setText("");
							});

						});
						/* ADMIN MAIN MENU BOTTOM BUTTON FOR LOG OUT! */
						Button adminPageLogOutButton = new Button("Log Out!");
						adminPageLogOutButton.setMaxWidth(Double.MAX_VALUE);
						adminPageLogOutButton.setMaxHeight(Double.MAX_VALUE);
						adminPageLogOutButton.setMinWidth(150);
						adminPageLogOutButton.setMinHeight(30);
						adminPage.setBottom(adminPageLogOutButton);
						adminPageLogOutButton.setOnAction(out -> {
							primaryStage.setScene(mainMenu);
							accountInput.setText("");
							passwordInput.setText("");
							warningMessage1.setText("");
							warningMessage2.setText("");
						});

						break;
						///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

						////////////////////////////////////////////////// PERSONAL MENU
						////////////////////////////////////////////////// //////////////////////////////////////////////////////
					} else if (client.getAccountNumber() == userAccountNumberParsed
							&& client.getPassword() == userPasswordParsed) {

						/* PERSONAL PAGE */
						BorderPane personalPage = new BorderPane();
						primaryStage.setTitle("Kiwi Bank (Personal)");
						primaryStage.getIcons().add(icon);

						Scene personalMenu = new Scene(personalPage, 900, 500);
						personalPage.getStylesheets().add("file:images/stylePersonalMenu.css");
						primaryStage.setScene(personalMenu);

						Label top = new Label(">  Welcome Your Page  <");
						personalPage.setTop(top);
						BorderPane.setAlignment(top, Pos.CENTER);
						top.setMinHeight(70);
						top.setStyle(styleLux30);
						Label left = new Label("");
						personalPage.setLeft(left);
						BorderPane.setAlignment(left, Pos.CENTER_LEFT);
						left.setMinWidth(250); // This is only for balancing the page design.

						/* THE INFORMATIONS OF THE ACCOUNT OWNER IN PERSONAL PAGE */
						GridPane personalInformations = new GridPane();
						personalInformations.setHgap(30);
						personalInformations.setVgap(20);
						personalInformations.setGridLinesVisible(false);
						Label personalName = new Label("\n\n\nName\t\t\t:");
						personalName.setStyle(styleLux20);
						Label personalGetName = new Label("\n\n" + client.getName());
						personalGetName.setStyle(styleAri30);
						Label personalBirthdate = new Label("Birthdate\t\t\t:");
						personalBirthdate.setStyle(styleLux20);
						Label personalGetBirthdate = new Label("" + client.getBirthdate());
						personalGetBirthdate.setStyle(styleAri30);
						Label personalAccount = new Label("Account Number\t:");
						personalAccount.setStyle(styleLux20);
						Label personalGetAccount = new Label("" + client.getAccountNumber());
						personalGetAccount.setStyle(styleAri30);
						Label totalMoney = new Label("Total Money\t\t:");
						totalMoney.setStyle(styleLux20);
						Label totalGetMoney = new Label("" + client.getMoneySum() + " €");
						totalGetMoney.setStyle(styleAri30);
						personalInformations.add(personalName, 0, 0);
						personalInformations.add(personalGetName, 1, 0);
						personalInformations.add(personalBirthdate, 0, 1);
						personalInformations.add(personalGetBirthdate, 1, 1);
						personalInformations.add(personalAccount, 0, 2);
						personalInformations.add(personalGetAccount, 1, 2);
						personalInformations.add(totalMoney, 0, 3);
						personalInformations.add(totalGetMoney, 1, 3);
						personalPage.setCenter(personalInformations);
						BorderPane.setAlignment(personalInformations, Pos.CENTER);
						personalInformations.setMinWidth(100);

						/* RIGHT MENUBAR AND BUTTONS RELATED WITH TRANSACTIONS IN PERSONAL PAGE */
						GridPane actionMenu = new GridPane();
						actionMenu.setHgap(5);
						actionMenu.setVgap(5);
						actionMenu.setGridLinesVisible(false);
						Button transfer = new Button("Money\nTransfer");
						Button checkAccount = new Button("Account\nCheck");
						Button deposit = new Button("Deposit");
						Button settings = new Button("Settings");
						Button contact = new Button("Contact");
						actionMenu.add(transfer, 0, 0);
						transfer.setMinHeight(60);
						transfer.setMinWidth(120);
						actionMenu.add(checkAccount, 0, 1);
						checkAccount.setMinHeight(60);
						checkAccount.setMinWidth(120);
						actionMenu.add(deposit, 0, 2);
						deposit.setMinHeight(60);
						deposit.setMinWidth(120);
						actionMenu.add(settings, 0, 3);
						settings.setMinHeight(60);
						settings.setMinWidth(120);
						actionMenu.add(contact, 0, 4);
						contact.setMinHeight(60);
						contact.setMinWidth(120);
						personalPage.setRight(actionMenu);
						BorderPane.setAlignment(actionMenu, Pos.CENTER);
						actionMenu.setMinWidth(50);

						/* PERSONAL PAGE BOTTOM BUTTON FOR LOG OUT! */
						Button personalPageLogOutButton = new Button("Log Out!");
						personalPageLogOutButton.setMaxWidth(Double.MAX_VALUE);
						personalPageLogOutButton.setMaxHeight(Double.MAX_VALUE);
						personalPageLogOutButton.setMinWidth(150);
						personalPageLogOutButton.setMinHeight(30);
						personalPage.setBottom(personalPageLogOutButton);
						personalPageLogOutButton.setOnAction(eve -> {
							primaryStage.setScene(mainMenu);
							accountInput.setText("");
							passwordInput.setText("");
							warningMessage1.setText("");
							warningMessage2.setText("");
						});

						break;
						/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

					} else {
						/* LONIN TRY WIT FALSE DATA */
						warningMessage1.setText("Wrong!");
						warningMessage2.setText("Wrong!");
					}
				}
			}
		});
		primaryStage.setScene(mainMenu);
		primaryStage.show();
	}
}
