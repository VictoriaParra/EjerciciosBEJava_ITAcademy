package com.jobs.domain;

public class Volunteer extends AbsStaffMember {

	protected double salaryPerMonth;

	public Volunteer(String name, String address, String phone, String description) throws Exception {

		super(name, address, phone);

		// TODO
		if (description.equals("")) {
			throw new Exception();
		}

		salaryPerMonth = 0;
	}

	@Override
	public void pay() {
		// TODO
		totalPaid = salaryPerMonth;

	}

	@Override
	public String toString() {
		return "Volunteer [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", salaryPerMonth= " + salaryPerMonth + ", totalPaid=" + totalPaid + "]";
	}

}
