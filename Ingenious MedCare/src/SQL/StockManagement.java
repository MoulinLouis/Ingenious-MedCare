package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StockManagement {
	static SqlConnection sqlconnection = new SqlConnection();
	
	  public static  java.sql.ResultSet select() {
		  java.sql.ResultSet rs =null;
			Connection cn = sqlconnection.getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT * FROM User";
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
			
		}
}
