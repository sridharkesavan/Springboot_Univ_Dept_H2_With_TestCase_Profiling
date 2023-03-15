package com.skafeh.sprbt.service;

import com.skafeh.sprbt.entity.Department;
import com.skafeh.sprbt.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDept(Department department);

    public List<Department> fetchDeptList();

    public Department getDeptById(Long deptId) throws DepartmentNotFoundException;

    public void deleteDeptById(Long deptId);

    public Department updateDept(Long deptId, Department department);

    public Department findByDeptNameIgnoreCase(String deptName);
}
