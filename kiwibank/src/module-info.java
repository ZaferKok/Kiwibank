module kiwibank {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.base;
	requires java.sql;
	
	opens de.kiwi.frontend;
	opens de.kiwi.backend;
	opens de.kiwi.middle.methods;
}