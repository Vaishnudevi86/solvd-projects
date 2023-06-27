package bankdao.entity;


import bankJaxb.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
    public class Employee {
        @XmlElement(name = "name")
        private String name;

        @XmlElement(name = "position")
        private String position;


        @XmlJavaTypeAdapter(DateAdapter.class)
    private Date hireDate;

        // Getters and setters
        private List<Employee> employeeList;

    private int employeeId;
    private String employeeName;
    private int branchId;
    private String designation;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{"+
                " employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", branchId=" + branchId +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee( int employeeId, String employeeName, int branchId, String designation, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.branchId = branchId;
        this.designation = designation;
        this.salary = salary;


    }
}

