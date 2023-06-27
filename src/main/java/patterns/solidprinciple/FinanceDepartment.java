package patterns.solidprinciple;
//Liskov Substitution Principle
public class FinanceDepartment extends Department {
    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void performDepartmentFunction() {
        // Implementation for finance department specific function
        System.out.println("Performing finance department function");
    }
}