package com.example.SpringRevisionFab.services;

import com.example.SpringRevisionFab.error.DepartmentNotFoundException;
import com.example.SpringRevisionFab.model.Department;
import com.example.SpringRevisionFab.repository.DepartmentRepository;
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
    public List<Department> saveDepartment(List<Department> departments) {
        return  departmentRepository.saveAll(departments);
    }
    @Override
    public Optional<Department> findById(long id) throws DepartmentNotFoundException {

        Optional<Department> department =  departmentRepository.findById(id);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not available");
        }
        return department;
    }

    @Override
    public List<Department> DepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department debDB =  departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            debDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
           debDB.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            debDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(debDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
