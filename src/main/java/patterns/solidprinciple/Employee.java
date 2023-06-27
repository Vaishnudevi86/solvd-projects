package patterns.solidprinciple;
////Dependency Inversion Principle
public class Employee implements EmployeeRole {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public void performRole() {
        // Perform employee role-specific operations
        if (role.equals("Manager")) {
            manage();
        } else if (role.equals("Teller")) {
            processTransaction();
        } else if (role.equals("Loan Officer")) {
            processLoanApplication();
        } else {
            System.out.println("Invalid role");
        }
    }

    private void manage() {
        System.out.println(name + " is managing operations.");
    }

    private void processTransaction() {
        System.out.println(name + " is processing a transaction.");
    }

    private void processLoanApplication() {
        System.out.println(name + " is processing a loan application.");
    }


}
