package com.example.SpringRevisionFab.Controller;

import com.example.SpringRevisionFab.error.DepartmentNotFoundException;
import com.example.SpringRevisionFab.model.Department;
import com.example.SpringRevisionFab.services.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.Optional;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public List<Department> SaveDepartment(@Valid @RequestBody List<Department> department){
        LOGGER.info("Inside the save Department");
        return  departmentService.saveDepartment(department);
    }
    @GetMapping("/departments/{Id}")
    public Optional<Department> findDepartmentById(@PathVariable("Id") Long Id) throws DepartmentNotFoundException {
        LOGGER.info("Inside the function called findDepartmentbyId");
        return departmentService.findById(Id);

    };
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        LOGGER.info("Inside the function called fetchDepartmentList");
        return departmentService.DepartmentList();
    }
    @PutMapping("/departments/{Id}")
    public Department updateDepartment(@PathVariable("Id") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside the updateDepartment");
        return departmentService.updateDepartment(departmentId, department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String DepartmentName)
    {
        LOGGER.info("Inside the fetchDepartmentByName");
        return departmentService.fetchDepartmentByName(DepartmentName);
    }
}
