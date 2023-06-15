package buildingcompany;

import java.util.Objects;

public abstract class TownHome extends Building {
    private boolean garage;

    public TownHome(int noOfFloors, float carpetArea, int buildingID, float ratePerSqft, boolean garage) {
        super(noOfFloors, carpetArea, buildingID, ratePerSqft);
        this.garage = garage;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TownHome townHome)) return false;
        if (!super.equals(o)) return false;
        return isGarage() == townHome.isGarage();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isGarage());
    }

    @Override
    public float calculatePrice() {
        if(garage) {
            return this.getCarpetArea() * this.getRatePerSqft() * this.getNoOfFloors() + 50;
        }
        return this.getCarpetArea() * this.getRatePerSqft() * this.getNoOfFloors() ;
    }

}
