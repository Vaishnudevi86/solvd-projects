package bankBatis.mappers;

import bankdao.entity.Department;

import java.util.List;

public interface DepartmentMapper {

    Department selectDepartmentById(int id);

    List<Department> selectAllDepartments();

    void insertDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(int id);

}