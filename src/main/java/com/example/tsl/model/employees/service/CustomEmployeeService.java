package com.example.tsl.model.employees.service;

import com.example.tsl.model.employees.baseEntity.EmployeeDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomEmployeeService implements UserDetailsService {
    private final EmployeeService employeeService;

    public CustomEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeService.findEmployeeByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User with this e-mail not found"));
    }

    private UserDetails createUserDetails(EmployeeDTO employeeDTO) {
        return User.builder()
                .username(employeeDTO.getEmail())
                .password(employeeDTO.getPassword())
                .roles(employeeDTO.getRoles().toArray(String[]::new))
                .build();
    }
}
