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
				String sql = "SELECT M.id, M.nom, M.classification, M.substance, M.excipient, M.conservation, M.toxicity FROM medicalproduct AS M";
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
				String sql = "SELECT M.id, M.nom, M.classification, M.substance, M.excipient, M.conservation, M.toxicity FROM medicalproduct AS M WHERE M.id = " + id;
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  
	  public static  void create(String nom,String classification,String substance,String excipient,String conservation, String toxicity) {
			Connection cn = getInstance();
			if (nom.isEmpty() || classification.isEmpty() || substance.isEmpty() || excipient.isEmpty() || conservation.isEmpty() || toxicity.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "INSERT INTO medicalproduct (nom, classification, substance, excipient, conservation, quantity, cisCode, idToxicity) "
						+ "VALUES ('" + nom + "','" + classification + "','" + substance + "','" + excipient + "','" + conservation + "','" + toxicity + "')";
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
				// A gérer une gestion d'erreur
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
