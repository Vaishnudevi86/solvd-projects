package bankdao.interfaces;

import bankdao.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);
    void save(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
}
