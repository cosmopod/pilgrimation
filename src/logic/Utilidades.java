package logic;

import interfaces.IOperacionesBD;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import clases.Peregrinacion;

public class Utilidades {

	private IOperacionesBD operacionesBD;

	public Utilidades() {
		super();
		operacionesBD = new OperacionesBD();
	}

	public int peregrinacionIdCombo(JComboBox combo) {

		if (combo.getSelectedIndex() != -1) {
			String cadenaPeregrinacion = combo.getSelectedItem().toString();

			String[] arrayCadenaPeregrinacion = cadenaPeregrinacion
					.split("\\.");
			int idPeregrinacion = Integer.parseInt(arrayCadenaPeregrinacion[0]);

			return idPeregrinacion;
		} else {
			return 0;
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

	public boolean isObjeto(Object objeto) {
		if (objeto != null) {
			return true;
		} else {
			return false;
		}
	}

}
