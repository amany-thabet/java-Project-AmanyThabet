package model;

import java.time.LocalDate;

/** Employee paid a base salary plus commission on sales. */
public class CommissionEmployee extends Employee {
    private double baseSalary;
    private double commissionRate;
    private double salesAmount;

    public CommissionEmployee(int id, String name, Gender gender, LocalDate hireDate,
                             double baseSalary, double commissionRate, double salesAmount) {
        super(id, name, gender, hireDate);
        setBaseSalary(baseSalary);
        setCommissionRate(commissionRate);
        setSalesAmount(salesAmount);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) throw new IllegalArgumentException("baseSalary cannot be negative");
        this.baseSalary = baseSalary;
    }
    public double getCommissionRate() { return commissionRate; }
    /** Rate is a decimal fraction, e.g. 0.10 means 10%. */
    public void setCommissionRate(double commissionRate) {
        if (commissionRate < 0) throw new IllegalArgumentException("commissionRate cannot be negative");
        this.commissionRate = commissionRate;
    }
    public double getSalesAmount() { return salesAmount; }
    public void setSalesAmount(double salesAmount) {
        if (salesAmount < 0) throw new IllegalArgumentException("salesAmount cannot be negative");
        this.salesAmount = salesAmount;
    }

    public double calculateCommission() { return salesAmount * commissionRate; }

    @Override
    public double calculateSalary() { return baseSalary + calculateCommission(); }

    @Override
    public String toString() {
        return super.toString() + String.format(" [baseSalary=%.2f, commission=%.2f, sales=%.2f]",
                baseSalary, calculateCommission(), salesAmount);
    }
}
