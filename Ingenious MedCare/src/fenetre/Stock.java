package fenetre;
import SQL.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import model.buildTableModel;
import popup.addOrderForm;
import popup.addProductForm;

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

public class Stock {

	private JFrame frmIngeniousMedcare;
	private ImageIcon iconDeconnexion = new ImageIcon(Stock.class.getResource("/img/deconnexion.png"));
	private JTable table_1;
	private JTable table;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock window = new Stock();
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
	public Stock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngeniousMedcare = new JFrame();
		frmIngeniousMedcare.setTitle("Ingenious MedCare - Stock");
		frmIngeniousMedcare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngeniousMedcare.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		frmIngeniousMedcare.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		Image img = iconDeconnexion.getImage();
		Image newimg = img.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		iconDeconnexion = new ImageIcon(newimg);
		
		JButton btnDeconnect = new JButton(iconDeconnexion);
		btnDeconnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.main(null);
				frmIngeniousMedcare.dispose();
			}
		});
		btnDeconnect.setBorder(BorderFactory.createEmptyBorder());
		btnDeconnect.setContentAreaFilled(false);
		menuBar.add(btnDeconnect);
		
		
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
				addOrderForm addOrderForm = new addOrderForm();
				addOrderForm.main(null);
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
			table_2 = new JTable(buildTableModel.buildTableModel(StockManagement.getAllMedicalStock(), "tabStock"));
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		scrollPane_2.setViewportView(table_2);
		panelStock.setLayout(gl_panelStock);
		
		JPanel panelOrder = new JPanel();
		tabbedPane.addTab("Commandes", null, panelOrder, null);
		
		JLabel lblListeDesCommandes = new JLabel("Liste des commandes");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panelOrder = new GroupLayout(panelOrder);
		gl_panelOrder.setHorizontalGroup(
			gl_panelOrder.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOrder.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelOrder.createParallelGroup(Alignment.LEADING)
						.addComponent(lblListeDesCommandes)
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelOrder.setVerticalGroup(
			gl_panelOrder.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOrder.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblListeDesCommandes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		try {
			table = new JTable(buildTableModel.buildTableModel(OrdersManagement.getAllOrders(), "tabOrders"));
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		scrollPane_1.setViewportView(table);
		panelOrder.setLayout(gl_panelOrder);
		
		JPanel panelProduct = new JPanel();
		tabbedPane.addTab("Produits", null, panelProduct, null);
		
		JLabel lblListeDesProduits = new JLabel("Liste des produits");
		
		JButton btnAddProduct = new JButton("Ajouter un produit");
		btnAddProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				addProductForm addProductForm = new addProductForm();
				addProductForm.main(null);
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
			table_1 = new JTable(buildTableModel.buildTableModel(ProductManagement.getAllMedicalProduct(), "tabProduct"));
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		scrollPane.setViewportView(table_1);
		panelProduct.setLayout(gl_panelProduct);
		
	}
}
