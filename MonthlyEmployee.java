package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/** Employee paid a fixed monthly salary. */
public class MonthlyEmployee extends Employee {
    private double monthlySalary;
    private int vacationDays;
    private double bonusPercentage;
    private boolean hasHealthInsurance;

    public MonthlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                           double monthlySalary, int vacationDays,
                           double bonusPercentage, boolean hasHealthInsurance) {
        super(id, name, gender, hireDate);
        setMonthlySalary(monthlySalary);
        setVacationDays(vacationDays);
        setBonusPercentage(bonusPercentage);
        this.hasHealthInsurance = hasHealthInsurance;
    }

    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary < 0) throw new IllegalArgumentException("monthlySalary cannot be negative");
        this.monthlySalary = monthlySalary;
    }
    public int getVacationDays() { return vacationDays; }
    public void setVacationDays(int vacationDays) {
        if (vacationDays < 0) throw new IllegalArgumentException("vacationDays cannot be negative");
        this.vacationDays = vacationDays;
    }
    public double getBonusPercentage() { return bonusPercentage; }
    /** Rate is a decimal fraction, e.g. 0.05 means 5%. */
    public void setBonusPercentage(double bonusPercentage) {
        if (bonusPercentage < 0) throw new IllegalArgumentException("bonusPercentage cannot be negative");
        this.bonusPercentage = bonusPercentage;
    }
    public boolean isHasHealthInsurance() { return hasHealthInsurance; }
    public void setHasHealthInsurance(boolean hasHealthInsurance) { this.hasHealthInsurance = hasHealthInsurance; }

    @Override
    public double calculateSalary() { return monthlySalary * (1.0 + bonusPercentage); }

    /** Assumption: one additional vacation day per completed service year, capped at ten. */
    public int calculateAdditionalVacation() {
        int serviceYears = Math.max(0, Period.between(getHireDate(), LocalDate.now()).getYears());
        return (int) Math.min(10, serviceYears);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [monthlySalary=%.2f, vacationDays=%d, bonus=%.1f%%, healthInsurance=%s]",
                monthlySalary, vacationDays, bonusPercentage * 100, hasHealthInsurance);
    }
}
