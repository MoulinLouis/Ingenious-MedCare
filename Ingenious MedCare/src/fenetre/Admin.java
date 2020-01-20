package fenetre;
import SQL.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import SQL.UserManagement;
import model.buildTableModel;
import popup.InfoPatient;
import popup.addUserForm;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.FlowLayout;
import java.sql.SQLException;
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
	private JTable table_1;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngeniousMedcare = new JFrame();
		frmIngeniousMedcare.setTitle("Ingenious MedCare - Administrateur");
		frmIngeniousMedcare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngeniousMedcare.setExtendedState(JFrame.MAXIMIZED_BOTH);

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
		
		JPanel panelUtilisateura = new JPanel();
		tabbedPane.addTab("Utilisateurs", null, panelUtilisateura, null);
		
		JLabel lblListeDesUtilisateursa = new JLabel("Liste des utilisateurs");
		
		JButton btnAjouterUnUtilisateura = new JButton("Ajouter un utilisateur");
		
		JScrollPane scrollPaneUsers = new JScrollPane();
		GroupLayout gl_panelUtilisateura = new GroupLayout(panelUtilisateura);
		gl_panelUtilisateura.setHorizontalGroup(
			gl_panelUtilisateura.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUtilisateura.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUtilisateura.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneUsers, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
						.addGroup(gl_panelUtilisateura.createSequentialGroup()
							.addComponent(lblListeDesUtilisateursa)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAjouterUnUtilisateura)))
					.addContainerGap())
		);
		gl_panelUtilisateura.setVerticalGroup(
			gl_panelUtilisateura.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelUtilisateura.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUtilisateura.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListeDesUtilisateursa)
						.addComponent(btnAjouterUnUtilisateura))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneUsers, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		
		try {
			tableAllUsers = new JTable(buildTableModel.buildTableModel(UserManagement.getAllUser(), "tabUsers"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tableAllUsers.setEnabled(false);
		scrollPaneUsers.setViewportView(tableAllUsers);
		panelUtilisateura.setLayout(gl_panelUtilisateura);
		
		JPanel panelPatienta = new JPanel();
		tabbedPane.addTab("Patients", null, panelPatienta, null);
		
		JLabel lblListeDesPatientsa = new JLabel("Liste des patients");
		
		JButton btnAjouterUnPatienta = new JButton("Ajouter un patient");
		
		JScrollPane tableAllPatient = new JScrollPane();
		GroupLayout gl_panelPatienta = new GroupLayout(panelPatienta);
		gl_panelPatienta.setHorizontalGroup(
			gl_panelPatienta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPatienta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPatienta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPatienta.createSequentialGroup()
							.addComponent(lblListeDesPatientsa, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnAjouterUnPatienta, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
						.addComponent(tableAllPatient, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelPatienta.setVerticalGroup(
			gl_panelPatienta.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelPatienta.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panelPatienta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPatienta.createSequentialGroup()
							.addGap(4)
							.addComponent(lblListeDesPatientsa))
						.addComponent(btnAjouterUnPatienta))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tableAllPatient, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
		);
		
		try {
			table_1 = new JTable(buildTableModel.buildTableModel(PatientManagement.getAllPatient(), "tabPatients"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_1.setEnabled(false);
		tableAllPatient.setViewportView(table_1);
		panelPatienta.setLayout(gl_panelPatienta);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Stock", null, panel, null);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
