package buildingcompany.enums;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

public enum BuildingColor {
    WHITE("White"),
    BLUE("Blue"),
    GRAY("Gray");
    private String color;
    private BuildingColor(String color) {
        this.color = color;
            }
       public String getColor() {
        return color;
    }
}
