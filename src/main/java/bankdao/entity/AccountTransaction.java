package bankdao.entity;

import java.util.Date;

public class AccountTransaction {
    private int transaction_id;
    private int account_id;
    private Date transaction_date;
    private double amount;
    private String transaction_type;

    public AccountTransaction() {
    }

    public AccountTransaction(int transaction_id, int account_id, Date transaction_date, double amount, String transaction_type) {
        this.transaction_id = transaction_id;
        this.account_id = account_id;
        this.transaction_date = transaction_date;
        this.amount = amount;
        this.transaction_type = transaction_type;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transaction_id=" + transaction_id +
                ", account_id=" + account_id +
                ", transaction_date=" + transaction_date +
                ", amount=" + amount +
                ", transaction_type='" + transaction_type + '\'' +
                '}';
    }
}
