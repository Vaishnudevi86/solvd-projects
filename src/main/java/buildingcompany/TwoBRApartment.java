package buildingcompany;

import buildingcompany.interfaces.BuildDuration;
import buildingcompany.interfaces.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TwoBRApartment extends Apartment implements BuildDuration, Order {
    static Logger logger = LogManager.getLogger(TwoBRApartment.class);
    private boolean withWasherDryer;

    public TwoBRApartment(int noOfFloors, float carpetArea, int buildingID, float ratePerSqft, int aptPerFloor, boolean withWasherDryer) {
        super(noOfFloors, carpetArea, buildingID, ratePerSqft, aptPerFloor);
        this.withWasherDryer = withWasherDryer;
    }

    public boolean isWithWasherDryer() {
        return withWasherDryer;
    }

    public void setWithWasherDryer(boolean withWasherDryer) {
        this.withWasherDryer = withWasherDryer;
    }

    public float calculatePrice() {
        if (withWasherDryer) {
            return super.calculatePrice() + 100;
        } else {
            return super.calculatePrice();
        }
    }
    @Override
    public int monthsToBuild() {
       logger.info("It will take around 24 months to complete");
        return 0;
    }
    @Override
    public void placeOrder() {
       logger.info("Placing order: Two bedroom apartment");
    }
}
