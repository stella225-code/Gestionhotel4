package application.backend;
	import java.io.IOException;
	import java.sql.SQLException;

import application.SingleConnection;
import javafx.application.Application;
	import javafx.event.ActionEvent;
	import javafx.stage.Stage;
	import javafx.scene.Scene;
	import javafx.scene.image.Image;
	import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
	import javafx.fxml.FXMLLoader;

public class test2 {


	public class Main extends Application {
		private double x=0;
		private double  y=0;
		
		@Override
		public void start(Stage primaryStage) {
			try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Chambre.fxml"));
				Scene scene = new Scene(root);
				root.setOnMousePressed((MouseEvent event)->{
					x=event.getSceneX();
					y=event.getSceneY();
					
				});
				root.setOnMouseDragged(( MouseEvent event)->{
					primaryStage.setX(event.getScreenX() -x );
					primaryStage.setY(event.getScreenY() -y );
				}) ;
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("Page de Connexion");
				primaryStage.getIcons().add(new Image ("file:icon.jpg"));
				
			
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	SingleConnection conx = new SingleConnection();
		//	conx.connectdb();
			
		//	ChambreController loginxx =new ChambreController();
			
			launch(args);
	}

	private static void launch(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

