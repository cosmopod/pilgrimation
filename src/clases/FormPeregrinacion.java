package clases;

import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.Controlador;
import logic.Utilidades;

import com.toedter.calendar.JDateChooser;

public class FormPeregrinacion {

	private Peregrinacion peregrinacion;
	private JTextField campoLugar;
	private JDateChooser dateChooser;
	private JPanel panel;
	private JLabel labelLugar;
	private JLabel labelFecha;
	private Utilidades utilidades;

	public FormPeregrinacion() {
		super();
		peregrinacion = new Peregrinacion();
		campoLugar = new JTextField();
		dateChooser = new JDateChooser();
		panel = new JPanel(new GridLayout(0, 1));
		labelLugar = new JLabel("Lugar");
		labelFecha = new JLabel("Fecha");
		utilidades = new Utilidades();

	}

	public Peregrinacion formularioInsertar() {

		instanciaLabels();
		dateChooser.setDate(null);
		campoLugar.setText(null);
		panel.add(labelLugar);
		panel.add(campoLugar);
		panel.add(labelFecha);
		panel.add(dateChooser);

		int result = JOptionPane.showConfirmDialog(null, panel,
				"Añadir Peregrinación", JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {

			String lugar = obtenerTexto(campoLugar);
			String fecha = null;

			if (lugar.length() > 0) {
				fecha = obtenerFecha(dateChooser);
				peregrinacion = setPeregrinacion(peregrinacion, lugar, fecha);

			} else {
				JOptionPane.showMessageDialog(panel,
						"¡Debe introducir al menos un lugar!", "Atención",
						JOptionPane.WARNING_MESSAGE);
				this.formularioInsertar();
			}

		} else {
			peregrinacion = null;
		}
		return peregrinacion;

	}

	public Peregrinacion formularioEditar(Peregrinacion peregrinacion) {

		String lugar = peregrinacion.getLugar();
		String fecha = peregrinacion.getFecha();

		Date date = null;

		campoLugar.setText(lugar);
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dateChooser.setDate(date);

		instanciaLabels();
		panel.add(labelLugar);
		panel.add(campoLugar);
		panel.add(labelFecha);
		panel.add(dateChooser);

		int result = JOptionPane.showConfirmDialog(null, panel,
				"Editar Peregrinación", JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {

			String nuevoLugar = obtenerTexto(campoLugar);
			String nuevaFecha = obtenerFecha(dateChooser);

			if (lugar.length() > 0) {
				fecha = obtenerFecha(dateChooser);
				peregrinacion = setPeregrinacion(peregrinacion, nuevoLugar,
						nuevaFecha);

			} else {
				JOptionPane.showMessageDialog(panel,
						"¡Debe introducir al menos un lugar!", "Atención",
						JOptionPane.WARNING_MESSAGE);
				this.formularioInsertar();
			}

		} else {
			peregrinacion = null;
		}

		return peregrinacion;

	}

	public int eliminacionPeregrinacion() {

		int result = JOptionPane
				.showConfirmDialog(
						panel,
						"¡Va a eliminar una peregrinación. Se eliminará su lista de peregrinos!",
						"Eliminación peregrinación",
						JOptionPane.WARNING_MESSAGE);

		return result;
	}

	private String obtenerFecha(JDateChooser jdatechooser) {

		int dia, mes, anio;

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

		return fecha;
	}

	private String obtenerTexto(JTextField jtextfield) {

		String texto = jtextfield.getText();

		return texto;
	}

	private Peregrinacion setPeregrinacion(Peregrinacion peregrinacion,
			String lugar, String fecha) {

		peregrinacion.setFecha(fecha);
		peregrinacion.setLugar(lugar);

		return peregrinacion;
	}

	private void instanciaLabels() {

		if (!utilidades.isObjeto(labelLugar)
				|| !utilidades.isObjeto(labelFecha)) {
			labelLugar = new JLabel("Lugar");
			labelFecha = new JLabel("Fecha");
		}
	}
}
