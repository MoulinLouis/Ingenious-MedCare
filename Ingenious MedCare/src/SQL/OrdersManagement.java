package SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class OrdersManagement extends SqlConnection{	
	
	// Récupérer les commandes
	  public static  java.sql.ResultSet getAllOrders() {
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT O.id, P.nom, O.quantity, O.orderDate, O.status FROM orders AS O"
							+" INNER JOIN medicalproduct AS P ON P.id = O.id_medicalProduct;";
				System.out.print(sql);
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  // Récupérer une commande par rapport à son id unique
	  public static  java.sql.ResultSet getOrdersById(int id) {
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
		  	java.sql.ResultSet rs =null;
		  	LocalDate oderDate = LocalDate.now();
			Connection cn = getInstance();
			if (nameProduct.isEmpty() || quantity.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sqlRecup = "SELECT M.id FROM medicalproduct AS M WHERE M.nom ="+"'"+nameProduct+"'";
				rs = st.executeQuery(sqlRecup);
			    rs.next();
			    String idMedicalProduct = rs.getString("id");
				String sql = "INSERT INTO orders (id_medicalProduct, quantity, orderDate) "
						+ "VALUES ('" + idMedicalProduct + "','" + quantity + "','" + oderDate + "')";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	  }
	  
	  public static  void updateOrders(String id, String id_medicalProduct,String quantity,String orderDate,String status) {
			Connection cn = getInstance();
			if (id.isEmpty() || id_medicalProduct.isEmpty() || quantity.isEmpty() || orderDate.isEmpty() || status.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "UPDATE orders SET id_medicalProduct='" + id_medicalProduct + "',quantity='" + quantity + "',orderDate='" + orderDate + "', status='" + status + "' WHERE id ='" + id + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
	  
	  public static  void deleteOrders(String id) {
			Connection cn = getInstance();
			if (id.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("L'id est vide");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "DELETE FROM orders WHERE id='" + id + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
}
