package bankJason;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Bank bank = objectMapper.readValue(new File("C:\\Users\\deviv\\IdeaProjects\\solvd-projects\\src\\main\\java\\bankJason\\bank_hierarchy.json"), Bank.class);

            System.out.println("Bank name: " + bank.getName());
            System.out.println("Established date: " + bank.getEstablishedDate());
            System.out.println("Departments:");
            for (Department department : bank.getDepartments()) {
                System.out.println("- Department name: " + department.getName());
                System.out.println("  Employees:");
                for (Employee employee : department.getEmployees()) {
                    System.out.println("  - Employee name: " + employee.getName());
                    System.out.println("    Position: " + employee.getPosition());
                }
            }
            System.out.println("Accounts:");
            for (Account account : bank.getAccounts()) {
                System.out.println("- Account number: " + account.getAccountNumber());
                System.out.println("  Balance: " + account.getBalance());
                if (account instanceof SavingsAccount) {
                    SavingsAccount savingsAccount = (SavingsAccount) account;
                    System.out.println("  Interest rate: " + savingsAccount.getInterestRate());
                } else if (account instanceof CreditAccount) {
                    CreditAccount creditAccount = (CreditAccount) account;
                    System.out.println("  Credit limit: " + creditAccount.getCreditLimit());
                }
                System.out.println("  Holders:");
                for (String holder : account.getHolders()) {
                    System.out.println("  - Holder: " + holder);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}