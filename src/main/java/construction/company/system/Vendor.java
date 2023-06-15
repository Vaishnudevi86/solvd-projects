package construction.company.system;

public class Vendor extends Company{
    private int vendorId;
    private String vendorType;

    public Vendor(String companyName, String companyAddress, String companyPhoneNumber, String vendorType) {
        super(companyName, companyAddress, companyPhoneNumber);
        this.vendorType = vendorType;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }
}
