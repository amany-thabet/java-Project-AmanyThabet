# Employee Management System

**Student name:** [اكتب اسمك الكامل هنا]  
**Student ID:** [اكتب رقمك الجامعي هنا]

A small Java project based on the supplied UML diagram. It models employees, departments, salary calculation, employee lookup, and a runnable demonstration.

## Project structure

```text
EmployeeManagementSystem/
├── src/
│   ├── Main.java
│   ├── model/
│   │   ├── Employee.java
│   │   ├── CommissionEmployee.java
│   │   ├── MonthlyEmployee.java
│   │   ├── HourlyEmployee.java
│   │   ├── Department.java
│   │   └── Gender.java
│   └── test/
│       └── MainTest.java
└── README.md
```

## Requirements

Install a JDK (Java 17 or later recommended), then open a terminal in the project folder.

## Compile and run the demo

```bash
mkdir -p out
javac -d out src/model/*.java src/Main.java src/test/MainTest.java
java -cp out Main
```

## Run the lightweight checks

```bash
java -ea -cp out test.MainTest
```

Expected result: `All checks passed.`

## Assumptions (the diagram does not specify formulas)

- Commission rate and bonus percentage are decimal fractions: `0.10` means 10%.
- Commission salary = base salary + (sales amount × commission rate).
- Monthly salary = monthly salary + the percentage bonus.
- Hourly pay uses `hourlyRate` for the first 40 hours and `overtimeRate` for each hour above 40; here `overtimeRate` is the full overtime hourly amount.
- Additional vacation is one day per completed service year, capped at ten days.
- Department payroll is the sum of salaries for the employees in its roster; health insurance is stored as a property and does not change the salary formula.

## Upload to GitHub

1. Replace the student name and ID above with your own details.
2. Create a **public** repository on GitHub. Do not initialize it with a README, license, or `.gitignore`.
3. From this project folder, run the commands in the assignment instructions, replacing the URL with your repository URL:

```bash
git init
git add .
git commit -m "Initial commit: Java diagram implementation"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/YOUR-REPO-NAME.git
git push -u origin main
```

4. Copy the repository URL for submission.
