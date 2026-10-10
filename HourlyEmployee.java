package model;

import java.time.LocalDate;

/** Employee paid according to the number of hours worked. */
public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    private double overtimeRate;

    public HourlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                          double hourlyRate, double hoursWorked, double overtimeRate) {
        super(id, name, gender, hireDate);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
        setOvertimeRate(overtimeRate);
    }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) throw new IllegalArgumentException("hourlyRate cannot be negative");
        this.hourlyRate = hourlyRate;
    }
    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) throw new IllegalArgumentException("hoursWorked cannot be negative");
        this.hoursWorked = hoursWorked;
    }
    public double getOvertimeRate() { return overtimeRate; }
    public void setOvertimeRate(double overtimeRate) {
        if (overtimeRate < 0) throw new IllegalArgumentException("overtimeRate cannot be negative");
        this.overtimeRate = overtimeRate;
    }

    /** Assumption: the first 40 hours use hourlyRate; each extra hour uses overtimeRate. */
    @Override
    public double calculateSalary() {
        double regularHours = Math.min(hoursWorked, 40.0);
        double overtimeHours = Math.max(0.0, hoursWorked - 40.0);
        return regularHours * hourlyRate + overtimeHours * overtimeRate;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [hourlyRate=%.2f, hoursWorked=%.2f, overtimeRate=%.2f]",
                hourlyRate, hoursWorked, overtimeRate);
    }
}
