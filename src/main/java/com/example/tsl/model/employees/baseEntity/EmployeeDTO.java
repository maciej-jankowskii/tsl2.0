package com.example.tsl.model.employees.baseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {
    private final String email;
    private final String password;
    private final Set<String> roles;
}
