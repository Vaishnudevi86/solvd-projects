package construction.company.system;


import java.util.Objects;

public class Employee extends Roles {
    private String firstName;
    private String lastName;
    private long employeeId;
    private String phoneNumber;
    private String address;

    public Employee(String firstName, String lastName, String phoneNumber,
                    String address, String roleShortDesc, String roleLongDesc,
                    String companyName, String companyAddress, String companyPhoneNumber) {
        super(companyName, companyAddress, companyPhoneNumber, roleShortDesc, roleLongDesc);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(address, employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, employeeId, phoneNumber, address);
    }
}
