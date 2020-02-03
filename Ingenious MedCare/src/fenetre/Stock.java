package fenetre;

import SQL.*;
import extensions.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import model.buildTableModel;
import popup.InfoProduct;
import popup.InfoUser;
import popup.InfoStock;
import popup.InfoProduct;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.TableModel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Stock {

	private JFrame frmIngeniousMedcare;
	public static JTable tableProduct;
	public JTable tableOrders;
	public JTable tableStock;
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
					Stock window = new Stock(connectedId);
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
	public Stock(int connectedId) {
		initialize(connectedId);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int connectedId) {
		frmIngeniousMedcare = new JFrame();
		frmIngeniousMedcare.setTitle("Ingenious MedCare - Stock");
		frmIngeniousMedcare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngeniousMedcare.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		frmIngeniousMedcare.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu menuOptions = new JMenu("Options");
		menuBar.add(menuOptions);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Mon compte");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/* Mettre pour infoUser
				InfoUser administratif = new Administratif(idBase);
				administratif.main(null, idBase);
				frmIngeniousMedcare.dispose();
				*/
			}
		});
		menuOptions.add(mntmNewMenuItem);
		
		JMenuItem mntmSeDconnecter = new JMenuItem("Se d\u00E9connecter");
		menuOptions.add(mntmSeDconnecter);
		
		JList list = new JList();
		menuBar.add(list);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmIngeniousMedcare.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelAccueil = new JPanel();
		tabbedPane.addTab("Accueil", null, panelAccueil, null);
		
		JLabel label = new JLabel("Bienvenue sur le logiciel Ingenious MedCare");
		GroupLayout gl_panelAccueil = new GroupLayout(panelAccueil);
		gl_panelAccueil.setHorizontalGroup(
			gl_panelAccueil.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 429, Short.MAX_VALUE)
				.addGroup(gl_panelAccueil.createSequentialGroup()
					.addGap(103)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addGap(97))
		);
		gl_panelAccueil.setVerticalGroup(
			gl_panelAccueil.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 208, Short.MAX_VALUE)
				.addGroup(gl_panelAccueil.createSequentialGroup()
					.addGap(103)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(96))
		);
		panelAccueil.setLayout(gl_panelAccueil);
		
		JPanel panelStock = new JPanel();
		tabbedPane.addTab("Stock", null, panelStock, null);
		
		JLabel label_1 = new JLabel("Liste du stock");
		
		JButton buttonCommande = new JButton("Commander du stock");
		buttonCommande.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InfoStock InfoStock = new InfoStock();
				InfoStock.main(null);
			}
		});
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panelStock = new GroupLayout(panelStock);
		gl_panelStock.setHorizontalGroup(
			gl_panelStock.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelStock.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelStock.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelStock.createSequentialGroup()
							.addComponent(label_1)
							.addGap(18)
							.addComponent(buttonCommande))
						.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelStock.setVerticalGroup(
			gl_panelStock.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelStock.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelStock.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(buttonCommande))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		try {
			tableStock = new JTable(buildTableModel.buildTableModel(StockManagement.getAllMedicalStock(), "tabStock"));
			tableStock.setEnabled(false);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		scrollPane_2.setViewportView(tableStock);
		panelStock.setLayout(gl_panelStock);
		
		JPanel panelOrder = new JPanel();
		tabbedPane.addTab("Commandes", null, panelOrder, null);
		
		JLabel lblListeDesCommandes = new JLabel("Liste des commandes");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnSendMail = new JButton("SendMail");
		btnSendMail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				extensions.MailExtension.sendMessage();
			}
		});
		GroupLayout gl_panelOrder = new GroupLayout(panelOrder);
		gl_panelOrder.setHorizontalGroup(
			gl_panelOrder.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOrder.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelOrder.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelOrder.createSequentialGroup()
							.addComponent(lblListeDesCommandes)
							.addGap(18)
							.addComponent(btnSendMail))
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelOrder.setVerticalGroup(
			gl_panelOrder.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOrder.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelOrder.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListeDesCommandes)
						.addComponent(btnSendMail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		try {
			tableOrders = new JTable(buildTableModel.buildTableModel(OrdersManagement.getAllOrders(), "tabOrders"));
			tableOrders.setEnabled(false);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		scrollPane_1.setViewportView(tableOrders);
		panelOrder.setLayout(gl_panelOrder);
		
		JPanel panelProduct = new JPanel();
		tabbedPane.addTab("Produits", null, panelProduct, null);
		
		JLabel lblListeDesProduits = new JLabel("Liste des produits");
		
		JButton btnAddProduct = new JButton("Ajouter un produit");
		btnAddProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InfoProduct InfoProduct = new InfoProduct(0);
				InfoProduct.main(null,0);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelProduct = new GroupLayout(panelProduct);
		gl_panelProduct.setHorizontalGroup(
			gl_panelProduct.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProduct.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelProduct.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelProduct.createSequentialGroup()
							.addComponent(lblListeDesProduits)
							.addGap(18)
							.addComponent(btnAddProduct))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelProduct.setVerticalGroup(
			gl_panelProduct.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProduct.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelProduct.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListeDesProduits)
						.addComponent(btnAddProduct))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
					.addContainerGap())
		);

		try {
			tableProduct = new JTable(buildTableModel.buildTableModel(ProductManagement.getAllMedicalProduct(), "tabProduct"));
			tableProduct.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					int row = tableProduct.rowAtPoint(evt.getPoint());
			        //int col = tableAllPatient.columnAtPoint(evt.getPoint());
			        int idProduct = (int) tableProduct.getValueAt(row, 0);
					InfoProduct InfoProduct = new InfoProduct(idProduct);
					InfoProduct.main(null, idProduct);
				}
			});
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tableProduct.setEnabled(false);
		scrollPane.setViewportView(tableProduct);
		panelProduct.setLayout(gl_panelProduct);
		
		JPanel panelMonCompte = new JPanel();
		tabbedPane.addTab("Mon compte", null, panelMonCompte, null);
		
		JLabel label_2 = new JLabel("Login");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("Mot de passe");
		
		JLabel label_4 = new JLabel("Pr\u00E9nom");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label_5 = new JLabel("Email");
		
		JLabel label_6 = new JLabel("Nom");
		
		JButton btnModifier = new JButton("Modifier");
		
		JLabel lblModificationDeCompte = new JLabel("Modification de compte");
		lblModificationDeCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panelMonCompte = new GroupLayout(panelMonCompte);
		gl_panelMonCompte.setHorizontalGroup(
			gl_panelMonCompte.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMonCompte.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addGroup(gl_panelMonCompte.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addGroup(gl_panelMonCompte.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnModifier)
								.addGroup(gl_panelMonCompte.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addGap(44)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
							.addGap(32)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addGap(44))
				.addGroup(Alignment.LEADING, gl_panelMonCompte.createSequentialGroup()
					.addGap(141)
					.addComponent(lblModificationDeCompte)
					.addContainerGap(241, Short.MAX_VALUE))
		);
		gl_panelMonCompte.setVerticalGroup(
			gl_panelMonCompte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMonCompte.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModificationDeCompte)
					.addGap(11)
					.addGroup(gl_panelMonCompte.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addGap(3)
							.addComponent(label_5))
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_panelMonCompte.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addGap(3)
							.addComponent(label_6))
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panelMonCompte.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4)
						.addGroup(gl_panelMonCompte.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModifier)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		panelMonCompte.setLayout(gl_panelMonCompte);
			
	}
}
