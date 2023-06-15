package bankdao.main;


import bankdao.databaseConnection.DatabaseConnection;
import bankdao.interfaces.BankDAO;
import bankdao.jdbc.BankJdbcImpl;
import bankdao.model.Bank;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static com.solvd.practice.Main.logger;

public class Main {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()){
            BankDAO bankDAO = new BankJdbcImpl(connection);
               Bank newBank=new Bank (98,"Canara","104 First main rd Atlanta","64886989");
               bankDAO.saveBank(newBank);
               logger.info("New bank details added successfully");
               logger.info("All the bank details in the table");
            List<Bank> bankList=bankDAO.getAllBank();
            bankList.forEach(System.out::println);
            bankDAO.deleteBank(2);
            logger.info("Bank details deleted successfully");
            logger.info("Bank details for the bank_id entered is: " +bankDAO.getBank(34));
        }
    }
}