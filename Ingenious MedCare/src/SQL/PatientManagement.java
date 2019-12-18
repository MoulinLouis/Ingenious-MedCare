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
				String sql = "SELECT P.id, P.name, P.firstName, P.birthDate, P.email, P.gender, P.address, P.city, P.postalCode, P.phoneNumber, P.homePhoneNumber, P.country, P.profession, P.civilStatus, P.socialSecurityNumber, P.mutualNumber, P.bloodGroup, P.pathology, P.note, P.familyDoctor FROM patient AS P";
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
				String sql = "SELECT P.id, P.name, P.firstName, P.birthDate, P.email, P.gender, P.address, P.city, P.postalCode, P.phoneNumber, P.homePhoneNumber, P.country, P.profession, P.civilStatus, P.socialSecurityNumber, P.mutualNumber, P.bloodGroup, P.pathology, P.note, P.familyDoctor FROM patient AS P WHERE P.id = " + id;
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  
	  public static  void createPatient(String name,String firstName,String birthDate,String email,String gender, String address, String city, String postalCode, String phoneNumber, String homePhoneNumber, String country, String profession, String civilStatus, String mutualNumber, String bloodGroup, String pathology, String note, String familyDoctor) {
			Connection cn = getInstance();
			if (name.isEmpty() || firstName.isEmpty() || birthDate.isEmpty() || email.isEmpty() || gender.isEmpty() || address.isEmpty() || city.isEmpty() || postalCode.isEmpty() || phoneNumber.isEmpty() || homePhoneNumber.isEmpty() || country.isEmpty() || profession.isEmpty() || civilStatus.isEmpty() || mutualNumber.isEmpty() || bloodGroup.isEmpty() || pathology.isEmpty() || note.isEmpty() || familyDoctor.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "INSERT INTO utilisateurs (name, firstName, birthDate, email, gender, address, city, postalCode, phoneNumber, homePhoneNumber, country, profession, civilStatus, mutualNumber, bloodGroup, pathology, note, familyDoctor) "
						+ "VALUES ('" + name + "','" + firstName + "','" + birthDate + "','" + email + "','" + gender + "','" + address + "','" + city + "','" + postalCode + "','" + phoneNumber + "','" + homePhoneNumber + "','" + country + "','" + profession + "','" + civilStatus + "','" + mutualNumber + "','" + bloodGroup + "','" + pathology + "','" + note + "','" + familyDoctor + "')";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	  }
	  
	  public static  void updatePatient(String id, String name,String firstName,String birthDate,String email,String gender, String address, String city, String postalCode, String phoneNumber, String homePhoneNumber, String country, String profession, String civilStatus, String mutualNumber, String bloodGroup, String pathology, String note, String familyDoctor) {
			Connection cn = getInstance();
			if (name.isEmpty() || firstName.isEmpty() || birthDate.isEmpty() || email.isEmpty() || gender.isEmpty() || address.isEmpty() || city.isEmpty() || postalCode.isEmpty() || phoneNumber.isEmpty() || homePhoneNumber.isEmpty() || country.isEmpty() || profession.isEmpty() || civilStatus.isEmpty() || mutualNumber.isEmpty() || bloodGroup.isEmpty() || pathology.isEmpty() || note.isEmpty() || familyDoctor.isEmpty()) {
				// A gérer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "UPDATE user SET name='" + name + "',firstName='" + firstName + "', birthDate='" + birthDate + "',email='" + email + "',gender='" + gender + "',address='" + address + "',city='" + city + "',postalCode='" + postalCode + "',phoneNumber='" + phoneNumber + "',homePhoneNumber='" + homePhoneNumber + "',country='" + country + "',profession='" + profession + "',civilStatus='" + civilStatus + "',mutualNumber='" + mutualNumber + "',bloodGroup='" + bloodGroup + "',pathology='" + pathology + "',note='" + note + "',familyDoctor='" + familyDoctor + "' WHERE id='" + id + "'";
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
