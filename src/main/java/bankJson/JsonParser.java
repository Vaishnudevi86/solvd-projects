package bankJson;
import bankdao.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import static com.solvd.practice.Main.logger;

public class JsonParser {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Bank bank = objectMapper.readValue(new File(".\\src\\main\\java\\bankJson\\bank_hierarchy.json"), Bank.class);

            logger.info("Bank name: " + bank.getName());
            logger.info("Established date: " + bank.getEstablishedDate());
            logger.info("Departments:");
            for (Department department : bank.getDepartments()) {
                logger.info("- Department name: " + department.getName());
                logger.info("  Employees:");
                for (Employee employee : department.getEmployees()) {
                    logger.info("  - Employee name: " + employee.getName());
                    logger.info("    Position: " + employee.getPosition());
                }
            }
            logger.info("Accounts:");
            for (Account account : bank.getAccounts()) {
                logger.info("- Account number: " + account.getAccountNumber());
                logger.info("  Balance: " + account.getBalance());
                if (account instanceof SavingsAccount) {
                    SavingsAccount savingsAccount = (SavingsAccount) account;
                    logger.info("  Interest rate: " + savingsAccount.getInterestRate());
                } else if (account instanceof CreditAccount) {
                    CreditAccount creditAccount = (CreditAccount) account;
                    logger.info("  Credit limit: " + creditAccount.getCreditLimit());
                }
                logger.info("  Holders:");
                for (String holder : account.getHolders()) {
                    logger.info("  - Holder: " + holder);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}