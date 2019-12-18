package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class UserManagement extends SqlConnection{	
	// Récupérer tous les utilisateurs
	  public static  java.sql.ResultSet getAllUser() {
		  java.sql.ResultSet rs = null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT U.id, U.login, U.email, U.password, U.name, U.firstName, U.idRole FROM user AS U";
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  // Récupérer un utilisateur par rapport à son id unique 
	  public static java.sql.ResultSet getUserById(int id) {
		  java.sql.ResultSet rs = null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT U.id, U.login, U.email, U.password, U.name, U.firstName, U.idRole FROM user AS U WHERE U.id = " + id;
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  
	  public static  void createUser(String login,String email,String password,String name,String firstName, String idRole) {
			Connection cn = getInstance();
			if (login.isEmpty() || email.isEmpty() || password.isEmpty() || name.isEmpty() || firstName.isEmpty() || idRole.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "INSERT INTO utilisateurs (login, email, password, name, firstName, idRole) "
						+ "VALUES ('" + login + "','" + email + "','" + password + "','" + name + "','" + firstName + "','" + idRole + "')";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	  }
	  
	  public static  void updateUser(String id, String login,String email,String password,String name,String firstName, String idRole) {
			Connection cn = getInstance();
			if (id.isEmpty() || login.isEmpty() || email.isEmpty() || password.isEmpty() || name.isEmpty() || firstName.isEmpty() || idRole.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "UPDATE user SET login='" + login + "',email='" + email + "', password='" + password + "',name='" + name + "',firstName='" + firstName + "' WHERE idRole='" + idRole + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
	  
	  public static  void deleteUser(String id) {
			Connection cn = getInstance();
			if (id.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("L'id est vide");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "DELETE FROM user WHERE id='" + id + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
}
