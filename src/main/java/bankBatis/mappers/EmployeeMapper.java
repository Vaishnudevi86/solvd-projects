package bankBatis.mappers;

import bankdao.entity.Employee;



public interface EmployeeMapper {
    Employee selectEmployeeById(int employeeId);
    void insertEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
}