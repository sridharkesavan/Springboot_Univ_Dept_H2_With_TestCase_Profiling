package com.skafeh.sprbt.controller;

import com.skafeh.sprbt.entity.Department;
import com.skafeh.sprbt.error.DepartmentNotFoundException;
import com.skafeh.sprbt.service.DepartmentService;
import com.skafeh.sprbt.service.DepartmentServiceImpl;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //Utilization of slf4j logger pattern
    private final Logger LOGGER =
            LoggerFactory.getLogger(String.valueOf(DepartmentController.class));

    @PostMapping(value = "/depts")
    public Department saveDept(@Valid @RequestBody Department department){

        //user creating an object to control which is not required in springboot
        //Rather Autowire the object of the service like above
        //DepartmentService service = new DepartmentServiceImpl();
        LOGGER.info("You are in Save department post mapping at Department Controller");
        return departmentService.saveDept(department);
    }

    @GetMapping(value = "/depts")
    public List<Department> fetchDeptList(){

        LOGGER.info("You are in department get mapping at Department Controller");
        return departmentService.fetchDeptList();
    }

    @GetMapping(value = "dept/{id}")
    public Department getDeptById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
        return departmentService.getDeptById(deptId);
    }

    @DeleteMapping(value = "dept/{id}")
    public String deleteDeptById(@PathVariable("id") Long deptId){
        departmentService.deleteDeptById(deptId);
        return "Department deleted";
    }

    @PutMapping(value = "dept/{id}")
    public Department updateDept(@PathVariable("id") Long deptId, @RequestBody Department department){
        return departmentService.updateDept(deptId, department);

    }

    @GetMapping(value = "dept/name/{deptName}")
    public Department findByDeptNameIgnoreCase(@PathVariable("deptName") String deptName){
        return departmentService.findByDeptNameIgnoreCase(deptName);
    }

}
