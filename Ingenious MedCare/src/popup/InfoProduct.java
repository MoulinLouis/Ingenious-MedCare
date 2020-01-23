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

public class InfoProduct {

	private JDialog frmIngeniousMedcare;
	private JTextField textFieldClassification;
	private JTextField textFieldNom;
	private JTextField textFieldSubstance;
	private JTextField textFieldExcipient;
	private JTextField textFieldConservation;
	Toolkit toolkit = Toolkit.getDefaultToolkit();  
	Dimension screenSize = toolkit.getScreenSize();
	private boolean isEditable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int idProduct) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoProduct window = new InfoProduct(idProduct);
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
	public InfoProduct(int idProduct) {
		initialize(idProduct);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idProduct) {
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
		
		JButton btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(idProduct != 0) {
					ProductManagement.updateMedicalProduct(idProduct,textFieldNom.getText(), textFieldClassification.getText(), textFieldSubstance.getText(), textFieldExcipient.getText(), textFieldConservation.getText(), comboBoxToxicity.getSelectedItem().toString());
				}else {
					ProductManagement.create(textFieldNom.getText(), textFieldClassification.getText(), textFieldSubstance.getText(), textFieldExcipient.getText(), textFieldConservation.getText(), comboBoxToxicity.getSelectedItem().toString());
				}
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
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(isEditable == false) {
					isEditable = true;
					textFieldNom.setEditable(true);
					textFieldClassification.setEditable(true);
					textFieldSubstance.setEditable(true);
					textFieldExcipient.setEditable(true);
					textFieldConservation.setEditable(true);	
					comboBoxToxicity.setEnabled(true);
				} else if(isEditable == true) {
					isEditable = false;
					textFieldNom.setEditable(false);
					textFieldClassification.setEditable(false);
					textFieldSubstance.setEditable(false);
					textFieldExcipient.setEditable(false);
					textFieldConservation.setEditable(false);
					comboBoxToxicity.setEnabled(false);
				}

			}
		});
		
		ResultSet rsProduct = ProductManagement.getMedicalProductById(idProduct);
		try {
			if(rsProduct.next()){
				textFieldNom.setText(rsProduct.getString("nom"));
				textFieldClassification.setText(rsProduct.getString("classification"));
				textFieldSubstance.setText(rsProduct.getString("substance"));
				textFieldExcipient.setText(rsProduct.getString("excipient"));
				textFieldConservation.setText(rsProduct.getString("conservation"));
				comboBoxToxicity.setSelectedIndex(rsProduct.getInt("toxicity")-1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(idProduct != 0) {
			isEditable = false;
			textFieldNom.setEditable(false);
			textFieldClassification.setEditable(false);
			textFieldSubstance.setEditable(false);
			textFieldExcipient.setEditable(false);
			textFieldConservation.setEditable(false);
			comboBoxToxicity.setEnabled(false);
		}else {
			btnModifier.setVisible(false);
		}
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(75)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblClassification, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNom, 102, 102, 102)
								.addComponent(textFieldClassification, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(lblSubstance, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(textFieldSubstance, 102, 102, 102))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldExcipient, 173, 173, Short.MAX_VALUE)
								.addComponent(lblExcipient, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(lblConservation, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGap(17))
								.addComponent(textFieldConservation, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(comboBoxToxicity, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addGap(38))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(61))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(btnValider)
									.addGap(18)
									.addComponent(btnModifier))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(168)
							.addComponent(lblAddProduct, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addGap(90))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(98)
					.addComponent(btnRetour)
					.addContainerGap(281, Short.MAX_VALUE))
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
						.addComponent(btnValider)
						.addComponent(btnModifier))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
