package construction.company.system;

public class Finance extends Departments{
    private long developmentBudget;
    private long trainingBudget;
    private long salaryBudget;

    public Finance(String departmentName,String companyName, String companyAddress, String companyPhoneNumber) {
        super(departmentName,companyName, companyAddress, companyPhoneNumber);
    }

    public long getDevelopmentBudget() {
        return developmentBudget;
    }

    public void setDevelopmentBudget(long developmentBudget) {
        this.developmentBudget = developmentBudget;
    }

    public long getTrainingBudget() {
        return trainingBudget;
    }

    public void setTrainingBudget(long trainingBudget) {
        this.trainingBudget = trainingBudget;
    }

    public long getSalaryBudget() {
        return salaryBudget;
    }

    public void setSalaryBudget(long salaryBudget) {
        this.salaryBudget = salaryBudget;
    }
}
