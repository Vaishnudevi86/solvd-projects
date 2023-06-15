package buildingcompany;

public abstract class Building {
    //Characteristics
    private int noOfFloors;
    private float carpetArea;
    private int buildingID;
    private float ratePerSqft;

    //Constructors

    public Building(int noOfFloors, float carpetArea, int buildingID, float ratePerSqft) {
        this.noOfFloors = noOfFloors;
        this.carpetArea = carpetArea;
        this.buildingID = buildingID;
        this.ratePerSqft = ratePerSqft;
    }

    public Building() {

    }

    //Methods


    public float getRatePerSqft() {
        return ratePerSqft;
    }

    public void setRatePerSqft(float ratePerSqft) {
        this.ratePerSqft = ratePerSqft;
    }


    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public float getCarpetArea() {
        return carpetArea;
    }

    public float getCaretArea() {
        return carpetArea;
    }

    public void setCarpetArea(float carpetArea) {
        this.carpetArea = carpetArea;
    }


    public int getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(int buildingID) throws Exception {
        if (buildingID < 1 || buildingID > 999) {
            throw new Exception("Wrong building ID. Write ID in a 1 - 999 range");
        } else {
            this.buildingID = buildingID;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building building)) return false;
        return getNoOfFloors() == building.getNoOfFloors() && Float.compare(building.getCarpetArea(), getCarpetArea()) == 0 && getBuildingID() == building.getBuildingID() && Float.compare(building.getRatePerSqft(), getRatePerSqft()) == 0;
    }

   /* @Override
    public int hashCode() {
        return Objects.hash(getNoOfFloors(), getCarpetArea(), getBuildingID(), getRatePerSqft());
    }*/

    public abstract float calculatePrice();
}


