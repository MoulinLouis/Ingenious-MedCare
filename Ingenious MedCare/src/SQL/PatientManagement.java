package SQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class PatientManagement extends SqlConnection{	
	// Récupérer tous les patients
	  public static  java.sql.ResultSet getAllPatient() {
		  java.sql.ResultSet rs = null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT P.id, P.name, P.firstName, P.birthDate, P.email, (SELECT C.value FROM combobox AS C WHERE C.id_comboBox = P.id_gender AND C.id_type = 1), (SELECT C.value FROM combobox AS C WHERE C.id_comboBox = P.id_country AND C.id_type = 2), (SELECT C.value FROM combobox AS C WHERE C.id_comboBox = P.id_profession AND C.id_type = 3) FROM patient AS P";
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  // Récupérer un patient par rapport à son id unique
	  public static java.sql.ResultSet getPatientById(int id) {
		  java.sql.ResultSet rs = null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT P.id, P.name, P.firstName, P.birthDate, P.email, P.id_gender, P.address, P.city, P.postalCode, P.phoneNumber, P.homePhoneNumber, P.id_country, P.id_profession, P.civilStatus, P.socialSecurityNumber, P.mutualNumber, P.id_bloodGroup, P.pathology, P.note, P.familyDoctor FROM patient AS P WHERE P.id = " + id;
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
	  
	  public static  void createPatient(String name,String firstName,String birthDate,String email,int id_gender, String address, String city, String postalCode, String phoneNumber, String homePhoneNumber, int id_country, int id_profession, String civilStatus, String socialSecurityNumber, String mutualNumber, int id_bloodGroup, String pathology, String note, String familyDoctor) {
			Connection cn = getInstance();
			if (name.isEmpty() || firstName.isEmpty() || birthDate.isEmpty() || email.isEmpty() || address.isEmpty() || city.isEmpty() || postalCode.isEmpty() || phoneNumber.isEmpty() || homePhoneNumber.isEmpty() || civilStatus.isEmpty() || socialSecurityNumber.isEmpty() || mutualNumber.isEmpty() || pathology.isEmpty() || note.isEmpty() || familyDoctor.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "INSERT INTO patient (name, firstName, birthDate, email, id_gender, address, city, postalCode, phoneNumber, homePhoneNumber, id_country, id_profession, civilStatus, socialSecurityNumber, mutualNumber, id_bloodGroup, pathology, note, familyDoctor) "
						+ "VALUES ('" + name + "','" + firstName + "','" + birthDate + "','" + email + "','" + id_gender + "','" + address + "','" + city + "','" + postalCode + "','" + phoneNumber + "','" + homePhoneNumber + "','" + id_country + "','" + id_profession + "','" + civilStatus + "','" + socialSecurityNumber + "','" + mutualNumber + "','" + id_bloodGroup + "','" + pathology + "','" + note + "','" + familyDoctor + "')";
				System.out.print(sql);
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	  }
	  
	  public static  void updatePatient(int id, String name,String firstName,String birthDate,String email,int id_gender, String address, String city, String postalCode, String phoneNumber, String homePhoneNumber, int id_country, int id_profession, String civilStatus, String socialSecurityNumber, String mutualNumber, int id_bloodGroup, String pathology, String note, String familyDoctor) {
			Connection cn = getInstance();
			if (name.isEmpty() || firstName.isEmpty() || birthDate.isEmpty() || email.isEmpty() || civilStatus.isEmpty() || mutualNumber.isEmpty() || pathology.isEmpty() || note.isEmpty() || familyDoctor.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "UPDATE patient SET name='" + name + "',firstName='" + firstName + "', birthDate='" + birthDate + "',email='" + email + "',id_gender='" + id_gender + "',address='" + address + "',city='" + city + "',postalCode='" + postalCode + "',phoneNumber='" + phoneNumber + "',homePhoneNumber='" + homePhoneNumber + "',id_country='" + id_country + "',id_profession='" + id_profession + "',civilStatus='" + civilStatus + "',socialSecurityNumber='" + socialSecurityNumber + "',mutualNumber='" + mutualNumber + "',id_bloodGroup='" + id_bloodGroup + "',pathology='" + pathology + "',note='" + note + "',familyDoctor='" + familyDoctor + "' WHERE id='" + id + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
	  
	  public static  void deletePatient(String id) {
			Connection cn = getInstance();
			if (id.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("L'id est vide");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "DELETE FROM patient WHERE id='" + id + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
	  
}
