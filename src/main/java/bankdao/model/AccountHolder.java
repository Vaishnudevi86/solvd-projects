package bankdao.model;

import java.util.Date;

public class AccountHolder {
    private int account_holder_id;
    private String name;
    private String address;
    private String contact_number;
    private Date date_of_birth;
    public AccountHolder() {
    }

    public AccountHolder(int account_holder_id, String name, String address, String contact_number, Date date_of_birth) {
        this.account_holder_id = account_holder_id;
        this.name = name;
        this.address = address;
        this.contact_number = contact_number;
        this.date_of_birth = date_of_birth;
    }

    public int getAccount_holder_id() {
        return account_holder_id;
    }

    public void setAccount_holder_id(int account_holder_id) {
        this.account_holder_id = account_holder_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "AccountHolder{" +
                "account_holder_id=" + account_holder_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", date_of_birth=" + date_of_birth +
                '}';
    }
}
