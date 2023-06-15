package construction.company.system;

public class Departments extends Company{
    private int departmentId;
    private String departmentName;

    public Departments(String departmentName, String companyName, String companyAddress, String companyPhoneNumber) {
        super(companyName, companyAddress, companyPhoneNumber);
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
