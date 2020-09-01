package com.jobs.application;

import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	// Inicializar objeto
	private EmployeeRepository repository = new EmployeeRepository();

	public JobsController() {

	}

	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee boss = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}

	// Cambiar boss por employee
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee employee = new Employee(name, address, phone, salaryPerMonth,
				PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	// Crear Manager
	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth)
			throws Exception {
		// TODO Auto-generated method stub
		Employee manager = new Employee(name, address, phone, salaryPerMonth,
				PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);

	}

	public void payAllEmployeers() {
		// TODO Auto-generated method stub

		// Recorrer el listado de members
		for (int i = 0; i < repository.getAllMembers().size(); i++) {

			// Generación de pago para el miembro actual.
			repository.getAllMembers().get(i).pay();

		}

	}

	public String getAllEmployees() {
		// TODO Auto-generated method stub
		String returnString = "\n";

		// Recorrer el listado de members
		for (int i = 0; i < repository.getAllMembers().size(); i++) {

			// Obtener la info del miembro actual y guardarla en la variable returnString
			returnString = returnString + (repository.getAllMembers().get(i).toString()) + "\n";

		}
		// Devolver la variable returnString con toda la informacion del listado de
		// members
		return returnString;

	}

	// Crear Volunteer
	public void createVolunteer(String name, String address, String phone) throws Exception {
		// public void createVolunteer(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		Volunteer volunteer = new Volunteer(name, address, phone, "Es voluntario");
		repository.addMember(volunteer);

	}

}
