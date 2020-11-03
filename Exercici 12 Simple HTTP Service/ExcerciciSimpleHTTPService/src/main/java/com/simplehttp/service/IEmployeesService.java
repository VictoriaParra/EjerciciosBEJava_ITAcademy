package com.simplehttp.service;

import java.util.List;

import com.simplehttp.model.Employees;

/**
 * En esta interface se establecen los m�todos CRUD que luego la clase service
 * implementar�
 * 
 * @author Victoria Parra
 */

public interface IEmployeesService {

	// M�todos CRUD

	public List<Employees> getEmployees(); // Listar empleados

	public Employees createEmployee(Employees employee); // CREATE - crear/guardar nuevo empleado

	public Employees findEmployeeById(int id); // READ - leer datos de un empleado seg�n id

	public Employees updateEmployee(Employees employee); // UPDATE - actualizar datos del empleado

	public void deleteEmployee(int id); // DELETE - elimiar empleado seg�n id

}
