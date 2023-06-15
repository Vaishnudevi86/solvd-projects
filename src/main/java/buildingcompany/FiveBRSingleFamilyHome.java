package buildingcompany;
import buildingcompany.interfaces.BuildDuration;
import buildingcompany.interfaces.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FiveBRSingleFamilyHome extends SingleFamilyHome implements BuildDuration, Order {
    static Logger logger = LogManager.getLogger(FiveBRSingleFamilyHome.class);
    private boolean mediaRoom;

    public FiveBRSingleFamilyHome(int noOfFloors, float carpetArea, int buildingID, float ratePerSqft, boolean backyard,
                                  boolean basement, boolean mediaRoom) {
        super(noOfFloors, carpetArea, buildingID, ratePerSqft, backyard, basement);
        this.mediaRoom = mediaRoom;
    }

    public boolean isMediaRoom() {

        return mediaRoom;
    }

    public void setMediaRoom(boolean mediaRoom) {

        this.mediaRoom = mediaRoom;
    }
    public float calculatePrice() {

        return mediaRoom? super.calculatePrice() + 500 : super.calculatePrice();
    }

    @Override
    public int monthsToBuild() {
       logger.info("It will take around 20 months to complete");
        return 0;
    }

    @Override
    public void placeOrder() {
       logger.info("Placing order: Five bedroom single family home");
    }
}
