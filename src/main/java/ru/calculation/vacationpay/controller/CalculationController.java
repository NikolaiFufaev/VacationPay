package ru.calculation.vacationpay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.calculation.vacationpay.service.CalculationService;

@Controller
@RequestMapping("/calculacte")
public class CalculationController {
    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }


    @GetMapping()
    public ResponseEntity<String> getVacationPay(@RequestParam double averageSalary, @RequestParam int vacationDays) {
        if (averageSalary <= 0 || vacationDays <= 0) {
            String response = "Средняя зарплата и количество дней отпуска не могут быть отрицательными или равны 0.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        String response = String.format("%.2f", calculationService.getVacationPay(averageSalary, vacationDays));
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
