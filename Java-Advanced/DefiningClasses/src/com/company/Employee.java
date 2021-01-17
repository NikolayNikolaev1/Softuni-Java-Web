package com.company;

public class Employee {
    private static final String DEFAULT_MISSING_EMAIL = "n/a";
    private static final int DEFAULT_MISSING_AGE = -1;

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        setName(name);
        setSalary(salary);
        setPosition(position);
        setDepartment(department);
        setEmail(email);
        setAge(age);
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, DEFAULT_MISSING_AGE);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, DEFAULT_MISSING_EMAIL, age);
    }

    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, DEFAULT_MISSING_EMAIL, DEFAULT_MISSING_AGE);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    private void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    private void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }
}
