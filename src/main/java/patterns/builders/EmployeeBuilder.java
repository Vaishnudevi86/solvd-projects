package patterns.builders;

import bankdao.entity.Employee;

public class EmployeeBuilder {
    private int employeeId;
    private String employeeName;
    private int departmentId;
    private String designation;
    private double salary;

    public EmployeeBuilder setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public EmployeeBuilder setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public EmployeeBuilder setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public EmployeeBuilder setDesignation(String designation) {
        this.designation = designation;
        return this;
    }

    public EmployeeBuilder setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public Employee build() {
        return new Employee(employeeId, employeeName, departmentId, designation, salary);
    }
}