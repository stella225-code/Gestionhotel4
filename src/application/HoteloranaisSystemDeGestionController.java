package application;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import java.sql.Connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HoteloranaisSystemDeGestionController implements Initializable {
	
	@FXML
    private Button loginbtn;
	

    @FXML
    private PasswordField password;

    @FXML
    private StackPane root;
  
    
    @FXML
    private AnchorPane root1;

    @FXML
    private  TextField usertfd;
    
    
    //outil database 
    
 //   private static SingleConnection conx = new SingleConnection(); // Objet de connexion à la base de données
//	private static Connection connection=null;    // laconnexion doit etre partarger""static"" avec user , client et autre
	private static Connection connection=SingleConnection.getConnection();

    private static PreparedStatement pst=null; // Objet pour exécuter les requêtes SQL préparées
    private static ResultSet res=null; // Objet pour stocker les résultats des requêtes SQL
    
   /* public  void login() {
    //	String user = usertfd.getText();
   // 	String pass = password.getText();
    //	String sql = "SELECT * FROM login WHERE nomlogin ='"+user+"'  and passlogin= '"+pass+"'  ";
    	
    //	conx= SingleConnection.connectdb();
    	
    		pst = conx.prepareStatement(sql);// Préparer la requête SQL
			pst.setString(1, user);
			pst.setString(2, pass);
             System.out.println("Exécution de la requête SQL login");
             
            res=pst.executeQuery();
            
            Alert alert;
            
            if(res.next()) {
            	
             alert = new Alert(AlertType.INFORMATION);
           	 alert.setTitle("information message ");
           	 alert.setHeaderText(null);
           	 alert.setContentText("connection success ");
           	 alert.showAndWait();
            }else {
             alert = new Alert(AlertType.ERROR);
           	 alert.setTitle("information message ");
           	 alert.setHeaderText(null);
           	 alert.setContentText("code ou nom incorrect");
           	 alert.showAndWait();
            }
            
           if( usertfd.getText().isEmpty() || password.getText().isEmpty()) {
            
            	Alert alert = new Alert(AlertType.INFORMATION);
            	 alert.setTitle("information message ");
            	 alert.setHeaderText(null);
            	 alert.setContentText("champs invalide");
            	 alert.showAndWait();
            } /*else
            {
            	conx=(Connection) SingleConnection.connectdb();
    			PreparedStatement pst = conx.prepareStatement(sql);// Préparer la requête SQL
    			pst.setString(1, user);
    			pst.setString(2, pass);
                 System.out.println("Exécution de la requête SQL login");
                res=pst.executeQuery();
                   if (!res.isBeforeFirst()){ //si donnée n'existe pas
                	   
                	   Alert alert = new Alert(AlertType.ERROR);
  		           	 alert.setTitle("ERREUR message ");
  		           	 alert.setContentText("Compte invalide");
  		           	 alert.showAndWait();
             	
                   }else {
		            	while(res.next()){
		        		
		        			StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));

                            Stage stage =new Stage();
                            Scene scene=new Scene(root);
                            stage.setScene(scene);
                            stage.show();
		            	                 }
                   
                   }     }*/ 
    
   /* public static int loginx(String user , String pass) {
    	Connection conx= SingleConnection.connectdb();

    	if(conx==null) return -1;
    	String sql = "SELECT * FROM login WHERE nomlogin =?  and passlogin= ? ";

    	
    	 try {
			pst=conx.prepareStatement(sql);
			pst.setString(1 , user);
			pst.setString(2 , pass);
			
			res = pst.executeQuery();
			
			while(res.next()) {
				return 0;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}return 1 ;
    }*/
   

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loginbtn.setOnAction(actionEvent -> loginx());
		
	}
	
	 @FXML
  public  void exit() {
System.exit(0);
    }

	 private double x=0;
	 private double y=0;
	 
	 public void loginx() {
		 
	    //String sql = "SELECT * FROM login WHERE nomlogin =?  AND passlogin= ? ";
	    try {
			pst = connection.prepareStatement("SELECT * FROM user WHERE email =?  AND password= ?");
			pst.setString(1 , usertfd.getText());
			pst.setString(2 , password.getText());
			res=pst.executeQuery();
	    if(res.next()) {
	    	
				Alert alert = new Alert(AlertType.CONFIRMATION , "connection avec success" , ButtonType.OK);
				alert.show();
				StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));

                Stage stage =new Stage();
                Scene scene=new Scene(root);
                stage.setTitle("Tableau de bord");
                
                root.setOnMousePressed((MouseEvent event)->{
    				x=event.getSceneX();
    				y=event.getSceneY();
    				
    			});
                
                root.setOnMouseDragged(( MouseEvent event)->{
    				stage.setX(event.getScreenX() -x );
    				stage.setY(event.getScreenY() -y );
    			}) ;
                
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
			}else {
				Alert alert = new Alert(AlertType.WARNING , " erreur connection " , ButtonType.OK);
				alert.show();}
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		} 

	       
	  }  
}