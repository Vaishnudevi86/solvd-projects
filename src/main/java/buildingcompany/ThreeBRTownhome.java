package buildingcompany;

import buildingcompany.interfaces.BuildDuration;
import buildingcompany.interfaces.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreeBRTownhome extends TownHome implements BuildDuration, Order {
    static Logger logger = LogManager.getLogger(ThreeBRTownhome.class);
    private boolean withCarpet;

    public ThreeBRTownhome(int noOfFloors, float carpetArea, int buildingID, float ratePerSqft, boolean garage, boolean withCarpet) {
        super(noOfFloors, carpetArea, buildingID, ratePerSqft, garage);
        this.withCarpet = withCarpet;
    }

    public boolean isWithCarpet() {

        return withCarpet;
    }

    public void setWithCarpet(boolean withCarpet) {
        this.withCarpet = withCarpet;
    }

    public float calculatePrice() {

        return withCarpet ? super.calculatePrice() + 20 : super.calculatePrice();
    }

    @Override
    public int monthsToBuild() {
       logger.info("It will take around 12 months to complete");
        return 0;
    }

    @Override
    public void placeOrder() {
       logger.info("Placing order: Three bedroom townhome");
    }
}
