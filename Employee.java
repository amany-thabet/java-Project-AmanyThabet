package model;

import java.time.LocalDate;
import java.util.Objects;

/** Common base class for every employee type. */
public abstract class Employee {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate hireDate;
    private Department department;

    public Employee(int id, String name, Gender gender, LocalDate hireDate) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.gender = Objects.requireNonNull(gender, "gender must not be null");
        this.hireDate = Objects.requireNonNull(hireDate, "hireDate must not be null");
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = Objects.requireNonNull(name, "name must not be null"); }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = Objects.requireNonNull(gender, "gender must not be null"); }
    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = Objects.requireNonNull(hireDate, "hireDate must not be null"); }
    public Department getDepartment() { return department; }

    /** Assigns this employee to a department; use Department.addEmployee to update both sides. */
    public void setDepartment(Department department) { this.department = department; }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("%s{id=%d, name='%s', gender=%s, hireDate=%s, department=%s}",
                getClass().getSimpleName(), id, name, gender, hireDate,
                department == null ? "Unassigned" : department.getName());
    }
}
