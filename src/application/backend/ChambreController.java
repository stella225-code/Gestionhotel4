package application.backend;

	import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import application.SingleConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
	import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChambreController implements Initializable{




    @FXML
    private Button ajouterchambre;

    @FXML
    private AnchorPane bardemenu;

    @FXML
    private HBox bardemenuformulaire;

    @FXML
    private Button chambrebtn;

    @FXML
    private AnchorPane chambreformulaire;

    @FXML
    private Button checkbtn;

    @FXML
    private Button clientbtn;

    @FXML
    private Button close1;

    @FXML
    private Button closebtn;

    @FXML
    private TableColumn<Chambre, String> colidchambre1;

    @FXML
    private TableColumn<Chambre, String> colprixchambre1;

    @FXML
    private TableColumn<Chambre, String> colstatutchambre1;

    @FXML
    private TableColumn<Chambre, String> coltypechambre1;

    @FXML
    private Button deconnecterbtn;

    @FXML
    private Button employebtn;

    @FXML
    private Button enregistrerchambre;

    @FXML
    private TextField idchambre1;

    @FXML
    private Button modifierchambre;

    @FXML
    private Button nettoyerchambre;

    @FXML
    private TextField prixchambre1;

    @FXML
    private TextField recherchebtn;

    @FXML
    private TextField recherchechambre;

    @FXML
    private Button reservationbtn;

    @FXML
    private Button servicesbtn;

    @FXML
    private ComboBox<?> statutchambre1;

    @FXML
    private Button supprimerchambre;

    @FXML
    private Button tableaubordbtn;

    @FXML
    private TableView<Chambre> tablechambre;

    @FXML
    private ComboBox<Chambre> typechambre1;

    @FXML
    private Label username1;
    

    @FXML
    void chambreAjouter(ActionEvent event) {
        connection = SingleConnection.getConnection();
        
            String idchambre=idchambre1.getText();
			String typechambre=(String)statutchambre1.getSelectionModel().getSelectedItem();
			String statutchambre=(String)statutchambre1.getSelectionModel().getSelectedItem();
			String prixchambre=prixchambre1.getText();
			
			
 	    	String sql="insert into chambre(idchambre ,typechambre,statutchambre,prixchambre) values (?, ? ,? ,?) ";

 	    	try {
				
 	    		PreparedStatement pst = connection.prepareStatement(sql);// Préparer la requête SQL
 	   			pst.setString(1, idchambre);
 	   			pst.setString(2,  typechambre);
 	   			pst.setString(3, statutchambre);
 	   			pst.setString(4, prixchambre);
 	   		    pst.executeUpdate();
 	                System.out.println("Exécution de la requête SQL");
 	               if ( idchambre.isEmpty() ||  typechambre.isEmpty()|| statutchambre.isEmpty() || prixchambre.isEmpty() )
 	               {
 	               	Alert alert = new Alert(AlertType.ERROR , "champs invalide" , ButtonType.OK);
 	   				alert.show();
 	   				
 	   				 
 	               }else {
 	               	
 	               	Alert alert = new Alert(AlertType.CONFIRMATION , "element ajouter avec success" , ButtonType.OK);
 	   				alert.show();
 	   				
 	   				table();
 	   				idchambre1.setText("");
 	   			    typechambre1.setPromptText("");
 	   			    statutchambre1.setPromptText("");
 	   			    prixchambre1.setText("");
 	   			    
 	               }

 	                
			} catch (Exception e) {
				// TODO: handle exception
			}

    }

    @FXML
    void chambresupprimer(ActionEvent event) {

    	
    }
    
    @FXML
    void actualisertable(ActionEvent event) {
      connection = SingleConnection.getConnection();
    	
		ObservableList <Chambre> chambres= FXCollections.observableArrayList();
	    String sql="select*from chambre";
	    PreparedStatement pst;
		try {
			pst = connection.prepareStatement(sql);
			pst.executeQuery();
			
			res=pst.executeQuery();
				    
    	    chambres.clear();
    	    
    	    while(res.next()) {
	   		    	 chambres.add( new Chambre (
	   		    	res.getInt("idchambre"),
	   		        res.getString("typechambre"),
	   		        res.getString("statutchambre"),
	   		        res.getDouble("prixchambre")));
	   		        
	   		    	 tablechambre.setItems(chambres);
    	    }
    	    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// Préparer la requête SQL

	
    	
    }

    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void deconnexion(ActionEvent event) {

    }

    @FXML
    void statutchambres(ActionEvent event) {

    }

    @FXML
    void typechambre(ActionEvent event) {

    }

    @FXML
    void voirlistdonnee(ActionEvent event) {

    }

    
    public void table() {
    	connection = SingleConnection.getConnection();
    	
		ObservableList <Chambre> chambres= FXCollections.observableArrayList();
	    String sql="select idchambre ,typechambre,statutchambre,prixchambre from Chambre";

		try {
	    		PreparedStatement pst = connection.prepareStatement(sql);// Préparer la requête SQL

 	   		    pst.executeQuery();
 	   		    
 	   		    while(res.next()) {
 	   		    	Chambre ch= new Chambre();
 	   		    	ch.setIdchambre(res.getString("idchambre"));
 	   		        ch.setTypechambre(res.getString("typechambre"));
 	   		        ch.setStatutchambre(res.getString("statutchambre"));
 	   		        ch.setPrixchambre(res.getString("prixchambre"));
 	   		        
 	   		        chambres.add( ch);
 	   		        
 	   		         tablechambre.setItems(chambres);
 	   		    }
 	   		    
 	   		   
 	   		    
 	   	//    colidchambre1.setCellValueFactory(f -> f.getValue().idProperty());
 	   		colidchambre1.setCellValueFactory(new PropertyValueFactory<>("idchambre"));
	    	coltypechambre1.setCellValueFactory(new PropertyValueFactory<>("typechambre"));
	    	colstatutchambre1.setCellValueFactory(new PropertyValueFactory<>("statutchambre"));
	    	colprixchambre1.setCellValueFactory(new PropertyValueFactory<>("prixchambre"));

	    	
		} catch (Exception e) {
			// TODO: handle exception
		}

    }
  //---------------CONNECTION A LA DATA
    
    
    private static Connection connection=SingleConnection.getConnection();

    private static PreparedStatement pst=null; // Objet pour exécuter les requêtes SQL préparées
    private static Statement stm=null;
    private static ResultSet res=null; // Objet pour stocker les résultats des requêtes SQL


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		loaddate();
		
	}
    
   public void loaddate(){
	   connection=SingleConnection.getConnection();
	   
	 colidchambre1.setCellValueFactory(new PropertyValueFactory<>("idchambre"));
   	coltypechambre1.setCellValueFactory(new PropertyValueFactory<>("typechambre"));
   	colstatutchambre1.setCellValueFactory(new PropertyValueFactory<>("statutchambre"));
   	colprixchambre1.setCellValueFactory(new PropertyValueFactory<>("prixchambre"));

    }
   

	
	
  
   	}

