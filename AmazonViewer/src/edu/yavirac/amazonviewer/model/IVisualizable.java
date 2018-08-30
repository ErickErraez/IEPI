package edu.yavirac.amazonviewer.model;

import java.util.Date;


public interface IVisualizable {

	/**
	 * Este metodo captura el tiempo exacto de inicio de visualizacion
	 * 
	 * @param date1 es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @return Devuelve la fecha y hora capturada.
	 * 
	 */

	Date startToSee(Date dateI);

	/**
	 * Este metodo captura el tiempo exacto de inicio y final de visualizacion
	 * 
	 * @param date1 es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @param date1 es un objeto {@code Date} con el tiempo de final exacto.
	 * @return Devuelve la fecha y hora capturada.
	 * 
	 */

	void stopToSee(Date dateI, Date dateF);

}
