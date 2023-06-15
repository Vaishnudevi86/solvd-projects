package buildingcompany;

import buildingcompany.interfaces.BuildDuration;
import buildingcompany.interfaces.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FourBRSingleFamilyHome extends SingleFamilyHome implements BuildDuration, Order {
    static Logger logger = LogManager.getLogger(FourBRSingleFamilyHome.class);
    private boolean islandKitchen;

    public FourBRSingleFamilyHome(int noOfFloors, float carpetArea, int buildingID, float ratePerSqft, boolean backyard, boolean basement, boolean islandKitchen) {
        super(noOfFloors, carpetArea, buildingID, ratePerSqft, backyard, basement);
        this.islandKitchen = islandKitchen;
    }

    public boolean isIslandKitchen() {
        return islandKitchen;
    }

    public void setIslandKitchen(boolean islandKitchen) {
        this.islandKitchen = islandKitchen;
    }

    public float calculatePrice() {
        return islandKitchen ? super.calculatePrice() + 1000 : super.calculatePrice();
    }

    @Override
    public int monthsToBuild() {
       logger.info("It will take around 15 months to complete");
        return 0;
    }

    @Override
    public void placeOrder() {
       logger.info("Placing order: Four bedroom single family home");
    }
}
