package buildingcompany.exception;

public class BuildingTypeException extends Exception
{
    public BuildingTypeException(String s) {
        super("Incorrect building type.  " +s);
    }
}
