package com.example.tsl.model.employees.service;

import com.example.tsl.model.employees.baseEntity.EmployeeDTO;
import com.example.tsl.model.employees.baseEntity.EmployeeMapper;
import com.example.tsl.model.employees.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public Optional<EmployeeDTO> findEmployeeByEmail(String email){
        return employeeRepository.findByEmail(email).map(EmployeeMapper::map);
    }

}
