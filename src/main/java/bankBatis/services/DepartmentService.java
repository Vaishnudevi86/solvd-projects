package bankBatis.services;


import bankBatis.main.MyBatisUtil;
import bankBatis.mappers.DepartmentMapper;
import bankdao.entity.Department;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DepartmentService {
    private final SqlSessionFactory sqlSessionFactory;

    public DepartmentService() {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    public Department getDepartmentById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            return departmentMapper.selectDepartmentById(id);
        }
    }

    public List<Department> getAllDepartments() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            return departmentMapper.selectAllDepartments();
        }
    }

    public void updateDepartment(Department department) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            departmentMapper.updateDepartment(department);
        }
    }

    public void deleteDepartment(int id) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            departmentMapper.deleteDepartment(id);
        }
    }
}