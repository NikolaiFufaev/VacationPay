package ru.calculation.vacationpay;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import ru.calculation.vacationpay.controller.CalculationController;
import ru.calculation.vacationpay.service.CalculationService;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VacationPayApplicationTests {
    @Inject
    private CalculationService calculationService;
    @InjectMocks
    private CalculationController calculationController;


    @Test
    public void testGetVacationPay() {
        double expected = 11945.392491467577;
        assertEquals(expected, calculationService.getVacationPay(600000.00, 7));
    }

    @Test
    public void testGetVacationPayForZeroDays() {
        double expected = 0.0;
        assertEquals(expected, calculationService.getVacationPay(50000.00, 0));
    }

    @Test
    public void testMinusSalary() {
        HttpStatus expected = HttpStatus.BAD_REQUEST;
        assertEquals(expected, calculationController.getVacationPay(-600000.00, 14).getStatusCode());
    }


}
