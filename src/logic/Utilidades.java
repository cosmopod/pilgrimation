package logic;

import interfaces.IOperacionesBD;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import clases.FormPeregrinacion;
import clases.Peregrinacion;
import clases.Peregrino;

import com.toedter.calendar.JDateChooser;

public class Utilidades {

	private Peregrino miPeregrino;
	private Peregrinacion miPeregrinacion;
	private FormPeregrinacion formPeregrinacion;
	private JComboBox comboBox;
	private IOperacionesBD operacionesBD;
	private boolean objetoEdicion = false;

	public Utilidades() {

		operacionesBD = new OperacionesBD();
		formPeregrinacion = new FormPeregrinacion();
	}



	// FUNCIONES PARA LA GESTIÓN DE PEREGRINACIONES ///////////////////////

	public Peregrinacion formInsertPeregrinacion() {

		return formPeregrinacion.formularioInsertar();

	}

	public Peregrinacion formEditarPeregrinacion(Peregrinacion peregrinacion) {

		return formPeregrinacion.formularioEditar(peregrinacion);
	}

	public void formEliminarPeregrinacion(int idPeregrinacion) {

		int resultado = formPeregrinacion.eliminacionPeregrinacion();
		if (resultado == JOptionPane.OK_OPTION) {
			operacionesBD.eliminarPeregrinacion(idPeregrinacion);
		}

	}

	public void refreshPeregrinacionCombo(JComboBox comboBox) {

		comboBox.removeAllItems();
		comboBox.repaint();

		ArrayList<Peregrinacion> peregrinaciones = operacionesBD
				.totalPeregrinaciones();
		Iterator it = peregrinaciones.iterator();
		while (it.hasNext()) {
			Peregrinacion numPeregrinacion = (Peregrinacion) it.next();
			comboBox.addItem(numPeregrinacion.toString());

		}

	}

	public int peregrinacionIdCombo(JComboBox combo) {
		String cadenaPeregrinacion = combo.getSelectedItem().toString();
		String[] arrayCadenaPeregrinacion = cadenaPeregrinacion.split("\\.");
		int idPeregrinacion = Integer.parseInt(arrayCadenaPeregrinacion[0]);

		return idPeregrinacion;
	}
	
	// FUNCIONES PARA LA GESTION DE PEREGRINOS //////////////////////////
	
	public Peregrino formPeregrino() {

		// Creación de elementos del formulario ==========================
		Peregrino peregrino = new Peregrino();
		JTextField campoNombre = new JTextField();
		JTextField campoApellido1 = new JTextField();
		JTextField campoApellido2 = new JTextField();
		SpinnerModel smBus = new SpinnerNumberModel(0, 0, 5, 1);
		JSpinner spinnerBus = new JSpinner(smBus);
		String[] tipoHabitacion = { "Simple", "Doble", "Triple", "Cuádruple",
				"Otras" };
		JComboBox comboHabitacion = new JComboBox(tipoHabitacion);
		SpinnerModel smCantidadLiquidada = new SpinnerNumberModel(0, 0, 10000,
				1);
		JSpinner spnCantidadLiquidada = new JSpinner(smCantidadLiquidada);
		JTextField campoTelefono = new JTextField();
		String[] pagadoNoPagado = { "Pagado", "No pagado" };
		JComboBox comboLiquidacion = new JComboBox(pagadoNoPagado);
		JTextField TextTelefono = new JTextField();

		// Declaración de las variables donde almacenar los valores del
		// formulario

		int idPeregrinacion;
		String idPeregString;
		String nombre;
		String apellido1;
		String apellido2;
		String bus;
		String habitacion;
		int cantidadLiquidada;
		Boolean liquidacion;
		String telefono;

		// Creación de un JPanel donde enganchar los labels y áreas de texto

		JPanel panel = new JPanel(new GridLayout(0, 1));

		comboBox = new JComboBox();

		// Rellena el comboBox con los datos de la BD y se agregan los
		// componentes al panel
		refreshPeregrinacionCombo(comboBox);

		panel.add(new JLabel("Peregrinación"));
		panel.add(comboBox);
		panel.add(new JLabel("Nombre"));
		panel.add(campoNombre);
		panel.add(new JLabel("Primer apellido"));
		panel.add(campoApellido1);
		panel.add(new JLabel("Segundo apellido"));
		panel.add(campoApellido2);
		panel.add(new JLabel("Autobus"));
		panel.add(spinnerBus);
		panel.add(new JLabel("Habitacion"));
		panel.add(comboHabitacion);
		panel.add(new JLabel("Cantidad abonada"));
		panel.add(spnCantidadLiquidada);
		panel.add(new JLabel("Liquidación"));
		panel.add(comboLiquidacion);
		panel.add(new JLabel("Teléfono"));
		panel.add(TextTelefono);

		int result = JOptionPane.showConfirmDialog(null, panel,
				"Insertar Peregrino", JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			nombre = campoNombre.getText();
			if (nombre.length() > 0) {
				String peregrinacionToString = comboBox.getSelectedItem()
						.toString();
				/*
				 * En la siguiente línea descomponemos el resultado de
				 * toString() cortando por el punto y lo guardamos en un array.
				 * El primer elemento de ese array se corresponderá con el
				 * miembro 'id' del objeto 'Peregrinación'.
				 */
				String[] arrayToString = peregrinacionToString.split("\\.");
				idPeregString = arrayToString[0];
				idPeregrinacion = Integer.parseInt(idPeregString);
				apellido1 = campoApellido1.getText();
				apellido2 = campoApellido2.getText();
				bus = spinnerBus.getValue().toString();
				habitacion = comboHabitacion.getSelectedItem().toString();
				cantidadLiquidada = Integer.parseInt(spnCantidadLiquidada
						.getValue().toString());
				// poner liquidación ==================
				String estadoLiquidacion = comboLiquidacion.getSelectedItem()
						.toString();
				if (estadoLiquidacion.equalsIgnoreCase("Pagado")) {
					liquidacion = true;
				} else {
					liquidacion = false;
				}

				telefono = TextTelefono.getText();

				// asignamos el valor de los atributos del objeto Peregrino
				peregrino.setNombre(nombre);
				peregrino.setApellido1(apellido1);
				peregrino.setApellido2(apellido2);
				peregrino.setIdPeregrinacion(idPeregrinacion);
				peregrino.setPagado(liquidacion);
				peregrino.setTelefono(telefono);
				peregrino.setBus(bus);
				peregrino.setCantidad(cantidadLiquidada);
				peregrino.setTipoHab(habitacion);

			} else {
				JOptionPane.showMessageDialog(panel,
						"¡Debe introducir al menos un nombre!", "Atención",
						JOptionPane.WARNING_MESSAGE);
				this.formPeregrino();
			}

		} else {
			peregrino = null;
		}

		return peregrino;
	}
	
	public DefaultListModel<String> peregrinoLista(JComboBox comboBox) {

		DefaultListModel<String> modeloLista = new DefaultListModel<String>();

		if (comboBox.getSelectedItem() != null) {
			String peregrinacion = comboBox.getSelectedItem().toString();

			String[] arrayToString = peregrinacion.split("\\.");
			String idPeregString = arrayToString[0];
			int idPeregrinacion = Integer.parseInt(idPeregString);

			ArrayList<Peregrino> arrayPeregrinos = operacionesBD
					.totalPeregrinos(idPeregrinacion);
			Iterator it = arrayPeregrinos.iterator();
			while (it.hasNext()) {
				Peregrino peregrino = (Peregrino) it.next();
				modeloLista.addElement(peregrino.toString());
			}
		}

		return modeloLista;
	}

	

}
