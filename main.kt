{\rtf1\ansi\ansicpg1252\cocoartf2822
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 // Base class Employee\
open class Employee(\
    protected val name: String,\
    protected val baseSalary: Double\
) \{\
    /**\
     * Calculates the employee's salary.\
     * Open function to be overridden by subclasses.\
     * @return The calculated salary (default is baseSalary).\
     */\
    open fun calculateSalary(): Double \{\
        return baseSalary\
    \}\
\
    /**\
     * Provides a string representation of the employee.\
     */\
    override fun toString(): String \{\
        return "Employee: $name"\
    \}\
\}\
\
// Subclass FullTimeEmployee\
class FullTimeEmployee(\
    name: String,\
    baseSalary: Double,\
    private val bonus: Double\
) : Employee(name, baseSalary) \{\
\
    /**\
     * Overrides calculateSalary to include the bonus.\
     * Formula: baseSalary + bonus\
     */\
    override fun calculateSalary(): Double \{\
        return baseSalary + bonus\
    \}\
\
    override fun toString(): String \{\
        return "FullTimeEmployee: $name (Base: $baseSalary, Bonus: $bonus)"\
    \}\
\}\
\
// Subclass PartTimeEmployee\
class PartTimeEmployee(\
    name: String,\
    // Note: baseSalary is used to fulfill the Employee constructor requirement, \
    // but the PartTimeEmployee's actual salary calculation relies on rate and hours.\
    baseSalary: Double = 0.0, \
    private val hourlyRate: Double,\
    private val hoursWorked: Int\
) : Employee(name, baseSalary) \{\
\
    /**\
     * Overrides calculateSalary to calculate salary based on hourly rate and hours worked.\
     * Formula: hourlyRate * hoursWorked\
     */\
    override fun calculateSalary(): Double \{\
        return hourlyRate * hoursWorked\
    \}\
\
    override fun toString(): String \{\
        return "PartTimeEmployee: $name (Rate: $hourlyRate, Hours: $hoursWorked)"\
    \}\
\}\
\
fun main() \{\
    // 1. Create multiple employees using mapOf.\
    val employees = mapOf(\
        "Alice Johnson" to FullTimeEmployee("Alice Johnson", 50000.0, 10000.0),\
        "Bob Smith" to PartTimeEmployee("Bob Smith", hourlyRate = 25.0, hoursWorked = 160),\
        "Charlie Brown" to FullTimeEmployee("Charlie Brown", 65000.0, 5000.0),\
        "Dana Scully" to PartTimeEmployee("Dana Scully", hourlyRate = 30.0, hoursWorked = 80)\
    )\
\
    println("--- Employee Salary Report ---")\
    // Removed the problematic image tag here.\
\
    // 2. Loop through the map and display each employee's salary.\
    for ((name, employee) in employees) \{\
        // Polymorphism: The correct calculateSalary() function is called.\
        val salary = employee.calculateSalary()\
        \
        // Using String.format for clean currency output (two decimal places)\
        println("$\{employee.toString()\}")\
        println("  -> Calculated Salary: \\$$\{String.format("%.2f", salary)\}")\
    \}\
\
    println("------------------------------")\
\}}