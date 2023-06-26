package bankBatis.main;
import bankBatis.mappers.*;
import bankdao.entity.Account;
import bankdao.entity.Bank;
import bankdao.entity.Department;
import bankdao.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            // Load MyBatis configuration
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            // Open a new session
            sqlSession = sqlSessionFactory.openSession();

            // Get mappers for each entity
            BankMapper bankMapper = sqlSession.getMapper(BankMapper.class);
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            CreditAccountMapper creditAccountMapper = sqlSession.getMapper(CreditAccountMapper.class);
            SavingsAccountMapper savingsAccountMapper = sqlSession.getMapper(SavingsAccountMapper.class);

            // Perform operations using the mappers
            // Example: Select a bank by ID
            Bank bank = bankMapper.selectBankById(67);
            System.out.println("Bank: " + bank.getName());
            System.out.println("Bank ID: " + bank.getId());
            System.out.println("Bank Address: " + bank.getAddress());
            System.out.println("Contact Number: " + bank.getContactNumber());

            // Example: Insert a new department
            Department department = new Department();
            department.setDepartmentName("Customer Service Department");
            department.setLocation("New York");
            department.setManagerId(123);
            departmentMapper.insertDepartment(department);
            System.out.println("New department inserted with ID: " + department.getDepartmentId());

            // Example: Update an employee
            Employee employee = employeeMapper.selectEmployeeById(2);
            System.out.println("Original employee: " + employee);

            employee.setEmployeeName("Jones");
            employeeMapper.updateEmployee(employee);

            System.out.println("Employee updated successfully!");
            System.out.println("Updated employee details: " + employee);

            // Commit the transaction
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}