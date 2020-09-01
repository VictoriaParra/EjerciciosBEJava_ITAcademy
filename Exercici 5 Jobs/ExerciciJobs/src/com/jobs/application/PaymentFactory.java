package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	public static IPaymentRate createPaymentRateBoss() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth * 1.5;
			}
		};
	}

	// Cambiar return 0 por salaryPerMonth+0.85 para q cobre un 15% menos.
	public static IPaymentRate createPaymentRateEmployee() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				//todo

				return salaryPerMonth * 0.85;
			}
		};
	}


	//Agregar el método para los Managers
	public static IPaymentRate createPaymentRateManager() {

		return new IPaymentRate() {

			public double pay(double salaryPerMonth) {

				return salaryPerMonth * 1.1;
			}
		};

	}

}
