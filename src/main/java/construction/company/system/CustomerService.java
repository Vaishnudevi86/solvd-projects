package construction.company.system;

public class CustomerService extends Departments {
    private String phoneNumber;
    private String chatId;

    public CustomerService(String departmentName, String phoneNumber, String chatId,String companyName, String companyAddress, String companyPhoneNumber) {
        super(departmentName,companyName, companyAddress, companyPhoneNumber);
        this.phoneNumber = phoneNumber;
        this.chatId = chatId;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
}
