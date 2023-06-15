package bankJaxb;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class BankOperations {
    public static void main(String[] args) {
        try {
            // Create JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);

            // Create Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Specify the XML file to unmarshal
            File xmlFile = new File("C:\\Users\\deviv\\IdeaProjects\\solvd-projects\\src\\main\\java\\bankJaxb\\bankJaxb.xml");

            // Unmarshal XML to Java object
            Bank bank = (Bank) unmarshaller.unmarshal(xmlFile);

            // Access the data
            System.out.println("Bank Name: " + bank.getName());
            System.out.println("Established Date: " + bank.getEstablishedDate());

            List<Department> departments = bank.getDepartments();
            for (Department department : departments) {
                System.out.println("Department Name: " + department.getName());

                List<Employee> employees = department.getEmployees();
                for (Employee employee : employees) {
                    System.out.println("Employee Name: " + employee.getName());
                    System.out.println("Employee Position: " + employee.getPosition());
                }
            }

            List<Account> accounts = bank.getAccounts();
            for (Account account : accounts) {
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Account Balance: " + account.getBalance());

                if (account instanceof SavingsAccount) {
                    SavingsAccount savingsAccount = (SavingsAccount) account;
                    System.out.println("Interest Rate: " + savingsAccount.getInterestRate());
                } else if (account instanceof CreditAccount) {
                    CreditAccount creditAccount = (CreditAccount) account;
                    System.out.println("Credit Limit: " + creditAccount.getCreditLimit());
                }

                List<String> holders = account.getHolders();
                for (String holder : holders) {
                    System.out.println("Account Holder: " + holder);
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}