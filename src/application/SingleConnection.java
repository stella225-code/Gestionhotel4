package application;

    import java.io.IOException;
import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
	
	
	
public class SingleConnection {

	//private Connection conx; // Objet de connexion à la base de données
    private PreparedStatement statement; // Objet pour exécuter les requêtes SQL préparées
    private ResultSet res; // Objet pour stocker les résultats des requêtes SQL
    private int ok; // Indicateur de succès pour les opérations d'update
    
    // URL de la base de données, utilisateur, mot de passe
     
     
	String db="hoteloranais";
	String url = "jdbc:mysql://localhost:3307/hoteloranais"; // URL de la base de données
    String user =  "root"; // Nom d'utilisateur de la base de données
    String pwd = ""; // Mot de passe de la base de données
    
	private static Connection connection=null; // laconnexion doit etre partarger""static"" avec user , client et autre

	public SingleConnection() {
		 try {
			connection = DriverManager.getConnection(url, user, pwd);
			System.out.println("instance crerr");
		} catch (SQLException e) {
			
			e.printStackTrace();
		} // Établissement de la connexion
	}
	

	
	public static Connection getConnection() {
		if (connection ==null)  
			new SingleConnection();
		return connection;
	}



	
    
	/* public static Connection connectdb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7727236","sql7727236" , "gq3C1KbsZl");
			 System.out.println("connection ok.");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	


	   // Unique instance de la classe
	    private static SingleConnection instance;
	    // Objet Connection à utiliser
	    private static Connection connection;

	    // URL de la base de données, utilisateur, mot de passe
	    private static final String URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7727236";
	    private static final String USER = "sql7727236";
	     private static final String PASSWORD = "gq3C1KbsZl";

	    // Constructeur privé pour empêcher l'instanciation externe
	    public static SingleConnection condb () throws SQLException {
	        try {
	            // Charger le driver JDBC
	            Class.forName("com.mysql.jdbc.Driver");
	            // Initialiser la connexion
	            connection = DriverManager.getConnection(URL, USER, PASSWORD);
	            System.out.println("Connexion établie.");
	        } catch (ClassNotFoundException e) {
	            throw new SQLException("Erreur de chargement du driver : " + e.getMessage());
	        }
			return null;
	    }

	    // Méthode pour obtenir l'instance unique
	    public static SingleConnection getInstance() throws SQLException {
	        if (instance == null) {
	            instance = new SingleConnection();
	        } else if (instance.getConnection().isClosed()) {
	            instance = new SingleConnection();
	        }
	        return instance;
	    }

	    // Méthode pour obtenir l'objet Connection
	    public Connection getConnection() {
	        return connection;
	    }

	public static void main(String[] args)  {
		connectdb();
		
			launch(args);
		}






	private static void launch(String[] args) {
		// TODO Auto-generated method stub
		
	}	*/
}
