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
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.TableModel;

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
		frmIngeniousMedcare.setBounds(100, 100, 450, 300);
		frmIngeniousMedcare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		GroupLayout gl_panelUtilisateur = new GroupLayout(panelUtilisateur);
		gl_panelUtilisateur.setHorizontalGroup(
			gl_panelUtilisateur.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUtilisateur.createSequentialGroup()
					.addContainerGap()
					.addComponent(tableAllUser, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelUtilisateur.setVerticalGroup(
			gl_panelUtilisateur.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelUtilisateur.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addComponent(tableAllUser, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
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
					.addComponent(tableAllStock, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelStock.setVerticalGroup(
			gl_panelStock.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelStock.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addComponent(tableAllStock, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
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
					.addComponent(tableAllPatient, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelPatient.setVerticalGroup(
			gl_panelPatient.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelPatient.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addComponent(tableAllPatient, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelPatient.setLayout(gl_panelPatient);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
