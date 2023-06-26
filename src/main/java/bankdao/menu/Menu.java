package bankdao.menu;

import bankdao.entity.Account;
import bankdao.entity.Bank;
import bankdao.entity.CreditAccount;
import bankdao.entity.SavingsAccount;
import bankdao.services.AccountService;
import bankdao.services.BankService;
import bankdao.services.EmployeeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import static com.solvd.practice.Main.logger;

public class Menu {
    private BankService bankService;
    private AccountService accountService;
    /*private DepartmentService departmentService;
    private CreditAccountService creditAccountService;
    private SavingsAccountService savingsAccountService;*/
    private EmployeeService employeeService;

    public Menu(BankService bankService) {
        this.bankService = bankService;
        /*this.departmentService = departmentService;
        this.creditAccountService = creditAccountService;
        this.savingsAccountService = savingsAccountService;*/
    }

    public void start() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            logger.info("\n===== Bank Hierarchy Menu =====");
            logger.info("1. Create Bank");
            logger.info("2. Get Bank Details");
            logger.info("3. Update Bank Details");
            logger.info("4. Delete Bank");
           /* logger.info("5. Create Account");
            logger.info("6. Get Account Details");
            logger.info("7. Update Account Details");
            logger.info("8. Delete Account");
            logger.info("9. Create Department");
            logger.info("10. Get Department Details");
            logger.info("11. Update Department Details");
            logger.info("12. Delete Department");
            logger.info("13. Create Credit Account");
            logger.info("14. Get Credit Account Details");
            logger.info("15. Update Credit Account Details");
            logger.info("16. Delete Credit Account");
            logger.info("17. Create Savings Account");
            logger.info("18. Get Savings Account Details");
            logger.info("19. Update Savings Account Details");
            logger.info("20. Delete Savings Account");
            logger.info("21. Create Employee");
            logger.info("22. Get Employee Details");
            logger.info("23. Update Employee Details");
            logger.info("24. Delete Employee");*/
            logger.info("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createBank(scanner);
                    break;
                case 2:
                    getBankDetails(scanner);
                    break;
                case 3:
                    updateBankDetails(scanner);
                    break;
                case 4:
                    deleteBank(scanner);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

   /* private void createAccount(Scanner scanner) throws SQLException {
        try {
            System.out.print("Enter the bank ID: ");
            int bankId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter the account type (1 for Credit Account, 2 for Savings Account): ");
            int accountType = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter the account number: ");
            String accountNumber = scanner.nextLine();

            System.out.print("Enter the account balance: ");
            double accountBalance = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            // Create an instance of Account based on the account type
            AccountEntity account;
            if (accountType == 1) {
                System.out.print("Enter the credit limit: ");
                double creditLimit = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                account = new CreditAccountEntity(accountNumber, accountBalance, creditLimit);
            } else if (accountType == 2) {
                System.out.print("Enter the interest rate: ");
                double interestRate = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                account = new SavingsAccountEntity(accountNumber, accountBalance, interestRate);
            } else {
                logger.info("Invalid account type.");
                return;
            }

            // Get the bank object
            BankEntity bank = bankService.getBankById(bankId);
            if (bank != null) {
                // Add the account to the bank
                bank.addAccount(account);
                // Update the bank in the database
                bankService.updateBank(bank);
                logger.info("Account created successfully.");
            } else {
                logger.info("Bank not found.");
            }
        }
        catch (Exception e) {
            logger.info("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }*/

    private void updateBankDetails(Scanner scanner) {
        logger.info("Choose the bank ID for which you want to update:");
        try {
            List<Bank> bankList = bankService.getAllBanks();
            bankList.forEach(bank -> logger.info(bank.getId() + "\t" + bank.getName()));
            int bankID = scanner.nextInt();
            logger.info("Select option to update");
            logger.info("1. Address 2. Contact Number");
            int updateChoice = scanner.nextInt();
            scanner.nextLine();
            Bank bank = new Bank();
            bank.setId(bankID);
            switch (updateChoice) {
                case 1:
                    logger.info("Enter new address");
                    String newAddress = scanner.nextLine();
                    bank.setAddress(newAddress);
                    bankService.updateBank(bank);
                    break;
                case 2:
                    logger.info("Enter new contact number");
                    String newContact = scanner.nextLine();
                    bank.setContactNumber(newContact);
                    bankService.updateBank(bank);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void getBankDetails(Scanner scanner)  {
        try{
            logger.info("Getting all bank details:");
            List<Bank> bankList = bankService.getAllBanks();
            bankList.forEach(bank -> logger.info(bank.toString()));
        }
        catch(SQLException e){

        }

    }

    private void createBank(Scanner scanner) {
        try {
            logger.info("Enter Bank Name:");
            String bankName = scanner.nextLine();
            logger.info("Enter Bank Address:");
            String bankAddress = scanner.nextLine();
            logger.info("Enter Bank Contact Number:");
            String bankContactNumber = scanner.nextLine();
            Bank bank = new Bank( );
            bankService.saveBank(bank);
            logger.info("Successfully Created Bank " + bankName);
        }catch (SQLException sqlException) {
            logger.info("Caught exception while saving bank details");
        }

    }
    private void deleteBank(Scanner scanner) {
        System.out.print("Enter the bank ID to delete: ");
        int bankId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        try {
            logger.info("Select option to update");
            Bank bank = bankService.getBankById(bankId);
            if (bank != null) {
                bankService.deleteBank(bank);
                logger.info("Bank deleted successfully.");
            } else {
                logger.info("Bank not found.");
            }
        } catch (Exception e) {
            logger.info("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }

    }
}