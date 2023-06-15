package construction.company.system;

public class Client extends Company{
    private String clientId;
    private String clientType;

    public Client(String companyName, String companyAddress, String companyPhoneNumber, String clientType) {
        super(companyName, companyAddress, companyPhoneNumber);
        this.clientType = clientType;
    }

    public Client(String companyName, String companyAddress, String companyPhoneNumber) {
        super(companyName, companyAddress, companyPhoneNumber);
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
}
