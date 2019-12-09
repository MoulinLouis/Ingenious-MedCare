package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSet;

public class SqlConnection {

	  /**
	  * URL de connection
	  */
	  private static String url = "jdbc:mysql://localhost/ingeniousmedcare?characterEncoding=latin1&useConfigs=maxPerformance";

	  /**
	  * Nom du user
	  */
	  private static String user = "root";

	  /**
	  * Mot de passe du user
	  */
	  private static String passwd = "";

	  /**
	  * Objet Connection
	  */
	  private static Connection connect;

	  /**
	  * Méthode qui permet de réaliser notre connexion à notre 
	  * base de données
	  */
	  public static Connection getInstance(){
		// Etape 1 : Chargement du driver
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// Etape 2 : recuperation de la connexion
					Connection cn = null;
					try {
						cn = DriverManager.getConnection(url, user, passwd);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return cn;
	}
	  
	  /* Méthode qui permet de réaliser une insertion 
	   * dans la base de donnée
	   */
	  public static  void Inscription(String text1, String text2,String text3,String text4) {
			Connection cn = getInstance();
			if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty() || text4.isEmpty()) {
				JOptionPane.showMessageDialog(null, 
                        "Un des deux champs est vide !", 
                        "ERREUR", 
                        JOptionPane.ERROR_MESSAGE);
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "INSERT INTO utilisateurs (nom, prenom, login, mdp) VALUES ('" + text1 + "','" 
						+ text2 + "','" + text3 + "','" + text4 + "')";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	  }
	  
	  /* Méthode qui permet de réaliser un DELETE 
	   * dans la base de donnée
	   */
	  public static  void delete(String text3) {
			Connection cn = getInstance();
			if (text3.isEmpty()) {
				JOptionPane.showMessageDialog(null, 
                        "ID de la personne a supprimer non renseign�", 
                        "ERREUR", 
                        JOptionPane.ERROR_MESSAGE);
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "DELETE FROM User WHERE id='" + text3 + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
	  
	  /* Méthode qui permet de réaliser une MODIFICATION 
	   * dans la base de donnée
	   */
	  public static  void Modifier(String text1,String text2,String text3,String text4,String text5) {
			Connection cn = getInstance();
			if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty() || text4.isEmpty() || text5.isEmpty()) {
				JOptionPane.showMessageDialog(null, 
                        "Tout les champs doivent etre remplit", 
                        "ERREUR", 
                        JOptionPane.ERROR_MESSAGE);
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "UPDATE User SET Nom='" + text1 + "',Prenom='" + text2 + "', email='" + text3 + "',mdp='" + text4 + "' WHERE id='" + text5 + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
	  
	  /*
	   * M�thode qui retourne les infos de tous les utilisateurs
	   * sur la base de données
	   */
	  /*
	  public static  java.sql.ResultSet select() {
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT * FROM User";
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
			
		}
	  */
	  /*
	   * Méthode qui permet de réaliser une connexion
	   * sur la base de données
	   */
	  public static  java.sql.ResultSet Connect(String text1,String text2) {
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT * FROM utilisateurs WHERE login='" + text1 + "' AND mdp='" + text2 + "' ";
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
			
		}
	  
	  // L'admin ajoute un scooter en envoyant ses informations
	  public static void InsertScooter(String num_scooter, String date_scooter) {
			Connection cn = getInstance();
			// Gestion d'erreur si un des champs est vide
			if (num_scooter.isEmpty() || date_scooter.isEmpty()) {
				JOptionPane.showMessageDialog(null, 
                      "Un des deux champs est vide !", 
                      "ERREUR", 
                      JOptionPane.ERROR_MESSAGE);
			}
			else {
			try {
				// Requ�te SQL pour ins�rer les infos dans la table scooter
				Statement st = cn.createStatement();
				String sql = "INSERT INTO scooter (numero, date) VALUES ('" + num_scooter + "','" 
						+ date_scooter + "')";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	  }
	  
	  public static void attribScooter(String id_scooter, String id_user) {
			Connection cn = getInstance();
			// Gestion d'erreur si un des champs est vide
			if (id_scooter.isEmpty() || id_user.isEmpty()) {
				JOptionPane.showMessageDialog(null, 
                    "Un des deux champs est vide !", 
                    "ERREUR", 
                    JOptionPane.ERROR_MESSAGE);
			}
			else {
			try {
				// Requ�te SQL pour modifier l'id utilisateur dans la table des scooters
				// TODO 
				Statement st = cn.createStatement();
				String sql = "UPDATE scooter SET id_user='" + id_user + "' WHERE id_scooter='" + id_scooter + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	  }

}


