package vista;

import interfaces.IOperacionesBD;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logic.Controlador;
import logic.OperacionesBD;
import logic.Utilidades;
import clases.Peregrinacion;
import clases.Peregrino;

public class Lista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IOperacionesBD operacionesBD = new OperacionesBD();
	private JPanel contentPane;
	private JComboBox comboBox;
	private JButton btnNuevPeregrinacion;
	private JButton btnuevPeregrino;
	private JList listPeregrinos;
	private Peregrino peregrino;
	private Peregrinacion peregrinacion;
	private Controlador controlador;
	private Utilidades utilidades;
	private JButton btnEditPeregrinacion;
	private JButton btnEditarPeregrino;

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
		setResizable(false);
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

		controlador = new Controlador();
		utilidades = new Utilidades();

		comboBox = new JComboBox();

		utilidades.refreshPeregrinacionCombo(comboBox);

		JLabel lblNewLabel = new JLabel("Listado de peregrinaciones");

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel_1 = new JLabel("Listado de peregrinos");

		btnNuevPeregrinacion = new JButton("Añadir Peregrinación");

		btnuevPeregrino = new JButton("Añadir Peregrino");

		btnEditPeregrinacion = new JButton(
				"<html><center><p>Editar<br />Peregrinación</p></center></html>");

		btnEditarPeregrino = new JButton(
				"<html><center><p>Editar<br />Peregrino</p></center></html>");

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
																										btnNuevPeregrinacion)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										btnuevPeregrino))
																				.addComponent(
																						scrollPane,
																						GroupLayout.PREFERRED_SIZE,
																						623,
																						GroupLayout.PREFERRED_SIZE))
																.addGap(101))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						comboBox,
																						GroupLayout.PREFERRED_SIZE,
																						289,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						lblNewLabel,
																						GroupLayout.PREFERRED_SIZE,
																						212,
																						GroupLayout.PREFERRED_SIZE))
																.addGap(58)
																.addComponent(
																		btnEditPeregrinacion,
																		GroupLayout.PREFERRED_SIZE,
																		127,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(
																		btnEditarPeregrino,
																		GroupLayout.PREFERRED_SIZE,
																		127,
																		GroupLayout.PREFERRED_SIZE)))
								.addGap(99)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(42)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														btnEditPeregrinacion,
														Alignment.TRAILING,
														GroupLayout.DEFAULT_SIZE,
														97, Short.MAX_VALUE)
												.addComponent(
														btnEditarPeregrino,
														Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE,
														97,
														GroupLayout.PREFERRED_SIZE))
								.addGap(40)
								.addComponent(lblNewLabel_1,
										GroupLayout.PREFERRED_SIZE, 21,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 235,
										GroupLayout.PREFERRED_SIZE)
								.addGap(33)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														btnNuevPeregrinacion)
												.addComponent(btnuevPeregrino))
								.addGap(52))
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(47)
								.addComponent(lblNewLabel,
										GroupLayout.PREFERRED_SIZE, 52,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox,
										GroupLayout.PREFERRED_SIZE, 39,
										GroupLayout.PREFERRED_SIZE).addGap(419)));
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {
				btnNuevPeregrinacion, btnuevPeregrino });

		// listado peregrinos por peregrinación
		DefaultListModel<String> miModelo = controlador
				.peregrinoLista(comboBox);

		listPeregrinos = new JList(miModelo);

		scrollPane.setViewportView(listPeregrinos);

		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Habitaciones", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Bus", null, panel_2, null);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Actividades", null, panel_3, null);
		setLocationRelativeTo(null);

		// EVENTOS //////////////////////////////////////////////////

		// Evento Refresco de la lista con el cambio de item del Combo
		// =======================
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DefaultListModel<String> ultimoModelo = controlador
						.peregrinoLista(comboBox);
				listPeregrinos.setModel(ultimoModelo);
			}
		});

		// Evento inserción peregrino //////////////////////////
		btnuevPeregrino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.formInsertarPeregrino(comboBox);
				DefaultListModel<String> ultimoModelo = controlador
						.peregrinoLista(comboBox);
				listPeregrinos.setModel(ultimoModelo);
			}

		});

		// Evento eliminación peregrino ////////////////////////
		listPeregrinos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!listPeregrinos.isSelectionEmpty()) {
					if (controlador.eliminacionPeregrino(listPeregrinos)) {
						DefaultListModel<String> nuevaLista = controlador
								.peregrinoLista(comboBox);
						listPeregrinos.setModel(nuevaLista);

					} else
						listPeregrinos.requestFocus();
				}
			}
		});

		// Evento de edición de Peregrino ////////////////////////
		btnEditarPeregrino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (controlador.edicionPeregrino(comboBox, listPeregrinos)) {
					DefaultListModel<String> nuevaLista = controlador
							.peregrinoLista(comboBox);
					listPeregrinos.setModel(nuevaLista);

				} else {
					utilidades.avisoPeregrinacion();
				}
			}
		});

		// Evento inserción peregrinación ///////////////////////
		btnNuevPeregrinacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Acción realizada al pulsar botón de inserción de
				// peregrinación: REFRESCA ITEMS COMBOBOX
				// ==============================================

				peregrinacion = controlador.formInsertPeregrinacion();

				if (peregrinacion != null) {
					operacionesBD.insertarPeregrinacion(
							peregrinacion.getFecha(), peregrinacion.getLugar());
					utilidades.refreshPeregrinacionCombo(comboBox);

				}

			}
		});

		// Evento pata edición de peregrinación //////////////////
		btnEditPeregrinacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int idPeregrinacion = utilidades.peregrinacionIdCombo(comboBox);
				if (idPeregrinacion != 0) {

					try {
						peregrinacion = operacionesBD
								.obtenerPeregrinacion(idPeregrinacion);
						peregrinacion = controlador
								.formEditarPeregrinacion(peregrinacion);

						if (peregrinacion != null) {
							operacionesBD.editarPeregrinacion(
									peregrinacion.getId(),
									peregrinacion.getLugar(),
									peregrinacion.getFecha());

							utilidades.refreshPeregrinacionCombo(comboBox);
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					utilidades.avisoPeregrinacion();
				}

			}
		});

		// Evento para la eliminación de peregrinación //////////
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				int idPeregrinacion = utilidades.peregrinacionIdCombo(comboBox);
				if (idPeregrinacion != 0) {
					controlador.formEliminarPeregrinacion(idPeregrinacion);
					utilidades.refreshPeregrinacionCombo(comboBox);

				} else {
					utilidades.avisoPeregrinacion();
					btnNuevPeregrinacion.requestFocus();
				}
			}
		});

	}
}
