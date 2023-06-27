package patterns.builders;

import bankdao.entity.Department;

public class DepartmentBuilder {
    private int departmentId;
    private String departmentName;
    private String location;
    private int managerId;

    public DepartmentBuilder setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public DepartmentBuilder setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public DepartmentBuilder setLocation(String location) {
        this.location = location;
        return this;
    }

    public DepartmentBuilder setManagerId(int managerId) {
        this.managerId = managerId;
        return this;
    }

    public Department build() {
        return new Department(departmentId, departmentName, location, managerId);
    }
}