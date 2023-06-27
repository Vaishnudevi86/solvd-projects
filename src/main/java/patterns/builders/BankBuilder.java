package patterns.builders;

import bankdao.entity.Bank;

public class BankBuilder {
    private int id;
    private String name;
    private String address;
    private String contactNumber;

    public BankBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public BankBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BankBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public BankBuilder withContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }

    public Bank build() {
        return new Bank(id, name, address, contactNumber);
    }
}