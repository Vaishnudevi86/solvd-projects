package construction.company.system;

public class Projects extends Company{
    private int projectId;
    private String projectType;

    public Projects(String companyName, String companyAddress, String companyPhoneNumber, int projectId, String projectType) {
        super(companyName, companyAddress, companyPhoneNumber);
        this.projectId = projectId;
        this.projectType = projectType;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
}
