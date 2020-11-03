package com.simplehttp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Victoria Parra
 */

@Entity // especifica que la clase es una entidad y está asignada a una tabla de bbdd
public class Employees {

	// Atributos de entidad empleados
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // el id se auto-genera.
	private int id;
	private String name;
	@Enumerated(EnumType.STRING) // JPA usará el valor del enum como un string/texto
	private JobsTypes jobType;
	private int salaryMonth;

	// Constructores

	/**
	 * Constructor por defecto/sin parámetros
	 */
	public Employees() {
		
	}

	/**
	 * Constructor con parametros que necesitamos para crear un objeto tipo empleado
	 * 
	 * @param name    nombre del empleado
	 * @param jobType tipo de trabajo del empleado
	 * @throws NullPointerException si el tipo de trabajo no es correcto/no
	 *                              corresponde a ninguno de los enums
	 */
	public Employees(String name, String job) throws NullPointerException {

		this.name = name;

		jobType = JobsTypes.getJobType(job);

		if (jobType == null) {
			throw new NullPointerException("El tipo de trabajo no es correcto");
		}

		salaryMonth = jobType.getSalary(job);
	}

//	/**
//	 * @param id          id del empleado
//	 * @param name        nombre del empleado
//	 * @param jobType     tipo de trabajo del empleado
//	 * @param salaryMonth salario del empleado
//	 */
//	public Employees(int id, String name, JobsTypes jobType, int salaryMonth) {
//
//		this.id = id;
//		this.name = name;
//		this.jobType = jobType;
//		this.salaryMonth = salaryMonth;
//	}

	// GETTERS Y SETTERS

	/**
	 * Método para obtener el id del empleado
	 * 
	 * @return ID del empleado
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para establecer cual es el id del empleado
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Método para obtener el nombre del empleado
	 * 
	 * @return nombre del empleado
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método para establecer el nombre del empleado
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método para obtener el tipo de trabajo del empleado
	 * 
	 * @return el tipo de trabajo, que es del tipo enum, una constante
	 */
	public JobsTypes getType() {
		return jobType;
	}

	/**
	 * Método para establecer el tipo de trabajo del empleado. Se utilizará el
	 * método de getJobType de la clase JobsTypes para convertir y corroborar que el
	 * tipo de trabajo exista y sea del tipo enum/JobsTypes
	 * 
	 * @param jobType tipo de trabajo del empleado
	 */
	public void setType(String jobType) {
		this.jobType = JobsTypes.getJobType(jobType);
	}

	/**
	 * Método para obtener el salario por mes del empleado
	 * 
	 * @return salario (por mes) del empleado
	 */
	public int getSalaryMonth() {
		return salaryMonth;
	}

	/**
	 * Método para establecer el salario del empleado. El salario se establece segun
	 * el tipo de trabajo que tiene.
	 * 
	 * @param jobType
	 */
	public void setSalaryMonth(JobsTypes jobType) {
		salaryMonth = jobType.getSalary(jobType.toString());
	}

	// Método para poder ver los datos por consola
	@Override
	public String toString() {
		return "Employees [id= " + id + ", name= " + name + ", job_type= " + jobType + ", salary_Month= " + salaryMonth
				+ "]";
	}
}
