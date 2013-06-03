package clases;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import logic.Utilidades;

public class FormPeregrino {
	private JComboBox comboBoxForm;
	private Peregrino peregrino;
	private JTextField campoNombre;
	private JTextField apellido1;
	private JTextField apellido2;
	private SpinnerModel smBus;
	private JSpinner spinnerBus;
	private JComboBox comboHabitacion;
	private SpinnerModel smCantidadLiquidada;
	private JSpinner spnCantidadLiquidada;
	private JTextField campoTelefono;
	private JComboBox comboLiquidacion;
	private JTextField textTelefono;
	private JPanel panel;
	private Utilidades utilidades;
	private JLabel labelNombre;
	private JLabel labelPeregrinacion;
	private JLabel labelApellido1;
	private JLabel labelApellido2;
	private JLabel labelAutobus;
	private JLabel labelHabitacion;
	private JLabel labelCantAbon;
	private JLabel labelLiquid;
	private JLabel labelTelf;
	private int idCombo;
	

	public FormPeregrino() {

		super();
		comboBoxForm = new JComboBox();
		peregrino = new Peregrino();
		campoNombre = new JTextField();
		apellido1 = new JTextField();
		apellido2 = new JTextField();
		smBus = new SpinnerNumberModel(1, 1, 10, 1);
		spinnerBus = new JSpinner();
		String[] tipoHabitacion = { "Simple", "Doble", "Triple", "Cuádruple",
				"Otros" };
		comboHabitacion = new JComboBox(tipoHabitacion);
		smCantidadLiquidada = new SpinnerNumberModel(0, 0, 1000, 1);
		spnCantidadLiquidada = new JSpinner();
		campoTelefono = new JTextField();
		String[] pagadoNoPagado = { "Pagado", "No Pagado" };
		comboLiquidacion = new JComboBox(pagadoNoPagado);
		textTelefono = new JTextField();
		panel = new JPanel(new GridLayout(0, 1));
		utilidades = new Utilidades();
		labelNombre = new JLabel("Nombre");
		labelPeregrinacion = new JLabel("Peregrinación");
		labelApellido1 = new JLabel("Primer Apellido");
		labelApellido2 = new JLabel("Segundo Apellido");
		labelAutobus = new JLabel("Autobus");
		labelHabitacion = new JLabel("Habitación");
		labelCantAbon = new JLabel("Cantidad abonada");
		labelLiquid = new JLabel("Liquidación");
		labelTelf = new JLabel("Teléfono");

	}

	public Peregrino formularioInsertar(JComboBox comboBox) {

		

		panel = crearPanel(panel);
		if (idCombo != 0) {

			int result = JOptionPane.showConfirmDialog(null, panel,
					"Insertar Peregrino", JOptionPane.OK_OPTION,
					JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.OK_OPTION) {
				String nombre = campoNombre.getText();
				if (nombre.length() > 0) {
					String stringApell1 = apellido1.getText();
					String stringApell2 = apellido2.getText();
					String strinBus = spinnerBus.getValue().toString();
					String strinHab = comboHabitacion.getSelectedItem()
							.toString();
					int idPeregrinacion = utilidades
							.peregrinacionIdCombo(comboBox);
					int cantLiquidada = Integer.parseInt(spnCantidadLiquidada
							.getValue().toString());
					boolean liquidacion = false;
					String estadoLiquidacion = comboLiquidacion
							.getSelectedItem().toString();
					if (estadoLiquidacion.equalsIgnoreCase("Pagado")) {
						liquidacion = true;
					} else {
						liquidacion = false;
					}
					String telefono = textTelefono.getText();

					peregrino = setPeregrino(nombre, stringApell1,
							stringApell2, idPeregrinacion, liquidacion,
							telefono, strinBus, cantLiquidada, strinHab);
				} else {
					JOptionPane.showMessageDialog(panel,
							"¡Debe introducir al menos un nombre!", "Atención",
							JOptionPane.WARNING_MESSAGE);
					this.formularioInsertar(comboBox);
				}
			} else {
				peregrino = null;
			}

			return peregrino;
		} else {
			utilidades.avisoPeregrinacion();
			peregrino = null;
			return peregrino;
		}
	}

	public Peregrino formularioEditar(Peregrino peregrino, JComboBox comboBox) {
		
		campoNombre.setText(peregrino.getNombre());
		apellido1.setText(peregrino.getApellido1());
		apellido2.setText(peregrino.getApellido2());
		spinnerBus.setValue(Integer.valueOf(peregrino.getBus()));
		spnCantidadLiquidada.setValue(peregrino.getCantidad());
		textTelefono.setText(peregrino.getTelefono());

		panel = crearPanel(panel);

		if (idCombo != 0) {
			
			int result = JOptionPane.showConfirmDialog(null, panel,
					"Insertar Peregrino", JOptionPane.OK_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (result == JOptionPane.OK_OPTION) {
				String nombre = campoNombre.getText();
				if (nombre.length() > 0) {

					String stringApell1 = apellido1.getText();
					String stringApell2 = apellido2.getText();
					String strinBus = spinnerBus.getValue().toString();
					String strinHab = comboHabitacion.getSelectedItem()
							.toString();
					int idPeregrinacion = utilidades
							.peregrinacionIdCombo(comboBoxForm);
					
					int cantLiquidada = Integer.parseInt(spnCantidadLiquidada
							.getValue().toString());
					boolean liquidacion = false;
					String estadoLiquidacion = comboLiquidacion
							.getSelectedItem().toString();
					if (estadoLiquidacion.equalsIgnoreCase("Pagado")) {
						liquidacion = true;
					} else {
						liquidacion = false;
					}
					String telefono = textTelefono.getText();

					
					peregrino = setPeregrino(nombre, stringApell1,
							stringApell2, idPeregrinacion, liquidacion,
							telefono, strinBus, cantLiquidada, strinHab);
				} else {
					JOptionPane.showMessageDialog(panel,
							"¡Debe introducir al menos un nombre!", "Atención",
							JOptionPane.WARNING_MESSAGE);
					this.formularioEditar(peregrino, comboBox);
				}
			} else {
				peregrino = null;
			}
			return peregrino;
		} else {

			peregrino = null;
			return peregrino;
		}
	}

	private JPanel crearPanel(JPanel jpanel) {
		utilidades.refreshPeregrinacionCombo(comboBoxForm);
		idCombo = utilidades.peregrinacionIdCombo(comboBoxForm);
		instanciaLabels();
		panel.add(labelPeregrinacion);
		panel.add(comboBoxForm);
		panel.add(labelNombre);
		panel.add(campoNombre);
		panel.add(labelApellido1);
		panel.add(apellido1);
		panel.add(labelApellido2);
		panel.add(apellido2);
		panel.add(labelAutobus);
		panel.add(spinnerBus);
		panel.add(labelHabitacion);
		panel.add(comboHabitacion);
		panel.add(labelCantAbon);
		panel.add(spnCantidadLiquidada);
		panel.add(labelLiquid);
		panel.add(comboLiquidacion);
		panel.add(labelTelf);
		panel.add(textTelefono);
		return jpanel;

	}

	private Peregrino setPeregrino(String nombre, String apellido1,
			String apellido2, int idPeregrinacion, boolean liquidacion,
			String telefono, String bus, int cantidadLiquidada, String tipoHab) {

		peregrino.setNombre(nombre);
		peregrino.setApellido1(apellido1);
		peregrino.setApellido2(apellido2);
		peregrino.setIdPeregrinacion(idPeregrinacion);
		peregrino.setPagado(liquidacion);
		peregrino.setTelefono(telefono);
		peregrino.setBus(bus);
		peregrino.setCantidad(cantidadLiquidada);
		peregrino.setTipoHab(tipoHab);

		return peregrino;
	}

	private void instanciaLabels() {
		if (!utilidades.isObjeto(labelNombre)
				|| !utilidades.isObjeto(labelPeregrinacion)
				|| !utilidades.isObjeto(labelApellido1)
				|| !utilidades.isObjeto(labelApellido2)
				|| !utilidades.isObjeto(labelHabitacion)
				|| !utilidades.isObjeto(labelAutobus)
				|| !utilidades.isObjeto(labelCantAbon)
				|| !utilidades.isObjeto(labelLiquid)
				|| !utilidades.isObjeto(labelTelf)) {

			labelPeregrinacion = new JLabel("Peregrinación");
			labelNombre = new JLabel("Nombre");
			labelApellido1 = new JLabel("Primer apellido");
			labelApellido2 = new JLabel("Segundo apeliido");
			labelAutobus = new JLabel("Autobus");
			labelCantAbon = new JLabel("Cantidad abonada");
			labelHabitacion = new JLabel("Habitación");
			labelLiquid = new JLabel("Liquidación");
			labelTelf = new JLabel("Teléfono");

		}

	}
}
