package buildingcompany;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Project {
    private String name;
    private String location;
    private double budget;
    private static final Logger logger = LogManager.getLogger(Menu.class);

    public Project(String name, String location, double budget) {
        super();
        this.name = name;
        this.location = location;
        this.budget = budget;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", budget=" + budget +
                '}';
    }

}