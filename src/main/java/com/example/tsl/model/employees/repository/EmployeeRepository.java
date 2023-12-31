package com.example.tsl.model.employees.repository;

import com.example.tsl.model.employees.baseEntity.Employee;
import com.example.tsl.model.employees.officeWorkers.Forwarder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);

}
