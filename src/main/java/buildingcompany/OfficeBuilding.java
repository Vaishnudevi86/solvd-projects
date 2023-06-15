package buildingcompany;

import buildingcompany.interfaces.BuildDuration;
import buildingcompany.interfaces.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class OfficeBuilding extends Building implements BuildDuration, Order {
    static Logger logger = LogManager.getLogger(OfficeBuilding.class);
    //Characteristics
    private int numberOfCabins;
    protected float costPerCabin;
    protected float totalCost;

    static{
       logger.info("Getting the details for the office building");
    }
    //Constructors

    public OfficeBuilding(int noOfFloors, float carpetArea, int buildingID, float ratePerSqft, int numberOfCabins, float costPerCabin) {
        super(noOfFloors, carpetArea, buildingID, ratePerSqft);
        this.numberOfCabins = numberOfCabins;
        this.costPerCabin = costPerCabin;
    }

    public int getNumberOfCabins() {
        return numberOfCabins;
    }

    public void setNumberOfCabins(int numberOfCabins) {

        this.numberOfCabins = numberOfCabins;
    }

    public float getCostPerCabin() {

        return costPerCabin;
    }

    public void setCostPerCabin(float costPerCabin) {

        this.costPerCabin = costPerCabin;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return String.format("Configuration: \n" +
                        " floors: %s \n" +
                        " building ID: %d",
                getNoOfFloors(),
                getBuildingID());
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return getBuildingID() == building.getBuildingID();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getBuildingID());
    }

    @Override
    public float calculatePrice() {
        this.totalCost =  this.getCostPerCabin() * this.getNumberOfCabins()
                + this.getCarpetArea() * this.getRatePerSqft() * this.getNoOfFloors();
        return this.totalCost;
    }

    @Override
    public int monthsToBuild() {
       logger.info("It will take around 48 months to complete");
        return 0;
    }

    @Override
    public void placeOrder() {
       logger.info("Placing order: Office building");
    }
}
