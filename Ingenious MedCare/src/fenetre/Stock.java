package fenetre;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import SQL.OrdersManagement;
import SQL.ProductManagement;
import SQL.SqlConnection;
import SQL.StockManagement;
import models.OrdersModel;
import models.ProductModel;
import models.StockModel;
import popup.InfoProduct;
import popup.InfoStock;

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
		Show_Orders_In_JTable();
		Show_Product_In_JTable();
		Show_Stock_In_JTable();
	}
	
	// Execute The Insert Update And Delete Querys
	public void executeSQlQuery(String query, String message)
	{
	   Connection cn = SqlConnection.getInstance();
	   Statement st;
	   try{
	       st = cn.createStatement();
	       if((st.executeUpdate(query)) == 1)
	       {
		    	// refresh jtable data
		    	DefaultTableModel model = (DefaultTableModel)tableOrders.getModel();
		    	model.setRowCount(0);
		    	Show_Orders_In_JTable();    
	    	   JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
	       	}else{
	           JOptionPane.showMessageDialog(null, "Data Not "+message);
	        }
	        }catch(Exception ex){
	           ex.printStackTrace();
	       }
	 }
	
	 public void Show_Orders_In_JTable()
	   {
		   ArrayList<OrdersModel> Orderslist = OrdersManagement.getAllOrders();
	       DefaultTableModel OrdersModel = (DefaultTableModel) tableOrders.getModel();
	       Object[] OdersRow = new Object[5];
	       for(int i = 0; i < Orderslist.size(); i++)
	       {
	    	   OdersRow[0] = Orderslist.get(i).getId();
	    	   OdersRow[1] = Orderslist.get(i).getNom();
	    	   OdersRow[2] = Orderslist.get(i).getQuantity();
	    	   OdersRow[3] = Orderslist.get(i).getOrderDate();
	    	   OdersRow[4] = Orderslist.get(i).getStatus();
	           
	           OrdersModel.addRow(OdersRow);
	       }
	    }
	 public void Show_Product_In_JTable() {
	       
		   ArrayList<ProductModel> Productlist = ProductManagement.getAllMedicalProduct();
	       DefaultTableModel ProductModel = (DefaultTableModel) tableProduct.getModel();
	       Object[] ProductRow = new Object[7];
	       for(int i = 0; i < Productlist.size(); i++)
	       {
	    	   ProductRow[0] = Productlist.get(i).getId();
	    	   ProductRow[1] = Productlist.get(i).getNom();
	    	   ProductRow[2] = Productlist.get(i).getClassification();
	    	   ProductRow[3] = Productlist.get(i).getSubstance();
	    	   ProductRow[4] = Productlist.get(i).getExcipient();
	    	   ProductRow[5] = Productlist.get(i).getConservation();
	    	   ProductRow[6] = Productlist.get(i).getLibelle();
	    	   
	           ProductModel.addRow(ProductRow);
	       }
	 }
	 public void Show_Stock_In_JTable() {
	       
		   ArrayList<StockModel> Stocklist = StockManagement.getAllMedicalStock();
	       DefaultTableModel StockModel = (DefaultTableModel) tableStock.getModel();
	       Object[] StockRow = new Object[3];
	       for(int i = 0; i < Stocklist.size(); i++)
	       {
	    	   StockRow[0] = Stocklist.get(i).getId();
	    	   StockRow[1] = Stocklist.get(i).getNom();
	    	   StockRow[2] = Stocklist.get(i).getQuantity();
	    	   
	           StockModel.addRow(StockRow);
	       }
	 }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int connectedId) {
		frmIngeniousMedcare = new JFrame();
		frmIngeniousMedcare.setTitle("Ingenious MedCare - Stock");
		frmIngeniousMedcare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngeniousMedcare.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		tableOrders = new javax.swing.JTable();
		tableProduct = new javax.swing.JTable();
		tableStock = new javax.swing.JTable();
		
		JMenuBar menuBar = new JMenuBar();
		frmIngeniousMedcare.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu menuOptions = new JMenu("Options");
		menuBar.add(menuOptions);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Mon compte");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmIngeniousMedcare.getContentPane().removeAll();
				frmIngeniousMedcare.repaint();
			}
		});
		menuOptions.add(mntmNewMenuItem);
		
		JMenuItem mntmSeDconnecter = new JMenuItem("Se d\u00E9connecter");
		mntmSeDconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmIngeniousMedcare.dispose();
				Login login = new Login();
				login.main(null);
			}
		});
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
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
						.addGroup(gl_panelStock.createSequentialGroup()
							.addComponent(label_1)
							.addGap(18)
							.addComponent(buttonCommande)))
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
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableStock.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Id", "Nom produit", "Quantity"
                }
            ));
		tableStock.setEnabled(false);
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
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
						.addGroup(gl_panelOrder.createSequentialGroup()
							.addComponent(lblListeDesCommandes)
							.addGap(18)
							.addComponent(btnSendMail)))
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
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
					.addContainerGap())
		);
		
	
		
		tableOrders.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Id", "Nom produit", "Quantité", "Date de commande","Status"
                }
            ));
		tableOrders.setEnabled(false);
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
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
						.addGroup(gl_panelProduct.createSequentialGroup()
							.addComponent(lblListeDesProduits)
							.addGap(18)
							.addComponent(btnAddProduct)))
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
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
					.addContainerGap())
		);

		tableProduct.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Id", "Nom produit", "Classification", "Substance","excipient", "Conservation", "Libelle"
                }
            ));
		tableProduct.setEnabled(false);
		scrollPane.setViewportView(tableProduct);
		panelProduct.setLayout(gl_panelProduct);
		
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
