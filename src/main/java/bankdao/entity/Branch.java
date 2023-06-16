package bankdao.entity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Branch {

    private int branch_id;
    private String branch_name;
    private int bank_id;
    private String address;
    private String contact_number;
    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    private List<Employee> employees;


    public Branch(int branch_id, String branch_name, int bank_id, String address, String contact_number) {
        this.branch_id = branch_id;
        this.branch_name = branch_name;
        this.bank_id = bank_id;
        this.address = address;
        this.contact_number = contact_number;
    }
    public Branch() {
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
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
        return "Branch{" +
                "branch_id=" + branch_id +
                ", branch_name='" + branch_name + '\'' +
                ", bank_id=" + bank_id +
                ", address='" + address + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", employees=" + employees +
                '}';
    }
}

