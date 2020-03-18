package fenetre;
import SQL.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import models.OrdersModel;
import models.PatientModel;
import models.UserModel;
import popup.InfoPatient;
import popup.InfoProduct;
import popup.InfoUser;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Admin {

	private JFrame frmIngeniousMedcare;
	private JTable tableAllUsers;
	private JTable tableAllPatients;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frmIngeniousMedcare.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
		Show_Users_In_JTable();
		Show_Patients_In_JTable();
	}
	
	// Execute The Insert Update And Delete Querys
		public void executeSQlQuery(String query, String message)
		{
		   Connection cn = SqlConnection.getInstance();
		   Statement st;
		   try{
		       st = cn.createStatement();
		       if((st.executeUpdate(query)) == 1)
		       {
			    	// refresh jtable data
			    	//DefaultTableModel model = (DefaultTableModel)tableOrders.getModel();
			    	//model.setRowCount(0);
			    	//Show_Orders_In_JTable();    
		    	   JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
		       	}else{
		           JOptionPane.showMessageDialog(null, "Data Not "+message);
		        }
		        }catch(Exception ex){
		           ex.printStackTrace();
		       }
		 }
		 public void Show_Users_In_JTable()
		   {
			   ArrayList<UserModel> Userlist = UserManagement.getAllUser();
		       DefaultTableModel UserModel = (DefaultTableModel) tableAllUsers.getModel();
		       Object[] UserRow = new Object[7];
		       for(int i = 0; i < Userlist.size(); i++)
		       {
		    	   UserRow[0] = Userlist.get(i).getId();
		    	   UserRow[1] = Userlist.get(i).getLogin();
		    	   UserRow[2] = Userlist.get(i).getEmail();
		    	   UserRow[3] = Userlist.get(i).getPassword();
		    	   UserRow[4] = Userlist.get(i).getName();
		    	   UserRow[5] = Userlist.get(i).getFirstname();
		    	   UserRow[6] = Userlist.get(i).getIdRole();
		    	   
		    	   UserModel.addRow(UserRow);
		       }
		    }
		 public void Show_Patients_In_JTable()
		   {
			   ArrayList<PatientModel> PatientList = PatientManagement.getAllPatient();
		       DefaultTableModel PatientModel = (DefaultTableModel) tableAllPatients.getModel();
		       Object[] PatientRow = new Object[5];
		       for(int i = 0; i < PatientList.size(); i++)
		       {
		    	   PatientRow[0] = PatientList.get(i).getId();
		    	   PatientRow[1] = PatientList.get(i).getName();
		    	   PatientRow[2] = PatientList.get(i).getFirstName();
		    	   PatientRow[3] = PatientList.get(i).getBirthDate();
		    	   PatientRow[4] = PatientList.get(i).getEmail();
		    	   PatientRow[4] = PatientList.get(i).getGender();
		    	   PatientRow[4] = PatientList.get(i).getCountry();
		    	   PatientRow[4] = PatientList.get(i).getProfession();
		    	   
		           PatientModel.addRow(PatientRow);
		       }
		    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngeniousMedcare = new JFrame();
		frmIngeniousMedcare.setTitle("Ingenious MedCare - Administrateur");
		frmIngeniousMedcare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngeniousMedcare.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		tableAllUsers = new javax.swing.JTable();
		tableAllPatients = new javax.swing.JTable();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frmIngeniousMedcare.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
		);
		
		JPanel panelAccueil = new JPanel();
		tabbedPane.addTab("Accueil", null, panelAccueil, null);
		
		JLabel labelAccueil1 = new JLabel("Bienvenue sur le logiciel Ingenious MedCare");
		GroupLayout gl_panelAccueil = new GroupLayout(panelAccueil);
		gl_panelAccueil.setHorizontalGroup(
			gl_panelAccueil.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelAccueil.createSequentialGroup()
					.addGap(110)
					.addComponent(labelAccueil1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(104))
		);
		gl_panelAccueil.setVerticalGroup(
			gl_panelAccueil.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAccueil.createSequentialGroup()
					.addGap(99)
					.addComponent(labelAccueil1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(122))
		);
		panelAccueil.setLayout(gl_panelAccueil);
		
		JPanel panelUtilisateur = new JPanel();
		tabbedPane.addTab("Utilisateurs", null, panelUtilisateur, null);
		
		JLabel lblListeDesUtilisateurs = new JLabel("Liste des utilisateurs");
		
		JButton btnAjouterUnUtilisateur = new JButton("Ajouter un utilisateur");
		btnAjouterUnUtilisateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InfoUser addUserForm = new InfoUser(0);
				addUserForm.main(null, 0);
			}
		});
		
		JScrollPane scrollPaneUsers = new JScrollPane();
		GroupLayout gl_panelUtilisateur = new GroupLayout(panelUtilisateur);
		gl_panelUtilisateur.setHorizontalGroup(
			gl_panelUtilisateur.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUtilisateur.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUtilisateur.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneUsers, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
						.addGroup(gl_panelUtilisateur.createSequentialGroup()
							.addComponent(lblListeDesUtilisateurs)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAjouterUnUtilisateur)))
					.addContainerGap())
		);
		gl_panelUtilisateur.setVerticalGroup(
			gl_panelUtilisateur.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelUtilisateur.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUtilisateur.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListeDesUtilisateurs)
						.addComponent(btnAjouterUnUtilisateur))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneUsers, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		
		tableAllUsers.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Id", "Login", "Email", "Password", "Name", "Firstname", "Role"
                }
            ));
		tableAllUsers.setEnabled(false);
		scrollPaneUsers.setViewportView(tableAllUsers);
		panelUtilisateur.setLayout(gl_panelUtilisateur);
		
		tableAllUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = tableAllUsers.rowAtPoint(evt.getPoint());
		        //int col = tableAllPatient.columnAtPoint(evt.getPoint());
				int idUser = (int) tableAllUsers.getValueAt(row, 0);
		        InfoUser InfoUser = new InfoUser(idUser);
				InfoUser.main(null, idUser);
			}
		});
		
		JPanel panelPatient = new JPanel();
		tabbedPane.addTab("Patients", null, panelPatient, null);
		
		JLabel lblListeDesPatients = new JLabel("Liste des patients");
		
		JButton btnAjouterUnPatient = new JButton("Ajouter un patient");
		btnAjouterUnPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InfoPatient InfoClient = new InfoPatient(0);
				InfoClient.main(null, 0);
			}
		});
		
		JScrollPane scrollPanelPatient = new JScrollPane();
		GroupLayout gl_panelPatient = new GroupLayout(panelPatient);
		gl_panelPatient.setHorizontalGroup(
			gl_panelPatient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPatient.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPatient.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPatient.createSequentialGroup()
							.addComponent(lblListeDesPatients, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnAjouterUnPatient, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPanelPatient, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelPatient.setVerticalGroup(
			gl_panelPatient.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelPatient.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panelPatient.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPatient.createSequentialGroup()
							.addGap(4)
							.addComponent(lblListeDesPatients))
						.addComponent(btnAjouterUnPatient))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPanelPatient, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
		);
		
		tableAllPatients.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Id", "Name", "FirstName", "BirthDate", "Email", "Gender", "Country", "Profession"
                }
            ));
		tableAllPatients.setEnabled(false);
		scrollPanelPatient.setViewportView(tableAllPatients);
		panelPatient.setLayout(gl_panelPatient);
		
		tableAllPatients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = tableAllPatients.rowAtPoint(evt.getPoint());
		        //int col = tableAllPatient.columnAtPoint(evt.getPoint());
		        int idPatient = (int) tableAllPatients.getValueAt(row, 0);
				InfoPatient InfoClient = new InfoPatient(idPatient);
				InfoClient.main(null, idPatient);
			}
		});

		JPanel panelStock = new JPanel();
		tabbedPane.addTab("Stock", null, panelStock, null);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
