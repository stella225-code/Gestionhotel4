module HoteloranaisSystemDeGestion {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	exports application;
	
	opens application to javafx.graphics, javafx.fxml;
}
