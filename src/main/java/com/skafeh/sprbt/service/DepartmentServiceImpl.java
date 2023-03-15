package com.skafeh.sprbt.service;

import com.skafeh.sprbt.entity.Department;
import com.skafeh.sprbt.error.DepartmentNotFoundException;
import com.skafeh.sprbt.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDept(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDeptList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDeptById(Long deptId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(deptId);
        if (!department.isPresent()){
            throw new DepartmentNotFoundException("There is no department with ID");
        }
        return department.get();
    }

    @Override
    public void deleteDeptById(Long deptId) {
        departmentRepository.deleteById(deptId);
    }

    @Override
    public Department updateDept(Long deptId, Department department) {
        Department deptDb = departmentRepository.findById(deptId).get();

        if (Objects.nonNull(department.getDeptName()) &&
        !"".equalsIgnoreCase(department.getDeptName())) {
            deptDb.setDeptName(department.getDeptName());
        }
        if (Objects.nonNull(department.getDeptCode()) &&
                !"".equalsIgnoreCase(department.getDeptCode())) {
            deptDb.setDeptCode(department.getDeptCode());
        }

        if (Objects.nonNull(department.getDeptAddress()) &&
                !"".equalsIgnoreCase(department.getDeptAddress())) {
            deptDb.setDeptAddress(department.getDeptAddress());
        }
        return  departmentRepository.save(deptDb);
    }

    @Override
    public Department findByDeptNameIgnoreCase(String deptName) {
        // example for JPA repository utilization for a custom field
        return departmentRepository.findByDeptNameIgnoreCase(deptName);
    }


}
