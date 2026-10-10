import model.CommissionEmployee;
import model.Department;
import model.Employee;
import model.Gender;
import model.HourlyEmployee;
import model.MonthlyEmployee;

import java.time.LocalDate;
import java.util.ArrayList;

/** Small runnable demonstration of the employee management model. */
public class Main {
    public static void main(String[] args) {
        MonthlyEmployee manager = new MonthlyEmployee(1, "Mona Ali", Gender.FEMALE,
                LocalDate.of(2020, 3, 1), 12000, 21, 0.05, true);
        Department department = new Department(10, "Sales", manager, new ArrayList<>());
        department.addEmployee(manager);
        department.addEmployee(new CommissionEmployee(2, "Omar Hassan", Gender.MALE,
                LocalDate.of(2022, 6, 15), 7000, 0.10, 25000));
        department.addEmployee(new HourlyEmployee(3, "Sara Nabil", Gender.FEMALE,
                LocalDate.of(2024, 1, 10), 100, 45, 150));

        System.out.println(department);
        System.out.println("Employees:");
        department.printAllEmployees();
        System.out.printf("Total monthly payroll: %.2f%n", department.calculateTotalPayroll());

        Employee found = department.findEmployee(2);
        System.out.println("Found employee #2: " + found);
    }
}
