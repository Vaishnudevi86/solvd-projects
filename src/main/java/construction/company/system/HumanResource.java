package construction.company.system;

public class HumanResource extends Departments{
    private int employeeCount;
    private String location;

    public HumanResource(String departmentName, int employeeCount, String location,String companyName, String companyAddress, String companyPhoneNumber) {
        super(departmentName,companyName, companyAddress, companyPhoneNumber);
        this.employeeCount = employeeCount;
        this.location = location;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
