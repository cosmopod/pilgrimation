package logic;

import interfaces.IOperacionesBD;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Peregrinacion;
import clases.Peregrino;

import com.toedter.calendar.JDateChooser;

public class Utilidades {

	private Peregrino peregrino;
	private Peregrinacion peregrinacion;
	private JComboBox comboBox;
	private IOperacionesBD operacionesBD;

	public Utilidades() {

		operacionesBD = new OperacionesBD();
	}

	public Peregrino formPeregrino() {

		Peregrino peregrino = new Peregrino();
		JTextField campoNombre = new JTextField();
		JTextField campoApellido1 = new JTextField();
		JTextField campoApellido2 = new JTextField();
		String nombre;
		String apellido1;
		String apellido2;
		String idPeregString;
		int idPeregrinacion;

		// Creación de un JPanel donde enganchar los labels y áreas de texto

		JPanel panel = new JPanel(new GridLayout(0, 1));

		comboBox = new JComboBox();
		// Rellena el comboBox con los datos de la BD
		refreshPeregrinacionCombo(comboBox);

		panel.add(new JLabel("Peregrinación"));
		panel.add(comboBox);
		panel.add(new JLabel("Nombre"));
		panel.add(campoNombre);
		panel.add(new JLabel("Primer Apellido"));
		panel.add(campoApellido1);
		panel.add(new JLabel("Segundo Apellido"));
		panel.add(campoApellido2);

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
				 * miembro 'id' del objeto 'Peregrinacion'.
				 */
				String[] arrayToString = peregrinacionToString.split("\\.");
				idPeregString = arrayToString[0];
				idPeregrinacion = Integer.parseInt(idPeregString);
				apellido1 = campoApellido1.getText();
				apellido2 = campoApellido2.getText();
				//asignamos el valor de los atributos del objeto Peregrino
				peregrino.setNombre(nombre);
				peregrino.setApellido1(apellido1);
				peregrino.setApellido2(apellido2);
				peregrino.setIdPeregrinacion(idPeregrinacion);
				
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

	public Peregrinacion formPeregrinacion() {

		peregrinacion = new Peregrinacion();
		JTextField campoLugar = new JTextField();
		JDateChooser dateChooser = new JDateChooser();
		int dia, mes, anio;

		// Creación de un panel donde enganchar los campos, los labels y el
		// JDateChooser
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Lugar"));
		panel.add(campoLugar);
		panel.add(new JLabel("Fecha"));
		panel.add(dateChooser);

		// Creación del JOptionPane
		int result = JOptionPane.showConfirmDialog(null, panel,
				"Insertar Peregrinación", JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			String lugar = campoLugar.getText();
			if (lugar.length() > 0) {

				if (dateChooser.getDate() != null) {
					dia = dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);
					mes = dateChooser.getCalendar().get(Calendar.MONTH);
					anio = dateChooser.getCalendar().get(Calendar.YEAR);
				} else {
					dia = 0;
					mes = 0;
					anio = 0;
				}

				String fecha = dia + "-" + mes + "-" + anio;

				// Asignación de la fecha y hora a un nuevo objeto

				peregrinacion.setLugar(lugar);
				peregrinacion.setFecha(fecha);
			} else {

				JOptionPane.showMessageDialog(panel,
						"¡Debe introducir al menos un lugar!", "Atención",
						JOptionPane.WARNING_MESSAGE);
				this.formPeregrinacion();
			}

		} else {
			peregrinacion = null;
		}
		return peregrinacion;
	}

	public void refreshPeregrinacionCombo(JComboBox comboBox) {

		comboBox.repaint();
		ArrayList<Peregrinacion> peregrinaciones = operacionesBD
				.totalPeregrinaciones();
		Iterator it = peregrinaciones.iterator();
		while (it.hasNext()) {
			Peregrinacion numPeregrinacion = (Peregrinacion) it.next();
			comboBox.addItem(numPeregrinacion.toString());

		}

	}

}
