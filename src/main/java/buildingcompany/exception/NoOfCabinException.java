package buildingcompany.exception;

public class NoOfCabinException extends Exception{
    public NoOfCabinException(String s) {
        super("Invalid entry.  " +   s);
    }
}


