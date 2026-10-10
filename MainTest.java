package test;

import model.CommissionEmployee;
import model.Department;
import model.Gender;
import model.HourlyEmployee;
import model.MonthlyEmployee;

import java.time.LocalDate;
import java.util.ArrayList;

/** Lightweight executable checks; run with: java -ea -cp out test.MainTest */
public class MainTest {
    public static void main(String[] args) {
        CommissionEmployee commissionEmployee = new CommissionEmployee(1, "Test Sales", Gender.MALE,
                LocalDate.of(2024, 1, 1), 5000, 0.10, 20000);
        assert Math.abs(commissionEmployee.calculateCommission() - 2000.0) < 0.001;
        assert Math.abs(commissionEmployee.calculateSalary() - 7000.0) < 0.001;

        MonthlyEmployee monthlyEmployee = new MonthlyEmployee(2, "Test Monthly", Gender.FEMALE,
                LocalDate.of(2023, 1, 1), 10000, 21, 0.05, true);
        assert Math.abs(monthlyEmployee.calculateSalary() - 10500.0) < 0.001;

        HourlyEmployee hourlyEmployee = new HourlyEmployee(3, "Test Hourly", Gender.MALE,
                LocalDate.of(2025, 1, 1), 100, 45, 150);
        assert Math.abs(hourlyEmployee.calculateSalary() - 4750.0) < 0.001;

        Department department = new Department(1, "Test", monthlyEmployee, new ArrayList<>());
        department.addEmployee(monthlyEmployee);
        department.addEmployee(commissionEmployee);
        assert department.findEmployee(1) == commissionEmployee;
        assert Math.abs(department.calculateTotalPayroll() - 17500.0) < 0.001;
        department.removeEmployee(1);
        assert department.findEmployee(1) == null;
        assert commissionEmployee.getDepartment() == null;

        System.out.println("All checks passed.");
    }
}
