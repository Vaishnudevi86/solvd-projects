package buildingcompany;

import buildingcompany.interfaces.BuildDuration;
import buildingcompany.interfaces.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FourBRTownhome extends TownHome implements BuildDuration, Order {
    static Logger logger = LogManager.getLogger(FourBRTownhome.class);
    private boolean withHardWoodFloor;

    public FourBRTownhome(int noOfFloors, float carpetArea, int buildingID, float ratePerSqft, boolean garage, boolean withHardWoodFloor) {
        super(noOfFloors, carpetArea, buildingID, ratePerSqft, garage);
        this.withHardWoodFloor = withHardWoodFloor;
    }

    public boolean isWithHardWoodFloor() {
        return withHardWoodFloor;
    }

    public void setWithHardWoodFloor(boolean withHardWoodFloor) {
        this.withHardWoodFloor = withHardWoodFloor;
    }

    @Override
    public float calculatePrice() {
        return withHardWoodFloor ? super.calculatePrice() + 30 : super.calculatePrice();
    }

    @Override
    public int monthsToBuild() {
       logger.info("It will take around 14 months to complete");
        return 0;
    }

    @Override
    public void placeOrder() {
       logger.info("Placing order: Four bedroom townhome");
    }
}
