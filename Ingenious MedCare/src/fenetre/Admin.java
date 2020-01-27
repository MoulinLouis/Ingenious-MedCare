package fenetre;
import SQL.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import SQL.UserManagement;
import model.buildTableModel;
import popup.InfoPatient;
import popup.InfoUser;

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
		
		try {
			tableAllUsers = new JTable(buildTableModel.buildTableModel(UserManagement.getAllUser(), "tabUsers"));
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
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tableAllUsers.setEnabled(false);
		scrollPaneUsers.setViewportView(tableAllUsers);
		panelUtilisateur.setLayout(gl_panelUtilisateur);
		
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
		
		try {
			tableAllPatients = new JTable(buildTableModel.buildTableModel(PatientManagement.getAllPatient(), "tabPatients"));
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
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		scrollPanelPatient.setViewportView(tableAllPatients);
		panelPatient.setLayout(gl_panelPatient);
		
		JPanel panelStock = new JPanel();
		tabbedPane.addTab("Stock", null, panelStock, null);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
