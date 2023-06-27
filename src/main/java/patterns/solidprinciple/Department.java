package patterns.solidprinciple;
//Liskov Substitution Principle
public abstract class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void performDepartmentFunction();
}
