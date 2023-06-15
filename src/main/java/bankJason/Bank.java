package bankJason;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Bank {
    @JsonProperty("name")
    private String name;

    @JsonProperty("establishedDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date establishedDate;

    @JsonProperty("departments")
    private List<Department> departments;

    @JsonProperty("accounts")
    private List<Account> accounts;

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(Date establishedDate) {
        this.establishedDate = establishedDate;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Bank() {
    }

    public Bank(String name, Date establishedDate, List<Department> departments, List<Account> accounts) {
        this.name = name;
        this.establishedDate = establishedDate;
        this.departments = departments;
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", establishedDate=" + establishedDate +
                ", departments=" + departments +
                ", accounts=" + accounts +
                '}';
    }
}
