package com.skafeh.sprbt.controller;

import com.skafeh.sprbt.entity.Department;
import com.skafeh.sprbt.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultHandlersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp() {
        department = Department.builder()
                .deptId(2L)
                .deptName("Mech")
                .deptAddress("Chennai")
                .deptCode("MECH-01")
                .build();
    }

    @Test
    void saveDept() throws Exception {
        Department iDepartment =  Department.builder()
                .deptName("Mech")
                .deptAddress("Chennai")
                .deptCode("MECH-01")
                .build();

        Mockito.when(departmentService.saveDept(iDepartment))
                .thenReturn(department);
        mockMvc.perform(post("/depts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"deptName\": \"Mech\",\n" +
                        "  \"deptAddress\": \"Chennai\",\n" +
                        "  \"deptCode\": \"MECH-01\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getDeptById() throws Exception {
        Mockito.when(departmentService.getDeptById(1L))
                .thenReturn(department);
        mockMvc.perform(get("/dept/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deptName").value(department.getDeptName()));
    }
}