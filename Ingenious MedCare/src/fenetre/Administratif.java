package fenetre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import static javax.swing.JOptionPane.showMessageDialog;

import SQL.*;
public class Administratif {

	private JFrame frmIngeniousMedcare;
	private JTable tableAllPatient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administratif window = new Administratif();
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
	public Administratif() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngeniousMedcare = new JFrame();
		frmIngeniousMedcare.setTitle("Ingenious MedCare - Administratif");
		frmIngeniousMedcare.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		GroupLayout gl_panelAccueil = new GroupLayout(panelAccueil);
		gl_panelAccueil.setHorizontalGroup(
			gl_panelAccueil.createParallelGroup(Alignment.LEADING)
				.addGap(0, 431, Short.MAX_VALUE)
		);
		gl_panelAccueil.setVerticalGroup(
			gl_panelAccueil.createParallelGroup(Alignment.LEADING)
				.addGap(0, 235, Short.MAX_VALUE)
		);
		panelAccueil.setLayout(gl_panelAccueil);
		
		JPanel panelPatients = new JPanel();
		tabbedPane.addTab("Patients", null, panelPatients, null);
		
		tableAllPatient = new JTable();
		
		JLabel lblListeDesPatients = new JLabel("Liste des patients");
		
		JButton btnAjouterUnPatient = new JButton("Ajouter un patient");
		GroupLayout gl_panelPatients = new GroupLayout(panelPatients);
		gl_panelPatients.setHorizontalGroup(
			gl_panelPatients.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPatients.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPatients.createParallelGroup(Alignment.LEADING)
						.addComponent(tableAllPatient, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelPatients.createSequentialGroup()
							.addComponent(lblListeDesPatients)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAjouterUnPatient)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelPatients.setVerticalGroup(
			gl_panelPatients.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPatients.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPatients.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListeDesPatients)
						.addComponent(btnAjouterUnPatient))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tableAllPatient, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelPatients.setLayout(gl_panelPatients);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
