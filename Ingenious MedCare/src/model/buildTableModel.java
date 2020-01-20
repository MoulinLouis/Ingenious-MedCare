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
	    	tabColumns = new String[]{"Id","Login","Email","Mot de passe","Prénom","Nom","Rôle"};
	    	break;
	    case "tabPatients":
	    	tabColumns = new String[]{"Id","Prénom","Nom","Date de naissance","Email","Genre","Pays","Métier"};
	    	break;
	    case "tabProduct":
	    	tabColumns = new String[]{"Id", "Nom du produit", "Classification", "Substance", "Excipient", "Conservation", "Toxicité"};
	    	break;
	    case "tabOrders":
	    	tabColumns = new String[]{"id", "Nom du produit", "quantité", "Date de la commande", "status"};
	    	break;
	    case "tabStock":
	    	tabColumns = new String[]{"id", "Nom du produit", "quantité"};
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
