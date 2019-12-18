package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StockManagement extends SqlConnection{	
	// Récupérer tous le stock médical
	  public static  java.sql.ResultSet getAllMedicalStock() {
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT M.id, M.name, M.description, M.indication, M.laboratory, M.composition, M.quantity, M.cisCode, M.idToxicity FROM medicalstock AS M";
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  // Récupérer un médicament par rapport à son id unique
	  public static  java.sql.ResultSet getMedicalStockById(int id) {
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT M.id, M.name, M.description, M.indication, M.laboratory, M.composition, M.quantity, M.cisCode, M.idToxicity FROM medicalstock AS M WHERE M.id = " + id;
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  
	  public static  void createMedicalStock(String name,String description,String indication,String laboratory,String composition, String quantity,String cisCode,String idToxicity) {
			Connection cn = getInstance();
			if (name.isEmpty() || description.isEmpty() || indication.isEmpty() || laboratory.isEmpty() || composition.isEmpty() || quantity.isEmpty() || cisCode.isEmpty() || idToxicity.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "INSERT INTO medicalstock (name, description, indication, laboratory, composition, quantity, cisCode, idToxicity) "
						+ "VALUES ('" + name + "','" + description + "','" + indication + "','" + laboratory + "','" + composition + "','" + quantity + "','" + cisCode + "','" + idToxicity + "')";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	  }
	  
	  public static  void updateMedicalStock(String id, String name,String description,String indication,String laboratory,String composition, String quantity, String cisCode, String idToxicity) {
			Connection cn = getInstance();
			if (id.isEmpty() || name.isEmpty() || description.isEmpty() || indication.isEmpty() || laboratory.isEmpty() || composition.isEmpty() || quantity.isEmpty() || cisCode.isEmpty() || idToxicity.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "UPDATE medicalstock SET name='" + name + "',description='" + description + "',indication='" + indication + "', laboratory='" + laboratory + "',composition='" + composition + "',quantity='" + quantity + "',cisCode='" + cisCode + "',idToxicity='" + idToxicity + "' WHERE id ='" + id + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
	  
	  public static  void deleteMedicalStock(String id) {
			Connection cn = getInstance();
			if (id.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("L'id est vide");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "DELETE FROM medicalstock WHERE id='" + id + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
}
