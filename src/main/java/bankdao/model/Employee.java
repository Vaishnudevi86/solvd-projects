package bankdao.model;


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

        private int employee_id;
        private String employee_name;
        private int branch_id;
        private String designation;
        private double salary;
        @XmlJavaTypeAdapter(DateAdapter.class)
    private Date hireDate;

        // Getters and setters
        private List<Employee> employeeList;

        // Getter and Setter for userList
        public List<Employee> getEmployeeList() {
            return employeeList;
        }

        public void setEmployeeList(List<Employee> employeeList) {
            this.employeeList = employeeList;
        }


        public Employee() {
        }

        public Employee(int employee_id, String employee_name, int branch_id, String designation, double salary) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.branch_id = branch_id;
        this.designation = designation;
        this.salary = salary;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", branch_id=" + branch_id +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                ", employeeList=" + employeeList +
                '}';
    }
}

