package fenetre;
import SQL.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import SQL.UserManagement;
import model.buildTableModel;

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

public class Admin {

	private JFrame frmIngeniousMedcare;
	private JTable tableAllUser;
	private JTable tableAllStock;
	private JTable tableAllPatient;

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
			gl_panelAccueil.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelAccueil.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(labelAccueil1)
					.addGap(104))
		);
		gl_panelAccueil.setVerticalGroup(
			gl_panelAccueil.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAccueil.createSequentialGroup()
					.addGap(99)
					.addComponent(labelAccueil1)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		panelAccueil.setLayout(gl_panelAccueil);
		
		JPanel panelUtilisateur = new JPanel();
		tabbedPane.addTab("Utilisateur", null, panelUtilisateur, null);
		try {
			tableAllUser = new JTable(buildTableModel.buildTableModel(UserManagement.getAllUser()));
			tableAllUser.setEnabled(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblListeDesUtilisateurs = new JLabel("Liste des utilisateurs");
		
		JButton btnAjouterUnUtilisateur = new JButton("Ajouter un utilisateur");
		btnAjouterUnUtilisateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addUserForm addUserForm = new addUserForm();
				addUserForm.main(null);
				frmIngeniousMedcare.dispose();
			}
		});
		GroupLayout gl_panelUtilisateur = new GroupLayout(panelUtilisateur);
		gl_panelUtilisateur.setHorizontalGroup(
			gl_panelUtilisateur.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUtilisateur.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUtilisateur.createParallelGroup(Alignment.LEADING)
						.addComponent(tableAllUser, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
						.addGroup(gl_panelUtilisateur.createSequentialGroup()
							.addComponent(lblListeDesUtilisateurs)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAjouterUnUtilisateur)))
					.addGap(12))
		);
		gl_panelUtilisateur.setVerticalGroup(
			gl_panelUtilisateur.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelUtilisateur.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUtilisateur.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListeDesUtilisateurs)
						.addComponent(btnAjouterUnUtilisateur))
					.addGap(13)
					.addComponent(tableAllUser, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelUtilisateur.setLayout(gl_panelUtilisateur);
		
		JPanel panelStock = new JPanel();
		tabbedPane.addTab("Stock", null, panelStock, null);
		
		try {
			tableAllStock = new JTable(buildTableModel.buildTableModel(StockManagement.getAllMedicalStock()));
			tableAllStock.setEnabled(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GroupLayout gl_panelStock = new GroupLayout(panelStock);
		gl_panelStock.setHorizontalGroup(
			gl_panelStock.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelStock.createSequentialGroup()
					.addContainerGap()
					.addComponent(tableAllStock, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
					.addGap(12))
		);
		gl_panelStock.setVerticalGroup(
			gl_panelStock.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelStock.createSequentialGroup()
					.addGap(47)
					.addComponent(tableAllStock, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelStock.setLayout(gl_panelStock);
		
		JPanel panelPatient = new JPanel();
		tabbedPane.addTab("Patient", null, panelPatient, null);
		
		try {
			tableAllPatient = new JTable(buildTableModel.buildTableModel(PatientManagement.getAllPatient()));
			tableAllPatient.setEnabled(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GroupLayout gl_panelPatient = new GroupLayout(panelPatient);
		gl_panelPatient.setHorizontalGroup(
			gl_panelPatient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPatient.createSequentialGroup()
					.addContainerGap()
					.addComponent(tableAllPatient, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
					.addGap(12))
		);
		gl_panelPatient.setVerticalGroup(
			gl_panelPatient.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelPatient.createSequentialGroup()
					.addGap(47)
					.addComponent(tableAllPatient, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelPatient.setLayout(gl_panelPatient);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
