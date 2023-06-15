package bankJson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Department {
    @JsonProperty("name")
    private String name;

    @JsonProperty("employees")
    private List<Employee> employees;

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department() {
    }

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}