package popup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import SQL.ProductManagement;
import SQL.SqlConnection;
import SQL.UserManagement;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addProductForm {

	private JDialog frmIngeniousMedcare;
	private JTextField textFieldClassification;
	private JTextField textFieldNom;
	private JTextField textFieldSubstance;
	private JTextField textFieldExcipient;
	private JTextField textFieldConservation;
	Toolkit toolkit = Toolkit.getDefaultToolkit();  
	Dimension screenSize = toolkit.getScreenSize();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addProductForm window = new addProductForm();
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
	public addProductForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngeniousMedcare = new JDialog();
		frmIngeniousMedcare.setType(Type.POPUP);
		frmIngeniousMedcare.setResizable(false);
		frmIngeniousMedcare.setBounds(100, 100, 450, 300);
		frmIngeniousMedcare.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		frmIngeniousMedcare.setModalityType(ModalityType.APPLICATION_MODAL);
		frmIngeniousMedcare.setResizable(false);
		frmIngeniousMedcare.setType(Type.POPUP);
		frmIngeniousMedcare.setTitle("Ingenious MedCare - Ajout Produit");
		frmIngeniousMedcare.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = (screenSize.width - frmIngeniousMedcare.getWidth()) / 2;  
		int y = (screenSize.height - frmIngeniousMedcare.getHeight()) / 2;
		frmIngeniousMedcare.setLocation(x, y);
		
		JPanel panel = new JPanel();
		frmIngeniousMedcare.getContentPane().add(panel, BorderLayout.CENTER);
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		
		textFieldClassification = new JTextField();
		textFieldClassification.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		
		JLabel lblClassification = new JLabel("Classification");
		
		textFieldSubstance = new JTextField();
		textFieldSubstance.setColumns(10);
		
		JLabel lblSubstance = new JLabel("Substance");
		
		textFieldExcipient = new JTextField();
		textFieldExcipient.setColumns(10);
		
		JLabel lblExcipient = new JLabel("Excipient");
		
		textFieldConservation = new JTextField();
		textFieldConservation.setColumns(10);
		
		JLabel lblConservation = new JLabel("Conservation");
		
		JComboBox comboBoxToxicity = new JComboBox();
		
		 try
		 {
			java.sql.ResultSet rs = null;
			Connection cn = SqlConnection.getInstance();
			Statement st = cn.createStatement();
			String sql = "SELECT T.libelle FROM toxicity AS T";
			rs = st.executeQuery(sql);
			while (rs.next())
			{
			        //Pour affecter une valeur de base de données à un Combobox 
				comboBoxToxicity.addItem(rs.getString("libelle"));
			}
		 } 
		    catch
			(Exception e)
			{
			   System.out.print("impossible de se connecter à la base");
			}
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProductManagement.create(textFieldNom.getText(), textFieldClassification.getText(), textFieldSubstance.getText(), textFieldExcipient.getText(), textFieldConservation.getText(), comboBoxToxicity.getSelectedItem().toString());
				frmIngeniousMedcare.dispose();
			}
		});
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmIngeniousMedcare.dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Toxicit\u00E9");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(75)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblClassification, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
								.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNom, 102, 102, 102)
								.addComponent(textFieldClassification, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
								.addComponent(lblSubstance, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
								.addComponent(textFieldSubstance, 102, 102, 102))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(textFieldExcipient, Alignment.LEADING, 173, 173, Short.MAX_VALUE)
									.addComponent(lblExcipient, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
									.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
										.addGap(10)
										.addComponent(lblConservation, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addGap(17))
									.addComponent(textFieldConservation, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(comboBoxToxicity, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
										.addGap(38)))
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(61))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(168)
							.addComponent(lblAddProduct, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addGap(90))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(134)
					.addComponent(btnRetour)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAjouter)
					.addContainerGap(166, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addComponent(lblAddProduct)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNom)
						.addComponent(lblExcipient))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldExcipient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClassification)
						.addComponent(lblConservation))
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldClassification, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldConservation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubstance)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldSubstance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxToxicity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRetour)
						.addComponent(btnAjouter))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
