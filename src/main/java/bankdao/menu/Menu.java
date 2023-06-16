package bankdao.menu;

import bankdao.entity.AccountEntity;
import bankdao.entity.BankEntity;
import bankdao.entity.CreditAccountEntity;
import bankdao.entity.SavingsAccountEntity;
import bankdao.services.AccountService;
import bankdao.services.BankService;
import bankdao.services.EmployeeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("\n===== Bank Hierarchy Menu =====");
            System.out.println("1. Create Bank");
            System.out.println("2. Get Bank Details");
            System.out.println("3. Update Bank Details");
            System.out.println("4. Delete Bank");
           /* System.out.println("5. Create Account");
            System.out.println("6. Get Account Details");
            System.out.println("7. Update Account Details");
            System.out.println("8. Delete Account");
            System.out.println("9. Create Department");
            System.out.println("10. Get Department Details");
            System.out.println("11. Update Department Details");
            System.out.println("12. Delete Department");
            System.out.println("13. Create Credit Account");
            System.out.println("14. Get Credit Account Details");
            System.out.println("15. Update Credit Account Details");
            System.out.println("16. Delete Credit Account");
            System.out.println("17. Create Savings Account");
            System.out.println("18. Get Savings Account Details");
            System.out.println("19. Update Savings Account Details");
            System.out.println("20. Delete Savings Account");
            System.out.println("21. Create Employee");
            System.out.println("22. Get Employee Details");
            System.out.println("23. Update Employee Details");
            System.out.println("24. Delete Employee");*/
            System.out.println("0. Exit");
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
                System.out.println("Invalid account type.");
                return;
            }

            // Get the bank object
            BankEntity bank = bankService.getBankById(bankId);
            if (bank != null) {
                // Add the account to the bank
                bank.addAccount(account);
                // Update the bank in the database
                bankService.updateBank(bank);
                System.out.println("Account created successfully.");
            } else {
                System.out.println("Bank not found.");
            }
        }
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }*/

    private void updateBankDetails(Scanner scanner) {
        System.out.println("Choose the bank ID for which you want to update:");
        try {
            List<BankEntity> bankEntityList = bankService.getAllBanks();
            bankEntityList.forEach(bankEntity -> System.out.println(bankEntity.getBank_id() + "\t" + bankEntity.getBank_name()));
            int bankID = scanner.nextInt();
            System.out.println("Select option to update");
            System.out.println("1. Address 2. Contact Number");
            int updateChoice = scanner.nextInt();
            scanner.nextLine();
            BankEntity bankEntity = new BankEntity();
            bankEntity.setBank_id(bankID);
            switch (updateChoice) {
                case 1:
                    System.out.println("Enter new address");
                    String newAddress = scanner.nextLine();
                    bankEntity.setAddress(newAddress);
                    bankService.updateBank(bankEntity);
                    break;
                case 2:
                    System.out.println("Enter new contact number");
                    String newContact = scanner.nextLine();
                    bankEntity.setContact_number(newContact);
                    bankService.updateBank(bankEntity);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void getBankDetails(Scanner scanner)  {
        try{
            System.out.println("Getting all bank details:");
            List<BankEntity> bankEntityList = bankService.getAllBanks();
            bankEntityList.forEach(bankEntity -> System.out.println(bankEntity.toString()));
        }
        catch(SQLException e){

        }

    }

    private void createBank(Scanner scanner) {
        try {
            System.out.println("Enter Bank Name:");
            String bankName = scanner.nextLine();
            System.out.println("Enter Bank Address:");
            String bankAddress = scanner.nextLine();
            System.out.println("Enter Bank Contact Number:");
            String bankContactNumber = scanner.nextLine();
            BankEntity bankEntity = new BankEntity(bankName, bankAddress, bankContactNumber);
            bankService.saveBank(bankEntity);
            System.out.println("Successfully Created Bank " + bankName);
        }catch (SQLException sqlException) {
            System.out.println("Caught exception while saving bank details");
        }

    }
    private void deleteBank(Scanner scanner) {
        System.out.print("Enter the bank ID to delete: ");
        int bankId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        try {
            System.out.println("Select option to update");
            BankEntity bank = bankService.getBankById(bankId);
            if (bank != null) {
                bankService.deleteBank(bank);
                System.out.println("Bank deleted successfully.");
            } else {
                System.out.println("Bank not found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }

    }
}