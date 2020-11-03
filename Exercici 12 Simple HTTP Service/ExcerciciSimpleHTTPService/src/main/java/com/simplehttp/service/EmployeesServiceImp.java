package com.simplehttp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplehttp.exceptions.ArgumentNotFoundException;
import com.simplehttp.model.Employees;
import com.simplehttp.repository.IEmployeesRepository;

/**
 * @author Victoria Parra
 */

@Service // esta anotación indica que la clase es una service class.
public class EmployeesServiceImp implements IEmployeesService {

	// Utilizar los métodos de la interface IEmployeesRepository
	@Autowired
	private IEmployeesRepository repo;

	public List<Employees> findByJobType(String job) {
		// Filtrar empleados segun el trabajo que se pasa por parámetro
		return repo.findAll().stream().filter(s -> s.getType().toString().equalsIgnoreCase(job))
				.collect(Collectors.toList());
	}

	// Override métodos crud

	@Override
	public List<Employees> getEmployees() {
		return repo.findAll();
	}

	@Override
	public Employees createEmployee(Employees employee) {
		return repo.save(employee);
	}

	@Override
	public Employees findEmployeeById(int id) throws ArgumentNotFoundException {

		// Verificar si el empleado existe sino lanzar una excepción
		if (repo.existsById(id) == false) {
			throw new ArgumentNotFoundException("No existe ningún empleado con ID: " + id);
		} else {
			return repo.findById(id).get();
		}
	}

	@Override
	public Employees updateEmployee(Employees employee) {
		return repo.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		repo.deleteById(id);
	}

}
