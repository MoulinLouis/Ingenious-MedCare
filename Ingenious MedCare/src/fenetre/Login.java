package fenetre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import SQL.*;

public class Login {
	private JFrame frmIngeniousMedcare;
	private JTextField textField;
	private JPasswordField passwordField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngeniousMedcare = new JFrame();
		frmIngeniousMedcare.setTitle("Ingenious MedCare - Connexion");
		frmIngeniousMedcare.setBounds(100, 100, 450, 300);
		frmIngeniousMedcare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmIngeniousMedcare.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
		);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/* Exemple de récupération d'une requête SELECT au clic
				java.sql.ResultSet sql = StockManagement.select();
				try {
					if(sql.next()) {
						String a = sql.getString("login");
						System.out.print(a);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				*/
				if(textField.getText().equals("stock") && passwordField.getText().equals("stock")) {
					Stock stock = new Stock();
					stock.main(null);
					frmIngeniousMedcare.dispose();
				} else if(textField.getText().equals("admin") && passwordField.getText().equals("admin")) {
					Administratif administratif = new Administratif();
					administratif.main(null);
					frmIngeniousMedcare.dispose();
				} else if(textField.getText().equals("adm") && passwordField.getText().equals("adm")) {
					Admin admin = new Admin();
					admin.main(null);
					frmIngeniousMedcare.dispose();
				}
			}
		});
		
		JLabel lblEmail = new JLabel("Email");
		
		passwordField = new JPasswordField();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(169)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnConnexion)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblMotDePasse)
							.addComponent(lblEmail)
							.addComponent(textField)
							.addComponent(passwordField)))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(95, Short.MAX_VALUE)
					.addComponent(lblEmail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(lblMotDePasse)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConnexion)
					.addGap(55))
		);
		panel.setLayout(gl_panel);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
