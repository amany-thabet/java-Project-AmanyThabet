# Employee Management System

**Student name:** Amany Thabet Abdelrazek  
**Student ID:** 2303121

## Project Description

This project is a Java implementation of an Employee Management System based on the provided UML diagram. It includes different employee types, department management, employee search, and salary calculations.

## How to Run

1. Install JDK 17 or later.
2. Open a terminal in the project folder—the folder containing `README.md` and `src`.
3. Compile the project:

   ```bash
   mkdir out
   javac -d out src/model/Gender.java src/model/Employee.java src/model/CommissionEmployee.java src/model/MonthlyEmployee.java src/model/HourlyEmployee.java src/model/Department.java src/Main.java src/test/MainTest.java
   ```

4. Run the demo:

   ```bash
   java -cp out Main
   ```

5. Run the included checks:

   ```bash
   java -ea -cp out test.MainTest
   ```

The checks should print: `All checks passed.`
