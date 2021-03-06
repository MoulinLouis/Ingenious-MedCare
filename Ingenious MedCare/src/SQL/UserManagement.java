package SQL;

import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fenetre.Admin;
import fenetre.Administratif;
import fenetre.Stock;
import models.StockModel;
import models.UserModel;

public class UserManagement extends SqlConnection{	
	
	  public static void connectUser(String login,String password, JFrame frmIngeniousMedcare) {
		  java.sql.ResultSet rs =null;
			Connection cn = getInstance();
			String loginBase = "";
			String passwordBase = "";
			int idBase = 0;
			int roleIdBase = 0;
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT id, login, password, idRole FROM user WHERE login='" + login + "' AND password='" + password + "' ";
				rs = st.executeQuery(sql);
				if(rs.next()) {
					idBase = rs.getInt("id");
					loginBase = rs.getString("login");
					passwordBase = rs.getString("password");
					roleIdBase = rs.getInt("idRole");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(loginBase.isEmpty() && passwordBase.isEmpty()) {
				if(login.equals("adm") && password.equals("adm")) {
					showMessageDialog(null, "Connexion effectu�e en tant qu'administrateur avec succ�s !");
					Admin admin = new Admin();
					admin.main(null);
					frmIngeniousMedcare.dispose();
				} else {
					showMessageDialog(null, "Login ou mot de passe incorrect");
				}
			} else {
				if(login.equals(loginBase) && password.equals(passwordBase)) {
					if(roleIdBase == 2) {
						showMessageDialog(null, "Connexion effectu�e en tant que gestionnaire de stock avec succ�s !");
						Stock stock = new Stock(idBase);
						stock.main(null, idBase);
						frmIngeniousMedcare.dispose();
					} else if(roleIdBase == 1) {
						showMessageDialog(null, "Connexion effectu�e en tant qu'administratif avec succ�s !");
						Administratif administratif = new Administratif(idBase);
						administratif.main(null, idBase);
						frmIngeniousMedcare.dispose();
					}
				}
			}
		}
	
	// R�cup�rer tous les utilisateurs
	  public static  ArrayList<UserModel> getAllUser() {
		  ArrayList<UserModel> userList = new ArrayList<UserModel>();
		  java.sql.ResultSet rs = null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT U.id, U.login, U.email, U.password, U.name, U.firstName, U.idRole FROM user AS U";
				 rs = st.executeQuery(sql);
				 UserModel user;
				 while(rs.next())
		           {
		               user = new UserModel(rs.getInt("id"),rs.getString("login"),rs.getString("email"),rs.getString("password"),rs.getString("name"),rs.getString("firstname"),rs.getInt("idRole"));
		               userList.add(user);
		           }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userList;		
		}
	  // R�cup�rer un utilisateur par rapport � son id unique 
	  public static java.sql.ResultSet getUserById(int id) {
		  java.sql.ResultSet rs = null;
			Connection cn = getInstance();
			try {
				Statement st = cn.createStatement();
				String sql = "SELECT U.id, U.login, U.email, U.password, U.name, U.firstName, U.idRole FROM user AS U WHERE U.id = " + id;
				 rs = st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;		
		}
	  
	  public static  void createUser(String login,String email,String password,String name,String firstName, String idRole) {
			Connection cn = getInstance();
			if (login.isEmpty() || email.isEmpty() || password.isEmpty() || name.isEmpty() || firstName.isEmpty() || idRole.isEmpty()) {
				// A g�rer une gestion d'erreur
				showMessageDialog(null, "Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "INSERT INTO user (login, email, password, name, firstName, idRole) "
						+ "VALUES ('" + login + "','" + email + "','" + password + "','" + name + "','" + firstName + "','" + idRole + "')";
				st.executeUpdate(sql);
				showMessageDialog(null, "Insertion effectu� avec succ�s");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	  }
	  
	  public static  void updateUser(int idUser, String login,String email,String password,String name,String firstName, String idRole) {
			Connection cn = getInstance();
			if (login.isEmpty() || email.isEmpty() || password.isEmpty() || name.isEmpty() || firstName.isEmpty() || idRole.isEmpty()) {
				// A g�rer une gestion d'erreur
				System.out.print("Tous les champs ne sont pas remplis");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "UPDATE user SET login='" + login + "',email='" + email + "', password='" + password + "',name='" + name + "',firstName='" + firstName + "' WHERE idRole='" + idRole + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
	  
	  public static  void deleteUser(String id) {
			Connection cn = getInstance();
			if (id.isEmpty()) {
				// A g�rer une gestion d'erreur
				System.out.print("L'id est vide");
			}
			else {
			try {
				Statement st = cn.createStatement();
				String sql = "DELETE FROM user WHERE id='" + id + "'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }
}
