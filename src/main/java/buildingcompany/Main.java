package buildingcompany;

import buildingcompany.enums.BuildingColor;
import buildingcompany.enums.CitiesPlanned;
import buildingcompany.enums.ConstructionStatus;
import buildingcompany.exception.BuildingTypeException;
import buildingcompany.exception.MediaRoomException;
import buildingcompany.exception.NoOfCabinException;
import buildingcompany.interfaces.ProjectFilter;
import buildingcompany.threads.Connection;
import buildingcompany.threads.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static buildingcompany.Menu.*;
import static com.solvd.practice.Main.logger;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    static Logger logger = LogManager.getLogger(Main.class);
    private static Menu menu = new Menu();
    private static ProjectFilter filter;
    private static Object NoSuchMethodException;

    public static void main(String[] args) throws BuildingTypeException, MediaRoomException, NoOfCabinException,
            NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, ClassNotFoundException {
        int poolSize = 5;
        int totalThreads = 7;
        ConnectionPool connectionPool = new ConnectionPool(poolSize);
        ExecutorService executor = Executors.newFixedThreadPool(totalThreads);
        CompletableFuture<Void>[] futures = new CompletableFuture[totalThreads];
        for (int i = 0; i < totalThreads; i++) {
            CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                Connection connection = null;
                try {
                    connection = connectionPool.getConnection();
                    // Use the connection for some work
                    System.out.println("Thread " + Thread.currentThread().getId() + " acquired connection: " + connection);
                    Thread.sleep(2000); // Simulating some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connectionPool.releaseConnection(connection);
                        System.out.println("Thread " + Thread.currentThread().getId() + " released connection: " + connection);
                    }
                }
                return null;
            }, executor);
            futures[i] = future;
        }
        CompletableFuture.allOf(futures).join();
        executor.shutdown();

        menu.printMenu();
        Scanner scanner = new Scanner(System.in);
        int buildingType = scanner.nextInt();
        processByBuildingType(scanner, buildingType);
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Walton grove", "Smyrna", 500000));
        projects.add(new Project("Park at Marietta", "Marietta", 1000000));
        projects.add(new Project("Alpharetta Square", "Alpharetta", 800000));
        projects.add(new Project("Alpharetta Mansion", "Alpharetta", 300000));

        //Custom lambda expression

        ProjectFilter budgetFilter = project -> project.getBudget() > 300000;
        List<Project> filteredProjects = projects.stream()
                .filter(budgetFilter::test)
                .collect(Collectors.toList());
        logger.info("\nProjects greater than 300000: ");
        filteredProjects.forEach(System.out::println);

        // Filter projects by location (e.g., Alpharetta)
        List<Project> cityAProjects = projects.stream()
                .filter(project -> project.getLocation().equals("Alpharetta"))
                .collect(Collectors.toList());

        logger.info("\nAlpharetta city Projects: ");
        cityAProjects.forEach(System.out::println);

        //Printing the list of projects based on city using stream (Non Terminal  and terminal operation)
        List<Project> cityBProjects = projects.stream()
                .filter(project -> project.getLocation().equals("Marietta"))
                .collect(Collectors.toList());

        logger.info("\nMarietta city Projects: ");
        cityBProjects.forEach(System.out::println);

        // Calculate total budget of all projects (Non Terminal  and terminal operation)

        double totalBudget = projects.stream()
                .mapToDouble(Project::getBudget)
                .sum();

        logger.info("\nTotal Budget: " + totalBudget);

        //  Finding the building with the largest budget (Terminal operation)

        Project highestBudget = projects.stream()
                .max(Comparator.comparingDouble(Project::getBudget))
                .orElse(null);

        logger.info("\nHighest budget planned is :");
        logger.info(highestBudget);

    }

    private static void processByBuildingType(Scanner scanner, int buildingType) throws NoOfCabinException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        switch (buildingType) {
            case 1:
                menu.noOfOfficeBuilding(scanner);
                Class<?> classOffice = Class.forName("buildingcompany.OfficeBuilding");

                //Getting all the constructors in the OfficeBuilding class using reflection

                Constructor<?>[] officeConstructors = classOffice.getDeclaredConstructors();
                for (int k = 0; k < officeConstructors.length; k++) {
                    logger.info("\nConstructors in the OfficeBuilding class: " + officeConstructors[k]);
                }
                //Getting modifiers of OfficeBuilding class using Reflection

                int officemodifiers = classOffice.getModifiers();
                logger.info("\nModifiers in officeBuilding class: " + officemodifiers);
                if (!Modifier.isAbstract(officemodifiers)) {
                    logger.info("\nClass OfficeBuilding is not declared as Abstract");
                }
                if (!Modifier.isFinal(officemodifiers)) {
                    logger.info("\nClass OfficeBuilding is not declared as Final");
                }
                if (!Modifier.isStatic(officemodifiers)) {
                    logger.info("\nOfficeBuilding Class or method is not declared as Static");
                }

                logger.info(ConstructionStatus.IN_PROGRESS.getStatus());
                logger.info("\nPlease paint the building " + BuildingColor.WHITE.getColor());
                logger.info("\nWe have planned to build 20 office buildings in " + CitiesPlanned.ALPHARETTA.getCities());
                break;

            case 2:
                menu.processApartment(scanner);

                //Printing fieldnames,method names using reflection

                Apartment myApartment = new Apartment(5, 800, 2, 314, 10);

                Field[] apartmentFields = myApartment.getClass().getDeclaredFields();
                for (Field field : apartmentFields) {
                    int fieldmodifiers = field.getModifiers();
                    logger.info("Field modifiers:" + fieldmodifiers);
                    Class fieldtype = field.getType();
                    logger.info("Field Type:" + fieldtype);
                    if (field.getName().equals(2)) {
                        field.setAccessible(true);
                        field.set(myApartment, "3");
                    }
                    logger.info(field.getName());
                }
                Method[] apartmentMethods = myApartment.getClass().getDeclaredMethods();
                for (Method apartmentmethod : apartmentMethods) {
                    if (apartmentmethod.getName().equals(scanner)) {
                        apartmentmethod.invoke(myApartment);
                        myApartment.getRatePerSqft();
                    }
                    logger.info(apartmentmethod.getName());
                }
                Class<?> apartmentClass = Apartment.class;
                int apartmentmodifiers = apartmentClass.getModifiers();
                logger.info("Modifiers in the class: " + apartmentmodifiers);
                logger.info(ConstructionStatus.COMPLETED.getStatus());
                logger.info("\nPlease paint the building " + BuildingColor.GRAY.getColor());
                logger.info("\nWe have planned to build 100 apartment homes in " + CitiesPlanned.MARIETTA.getCities());
                break;

            case 3:
                menu.processTownhome(scanner);
                Class<?> classTownhome = Class.forName("buildingcompany.TownHome");

                //Getting only the public constructors in the OfficeBuilding class using reflection

                Constructor<?>[] townhomeConstructor = classTownhome.getConstructors();
                for (int l = 0; l < townhomeConstructor.length; l++) {
                    logger.info("\nPublic Constructors in the Townhome class: " + townhomeConstructor[l]);
                }
                logger.info(ConstructionStatus.CANCELLED.getStatus());
                break;

            case 4:
                menu.processSingleFamilyHome(scanner);

                //Getting the return type of method calculatePrice using reflection

                try {
                    Class<?> singleFamilyHomeClass = Class.forName("buildingcompany.SingleFamilyHome");
                    Method singleFamilyHomemethod = singleFamilyHomeClass.getMethod("calculatePrice");
                    Type singleFamilyHomereturntype = singleFamilyHomemethod.getGenericReturnType();
                    logger.info("\nReturn types: " + singleFamilyHomereturntype);
                    if (singleFamilyHomereturntype instanceof ParameterizedType) {
                        ParameterizedType parameterizedtype = (ParameterizedType) singleFamilyHomereturntype;
                        Type[] typeArguments = parameterizedtype.getActualTypeArguments();
                        for (Type typeArgument : typeArguments) {
                            Class typeArgClass = (Class) typeArgument;
                            logger.info("\nArgument type:" + typeArgClass);
                            logger.info("\nArgument type name: " + typeArgClass.getName());
                        }
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                } catch (SecurityException e) {
                    throw new RuntimeException(e);
                }
                logger.info(ConstructionStatus.PLANNED.getStatus());
                logger.info("\nPlease paint the building " + BuildingColor.BLUE.getColor());
                logger.info("\nWe have planned to build 200 singlefamily homes in " + CitiesPlanned.SMYRNA.getCities());
                break;
            default:
                logger.error("Invalid building type");
        }
    }
}

