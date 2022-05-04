package tests;

import java.util.ArrayList;
import java.util.List;
import de.kiwi.backend.Admin;
import de.kiwi.backend.AdminMaker;

/** Testing how functions the AdminMaker-Class */

public class AdminMakerTest {

	public static void main(String[] args) {

		AdminMaker adminList = new AdminMaker(1);
		List<Admin> sample = new ArrayList<Admin>();
		sample = adminList.getAllAdmins();
		sample.forEach(Client -> System.out.println(Client));
	}
}
