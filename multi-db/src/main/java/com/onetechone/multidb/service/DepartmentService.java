package com.onetechone.multidb.service;


import com.onetechone.multidb.model.db2.Department;
import com.onetechone.multidb.repository.db2.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

  @Autowired
  DepartmentRepository departmentRepository;

  public List<Department> getAll() {
    return  departmentRepository.findAll();
  }

  public Department save(Department dept) {
    Department department= departmentRepository.save(dept);
    return department;

  }
}
