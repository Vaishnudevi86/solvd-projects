package bankBatis.main;
import bankBatis.mappers.*;
import bankdao.entity.Bank;
import bankdao.entity.Department;
import bankdao.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import static com.solvd.practice.Main.logger;

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
            Bank bank = bankMapper.selectBankById(235);
            logger.info("Bank: " + bank.getName());
            logger.info("Bank ID: " + bank.getId());
            logger.info("Bank Address: " + bank.getAddress());
            logger.info("Contact Number: " + bank.getContactNumber());

            // Example: Insert a new department
            Department department = new Department();
            department.setDepartmentName("Loan Department");
            department.setLocation("Atlanta");
            department.setManagerId(156);
            departmentMapper.insertDepartment(department);
            logger.info("New department inserted with ID: " + department.getDepartmentId());
            logger.info("Department Name: " + department.getDepartmentName());
            logger.info("Location: " + department.getLocation());
            logger.info("Manager ID: " + department.getManagerId());

            // Example: Update an employee
            Employee employee = employeeMapper.selectEmployeeById(3);
            logger.info("Original employee: " + employee);
            employee.setEmployeeName("Jones");
            employeeMapper.updateEmployee(employee);
            logger.info("Employee updated successfully!");
            logger.info("Updated employee details: " + employee);

            // Example: Delete an employee
            int employeeIdToDelete = 2; // ID of the employee to delete
            employeeMapper.deleteEmployee(employeeIdToDelete);
            logger.info("Employee with ID " + employeeIdToDelete + " has been deleted.");

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