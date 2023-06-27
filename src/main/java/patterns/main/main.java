package patterns.main;

import bankdao.entity.Bank;
import bankdao.entity.CreditAccount;
import patterns.builders.*;
import patterns.solidprinciple.*;

public class main {
    public static void main(String[] args) {

        // Create a Bank using the BankBuilder
        Bank bank = new BankBuilder()
                .withId(1)
                .withName("ABC Bank")
                .withAddress("123 Main Street")
                .withContactNumber("123-456-7890")
                .build();

        // Print the details of the Bank
        System.out.println("Bank Details:");
        System.out.println("ID: " + bank.getId());
        System.out.println("Name: " + bank.getName());
        System.out.println("Address: " + bank.getAddress());
        System.out.println("Contact Number: " + bank.getContactNumber());

        // Create an Account using the AccountBuilder
        bankdao.entity.Account account = new AccountBuilder()
                .withAccountId(123)
                .withBranchId("B001")
                .withAccountType("Savings")
                .withBalance(1000.0)
                .withAccountHolderId("AH001")
                .build();

        // Print the created Account
        System.out.println(account);
        // Create a Department using the DepartmentBuilder
        bankdao.entity.Department department = new DepartmentBuilder()
                .setDepartmentId(1)
                .setDepartmentName("Finance")
                .setLocation("New York")
                .setManagerId(123)
                .build();

        // Print the created Department
        System.out.println(department.toString());

        // Create an Employee using the EmployeeBuilder
        bankdao.entity.Employee employee = new EmployeeBuilder()
                .setEmployeeId(1)
                .setEmployeeName("John Doe")
                .setDepartmentId(1)
                .setDesignation("Manager")
                .setSalary(5000.0)
                .build();
        // Print the created Employee
        System.out.println(employee);

        // Create a CreditAccount using the CreditAccountBuilder
        CreditAccount creditAccount = new CreditAccountBuilder()
                .setAccountId(123)
                .setBranchId("B001")
                .setAccountType("Credit")
                .setBalance(1000.0)
                .setAccountHolderId("AH001")
                .setCreditLimit(5000.0)
                .build();

        // Print the created CreditAccount
        System.out.println(creditAccount.toString());


        // Create a SavingsAccount using the SavingsAccountBuilder
        bankdao.entity.SavingsAccount savingsAccount = new SavingsAccountBuilder()
                .setAccountId(456)
                .setBranchId("B002")
                .setAccountType("Savings")
                .setBalance(5000.0)
                .setAccountHolderId("AH002")
                .build();

        // Print the created SavingsAccount
        System.out.println(savingsAccount.toString());

        // Single Responsibility Principle

        // Create an account
        Account account1 = new Account(123456789, 1000.0);

        // Deposit funds into the account
        account1.deposit(500.0);

        // Withdraw funds from the account
        account1.withdraw(200.0);

        // Print the account details
        System.out.println("Account ID: " + account1.getAccountId());
        System.out.println("Balance: $" + account1.getBalance());

         // Open Closed Principle
        SavingsAccount savingsAccount1 = new SavingsAccount(1, "Savings Account", 5000.0, 2.5);
        savingsAccount1.displayProductDetails();

        //Liskov Substitution Principle
        Department financeDepartment = new FinanceDepartment("Finance");
        Department hrDepartment = new HRDepartment("HR");

        financeDepartment.performDepartmentFunction();
        hrDepartment.performDepartmentFunction();

        //Interface Segregation Principle
        BankCustomer individualCustomer = new IndividualCustomer("IC001", "John Doe");
        BankCustomer corporateCustomer = new CorporateCustomer("CC001", "ABC Corp");

        individualCustomer.deposit(1000);
        individualCustomer.withdraw(500);
        individualCustomer.checkBalance();
        individualCustomer.transferFunds(200, "RecipientAccount123");

        corporateCustomer.deposit(5000);
        corporateCustomer.withdraw(2000);

        //Dependency Inversion Principle

        // Create employees with different roles
        Employee manager = new Employee("John", "Manager");
        Employee teller = new Employee("Sarah", "Teller");
        Employee loanOfficer = new Employee("Mike", "Loan Officer");

        // Perform employee role-specific operations
        manager.performRole();
        teller.performRole();
        loanOfficer.performRole();
        }

       }

