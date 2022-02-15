package com.example.SpringRevisionFab.services;

import com.example.SpringRevisionFab.error.DepartmentNotFoundException;
import com.example.SpringRevisionFab.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public List<Department> saveDepartment(List<Department> departments);
    public Optional<Department> findById(long id) throws DepartmentNotFoundException;

    List<Department> DepartmentList();

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
