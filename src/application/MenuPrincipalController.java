package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.backend.Chambre;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
	import javafx.scene.layout.HBox;
	import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

	public class MenuPrincipalController implements Initializable{


		 @FXML
		    private StackPane root1;
	    @FXML
	    private Button accueil;

	    @FXML
	    private Button ajouterchambre;

	    @FXML
	    private Button categorie;

	    @FXML
	    private Button chambre;
	     @FXML
	    private Button chambres;

	    @FXML
	    private Button client;

	    @FXML
	    private Button close;
		 @FXML
			    private Button deconnection;
		 @FXML
	    private Button fermer;
	    @FXML
	    private Pane inner_pane11;

	    @FXML
	    private Pane inner_pane111;

	    @FXML
	    private Pane inner_pane1111;

	    @FXML
	    private Button map; 
	    @FXML
	    private Button parametre; 
	    @FXML
	    private TextField recherche;

	 @FXML
	    private ImageView reduire;

	    @FXML
	    private HBox root11;

	    @FXML
	    private Button services;

	    @FXML
	    private AnchorPane side_ankerpane1;

	 

	    //-----------------------------------------------CHAMBRE.FXML

	    @FXML
	    private AnchorPane chambredispo;

	   
	   @FXML
	 private TableColumn<donneechambre, String> colidchambre;

	    @FXML
	    private TableColumn<donneechambre, String> colprixchambre;

	  //  @FXML
	  //  private TableColumn<donneechambre, String> colstatutchambre;

	 //   @FXML
	  //  private TableColumn<donneechambre, String> coltypechambre;

	    @FXML
	    private TextField idchambre;

	    
	   
	    @FXML
	    private TableView<donneechambre> tabledonneechambre;
		 @FXML
			    private Button enregistrerchambre;
		 @FXML
	    private Button modifierchambre;

	    @FXML
	    private Button actualiserchambre;
	    @FXML
	    private TextField prixchambre;
	        @FXML
	    private TextField recherchechambre; 
	   

	        @FXML
	    private ComboBox<?> statutchambre;

	    
	    //----------------------------------EMPLOYES.FXML   
@FXML
	    private TextField rechercheemploye;
	    @FXML
	    private Button employe;

	    @FXML
	    private Button employes;

	    @FXML
	    private TableColumn<?, ?> enregistreremploye;


	    @FXML
	    private TableColumn<?, ?> idemploye;

	    @FXML
	    private TableColumn<?, ?> nomemploye;

	  
	    @FXML
	    private TableColumn<?, ?> prenomemploye;

	   
	    @FXML
	    private Button supprimerchambre;

	    @FXML
	    private AreaChart<?, ?> tabdonnee;

	    @FXML
	    private AnchorPane tabform;

	    @FXML
	    private AnchorPane tableemploye;

	    @FXML
	    private Label tablivre;

	    @FXML
	    private Label tabrev;

	    @FXML
	    private Label tabrevtotal;

	    @FXML
	    private TableColumn<?, ?> telemploye;

	    @FXML
	    private Pane text_recherche1;

	    @FXML
	    private TableColumn<?, ?> totalpayer;

	    @FXML
	    private ComboBox<?> typechambre;

	    @FXML
	    private Label username;

	    @FXML
	    private TableColumn<?, ?> verifieremploye;

	    @FXML
	    private Button deconnecter;
	    
	    
	    
	    TableColumn<donneechambre,String> idchambre1 = new TableColumn<>("idchambre");
	    TableColumn<donneechambre,String> coltypechambre = new TableColumn<>("type de chambre");
	    TableColumn<donneechambre,String> colstatutchambre = new TableColumn<>("status chambre");
	    TableColumn<donneechambre,Double> prixchambre1 = new TableColumn<>("prix de chambre");
	    
	    
	
	
	    private static Connection connection=SingleConnection.getConnection();

	    private static PreparedStatement pst=null; // Objet pour exécuter les requêtes SQL préparées
	    private static Statement stm=null;
	    private static ResultSet res=null; // Objet pour stocker les résultats des requêtes SQL
	    
	    
	    public ObservableList<donneechambre> donneechambres(){
	    	ObservableList<donneechambre> listdonneechambre=FXCollections.observableArrayList();
	    	String sql= "select*from chambre";
	    	connection = SingleConnection.getConnection();
	    	
	    	
	    	try {
				donneechambre Dchambre;
				
				PreparedStatement pst = connection.prepareStatement(sql);// Préparer la requête SQL

	           res= pst.executeQuery();
	            
	            while ( res.next()) {
	            	Dchambre= new donneechambre(res.getInt("idchambre"),res.getString("typechambre"), res.getString("statutchambre"), res.getDouble("prixchambre") );
	            	
	            	listdonneechambre.add(Dchambre);
	            }

			} catch (Exception e) {
				// TODO: handle exception
			}
			return listdonneechambre;
			
	    }
	    
	    private ObservableList<donneechambre> chambrelistdonnee;
	    
	    public void voirlistdonnee() {
	    	
	    	
	    	chambrelistdonnee=donneechambres();
	    	
	    	colidchambre.setCellValueFactory(new PropertyValueFactory<>("idchambre"));
	    	coltypechambre.setCellValueFactory(new PropertyValueFactory<>("typechambre"));
	    	colstatutchambre.setCellValueFactory(new PropertyValueFactory<>("statutchambre"));
	    	colprixchambre.setCellValueFactory(new PropertyValueFactory<>("prixchambre"));
	    	
	    	tabledonneechambre.setItems(chambrelistdonnee);
	    }
	
	    public void selectiolisdonnechambre() {
	    	
	    	donneechambre Dchambre =tabledonneechambre.getSelectionModel().getSelectedItem();
	    	int num = tabledonneechambre.getSelectionModel().getSelectedIndex();
	    	
	    	if((num -1) <-1) {
	    		return;
	    	}
	    	
	    	idchambre.setText(String.valueOf(Dchambre.getIdchambre()));
	    	prixchambre.setText(String.valueOf(Dchambre.getPrixchambre()));
	    }
	    //-----------------------------------------------FONCTION AJOUTER
	
	public void chambreAjouter() {
		String sql="insert into chambre(idchambre ,typechambre,statutchambre,prixchambre) values (?, ? ,? ,?) ";
       
		try {
			PreparedStatement pst = connection.prepareStatement(sql);// Préparer la requête SQL
			pst.setString(1, idchambre.getText());
			pst.setString(2, (String) typechambre.getSelectionModel().getSelectedItem());
			pst.setString(3, (String) statutchambre.getSelectionModel().getSelectedItem());
			pst.setString(4, prixchambre.getText());

			
					
             System.out.println("Exécution de la requête SQL");
            pst.executeUpdate();
            if ( idchambre.getText().isEmpty() || ((String) typechambre.getSelectionModel().getSelectedItem()).isEmpty()|| ((String) statutchambre.getSelectionModel().getSelectedItem()).isEmpty() || prixchambre.getText().isEmpty()){
            	Alert alert = new Alert(AlertType.ERROR , "champs invalide" , ButtonType.OK);
				alert.show();
				
				 
            }else {
            	Alert alert = new Alert(AlertType.CONFIRMATION , "element ajouter avec success" , ButtonType.OK);
				alert.show();
				
				voirlistdonnee();
				    idchambre.setText("");
	   			    typechambre.setPromptText("");
	   			    statutchambre.setPromptText("");
	   			    prixchambre.setText("");
				
				chambresupprimer();
				
            }

             
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
        System.out.println("préparation de la requête SQL est ok");
		
		
	}
/*
	 void actualisertable() {
	      connection = SingleConnection.getConnection();
	    	
			ObservableList <donneechambre> chambres= FXCollections.observableArrayList();
		    String sql="select*from chambre";
		    PreparedStatement pst;
			try {
				pst = connection.prepareStatement(sql);
				pst.executeQuery();
				
				res=pst.executeQuery();
					    
	    	    chambres.clear();
	    	    
	    	    while(res.next()) {
		   		    	 chambres.add( new donneechambre (
		   		    	res.getInt("idchambre"),
		   		        res.getString("typechambre"),
		   		        res.getString("statutchambre"),
		   		        res.getDouble("prixchambre")));
		   		        
		   		    	 tabledonneechambre.setItems(chambres);
	    	    }
	    	    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// Préparer la requête SQL

		
	    	
	    }*/

	
	private static String typechambres[]= {"Chambre Simple ", "Chambre Double","Chambre Triple","Chambre Famillial", "Chambre Royal"};
	public void typechambre() {
		List<String> listdonneechambre=new ArrayList<>();
		for(String donnee : typechambres) {
			listdonneechambre.add(donnee);
		}
		ObservableList list= FXCollections.observableArrayList(listdonneechambre);
		typechambre.setItems(list);
	}

	
	
	private static String statutchambres[]= {"Disponible ", "Non Disponible","Occupé"};
	public void statutchambres() {
		List<String> listdonneechambre=new ArrayList<>();
		for(String donnee : statutchambres) {
			listdonneechambre.add(donnee);
		}
		ObservableList list= FXCollections.observableArrayList(listdonneechambre);
		statutchambre.setItems(list);
	}
	
	public void chambresupprimer() {
		
		idchambre.setText("");
		typechambre.getSelectionModel().clearSelection();
		statutchambre.getSelectionModel().clearSelection();
		prixchambre.setText("");

}

	
	 private double x=0;
	 private double y=0;
	 
	public void deconnexion () {
		
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION , "vous etes sur de vouloir vous deconnecter?" , ButtonType.OK);
			Optional<ButtonType> option=alert.showAndWait();
			alert.show();
			
			if(option.get().equals(ButtonType.OK)) {
				
			
				
			Parent root = FXMLLoader.load(getClass().getResource("HoteloranaisSystemDeGestion.fxml"));
			

            Stage stage =new Stage();
            Scene scene=new Scene(root);
            
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
            
            deconnecter.getScene().getWindow().hide();
            
            }else {
            	return;
            }

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void close() {
		System.exit(0);
	}
	
	public void minimize() {
		Stage stage = (Stage)root1.getScene().getWindow();
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		voirlistdonnee();
		chambreAjouter();
		typechambre();
		statutchambres();
		
		
	}

	//--------------------------------------------FONCTION SUPPRIMER

	
}
