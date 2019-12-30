package fenetre;
import SQL.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import SQL.UserManagement;
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
import javax.swing.JLabel;
import javax.swing.JTable;

public class Stock {

	private JFrame frmIngeniousMedcare;
	private JTable tableAllStock;

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
		frmIngeniousMedcare.setBounds(100, 100, 450, 300);
		frmIngeniousMedcare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frmIngeniousMedcare.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
		);
		
		JPanel panelAccueil = new JPanel();
		tabbedPane.addTab("Accueil", null, panelAccueil, null);
		
		JLabel labelAccueil = new JLabel("Bienvenue sur le logiciel Ingenious MedCare");
		GroupLayout gl_panelAccueil = new GroupLayout(panelAccueil);
		gl_panelAccueil.setHorizontalGroup(
			gl_panelAccueil.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelAccueil.createSequentialGroup()
					.addGap(103)
					.addComponent(labelAccueil, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(97))
		);
		gl_panelAccueil.setVerticalGroup(
			gl_panelAccueil.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelAccueil.createSequentialGroup()
					.addGap(103)
					.addComponent(labelAccueil, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(96))
		);
		panelAccueil.setLayout(gl_panelAccueil);
		
		JPanel panelStock = new JPanel();
		tabbedPane.addTab("Stock", null, panelStock, null);
		
		tableAllStock = new JTable();
		
		JLabel labelListeStock = new JLabel("Liste du stock");
		
		JButton btnAjouterDuStock = new JButton("Ajouter du stock");
		
		JButton btnCommanderDuStock = new JButton("Commander du stock");
		GroupLayout gl_panelStock = new GroupLayout(panelStock);
		gl_panelStock.setHorizontalGroup(
			gl_panelStock.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelStock.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelStock.createParallelGroup(Alignment.LEADING)
						.addComponent(tableAllStock, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
						.addGroup(gl_panelStock.createSequentialGroup()
							.addComponent(labelListeStock)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAjouterDuStock)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCommanderDuStock)))
					.addContainerGap())
		);
		gl_panelStock.setVerticalGroup(
			gl_panelStock.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelStock.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelStock.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelListeStock)
						.addComponent(btnAjouterDuStock)
						.addComponent(btnCommanderDuStock))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tableAllStock, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelStock.setLayout(gl_panelStock);
		
		JPanel panelFacturation = new JPanel();
		tabbedPane.addTab("Facturation", null, panelFacturation, null);
		GroupLayout gl_panelFacturation = new GroupLayout(panelFacturation);
		gl_panelFacturation.setHorizontalGroup(
			gl_panelFacturation.createParallelGroup(Alignment.LEADING)
				.addGap(0, 417, Short.MAX_VALUE)
		);
		gl_panelFacturation.setVerticalGroup(
			gl_panelFacturation.createParallelGroup(Alignment.LEADING)
				.addGap(0, 213, Short.MAX_VALUE)
		);
		panelFacturation.setLayout(gl_panelFacturation);
		frmIngeniousMedcare.getContentPane().setLayout(groupLayout);
	}
}
