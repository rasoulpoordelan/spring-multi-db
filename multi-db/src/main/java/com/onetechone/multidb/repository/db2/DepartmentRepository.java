package com.onetechone.multidb.repository.db2;

import com.onetechone.multidb.model.db2.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department,Long> {

}