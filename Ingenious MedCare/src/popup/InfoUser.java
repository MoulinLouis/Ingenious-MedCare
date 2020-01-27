package popup;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import SQL.PatientManagement;
import SQL.UserManagement;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Dialog.ModalityType;
import java.awt.Dialog.ModalExclusionType;

public class InfoUser {

	private JDialog frmIngeniousMedcare;
	private JTextField fieldLogin;
	private JTextField fieldEmail;
	private JLabel lblEmail;
	private JTextField fieldMdp;
	private JLabel lblMotDePasse;
	private JTextField fieldNom;
	private JLabel lblNom;
	private JLabel lblPrnom;
	private JTextField fieldPrenom;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Toolkit toolkit = Toolkit.getDefaultToolkit();  
	Dimension screenSize = toolkit.getScreenSize();
	private boolean isEditable;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int idUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoUser window = new InfoUser(idUser);
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
	public InfoUser(int idUser) {
		initialize(idUser);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idUser) {
		frmIngeniousMedcare = new JDialog();
		frmIngeniousMedcare.setModalityType(ModalityType.APPLICATION_MODAL);
		frmIngeniousMedcare.setResizable(false);
		frmIngeniousMedcare.setType(Type.POPUP);
		frmIngeniousMedcare.setTitle("Ingenious MedCare - Ajout d'utilisateur");
		frmIngeniousMedcare.setBounds(100, 100, 500, 180);
		frmIngeniousMedcare.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = (screenSize.width - frmIngeniousMedcare.getWidth()) / 2;  
		int y = (screenSize.height - frmIngeniousMedcare.getHeight()) / 2;
		frmIngeniousMedcare.setLocation(x, y); 
		
		JPanel panelAddUser = new JPanel();
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmIngeniousMedcare.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelAddUser, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
				.addComponent(panelAddUser, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
		);
		JRadioButton radioBtnStock = new JRadioButton("Stock");
		buttonGroup.add(radioBtnStock);
		
		JRadioButton radioBtnAdministratif = new JRadioButton("Administratif");
		buttonGroup.add(radioBtnAdministratif);

		JButton btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String radioBtnSelected = "";
				if(radioBtnStock.isSelected()) {
					radioBtnSelected = "2";
				} else if(radioBtnAdministratif.isSelected()) {
					radioBtnSelected = "1";
				}
				if(idUser != 0) {
					UserManagement.updateUser(idUser, fieldLogin.getText(), fieldEmail.getText(), fieldMdp.getText(), fieldNom.getText(), fieldPrenom.getText(), radioBtnSelected);
				} else {
					UserManagement.createUser(fieldLogin.getText(), fieldEmail.getText(), fieldMdp.getText(), fieldNom.getText(), fieldPrenom.getText(), radioBtnSelected);
				}
				frmIngeniousMedcare.dispose();
			}
		});
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isEditable == false) {
					isEditable = true;
					fieldLogin.setEditable(true);
					fieldEmail.setEditable(true);
					fieldMdp.setEditable(true);
					fieldNom.setEditable(true);
					fieldPrenom.setEditable(true);
					radioBtnStock.setEnabled(true);
					radioBtnAdministratif.setEnabled(true);				
				} else if(isEditable == true) {
					isEditable = false;
					fieldLogin.setEditable(false);
					fieldEmail.setEditable(false);
					fieldMdp.setEditable(false);
					fieldNom.setEditable(false);
					fieldPrenom.setEditable(false);
					radioBtnStock.setEnabled(false);
					radioBtnAdministratif.setEnabled(false);
				}
			}
		});
		
		JButton button_2 = new JButton("Retour");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmIngeniousMedcare.dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(btnModifier, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(btnValider, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(181, Short.MAX_VALUE)
					.addComponent(button_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModifier)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnValider)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JLabel labelLogin = new JLabel("Login");
		
		fieldLogin = new JTextField();
		fieldLogin.setColumns(10);
		
		fieldEmail = new JTextField();
		fieldEmail.setColumns(10);
		
		lblEmail = new JLabel("Email");
		
		fieldMdp = new JTextField();
		fieldMdp.setColumns(10);
		
		lblMotDePasse = new JLabel("Mot de passe");
		
		fieldNom = new JTextField();
		fieldNom.setColumns(10);
		
		lblNom = new JLabel("Nom");
		
		lblPrnom = new JLabel("Pr\u00E9nom");
		
		fieldPrenom = new JTextField();
		fieldPrenom.setColumns(10);
		
		ResultSet rs_Patient = UserManagement.getUserById(idUser);
		try {
			if(rs_Patient.next()){
				fieldLogin.setText(rs_Patient.getString("login"));
				fieldEmail.setText(rs_Patient.getString("email"));
				fieldMdp.setText(rs_Patient.getString("password"));
				fieldNom.setText(rs_Patient.getString("name"));
				fieldPrenom.setText(rs_Patient.getString("firstName"));
				if(rs_Patient.getString("idRole").equals("1")) {
					radioBtnAdministratif.setSelected(true);
				} else if(rs_Patient.getString("idRole").equals("2")) {
					radioBtnStock.setSelected(true);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(idUser != 0) {
			isEditable = false;
			fieldLogin.setEditable(false);
			fieldEmail.setEditable(false);
			fieldMdp.setEditable(false);
			fieldNom.setEditable(false);
			fieldPrenom.setEditable(false);
			radioBtnStock.setEnabled(false);
			radioBtnAdministratif.setEnabled(false);
		}
		
		JLabel lblAjouterUnUtilisateur = new JLabel("Ajouter un utilisateur");
		lblAjouterUnUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panelAddUser = new GroupLayout(panelAddUser);
		gl_panelAddUser.setHorizontalGroup(
			gl_panelAddUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAddUser.createSequentialGroup()
					.addContainerGap()
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
											.addComponent(fieldMdp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNom))
										.addGroup(gl_panelAddUser.createSequentialGroup()
											.addComponent(fieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblEmail)))
									.addGap(32)
									.addGroup(gl_panelAddUser.createParallelGroup(Alignment.LEADING)
										.addComponent(fieldNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelAddUser.createSequentialGroup()
									.addComponent(fieldPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(radioBtnStock)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(radioBtnAdministratif))))
						.addGroup(gl_panelAddUser.createSequentialGroup()
							.addComponent(lblAjouterUnUtilisateur)
							.addGap(83)))
					.addContainerGap(26, Short.MAX_VALUE))
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
						.addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelAddUser.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelLogin)
							.addComponent(fieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(3)
					.addGroup(gl_panelAddUser.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAddUser.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblMotDePasse)
							.addComponent(fieldMdp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelAddUser.createParallelGroup(Alignment.BASELINE)
							.addComponent(fieldNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNom)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAddUser.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAddUser.createParallelGroup(Alignment.BASELINE)
							.addComponent(fieldPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(radioBtnStock)
							.addComponent(radioBtnAdministratif))
						.addComponent(lblPrnom))
					.addContainerGap(139, Short.MAX_VALUE))
		);
		panelAddUser.setLayout(gl_panelAddUser);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
