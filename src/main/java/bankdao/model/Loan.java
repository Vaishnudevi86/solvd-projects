package bankdao.model;

public class Loan {
    private int loan_id;
    private int branch_id;
    private int account_id;
    private String loan_type;
    private double loan_amount;
    private float interest_rate ;

    public Loan() {
    }

    public Loan(int loan_id, int branch_id, int account_id, String loan_type, double loan_amount, float interest_rate) {
        this.loan_id = loan_id;
        this.branch_id = branch_id;
        this.account_id = account_id;
        this.loan_type = loan_type;
        this.loan_amount = loan_amount;
        this.interest_rate = interest_rate;
    }

    public int getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(int loan_id) {
        this.loan_id = loan_id;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(String loan_type) {
        this.loan_type = loan_type;
    }

    public double getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(double loan_amount) {
        this.loan_amount = loan_amount;
    }

    public float getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(float interest_rate) {
        this.interest_rate = interest_rate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loan_id=" + loan_id +
                ", branch_id=" + branch_id +
                ", account_id=" + account_id +
                ", loan_type='" + loan_type + '\'' +
                ", loan_amount=" + loan_amount +
                ", interest_rate=" + interest_rate +
                '}';
    }
}
