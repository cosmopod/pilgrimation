package vista;

import interfaces.IOperacionesBD;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logic.OperacionesBD;
import clases.Peregrinacion;

public class Lista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IOperacionesBD operacionesBD = new OperacionesBD();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista frame = new Lista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Lista() {
		setTitle("Pilgrimation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "name_39170888246295");

		JPanel panel = new JPanel();
		tabbedPane.addTab("Peregrinación", null, panel, null);

		JComboBox comboBox = new JComboBox();

		ArrayList<Peregrinacion> peregrinaciones = operacionesBD
				.totalPeregrinaciones();
		Iterator it = peregrinaciones.iterator();
		while (it.hasNext()) {
			Peregrinacion numPeregrinacion = (Peregrinacion) it.next();
			comboBox.addItem(numPeregrinacion.toString());

		}

		JLabel lblNewLabel = new JLabel("Listado de peregrinaciones");

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel_1 = new JLabel("Listado de peregrinos");

		JButton btnNewButton = new JButton("Añadir Peregrinación");

		JButton btnNewButton_1 = new JButton("Añadir Peregrino");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(61)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		comboBox,
																		GroupLayout.PREFERRED_SIZE,
																		289,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(435))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNewLabel,
																		GroupLayout.PREFERRED_SIZE,
																		212,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(512))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNewLabel_1,
																		GroupLayout.DEFAULT_SIZE,
																		712,
																		Short.MAX_VALUE)
																.addGap(12))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.TRAILING)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										btnNewButton)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										btnNewButton_1))
																				.addComponent(
																						scrollPane,
																						GroupLayout.PREFERRED_SIZE,
																						623,
																						GroupLayout.PREFERRED_SIZE))
																.addGap(101)))
								.addGap(99)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addGap(47)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE,
								52, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 39,
								GroupLayout.PREFERRED_SIZE)
						.addGap(35)
						.addComponent(lblNewLabel_1,
								GroupLayout.PREFERRED_SIZE, 21,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
								235, GroupLayout.PREFERRED_SIZE)
						.addGap(33)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton)
										.addComponent(btnNewButton_1))
						.addGap(52)));
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {
				btnNewButton, btnNewButton_1 });

		JList listPeregrinos = new JList();
		scrollPane.setViewportView(listPeregrinos);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Habitaciones", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Bus", null, panel_2, null);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Actividades", null, panel_3, null);
		setLocationRelativeTo(null);
	}
}
