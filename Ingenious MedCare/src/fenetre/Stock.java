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

public class Stock {

	private JFrame frmIngeniousMedcare;
	private JTable tableAllUser;
	private ImageIcon iconDeconnexion = new ImageIcon(Stock.class.getResource("/img/deconnexion.png"));

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
		
		try {
			tableAllUser = new JTable(buildTableModel.buildTableModel(StockManagement.getAllMedicalStock()));
			tableAllUser.setEnabled(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableAllUser.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	int index = tableAllUser.getSelectedRow();
		        int row = tableAllUser.rowAtPoint(evt.getPoint());
		        int col = tableAllUser.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		           System.out.print(index);
		           System.out.print(row);
		           System.out.print(col);
		        }
		    }
		});
		
		JLabel label_1 = new JLabel("Liste du stock");
		
		JButton button = new JButton("Ajouter du stock");
		
		JButton button_1 = new JButton("Commander du stock");
		GroupLayout gl_panelStock = new GroupLayout(panelStock);
		gl_panelStock.setHorizontalGroup(
			gl_panelStock.createParallelGroup(Alignment.LEADING)
				.addGap(0, 429, Short.MAX_VALUE)
				.addGroup(gl_panelStock.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelStock.createParallelGroup(Alignment.LEADING)
						.addComponent(tableAllUser, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
						.addGroup(gl_panelStock.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_1)))
					.addContainerGap())
		);
		gl_panelStock.setVerticalGroup(
			gl_panelStock.createParallelGroup(Alignment.LEADING)
				.addGap(0, 208, Short.MAX_VALUE)
				.addGroup(gl_panelStock.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelStock.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(button)
						.addComponent(button_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tableAllUser, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelStock.setLayout(gl_panelStock);
		
		JPanel panelFacturation = new JPanel();
		tabbedPane.addTab("Facturation", null, panelFacturation, null);
		GroupLayout gl_panelFacturation = new GroupLayout(panelFacturation);
		gl_panelFacturation.setHorizontalGroup(
			gl_panelFacturation.createParallelGroup(Alignment.LEADING)
				.addGap(0, 429, Short.MAX_VALUE)
				.addGap(0, 429, Short.MAX_VALUE)
		);
		gl_panelFacturation.setVerticalGroup(
			gl_panelFacturation.createParallelGroup(Alignment.LEADING)
				.addGap(0, 208, Short.MAX_VALUE)
				.addGap(0, 208, Short.MAX_VALUE)
		);
		panelFacturation.setLayout(gl_panelFacturation);
		
	}
}
