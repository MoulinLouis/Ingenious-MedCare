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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
public class Administratif {

	private JFrame frmIngeniousMedcare;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int connectedId) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administratif window = new Administratif(connectedId);
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
	public Administratif(int connectedId) {
		initialize(connectedId);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int connectedId) {
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
		
		JLabel lblListeDesPatients = new JLabel("Liste des patients");
		
		JButton btnAjouterUnPatient = new JButton("Ajouter un patient");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelPatients = new GroupLayout(panelPatients);
		gl_panelPatients.setHorizontalGroup(
			gl_panelPatients.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPatients.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPatients.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPatients.createSequentialGroup()
							.addComponent(lblListeDesPatients)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAjouterUnPatient))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_panelPatients.setVerticalGroup(
			gl_panelPatients.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPatients.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPatients.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListeDesPatients)
						.addComponent(btnAjouterUnPatient))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelPatients.setLayout(gl_panelPatients);
		
		JPanel panelMonCompte = new JPanel();
		tabbedPane.addTab("Mon compte", null, panelMonCompte, null);
		
		JLabel label = new JLabel("Login");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("Mot de passe");
		
		JLabel label_2 = new JLabel("Pr\u00E9nom");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label_3 = new JLabel("Email");
		
		JLabel label_4 = new JLabel("Nom");
		GroupLayout gl_panelMonCompte = new GroupLayout(panelMonCompte);
		gl_panelMonCompte.setHorizontalGroup(
			gl_panelMonCompte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMonCompte.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_panelMonCompte.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_panelMonCompte.setVerticalGroup(
			gl_panelMonCompte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMonCompte.createSequentialGroup()
					.addGap(43)
					.addGap(1)
					.addGroup(gl_panelMonCompte.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_panelMonCompte.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panelMonCompte.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(538, Short.MAX_VALUE))
		);
		panelMonCompte.setLayout(gl_panelMonCompte);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
