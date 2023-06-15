package bankdao.model;


import bankJaxb.DateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "bank")
public class Bank {
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date established;

    @XmlElementWrapper(name = "branches")
    @XmlElement(name = "branch")
    private List<Branch> branches;

    private int bank_id;
    private String bank_name;
    private String address;
    private String contact_number;

    public Bank() {

    }

    public Bank(int bank_id, String bank_name, String address, String contact_number) {
        this.bank_id = bank_id;
        this.bank_name = bank_name;
        this.address = address;
        this.contact_number = contact_number;
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
                "established=" + established +
                ", branches=" + branches +
                ", bank_id=" + bank_id +
                ", bank_name='" + bank_name + '\'' +
                ", address='" + address + '\'' +
                ", contact_number='" + contact_number + '\'' +
                '}';
    }
}

