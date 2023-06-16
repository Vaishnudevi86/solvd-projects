package bankdao.entity;

import java.util.Date;

public class Deposit {
    private int deposit_id;
    private int branch_id;
    private int account_id;
    private double deposit_amount;
    private Date deposit_date;

    public Deposit() {
    }

    public Deposit(int deposit_id, int branch_id, int account_id, double deposit_amount, Date deposit_date) {
        this.deposit_id = deposit_id;
        this.branch_id = branch_id;
        this.account_id = account_id;
        this.deposit_amount = deposit_amount;
        this.deposit_date = deposit_date;
    }

    public int getDeposit_id() {
        return deposit_id;
    }

    public void setDeposit_id(int deposit_id) {
        this.deposit_id = deposit_id;
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

    public double getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(double deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public Date getDeposit_date() {
        return deposit_date;
    }

    public void setDeposit_date(Date deposit_date) {
        this.deposit_date = deposit_date;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "deposit_id=" + deposit_id +
                ", branch_id=" + branch_id +
                ", account_id=" + account_id +
                ", deposit_amount=" + deposit_amount +
                ", deposit_date=" + deposit_date +
                '}';
    }
}
