package construction.company.system;

public class Sales extends Departments{
    private long forecastedBudget;
    private double profitMargin;
    private long actualProfit;

    public Sales(String departmentName, long forecastedBudget,String companyName, String companyAddress, String companyPhoneNumber) {
        super(departmentName,companyName, companyAddress, companyPhoneNumber);
        this.forecastedBudget = forecastedBudget;
    }

    public long getForecastedBudget() {
        return forecastedBudget;
    }

    public void setForecastedBudget(long forecastedBudget) {
        this.forecastedBudget = forecastedBudget;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public long getActualProfit() {
        return actualProfit;
    }

    public void setActualProfit(long actualProfit) {
        this.actualProfit = actualProfit;
    }
}
