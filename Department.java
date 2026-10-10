package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** A department owns its employee roster and references its manager. */
public class Department {
    private int id;
    private String name;
    private Employee manager;
    private final List<Employee> employees;

    public Department(int id, String name, Employee manager, List<Employee> employees) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.employees = new ArrayList<>();
        if (employees != null) {
            for (Employee employee : employees) addEmployee(employee);
        }
        this.manager = manager;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = Objects.requireNonNull(name, "name must not be null"); }
    public Employee getManager() { return manager; }
    public void setManager(Employee manager) { this.manager = manager; }
    public List<Employee> getEmployees() { return Collections.unmodifiableList(employees); }

    public void addEmployee(Employee employee) {
        Objects.requireNonNull(employee, "employee must not be null");
        if (!employees.contains(employee)) employees.add(employee);
        employee.setDepartment(this);
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(employee -> {
            if (employee.getId() == employeeId) {
                if (employee.getDepartment() == this) employee.setDepartment(null);
                return true;
            }
            return false;
        });
        if (manager != null && manager.getId() == employeeId) manager = null;
    }

    public Employee findEmployee(int employeeId) {
        return employees.stream().filter(employee -> employee.getId() == employeeId).findFirst().orElse(null);
    }

    public double calculateTotalPayroll() {
        return employees.stream().mapToDouble(Employee::calculateSalary).sum();
    }

    public void printAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in department " + name);
            return;
        }
        employees.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return String.format("Department{id=%d, name='%s', manager=%s, employeeCount=%d}",
                id, name, manager == null ? "None" : manager.getName(), employees.size());
    }
}
