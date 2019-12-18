package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StockManagement extends SqlConnection{	
	// R�cup�rer tous le stock m�dical
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
	  // R�cup�rer un m�dicament par rapport � son id unique
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
}
