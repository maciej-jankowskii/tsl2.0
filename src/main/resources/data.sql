CREATE TABLE IF NOT EXISTS addresses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(255),
    postal_code VARCHAR(255),
    city VARCHAR(255),
    street VARCHAR(255),
    home_no VARCHAR(255),
    flat_no VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS employee_role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
    );


CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    telephone VARCHAR(255),
    address_id INT,
    basic_salary DECIMAL(10, 2),
    date_of_employment DATE,
    form_of_employment VARCHAR(255),
    contract_expiry_date DATE,
    FOREIGN KEY (address_id) REFERENCES addresses(id)
    );

CREATE TABLE IF NOT EXISTS management (
    id INT AUTO_INCREMENT PRIMARY KEY,
    management_role VARCHAR(255),
    FOREIGN KEY (id) REFERENCES employees(id));

CREATE TABLE IF NOT EXISTS employees_roles (
    employee_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (employee_id, role_id),
    FOREIGN KEY (employee_id) REFERENCES employees(id),
    FOREIGN KEY (role_id) REFERENCES employee_role(id)
    );

INSERT INTO addresses (country, postal_code, city, street, home_no, flat_no)
VALUES ('Poland', '00-000', 'Warsaw', 'Main Street', '123', '4');

-- Wstawianie roli
INSERT INTO employee_role (name, description)
VALUES ('FORWARDER', 'FORWARDER, ACCESS ONLY TO FORWARDER PANEL'),
       ('PLANNER', 'PLANER, ACCESS ONLY TO PLANNER PANEL'),
       ('ACCOUNTANT', 'ACCOUNTANT, ACCESS ONLY TO ACCOUNTANT PANEL'),
       ('ADMIN', 'ADMIN, ACCESS TO ALL PANELS');

INSERT INTO employees (first_name, last_name, email, password, telephone, address_id, basic_salary, date_of_employment, form_of_employment, contract_expiry_date)
VALUES ('John', 'Doe', 'john@example.com', '{bcrypt}$2a$10$ekPcaMnn28t7GP7GSGcF3uhe2xx3YVMr.FrC1B/kUkzw2/UM0Anm2', '+123456789', 1, 10000.00, '2023-01-01', 'CONTRACT_OF_EMPLOYMENT', null);

INSERT INTO employees_roles (employee_id, role_id)
VALUES (1, 1);

INSERT INTO management (management_role)
VALUES ('DIRECTOR');
