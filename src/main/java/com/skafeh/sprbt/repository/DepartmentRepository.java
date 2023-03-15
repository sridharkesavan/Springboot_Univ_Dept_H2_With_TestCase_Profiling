package com.skafeh.sprbt.repository;

import com.skafeh.sprbt.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDeptName(String deptName);

    //example for JPA repository on a non-primary key
    public Department findByDeptNameIgnoreCase(String deptName);

}
