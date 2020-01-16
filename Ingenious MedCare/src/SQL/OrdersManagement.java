package SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdersManagement extends SqlConnection{	
	
	// R�cup�rer les commandes
	  public static  java.sql.ResultSet getAllOrders() {
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT O.id, O.id_medicalProduct, O.quantity, O.orderDate, O.status FROM orders AS O";
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  // R�cup�rer une commande par rapport � son id unique
	  public static  java.sql.ResultSet getMedicalProductById(int id) {
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT O.id, O.id_medicalProduct, O.quantity, O.orderDate, O.status FROM orders AS O WHERE M.id = " + id;
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  
	  public static  void create(String nameProduct,String quantity) {
		  	ResultSet rs;
		  	long oderDate = System.currentTimeMillis();
			Connection cn = getInstance();
			if (nameProduct.isEmpty() || quantity.isEmpty()) {
				// A g�rer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sqlRecup = "SELECT M.id FROM medicalproduct AS M WHERE M.nom = " + nameProduct;
				rs = st.executeQuery(sqlRecup);
				String sql = "INSERT INTO orders (id_medicalProduct, quantity, orderDate) "
						+ "VALUES ('" + rs + "','" + quantity + "','" + oderDate + "')";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	  }
	  
	  public static  void updateMedicalProduct(String id, String nom,String classification,String substance,String excipient,String conservation, String toxicity) {
			Connection cn = getInstance();
			if (id.isEmpty() || nom.isEmpty() || classification.isEmpty() || substance.isEmpty() || excipient.isEmpty() || conservation.isEmpty() || toxicity.isEmpty()) {
				// A g�rer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "UPDATE medicalproduct SET nom='" + nom + "',classification='" + classification + "',substance='" + substance + "', excipient='" + excipient + "',conservation='" + conservation + "',toxicity='" + toxicity + "' WHERE id ='" + id + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
	  
	  public static  void deleteMedicalProduct(String id) {
			Connection cn = getInstance();
			if (id.isEmpty()) {
				// A g�rer une gestion d'erreur
				System.out.print("L'id est vide");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "DELETE FROM medicalproduct WHERE id='" + id + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
}
