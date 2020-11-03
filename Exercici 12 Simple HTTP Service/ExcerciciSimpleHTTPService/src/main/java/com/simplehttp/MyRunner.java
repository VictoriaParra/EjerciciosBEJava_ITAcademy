package com.simplehttp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.simplehttp.model.Employees;
import com.simplehttp.repository.IEmployeesRepository;

/**
 * En esta clase se establece que al dar inicio a la aplicación, el método run
 * crea tres empleados en memoria.
 * 
 * @author Victoria Parra
 */

@Component
public class MyRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

	@Autowired
	private IEmployeesRepository repo;

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		logger.info("initializing users");

		// Instanciar empleado
		// Utilizo el constructor con 2 parametros de la clase Employees
		Employees employee1 = new Employees("Juan", "programmer");
		// Guardar empleado
		repo.save(employee1);

		Employees employee2 = new Employees("Ana", "programmer");
		repo.save(employee2);

		Employees employee3 = new Employees("Diego", "administrative");
		repo.save(employee3);
	}
}