package fenetre;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import SQL.*;
import javax.swing.ImageIcon;

public class Login {
	private JFrame frmIngeniousMedcare;
	private JTextField fieldEmail;
	private JPasswordField fieldPassword;
	Toolkit toolkit = Toolkit.getDefaultToolkit();  
	Dimension screenSize = toolkit.getScreenSize();

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
		frmIngeniousMedcare.setBounds(100, 100, 600, 400);
		frmIngeniousMedcare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int x = (screenSize.width - frmIngeniousMedcare.getWidth()) / 2;  
		int y = (screenSize.height - frmIngeniousMedcare.getHeight()) / 2;
		frmIngeniousMedcare.setLocation(x, y);  

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
				if(fieldEmail.getText().equals("") || fieldPassword.getText().equals("")) {
					System.out.print("Un des champs est vide");
				} else {
					UserManagement.connectUser(fieldEmail.getText(), fieldPassword.getText(), frmIngeniousMedcare);
				}
			}
		});
		
		JLabel labelEmail = new JLabel("Email");
		
		fieldPassword = new JPasswordField();
		
		fieldEmail = new JTextField();
		fieldEmail.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/logo.png")));
		lblNewLabel.setSize(20, 20);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(117)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(125))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(252)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(labelEmail)
						.addComponent(lblMotDePasse)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnConnexion)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
						.addComponent(fieldPassword, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
						.addComponent(fieldEmail))
					.addGap(231))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelEmail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMotDePasse)
					.addGap(4)
					.addComponent(fieldPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConnexion)
					.addGap(55))
		);
		panel.setLayout(gl_panel);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
