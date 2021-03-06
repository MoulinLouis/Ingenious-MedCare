package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import models.ProductModel;

public class ProductManagement extends SqlConnection{	
	
	// R�cup�rer tous le stock m�dical
	  public static  ArrayList<ProductModel> getAllMedicalProduct() {
		  
		  ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT P.id, P.nom, P.classification, P.substance, P.excipient, P.conservation, T.libelle FROM medicalproduct AS P"
						+ " INNER JOIN toxicity AS T ON T.id = P.toxicity;";
				 rs = st.executeQuery(sql);
				 ProductModel product;
				 while(rs.next())
		           {
					 product = new ProductModel(rs.getInt("id"),rs.getString("nom"),rs.getString("classification"),rs.getString("substance"), rs.getString("excipient"), rs.getString("conservation"), rs.getString("libelle"));
					 productList.add(product);
		               System.out.print(product.getId());
		           }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return productList;		
		}
	  // R�cup�rer un m�dicament par rapport � son id unique
	  public static  java.sql.ResultSet getMedicalProductById(int id) {
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT P.id, P.nom, P.classification, P.substance, P.excipient, P.conservation, P.toxicity FROM medicalproduct AS P WHERE P.id = " + id;
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  
	  public static  void create(String nom,String classification,String substance,String excipient,String conservation, String toxicity) {
		  	java.sql.ResultSet rs =null;
		  	Connection cn = getInstance();
			if (nom.isEmpty() || classification.isEmpty() || substance.isEmpty() || excipient.isEmpty() || conservation.isEmpty() || toxicity.isEmpty()) {
				// A g�rer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				
				Statement st = cn.createStatement();
				String sqlRecup = "SELECT T.id FROM toxicity AS T WHERE T.libelle ="+"'"+toxicity+"'";
				rs = st.executeQuery(sqlRecup);
			    rs.next();
			    String idToxicity = rs.getString("id");
				String sql = "INSERT INTO medicalproduct (nom, classification, substance, excipient, conservation, toxicity) "
						+ "VALUES ('" + nom + "','" + classification + "','" + substance + "','" + excipient + "','" + conservation + "','" + idToxicity + "')";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	  }
	  
	  public static  void updateMedicalProduct(Integer id, String nom,String classification,String substance,String excipient,String conservation, String toxicity) {
		  java.sql.ResultSet rs =null;
		  Connection cn = getInstance();
			if (nom.isEmpty() || classification.isEmpty() || substance.isEmpty() || excipient.isEmpty() || conservation.isEmpty() || toxicity.isEmpty()) {
				// A g�rer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sqlRecup = "SELECT T.id FROM toxicity AS T WHERE T.libelle ="+"'"+toxicity+"'";
				rs = st.executeQuery(sqlRecup);
			    rs.next();
			    String idToxicity = rs.getString("id");
				String sql = "UPDATE medicalproduct SET nom='" + nom + "',classification='" + classification + "',substance='" + substance + "', excipient='" + excipient + "',conservation='" + conservation + "',toxicity='" + idToxicity + "' WHERE id ='" + id + "'";
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
