package popup;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import SQL.PatientManagement;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoClient {

	private JDialog frmIngeniousMedcare;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldEmail;
	private JTextField textFieldAdresse;
	private JTextField textFieldVille;
	private JTextField textFieldCodePostal;
	private JTextField textFieldTel;
	private JTextField textFieldFix;
	private JTextField textFieldStatutCivil;
	private JTextField textFieldNumeroSecu;
	private JTextField textFieldNumeroMutuel;
	private JTextField textFieldMedecin;
	private JTextField textFieldPathologie;
	private JTextField textFieldNote;
	Toolkit toolkit = Toolkit.getDefaultToolkit();  
	Dimension screenSize = toolkit.getScreenSize();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int idPatient) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoClient window = new InfoClient(idPatient);
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
	public InfoClient(int idPatient) {
		initialize(idPatient);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idPatient) {
		frmIngeniousMedcare = new JDialog();
		frmIngeniousMedcare.setType(Type.POPUP);
		frmIngeniousMedcare.setModalityType(ModalityType.APPLICATION_MODAL);
		frmIngeniousMedcare.setTitle("Ingenious MedCare - Informations client");
		frmIngeniousMedcare.setBounds(100, 100, 450, 500);
		frmIngeniousMedcare.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		int x = (screenSize.width - frmIngeniousMedcare.getWidth()) / 2;  
		int y = (screenSize.height - frmIngeniousMedcare.getHeight()) / 2;
		frmIngeniousMedcare.setLocation(x, y);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmIngeniousMedcare.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(4))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnNewButton = new JButton("Valider");
		
		JButton btnNewButton_1 = new JButton("Modifier");
		
		JButton btnNewButton_2 = new JButton("Retour");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(360, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Info 1", null, panel_1, null);
		
		JLabel lblNewLabel = new JLabel("Information du client X");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNom = new JLabel("Nom");
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		
		JComboBox comboBoxGenre = new JComboBox();
		comboBoxGenre.setModel(new DefaultComboBoxModel(new String[] {"Homme", "Femme"}));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		JLabel lblEmail = new JLabel("Email");
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");

		JLabel lblVille = new JLabel("Ville");
		
		textFieldVille = new JTextField();
		textFieldVille.setColumns(10);
		
		JLabel lblCodePostal = new JLabel("Code postal");
		
		textFieldCodePostal = new JTextField();
		textFieldCodePostal.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel");
		
		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		
		textFieldFix = new JTextField();
		textFieldFix.setColumns(10);
		
		JLabel lblFix = new JLabel("Fix");
		
		JLabel lblGenre = new JLabel("Genre");
		
		JLabel lblPays = new JLabel("Pays");
		
		JComboBox comboBoxPays = new JComboBox();
		comboBoxPays.setModel(new DefaultComboBoxModel(new String[] {"Faire appel fichier JSON", "France", "Angleterre", "Etats-Unis", "Su\u00E8de", "Allemagne", "Portugal", "Espagne"}));
		
		JLabel lblMetier = new JLabel("M\u00E9tier");
		
		JComboBox comboBoxMetier = new JComboBox();
		comboBoxMetier.setModel(new DefaultComboBoxModel(new String[] {"Faire appel fichier JSON", "D\u00E9veloppeur web", "D\u00E9veloppeur logiciel"}));
		
	
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(67)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(textFieldNom, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textFieldPrenom, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNom)
					.addPreferredGap(ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
					.addComponent(lblPrnom, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(100))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresse)
						.addComponent(textFieldAdresse, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVille)
						.addComponent(textFieldVille, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodePostal)
						.addComponent(textFieldCodePostal, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldTel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTel)
						.addComponent(lblGenre)
						.addComponent(comboBoxGenre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxPays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPays)
						.addComponent(lblFix)
						.addComponent(textFieldFix, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMetier)
					.addContainerGap(276, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBoxMetier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(165, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNom)
						.addComponent(lblPrnom))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblAdresse)
							.addGap(6)
							.addComponent(textFieldAdresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblVille)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldVille, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblCodePostal)
							.addGap(6)
							.addComponent(textFieldCodePostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTel)
						.addComponent(lblFix))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldFix, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenre)
						.addComponent(lblPays))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxGenre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxPays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMetier)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxMetier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Info 2", null, panel_2, null);
		
		JLabel label = new JLabel("Information du client X");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblStatutCivil = new JLabel("Statut civil");
		
		textFieldStatutCivil = new JTextField();
		textFieldStatutCivil.setColumns(10);
		
		JLabel lblNumroDeScurit = new JLabel("Num\u00E9ro de s\u00E9curit\u00E9 social");
		
		textFieldNumeroSecu = new JTextField();
		textFieldNumeroSecu.setColumns(10);
		
		JLabel lblNumroDeMutuel = new JLabel("Num\u00E9ro de mutuel");
		
		textFieldNumeroMutuel = new JTextField();
		textFieldNumeroMutuel.setColumns(10);
		
		JLabel lblGroupeSanguin = new JLabel("Groupe sanguin");

		JComboBox comboBoxGroupeSanguin = new JComboBox();
		comboBoxGroupeSanguin.setModel(new DefaultComboBoxModel(new String[] {"O", "O+", "O-", "A+", "A-"}));
		
		JLabel lblMdecinTraitant = new JLabel("M\u00E9decin traitant");
		
		textFieldMedecin = new JTextField();
		textFieldMedecin.setColumns(10);
		
		JLabel lblPathologie = new JLabel("Pathologie");
		
		textFieldPathologie = new JTextField();
		textFieldPathologie.setColumns(10);
		
		JLabel lblNote = new JLabel("Note");
		
		textFieldNote = new JTextField();
		textFieldNote.setColumns(10);

		ResultSet rs = PatientManagement.getPatientById(idPatient);
		try {
			if(rs.next()){
				textFieldNom.setText(rs.getString("name"));
				textFieldPrenom.setText(rs.getString("firstName"));
				textFieldEmail.setText(rs.getString("email"));
				textFieldAdresse.setText(rs.getString("address"));
				textFieldVille.setText(rs.getString("city"));
				textFieldCodePostal.setText(rs.getString("postalCode"));
				textFieldTel.setText(rs.getString("phoneNumber"));
				textFieldFix.setText(rs.getString("homePhoneNumber"));
				textFieldStatutCivil.setText(rs.getString("civilStatus"));
				textFieldNumeroSecu.setText(rs.getString("socialSecurityNumber"));
				textFieldNumeroMutuel.setText(rs.getString("mutualNumber"));
				textFieldMedecin.setText(rs.getString("familyDoctor"));
				textFieldPathologie.setText(rs.getString("pathology"));
				textFieldNote.setText(rs.getString("note"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(67)
							.addComponent(label))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldStatutCivil, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStatutCivil)
								.addComponent(lblNumroDeScurit))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGroupeSanguin)
								.addComponent(lblNumroDeMutuel)
								.addComponent(textFieldNumeroMutuel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(textFieldMedecin, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textFieldPathologie, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldNumeroSecu, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMdecinTraitant))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPathologie, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxGroupeSanguin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNote, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(textFieldNote, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatutCivil)
						.addComponent(lblNumroDeMutuel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldStatutCivil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNumeroMutuel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumroDeScurit)
						.addComponent(lblGroupeSanguin))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNumeroSecu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxGroupeSanguin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMdecinTraitant)
						.addComponent(lblPathologie))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldMedecin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPathologie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNote)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(190, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Info 3", null, panel_3, null);
		
		JLabel label_1 = new JLabel("Information du client X");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 315, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(67)
					.addComponent(label_1)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 435, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1)
					.addContainerGap(403, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
