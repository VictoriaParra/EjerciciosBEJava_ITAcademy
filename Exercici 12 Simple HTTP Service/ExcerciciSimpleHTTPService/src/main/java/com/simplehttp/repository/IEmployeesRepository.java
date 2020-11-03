package com.simplehttp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.simplehttp.model.Employees;

/**
 * @author Victoria Parra
 */

public interface IEmployeesRepository extends JpaRepository<Employees, Integer> {

	// Listar empleados por tipo de trabajo
	public List<Employees> findByJobType(String job);

}
