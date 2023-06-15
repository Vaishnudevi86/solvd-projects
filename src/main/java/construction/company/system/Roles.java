package construction.company.system;

public class Roles extends Company{
    private int roleId;
    private String roleShortDesc;
    private String roleLongDesc;

    public Roles(String companyName, String companyAddress, String companyPhoneNumber, String roleShortDesc, String roleLongDesc) {
        super(companyName, companyAddress, companyPhoneNumber);
        this.roleShortDesc = roleShortDesc;
        this.roleLongDesc = roleLongDesc;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleShortDesc() {
        return roleShortDesc;
    }

    public void setRoleShortDesc(String roleShortDesc) {
        this.roleShortDesc = roleShortDesc;
    }

    public String getRoleLongDesc() {
        return roleLongDesc;
    }

    public void setRoleLongDesc(String roleLongDesc) {
        this.roleLongDesc = roleLongDesc;
    }
}
