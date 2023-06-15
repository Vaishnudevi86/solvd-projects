package buildingcompany;

import java.util.Objects;

public class Apartment extends Building {
    private static final String TYPE = "Apartment Building";
    //Characteristics
    private int aptPerFloor;

    //Constructors
    public Apartment(int noOfFloors, float carpetArea, int buildingID, float ratePerSqft,
                     int aptPerFloor) {
        super(noOfFloors, carpetArea, buildingID, ratePerSqft);
        this.aptPerFloor = aptPerFloor;
    }

    public static String getTYPE() {
        return TYPE;
    }

    //Methods
    public int getAptPerFloor() {
        return aptPerFloor;
    }

    public void setAptPerFloor(int aptPerFloor) {
        this.aptPerFloor = aptPerFloor;
    }

    @Override
    public String toString() {
        return String.format("Configuration: \n" +
                        " floors: %s \n" +
                        " building ID: %d",
                getNoOfFloors(),
                getBuildingID());
    }
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
        return this.getCarpetArea() * this.getRatePerSqft() * this.getNoOfFloors() * this.getAptPerFloor();
    }
}

