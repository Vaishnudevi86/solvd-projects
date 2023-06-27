package patterns.solidprinciple;
//Liskov Substitution Principle
public class HRDepartment extends Department {
    public HRDepartment(String name) {
        super(name);
    }

    @Override
    public void performDepartmentFunction() {
        // Implementation for HR department specific function
        System.out.println("Performing HR department function");
    }
}