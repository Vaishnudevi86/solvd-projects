package bankdao.entity;


public class BankEntity {
    private int bank_id;
    private String bank_name;
    private String address;
    private String contact_number;

    public BankEntity() {

    }

    public BankEntity(String bank_name, String address, String contact_number) {
        this.bank_name = bank_name;
        this.address = address;
        this.contact_number = contact_number;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
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


    @Override
    public String toString() {
        return "Bank{" +
                ", bank_id=" + bank_id +
                ", bank_name='" + bank_name + '\'' +
                ", address='" + address + '\'' +
                ", contact_number='" + contact_number + '\'' +
                '}';
    }

    public void addAccount(AccountEntity account) {
    }
}

