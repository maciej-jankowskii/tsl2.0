package com.example.tsl.model.employees.baseEntity;

import com.example.tsl.model.roles.EmployeeRole;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeMapper {
    public static EmployeeDTO map(Employee employee) {
        String email = employee.getEmail();
        String password = employee.getPassword();
        Set<String> roles = employee.getRoles()
                .stream()
                .map(EmployeeRole::getName)
                .collect(Collectors.toSet());
        return new EmployeeDTO(email, password, roles);
    }

    public static Employee map(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setEmail(employeeDTO.getEmail());
        employee.setPassword(employeeDTO.getPassword());
        return employee;
    }
}
