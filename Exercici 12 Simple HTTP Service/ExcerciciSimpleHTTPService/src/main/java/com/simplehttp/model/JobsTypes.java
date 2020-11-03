package com.simplehttp.model;

/**
 * Clase enum para el tipo de trabajo del empleado. De este modo se pueden
 * agregar más tipos de trabajo en un futuro, sin necesidad de modificar la
 * clase Employees
 * 
 * @author Victoria Parra
 */

public enum JobsTypes {

	PROGRAMMER, ADMINISTRATIVE, RECEPTIONIST;

	/**
	 * Método para verificar si el parámetro coincide con algun valor del enum y si
	 * es así devuelve dicho valor y sino devuelve nulo.
	 * 
	 * @param typejob
	 * @return el tipo de trabajo sino coincide devuelve nulo
	 */
	public static JobsTypes getJobType(String typejob) {
		for (JobsTypes v : JobsTypes.values()) {
			if (v.name().equalsIgnoreCase(typejob)) {
				return v;
			}
		}
		return null;
	}

	/**
	 * Método para devolver el salario del empleado según el tipo de trabajo
	 * 
	 * @param typejob tipo de trabajo del empleado
	 * @return salario salario del empleado
	 */
	public int getSalary(String typejob) {

		if (typejob.equalsIgnoreCase(JobsTypes.ADMINISTRATIVE.name())) {
			return 1900;
			
		} else if (typejob.equalsIgnoreCase(JobsTypes.PROGRAMMER.name())) {
			return 2100;

		} else if (typejob.equalsIgnoreCase(JobsTypes.RECEPTIONIST.name())) {
			return 1500;
			
		} else {
			return 0;
		}
	}

}
