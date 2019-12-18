package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class UserManagement extends SqlConnection{	
	// R�cup�rer tous les utilisateurs
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
	  // R�cup�rer un utilisateur par rapport � son id unique 
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
	  
	  public static  void deleteUser(String id) {
			Connection cn = getInstance();
			if (id.isEmpty()) {
				// A g�rer une gestion d'erreur
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
