package buildingcompany;

import buildingcompany.exception.MediaRoomException;
import buildingcompany.exception.NoOfCabinException;
import buildingcompany.interfaces.CalculatePrice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Menu {
    static Logger logger = LogManager.getLogger(Menu.class);

    void printMenu() {
        List<String> buildingTypeList = new ArrayList<>();
        buildingTypeList.add( "1. Office Building");
        buildingTypeList.add( "2. Apartment");
        buildingTypeList.add( "3. Town Home");
        buildingTypeList.add( "4. Single Family Home");
        logger.info("Select the building type from the list:");
        List<String> buildingList = buildingTypeList.stream().collect(Collectors.toList());
        logger.info(buildingList);
    }

    void addApartments(Scanner scanner) {
        GenericList<Apartment> apartmentGenericList = new GenericList<>();
        logger.info("How many apartments to build?");
        int noOfApt = scanner.nextInt();
        for (int i = 1; i <= noOfApt; i++) {
            apartmentGenericList.addNode(processApartment(scanner));

        }
        logger.info("Do you want to add another apartment? Y/N");
        String addApt = scanner.next();

        if (addApt.equalsIgnoreCase("Y")) {
            logger.info("At which position?");
            int pos = scanner.nextInt();
            apartmentGenericList.addNode(pos, processApartment(scanner));
        }
        logger.info("Total number of apartments: " + apartmentGenericList.length());
    }

    void processSingleFamilyHome(Scanner scanner) {
        logger.info("Choose the type of single family home:");
        logger.info("1. Four BR Single family home \n2. Five BR Single family home");
        int singleFamilyHomeType = scanner.nextInt();
        
        if (fourBRSingleFamilyHomePredicate.test(singleFamilyHomeType)) {
            process4BRSingleFamilyHomeConsumer.accept(scanner);
        }
        if (singleFamilyHomeType == 2) {
            try {
                logger.info("Do you want with media room(Y/N)?");
                String withMediaRoom = scanner.next();
                if (!withMediaRoom.equalsIgnoreCase("Y") && !withMediaRoom.equalsIgnoreCase("N")) {
                    throw new MediaRoomException("Input Value can either be Y or N");
                }
                boolean withMediaRoomBool = (withMediaRoom.equalsIgnoreCase("y"));
                FiveBRSingleFamilyHome fiveBRSingleFamilyHome = new FiveBRSingleFamilyHome(2, 34, 3, 4,
                        true, true, withMediaRoomBool);
                logger.info("Cost of five BR single family home is: $" + fiveBRSingleFamilyHome.calculatePrice());
                fiveBRSingleFamilyHome.placeOrder();
                fiveBRSingleFamilyHome.monthsToBuild();
            } catch (MediaRoomException e) {
                logger.error(e);
            }
        }
    }

    Predicate<Integer> fourBRSingleFamilyHomePredicate = homeType -> (homeType == 1);

    Consumer<Scanner> process4BRSingleFamilyHomeConsumer =
            scanner -> {
                logger.info("Do you want with island kitchen(Y/N)?");
                String withIslandKitchen = scanner.next();
                boolean withIslandKitchenBool = (withIslandKitchen.equalsIgnoreCase("y"));
                FourBRSingleFamilyHome fourBRSingleFamilyHome = new FourBRSingleFamilyHome(2, 34, 3, 4,
                        true, true, withIslandKitchenBool);
                logger.info("Cost of four BR single family home is: $" + fourBRSingleFamilyHome.calculatePrice());
                fourBRSingleFamilyHome.placeOrder();
                fourBRSingleFamilyHome.monthsToBuild();
            };

    void processTownhome(Scanner scanner) {
        logger.info("Choose the type of townhome:");
        logger.info("1. Three BR townhome \n2. Four BR townhome");

        int townhomeType = scanner.nextInt();
        if (townhomeType == 1) {
            logger.info("Do you want with carpet(Y/N)?");
            String withCarpet = scanner.next();
            boolean withCarpetBool = (withCarpet.equalsIgnoreCase("y"));
            ThreeBRTownhome threeBRTownhome = new ThreeBRTownhome(2, 34, 3, 4,
                    true, withCarpetBool);
            logger.info("Cost of three BR townhome is: $" + threeBRTownhome.calculatePrice());
            threeBRTownhome.placeOrder();
            threeBRTownhome.monthsToBuild();
        }
        if (townhomeType == 2) {
            logger.info("Do you want with hardwood floor(Y/N)?");
            String withHardwood = scanner.next();
            boolean withHardwoodBool = (withHardwood.equalsIgnoreCase("y"));
            FourBRTownhome fourBRTownhome = new FourBRTownhome(2, 34, 3, 4,
                    true, withHardwoodBool);
            logger.info("Cost of four BR townhome is: $" + fourBRTownhome.calculatePrice());
            fourBRTownhome.placeOrder();
            fourBRTownhome.monthsToBuild();
        }
    }

    Apartment processApartment(Scanner scanner) {
        logger.info("Choose the type of apartment:");
        logger.info("1. One BR Apartment \n2. Two BR Apartment");
        int apartmentType = scanner.nextInt();
        if (oneBRApartmentPredicate.test(apartmentType)) {
            return oneBRApartmentFunction.apply(scanner);
        }
        if (apartmentType == 2) {
            logger.info("Do you want Washer and dryer(Y/N)?");
            String washerDryer = scanner.next();
            boolean withWasherDryerBool = (washerDryer.equalsIgnoreCase("y"));
            TwoBRApartment twoBRApartment = new TwoBRApartment(5, 45, 1, 56,
                    5, withWasherDryerBool);
            logger.info("Cost of two BR apartment is: $" + twoBRApartment.calculatePrice());
            twoBRApartment.placeOrder();
            twoBRApartment.monthsToBuild();
            return twoBRApartment;
        }
        return null;
    }
    CalculatePrice oneBrAptPrice = (oneBrApartment) -> ((OneBRApartment)oneBrApartment).calculatePrice();
    Predicate<Integer> oneBRApartmentPredicate = apartmentType-> apartmentType==1;
    Function<Scanner, OneBRApartment> oneBRApartmentFunction =
            scanner -> {
                logger.info("How many cabinets do you want?");
                int noOfCabinets = scanner.nextInt();
                OneBRApartment oneBRApartment = new OneBRApartment(5, 45, 1, 26,
                        5, noOfCabinets, 5);
                logger.info("Cost of one BR apartment is: $" + oneBrAptPrice.calculate(oneBRApartment));
                oneBRApartment.placeOrder();
                oneBRApartment.monthsToBuild();
                return oneBRApartment;
            };
    //Custom lambda expression
    CalculatePrice officeBuildingPrice = (officeBuilding) -> ((OfficeBuilding)officeBuilding).calculatePrice();

    OfficeBuilding processOfficeBuilding(Scanner scanner, int buildingId) throws NoOfCabinException {
        logger.info("Choose number of cabins for building ID " + buildingId + ":");
        try{
            int numberOfCabins = scanner.nextInt();
            OfficeBuilding officeBuilding = new OfficeBuilding(3, 12, buildingId, 2,
                    numberOfCabins, 20);
            logger.info("Cost of office building is: $" + officeBuildingPrice.calculate(officeBuilding));
            officeBuilding.placeOrder();
            officeBuilding.monthsToBuild();
            return officeBuilding;
        }
        catch(InputMismatchException ime){
            throw new NoOfCabinException(ime.getMessage());
        }
    }
        void noOfOfficeBuilding(Scanner scanner) throws NoOfCabinException {
        logger.info("How many office building(s) to build?");
        int noOfOffices = scanner.nextInt();
        Map<Integer, OfficeBuilding> officeBuildingMap = new HashMap<>();
        for (int i = 1; i <= noOfOffices; i++) {
            officeBuildingMap.put(i, processOfficeBuilding(scanner, i));
        }

        Set<Integer> cabinSet = new HashSet<>();
        for (OfficeBuilding officeBuilding : officeBuildingMap.values()) {
            cabinSet.add(officeBuilding.getNumberOfCabins());
        }
        logger.info("Unique cabin numbers are:" + cabinSet.toString());

        logger.info("Enter building ID to see cost");
        int buildingId = scanner.nextInt();
        logger.info(String.format("Cost of building ID %s is %s", buildingId,
                officeBuildingMap.get(buildingId).getTotalCost()));
    }
}
