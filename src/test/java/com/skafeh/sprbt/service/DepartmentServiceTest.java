package com.skafeh.sprbt.service;

import com.skafeh.sprbt.entity.Department;
import com.skafeh.sprbt.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    // This method is called for every test case whereas BeforeAll is called once before
    //running all the methods

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .deptName("IT")
                .deptAddress("Chennai")
                .deptCode("IT-01")
                .deptId(1L)
                .build();

        Mockito.when(departmentRepository.findByDeptNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get departments by a valid deptName")
    @Disabled //This annotation skips the test case - Just in case needed
    public void whenValidDeptName_thenDeptFound(){
        String deptName = "IT";
        Department found =
                departmentService.findByDeptNameIgnoreCase(deptName);

        assertEquals(deptName, found.getDeptName());

    }
}