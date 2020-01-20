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
	  }
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    System.out.print(columnCount);
	    for (int column = 0; column < columnCount; column++) {
	    	System.out.print(column);
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
