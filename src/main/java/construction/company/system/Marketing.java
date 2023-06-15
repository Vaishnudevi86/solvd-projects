package construction.company.system;

public class Marketing extends Departments{
    private long budget;
    private String campaignId;
    private String campaignName;

    public Marketing(String departmentName, long budget, String campaignId, String campaignName,String companyName, String companyAddress, String companyPhoneNumber) {
        super(departmentName,companyName, companyAddress, companyPhoneNumber);
        this.budget = budget;
        this.campaignId = campaignId;
        this.campaignName = campaignName;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
}
