package logic;

import interfaces.IOperacionesBD;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import clases.FormPeregrinacion;
import clases.FormPeregrino;
import clases.Peregrinacion;
import clases.Peregrino;

public class Controlador {

	private Peregrino miPeregrino;
	private Peregrinacion miPeregrinacion;
	private FormPeregrinacion formPeregrinacion;
	private FormPeregrino formPeregrino;
	private JComboBox comboBox;
	private IOperacionesBD operacionesBD;
	private boolean objetoEdicion = false;
	private Utilidades utilidades;

	public Controlador() {

		operacionesBD = new OperacionesBD();
		formPeregrinacion = new FormPeregrinacion();
		formPeregrino = new FormPeregrino();
		utilidades = new Utilidades();
	}

	// FUNCIONES PARA LA GESTIÓN DE PEREGRINACIONES ///////////////////////

	public Peregrinacion formInsertPeregrinacion() {

		return formPeregrinacion.formularioInsertar();

	}

	public Peregrinacion formEditarPeregrinacion(Peregrinacion peregrinacion) {

		return formPeregrinacion.formularioEditar(peregrinacion);
	}

	public boolean formEliminarPeregrinacion(int idPeregrinacion) {

		int resultado = formPeregrinacion.eliminacionPeregrinacion();
		if (resultado == JOptionPane.OK_OPTION) {
			operacionesBD.eliminarPeregrinacion(idPeregrinacion);
			/*
			 * Se ha de escribir una función que permita la eliminación global
			 * de peregrinos tras la eliminación de su peregrinación asociada.
			 */
			return true;
		}else{
			return false;
		}

	}

	// FUNCIONES PARA LA GESTION DE PEREGRINOS //////////////////////////

	public void formInsertarPeregrino(JComboBox comboBox) {
		miPeregrino = formPeregrino.formularioInsertar(comboBox);
		if (miPeregrino != null) {
			operacionesBD.insertarPeregrino(miPeregrino.getIdPeregrinacion(),
					miPeregrino.getNombre(), miPeregrino.getApellido1(),
					miPeregrino.getApellido2(), miPeregrino.getBus(),
					miPeregrino.getTipoHab(), miPeregrino.getCantidad(),
					miPeregrino.isPagado(), miPeregrino.getTelefono());
		}
	}

	public DefaultListModel<String> peregrinoLista(JComboBox comboBox) {

		DefaultListModel<String> modeloLista = new DefaultListModel<String>();

		int idPeregrinacion = utilidades.peregrinacionIdCombo(comboBox);
		if (idPeregrinacion != 0) {
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
