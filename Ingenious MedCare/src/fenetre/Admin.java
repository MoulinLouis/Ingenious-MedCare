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
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Accueil", null, panel, null);
		
		JLabel label = new JLabel("Bienvenue sur le logiciel Ingenious MedCare");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(104))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(99)
					.addComponent(label)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Utilisateur", null, panel_1, null);
		try {
			tableAllUser = new JTable(buildTableModel.buildTableModel(UserManagement.getAllUser()));
			tableAllUser.setEnabled(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(tableAllUser, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addComponent(tableAllUser, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Stock", null, panel_2, null);
		
		try {
			tableAllStock = new JTable(buildTableModel.buildTableModel(StockManagement.getAllMedicalStock()));
			tableAllStock.setEnabled(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(tableAllStock, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addComponent(tableAllStock, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Patient", null, panel_3, null);
		
		try {
			tableAllPatient = new JTable(buildTableModel.buildTableModel(PatientManagement.getAllPatient()));
			tableAllPatient.setEnabled(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(tableAllPatient, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addComponent(tableAllPatient, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
