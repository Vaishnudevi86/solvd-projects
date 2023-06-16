package bankdao.entity;

public class AccountHolderTransaction {
    private int account_holder_transaction_id;
    private int account_holder_id;
    private int transaction_id;

    public AccountHolderTransaction() {
    }

    public AccountHolderTransaction(int account_holder_transaction_id, int account_holder_id, int transaction_id) {
        this.account_holder_transaction_id = account_holder_transaction_id;
        this.account_holder_id = account_holder_id;
        this.transaction_id = transaction_id;
    }

    public int getAccount_holder_transaction_id() {
        return account_holder_transaction_id;
    }

    public void setAccount_holder_transaction_id(int account_holder_transaction_id) {
        this.account_holder_transaction_id = account_holder_transaction_id;
    }

    public int getAccount_holder_id() {
        return account_holder_id;
    }

    public void setAccount_holder_id(int account_holder_id) {
        this.account_holder_id = account_holder_id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    @Override
    public String toString() {
        return "AccountHolderTransaction{" +
                "account_holder_transaction_id=" + account_holder_transaction_id +
                ", account_holder_id=" + account_holder_id +
                ", transaction_id=" + transaction_id +
                '}';
    }
}
