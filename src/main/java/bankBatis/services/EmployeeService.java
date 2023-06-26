package bankBatis.services;
import bankBatis.main.MyBatisUtil;
import bankBatis.mappers.EmployeeMapper;
import bankdao.entity.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class EmployeeService {
    private final SqlSessionFactory sqlSessionFactory;

    public EmployeeService() {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    public Employee getEmployeeById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            return employeeMapper.selectEmployeeById(id);
        }
    }

    public List<Employee> getAllEmployees() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            return (List<Employee>) employeeMapper.selectEmployeeById(4);
        }
    }

    public void addEmployee(Employee employee) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            employeeMapper.insertEmployee(employee);
        }
    }

    public void updateEmployee(Employee employee) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            employeeMapper.updateEmployee(employee);
        }
    }

    public void deleteEmployee(int id) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            employeeMapper.deleteEmployee(id);
        }
    }
}