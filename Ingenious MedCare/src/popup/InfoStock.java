package popup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.LayoutStyle.ComponentPlacement;

import SQL.OrdersManagement;
import SQL.ProductManagement;
import SQL.UserManagement;

import javax.swing.JTextField;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;
import java.sql.ResultSet;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InfoStock {

	private JDialog frmIngeniousMedcare;
	private JTextField textFieldQuantity;
	Toolkit toolkit = Toolkit.getDefaultToolkit();  
	Dimension screenSize = toolkit.getScreenSize();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoStock window = new InfoStock();
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
	public InfoStock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngeniousMedcare = new JDialog();
		frmIngeniousMedcare.setModalityType(ModalityType.APPLICATION_MODAL);
		frmIngeniousMedcare.setResizable(false);
		frmIngeniousMedcare.setType(Type.POPUP);
		frmIngeniousMedcare.setBounds(100, 100, 450, 300);
		frmIngeniousMedcare.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frmIngeniousMedcare.setTitle("Ingenious MedCare - Ajout d'une commande");
		int x = (screenSize.width - frmIngeniousMedcare.getWidth()) / 2;  
		int y = (screenSize.height - frmIngeniousMedcare.getHeight()) / 2;
		frmIngeniousMedcare.setLocation(x, y); 
		
		JPanel panel = new JPanel();
		frmIngeniousMedcare.getContentPane().add(panel, BorderLayout.CENTER);
		
		JComboBox comboBoxProduct = new JComboBox();
		
		 try
		 {
		    ResultSet Rs = ProductManagement.getAllMedicalProduct();
			    while (Rs.next())
			    {
			        //Pour affecter une valeur de base de données à un Combobox 
			    	comboBoxProduct.addItem(Rs.getString("nom"));
			    }
		 } 
		    catch
			(Exception e)
			{
			            System.out.print("impossible de se connecter à la base");
			}
		
		JLabel lblNewLabel = new JLabel("Add Commande");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Produit");
		
		JLabel lblNewLabel_2 = new JLabel("Quantit\u00E9");
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		
		JButton btnCommander = new JButton("Commander");
		btnCommander.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(comboBoxProduct.getSelectedItem().toString().equals("") || textFieldQuantity.getText().equals("")) {
					System.out.print("Un des champs est vide");
				} else {
					OrdersManagement.create(comboBoxProduct.getSelectedItem().toString(), textFieldQuantity.getText());
					frmIngeniousMedcare.dispose();
				}
			}
		});
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmIngeniousMedcare.dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(163, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(155))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(77)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(lblNewLabel_2))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(61)
							.addComponent(textFieldQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRetour)
								.addComponent(comboBoxProduct, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))))
					.addGap(143))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(234)
					.addComponent(btnCommander)
					.addContainerGap(125, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(comboBoxProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textFieldQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCommander)
						.addComponent(btnRetour))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
