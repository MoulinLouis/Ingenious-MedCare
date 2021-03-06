package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.OrdersModel;
import models.ProductModel;
import models.StockModel;

public class StockManagement extends SqlConnection{	
	
	// R�cup�rer tous le stock m�dical
	  public static  ArrayList<StockModel> getAllMedicalStock() {
		  
		  ArrayList<StockModel> stockList = new ArrayList<StockModel>();
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT S.id, P.nom, S.quantity FROM medicalstock AS S"
						+ " INNER JOIN medicalproduct AS P ON P.id = S.id_medicalProduct;";
				 rs = st.executeQuery(sql);
				 StockModel stock;
				 while(rs.next())
		           {
		               stock = new StockModel(rs.getInt("id"),rs.getString("nom"),rs.getInt("quantity"));
		               stockList.add(stock);
		               System.out.print(stock.getId());
		           }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stockList;		
		}
	  // R�cup�rer un m�dicament par rapport � son id unique
	  public static  java.sql.ResultSet getMedicalStockById(int id) {
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
				// A g�rer une gestion d'erreur
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
	  
	  public static  void updateMedicalStock(String id, String id_medicalProduct,String quantity) {
			Connection cn = getInstance();
			if (id.isEmpty() || id_medicalProduct.isEmpty() || quantity.isEmpty()) {
				// A g�rer une gestion d'erreur
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
	  
	  public static  void deleteMedicalStock(String id) {
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
