package ru.calculation.vacationpay.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public double getVacationPay(double averageSalary, int vacationDays) {
        return (averageSalary / 351.6) * vacationDays;
    }

}
