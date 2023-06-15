package bankdao.model;


public class Customer {
    private int customer_id;
    private String customer_name;
    private int branch_id;
    private String address;
    private String contact_number;

    public Customer() {
    }

    public Customer(int customer_id, String customer_name, int branch_id, String address, String contact_number) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.branch_id = branch_id;
        this.address = address;
        this.contact_number = contact_number;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
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
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", branch_id=" + branch_id +
                ", address='" + address + '\'' +
                ", contact_number='" + contact_number + '\'' +
                '}';
    }
}
