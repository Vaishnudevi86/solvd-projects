package bankdao.services;

import bankdao.interfaces.EmployeeDAO;
import bankdao.entity.Employee;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDao) {
        this.employeeDAO = employeeDao;
    }

    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    public List<Employee> getAllEmployee() {
        return employeeDAO.getAllEmployee();
    }

    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeDAO.delete(employee);
    }
}


