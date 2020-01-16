package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StockManagement extends SqlConnection{	
	
	// Récupérer tous le stock médical
	  public static  java.sql.ResultSet getAllMedicalProduct() {
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT S.id, S.id_medicalProduct, S.quantity FROM medicalstock AS S";
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  // Récupérer un médicament par rapport à son id unique
	  public static  java.sql.ResultSet getMedicalProductById(int id) {
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT S.id, S.medicalProduct, S.quantity FROM medicalstock AS S WHERE S.id = " + id;
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  
	  public static  void create(String id_medicalProduct,String quantity) {
			Connection cn = getInstance();
			if (id_medicalProduct.isEmpty() || quantity.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "INSERT INTO medicalstock (id_medicalProduct, quantity) "
						+ "VALUES ('" + id_medicalProduct + "','" + quantity + "')";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	  }
	  
	  public static  void updateMedicalProduct(String id, String id_medicalProduct,String quantity) {
			Connection cn = getInstance();
			if (id.isEmpty() || id_medicalProduct.isEmpty() || quantity.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "UPDATE medicalstock SET id_medicalProduct='" + id_medicalProduct + "',quantity='" + quantity + "' WHERE id ='" + id + "'";
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
				// A gérer une gestion d'erreur
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
