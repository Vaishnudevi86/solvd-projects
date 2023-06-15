package buildingcompany;

import buildingcompany.interfaces.BuildDuration;
import buildingcompany.interfaces.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OneBRApartment extends Apartment implements BuildDuration, Order {
    static Logger logger = LogManager.getLogger(OneBRApartment.class);
    private int noOfCabinets;
    protected float pricePerCabinet;

    public OneBRApartment(int noOfFloors, float carpetArea, int buildingID, float ratePerSqft, int aptPerFloor, int noOfCabinets, float pricePerCabinet) {
        super(noOfFloors, carpetArea, buildingID, ratePerSqft, aptPerFloor);
        this.noOfCabinets = noOfCabinets;
        this.pricePerCabinet = pricePerCabinet;
    }

    public int getNoOfCabinets() {
        return noOfCabinets;
    }

    public void setNoOfCabinets(int noOfCabinets) {
        this.noOfCabinets = noOfCabinets;
    }

    public float getPricePerCabinet() {
        return pricePerCabinet;
    }

    public void setPricePerCabinet(float pricePerCabinet) {
        this.pricePerCabinet = pricePerCabinet;
    }

    public float calculatePrice() {
        return super.calculatePrice() + this.getPricePerCabinet() * this.getNoOfCabinets();
    }

    @Override
    public int monthsToBuild() {
       logger.info("It will take around 24 months to complete");
        return 0;
    }

    @Override
    public void placeOrder() {
       logger.info("Placing order: One bedroom apartment");
    }
}
