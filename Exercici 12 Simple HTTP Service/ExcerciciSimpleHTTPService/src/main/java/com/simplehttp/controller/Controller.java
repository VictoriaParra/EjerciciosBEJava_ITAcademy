package com.simplehttp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplehttp.exceptions.ArgumentNotFoundException;
import com.simplehttp.model.Employees;
import com.simplehttp.model.JobsTypes;
import com.simplehttp.service.EmployeesServiceImp;

/**
 * @author Victoria Parra
 */

@RestController
@RequestMapping("/api")
public class Controller {

	public Controller() {
	}

	@Autowired
	private EmployeesServiceImp employeesService;

	// Listar empleados según trabajo
	@GetMapping("/employees/{job}")
	public ResponseEntity<List<Employees>> findByJobType(@PathVariable String job) throws ArgumentNotFoundException {

		// Si el tipo de trabajo no coincide con los enums lanzar una excepción
		if (JobsTypes.getJobType(job) == null) {
			throw new ArgumentNotFoundException("El tipo de trabajo " + job + " no existe");

			// Si no encuentra ningun empleado con ese trabajo lanzar una excepción
		} else if (employeesService.findByJobType(job).isEmpty()) {
			throw new ArgumentNotFoundException("No existe ningún empleado con tipo de trabajo: " + job);

		} else {
			return new ResponseEntity<List<Employees>>(employeesService.findByJobType(job), HttpStatus.OK);
		}
	}

	// Listar empleados
	@GetMapping("/employees")
	public ResponseEntity<List<Employees>> getEmployees() throws ArgumentNotFoundException {

		// Si la lista de empleados esta vacia lanzar una excepción
		if (employeesService.getEmployees().isEmpty()) {
			throw new ArgumentNotFoundException("No existe ningún empleado");
		}
		return new ResponseEntity<List<Employees>>(employeesService.getEmployees(), HttpStatus.OK);
	}

	@GetMapping("/employees/get/{id}")
	public ResponseEntity<Employees> findEmployeeXId(@PathVariable(name = "id") int id)
			throws ArgumentNotFoundException {

		return new ResponseEntity<Employees>(employeesService.findEmployeeById(id), HttpStatus.OK);
	}

	// Crear nuevo empleado
	@PostMapping("/employees")
	public ResponseEntity<Employees> createEmployee(@RequestBody Employees employee) throws ArgumentNotFoundException {

		Employees newEmployee = new Employees();

		// Lanzar una excepción si el trabajo no coincide con los enums
		if (employee.getType() == null) {
			throw new ArgumentNotFoundException("El tipo de trabajo no existe. Verifique los campos");
		} else {
			newEmployee.setName(employee.getName());
			newEmployee.setType(employee.getType().toString());
			newEmployee.setSalaryMonth(employee.getType());
		}

		// Guardar nuevo empleado en memoria
		return new ResponseEntity<Employees>(employeesService.createEmployee(newEmployee), HttpStatus.CREATED);
	}

	// Actualizar datos del empleado según id
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employees> updateEmployee(@PathVariable(name = "id") int id, @RequestBody Employees employee)
			throws ArgumentNotFoundException {

		Employees employeeSelected = new Employees();
		Employees employeeUpdated = new Employees();

		employeeSelected = employeesService.findEmployeeById(id);

		// Lanzar una excepción si el trabajo no coincide con los enums
		if (employee.getType() == null) {
			throw new ArgumentNotFoundException("El tipo de trabajo no existe. Verifique los campos");
		} else {
			employeeSelected.setName(employee.getName());
			employeeSelected.setType(employee.getType().toString());
			employeeSelected.setSalaryMonth(employee.getType());
		}

		// Guardar actualización de datos del empleado en memoria
		employeeUpdated = employeesService.updateEmployee(employeeSelected);

		return new ResponseEntity<Employees>(employeeUpdated, HttpStatus.CREATED);
	}

	// Borrar empleado según id
	@DeleteMapping("/employees/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") int id) throws ArgumentNotFoundException {

		// Verificar que el empleado exista
		employeesService.findEmployeeById(id);
		// Borrar empleado
		employeesService.deleteEmployee(id);

		return new ResponseEntity<>("El empleado con ID: " + id + " ha sido eliminado exitosamente!", HttpStatus.OK);
	}

}
