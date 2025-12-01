Employee Salary System (Kotlin)
This Kotlin program models an employee salary calculation system, demonstrating core Object-Oriented Programming (OOP) concepts, specifically inheritance and polymorphism.

Program Structure:
The system uses a class hierarchy:

Base Class (Employee):

Protected properties: name and baseSalary.

Open function: calculateSalary(), which returns the baseSalary by default.

Subclasses:

FullTimeEmployee: Inherits from Employee. Overrides calculateSalary() to include an additional bonus.

PartTimeEmployee: Inherits from Employee. Overrides calculateSalary() to calculate salary based on hourlyRate multiplied by hoursWorked.

Implementation Details:
The main function stores various Employee types (Full-Time and Part-Time) in a Map<String, Employee> using the mapOf utility.

The program iterates through the map and calls calculateSalary() for each object. This demonstrates polymorphism, as the correct, type-specific calculation (either including a bonus or using hourly wages) is executed at runtime based on the actual class of the employee object.

The output displays the name, type, relevant variables, and the final calculated salary for each employee.
