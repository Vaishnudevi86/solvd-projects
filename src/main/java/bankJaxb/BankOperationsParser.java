package bankJaxb;
import bankdao.model.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import static com.solvd.practice.Main.logger;
public class BankOperationsParser {
    public static void main(String[] args) {
        try {
            // Create JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);

            // Create Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Specify the XML file to unmarshal
            File xmlFile = new File(".\\src\\main\\java\\bankJaxb\\bankJaxb.xml");

            // Unmarshal XML to Java object
            Bank bank = (Bank) unmarshaller.unmarshal(xmlFile);

            // Access the data
            logger.info("Bank Name: " + bank.getName());
            logger.info("Established Date: " + bank.getEstablishedDate());

            List<Department> departments = bank.getDepartments();
            for (Department department : departments) {
                logger.info("Department Name: " + department.getName());

                List<Employee> employees = department.getEmployees();
                for (Employee employee : employees) {
                    logger.info("Employee Name: " + employee.getName());
                    logger.info("Employee Position: " + employee.getPosition());
                }
            }

            List<Account> accounts = bank.getAccounts();
            for (Account account : accounts) {
                logger.info("Account Number: " + account.getAccountNumber());
                logger.info("Account Balance: " + account.getBalance());

                if (account instanceof SavingsAccount) {
                    SavingsAccount savingsAccount = (SavingsAccount) account;
                    logger.info("Interest Rate: " + savingsAccount.getInterestRate());
                } else if (account instanceof CreditAccount) {
                    CreditAccount creditAccount = (CreditAccount) account;
                    logger.info("Credit Limit: " + creditAccount.getCreditLimit());
                }

                List<String> holders = account.getHolders();
                for (String holder : holders) {
                    logger.info("Account Holder: " + holder);
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}