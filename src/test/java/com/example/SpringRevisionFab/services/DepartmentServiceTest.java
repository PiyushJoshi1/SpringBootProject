package com.example.SpringRevisionFab.services;

import com.example.SpringRevisionFab.model.Department;
import com.example.SpringRevisionFab.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void TestfetchDepartmentByNameFuncitonWorkingOrnot() {
        String departmentName = "IT";
        Department department = getDepartment();
        when(departmentRepository.findByDepartmentName(departmentName)).thenReturn(department);
        assertEquals( departmentService.fetchDepartmentByName("IT").getDepartmentName(),"IT" );
    }

    private Department getDepartment() {
        return Department.builder()
                .departmentID(1L)
                .departmentName("IT")
                .departmentCode("IT_803")
                .departmentAddress("None")
                .build();
//        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
    }

}