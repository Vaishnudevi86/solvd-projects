package construction.company.system;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Logger logger = LogManager.getLogger(buildingcompany.Main.class);
    public static void main(String[] args) {
        Company company = new Company("Global Construction", "456,First street,Atlanta,GA",
                "234-099-1234");
        Finance finance = new Finance("Finance", company.getCompanyName(), company.getCompanyAddress(),
                company.getCompanyPhoneNumber());
        Roles manager = new Roles(company.getCompanyName(), company.getCompanyAddress(), company.getCompanyPhoneNumber(),
                "MGR", "Manager");
        Employee employee1 = new Employee("Jones", "Cassia", "234-456-5678",
                "Villa 67,first main rd,MI", manager.getRoleShortDesc(), manager.getRoleLongDesc(),
                manager.getCompanyName(), manager.getCompanyAddress(), manager.getCompanyPhoneNumber());
        Vendor steel = new Vendor("Rod&Steel", "345,Second street,LA",
                "674-290-0987", "Steel");




       logger.info(String.format("Company Name: %s \nCompany Address: %s \nCompany Phone Number: %s",
                company.getCompanyName(), company.getCompanyAddress(), company.getCompanyPhoneNumber()));
       logger.info("--------Employee Details---------");
      logger.info(String.format("First Name: %s \nLast Name: %s \nPhone Number: %s \nAddress: %s",
                employee1.getFirstName(),employee1.getLastName(), employee1.getAddress(),employee1.getPhoneNumber()));
    }



}
