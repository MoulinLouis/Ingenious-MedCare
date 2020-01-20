package model;

import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import com.mysql.*;

public class buildTableModel {
	public static DefaultTableModel buildTableModel(ResultSet rs, String choosenTable) throws SQLException {
	    ResultSetMetaData metaData = rs.getMetaData();
	    String[] tabColumns = null;
	    switch(choosenTable) {
	    case "tabUsers":
	    	tabColumns = new String[]{"Id","Login","Email","Mot de passe","Pr�nom","Nom","R�le"};
	    	break;
	    case "tabPatients":
	    	tabColumns = new String[]{"Id","Pr�nom","Nom","Date de naissance","Email","Genre","Pays","M�tier"};
	    	break;
	    case "tabProduct":
	    	tabColumns = new String[]{"Id", "Nom du produit", "Classification", "Substance", "Excipient", "Conservation", "Toxicit�"};
	    	break;
	    case "tabOrders":
	    	tabColumns = new String[]{"id", "Nom du produit", "quantit�", "Date de la commande", "status"};
	    	break;
	    case "tabStock":
	    	tabColumns = new String[]{"id", "Nom du produit", "quantit�"};
	    	break;
	  }
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 0; column < columnCount; column++) {
	        columnNames.add(tabColumns[column]);
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }
	  
	    return new DefaultTableModel(data, columnNames);

	}
}
