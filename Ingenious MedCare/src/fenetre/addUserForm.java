package fenetre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addUserForm {

	private JFrame frmIngeniousMedcare;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblEmail;
	private JTextField textField_2;
	private JLabel lblMotDePasse;
	private JTextField textField_3;
	private JLabel lblNom;
	private JLabel lblPrnom;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addUserForm window = new addUserForm();
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
	public addUserForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngeniousMedcare = new JFrame();
		frmIngeniousMedcare.setTitle("Ingenious MedCare - Ajout d'utilisateur");
		frmIngeniousMedcare.setBounds(100, 100, 450, 300);
		frmIngeniousMedcare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelAddUser = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmIngeniousMedcare.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelAddUser, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelAddUser, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		
		JLabel labelLogin = new JLabel("Login");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		lblEmail = new JLabel("Email");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		lblMotDePasse = new JLabel("Mot de passe");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		lblNom = new JLabel("Nom");
		
		lblPrnom = new JLabel("Pr\u00E9nom");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblAjouterUnUtilisateur = new JLabel("Ajouter un utilisateur");
		lblAjouterUnUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnCrerLutilisateur = new JButton("Cr\u00E9er l'utilisateur");
		
		JRadioButton radioBtnStock = new JRadioButton("Stock");
		buttonGroup.add(radioBtnStock);
		
		JRadioButton radioBtnAdministratif = new JRadioButton("Administratif");
		buttonGroup.add(radioBtnAdministratif);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Admin admin = new Admin();
				admin.main(null);
				frmIngeniousMedcare.dispose();
			}
		});
		GroupLayout gl_panelAddUser = new GroupLayout(panelAddUser);
		gl_panelAddUser.setHorizontalGroup(
			gl_panelAddUser.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelAddUser.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_panelAddUser.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelAddUser.createSequentialGroup()
							.addGroup(gl_panelAddUser.createParallelGroup(Alignment.LEADING)
								.addComponent(labelLogin)
								.addComponent(lblMotDePasse)
								.addComponent(lblPrnom))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelAddUser.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelAddUser.createSequentialGroup()
									.addGroup(gl_panelAddUser.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelAddUser.createSequentialGroup()
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNom))
										.addGroup(gl_panelAddUser.createSequentialGroup()
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblEmail)))
									.addGap(32)
									.addGroup(gl_panelAddUser.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelAddUser.createSequentialGroup()
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(radioBtnStock)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(radioBtnAdministratif))))
						.addGroup(gl_panelAddUser.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 81, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAjouterUnUtilisateur)
							.addGap(83))
						.addGroup(gl_panelAddUser.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 55, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnRetour)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCrerLutilisateur)
							.addGap(75)))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_panelAddUser.setVerticalGroup(
			gl_panelAddUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAddUser.createSequentialGroup()
					.addGap(19)
					.addComponent(lblAjouterUnUtilisateur)
					.addGap(23)
					.addGroup(gl_panelAddUser.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAddUser.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEmail))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelAddUser.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelLogin)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(3)
					.addGroup(gl_panelAddUser.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAddUser.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblMotDePasse)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelAddUser.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNom)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAddUser.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAddUser.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radioBtnStock)
							.addComponent(radioBtnAdministratif))
						.addComponent(lblPrnom))
					.addGap(18)
					.addGroup(gl_panelAddUser.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCrerLutilisateur)
						.addComponent(btnRetour))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		panelAddUser.setLayout(gl_panelAddUser);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
