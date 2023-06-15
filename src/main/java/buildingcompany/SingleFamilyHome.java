package buildingcompany;

import java.util.Objects;

public abstract class SingleFamilyHome extends Building {
    //Characteristics
    private boolean backyard;
    private boolean basement;
    private static final String TYPE = "Single Family Home";

    //Constructors


    public SingleFamilyHome(int noOfFloors, float carpetArea, int buildingID, float ratePerSqft, boolean backyard, boolean basement) {
        super(noOfFloors, carpetArea, buildingID, ratePerSqft);
        this.backyard = backyard;
        this.basement = basement;
    }

    //Methods
    public boolean isBackyard() {
        return backyard;
    }

    public void setBackyard(boolean backyard) {
        this.backyard = backyard;
    }

    public static String getTYPE() {
        return TYPE;
    }

    public boolean isBasement() {
        return basement;
    }

    public void setBasement(boolean basement) {
        this.basement = basement;
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
        int areaMultiplier = this.getNoOfFloors();
        if(this.backyard){
            areaMultiplier+=1;
        }
        if(this.basement){
            areaMultiplier+=1;
        }
        return this.getCarpetArea() * this.getRatePerSqft() * areaMultiplier;
    }
}