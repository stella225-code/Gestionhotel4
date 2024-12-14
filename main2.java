package application;

	import java.io.IOException;
	import java.sql.SQLException;

	import javafx.application.Application;
	import javafx.event.ActionEvent;
	import javafx.stage.Stage;
	import javafx.scene.Scene;
	import javafx.scene.image.Image;
	import javafx.scene.input.MouseEvent;
	import javafx.scene.layout.StackPane;
	import javafx.fxml.FXMLLoader;
public class main2 {

	
		private double x=0;
		private double  y=0;
		
		public void start(Stage primaryStage) {
			try {
				StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
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
		
		
		
		public static void main(String[] args) throws SQLException, IOException {
		
			SingleConnection conx = new SingleConnection();
		//	conx.connectdb();
			
			
			HoteloranaisSystemDeGestionController loginxx =new HoteloranaisSystemDeGestionController();
			
			launch(args);
		}



		private static void launch(String[] args) {
			// TODO Auto-generated method stub
			
		}
	}
