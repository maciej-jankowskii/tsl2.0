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

CREATE TABLE IF NOT EXISTS forwarders (
    id INT PRIMARY KEY,
    extra_percentage DOUBLE,
    FOREIGN KEY (id) REFERENCES employees(id)
);

CREATE TABLE IF NOT EXISTS management (
    id INT AUTO_INCREMENT PRIMARY KEY,
    management_role VARCHAR(255),
    FOREIGN KEY (id) REFERENCES employees(id));

CREATE TABLE IF NOT EXISTS accountants (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type_of_role VARCHAR(255),
    FOREIGN KEY (id) REFERENCES employees(id));

CREATE TABLE IF NOT EXISTS employees_roles (
    employee_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (employee_id, role_id),
    FOREIGN KEY (employee_id) REFERENCES employees(id),
    FOREIGN KEY (role_id) REFERENCES employee_role(id)
    );

CREATE TABLE contractor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255),
    short_name VARCHAR(255),
    address_id INT,
    vat_number VARCHAR(255),
    description VARCHAR(255),
    term_of_payment INT,
    balance DECIMAL(10,2)
);

CREATE TABLE customer (
    id INT PRIMARY KEY,
    payments_rating VARCHAR(255),
    FOREIGN KEY (id) REFERENCES contractor(id)
);


INSERT INTO contractor (full_name, short_name, address_id, vat_number, description, term_of_payment, balance)
VALUES ('ABC Internationale Spediotion GmbH', 'ABC Spedition', 2, 'DE1234567890', 'Opis klienta', 30, 0.00);


INSERT INTO customer (id, payments_rating)
VALUES (1, 'SMALL_DELAYS');

INSERT INTO addresses (country, postal_code, city, street, home_no, flat_no)
VALUES ('Polska', '00-000', 'Warszawa', 'ul. Nowa', '1', '44'),
       ('Polska', '80-000', 'Gdańsk', 'ul. Stara', '5', '2'),
       ('Polska', '60-000', 'Poznań', 'ul. Testowa', '10', '1A'),
       ('Polska', '70-000', 'Szczecin', 'ul. Testowa', '3', '70'),
       ('Polska', '60-000', 'Poznań', 'ul. Testowa', '5', '5');


INSERT INTO employee_role (name, description)
VALUES ('FORWARDER', 'FORWARDER, ACCESS ONLY TO FORWARDER PANEL'),
       ('PLANNER', 'PLANER, ACCESS ONLY TO PLANNER PANEL'),
       ('ACCOUNTANT', 'ACCOUNTANT, ACCESS ONLY TO ACCOUNTANT PANEL'),
       ('ADMIN', 'ADMIN, ACCESS TO ALL PANELS');

INSERT INTO employees (first_name, last_name, email, password, telephone, address_id, basic_salary, date_of_employment, form_of_employment, contract_expiry_date)
VALUES ('John', 'Doe', 'john@example.com', '{bcrypt}$2a$10$ekPcaMnn28t7GP7GSGcF3uhe2xx3YVMr.FrC1B/kUkzw2/UM0Anm2', '+123456789', 1, 10000.00, '2023-01-01', 'CONTRACT_OF_EMPLOYMENT', null),
       ('Forwarder', 'Forwarder', 'forwarder@example.com', '{bcrypt}$2a$10$ekPcaMnn28t7GP7GSGcF3uhe2xx3YVMr.FrC1B/kUkzw2/UM0Anm2', '+123456789', 4, 5000.00, '2023-01-01', 'CONTRACT_OF_EMPLOYMENT', null),
       ('Forwarder2', 'Forwarder', 'forwarder2@example.com', '{bcrypt}$2a$10$ekPcaMnn28t7GP7GSGcF3uhe2xx3YVMr.FrC1B/kUkzw2/UM0Anm2', '+123456789', 3, 5000.00, '2023-01-01', 'CONTRACT_OF_EMPLOYMENT', null),
       ('Accountant', 'Accountant', 'acc@example.com', '{bcrypt}$2a$10$ekPcaMnn28t7GP7GSGcF3uhe2xx3YVMr.FrC1B/kUkzw2/UM0Anm2', '+123456789', 5, 3000.00, '2023-01-01', 'CONTRACT_OF_EMPLOYMENT', null);

INSERT INTO employees_roles (employee_id, role_id)
VALUES (1, 1),
       (1, 4),
       (2, 1),
       (3, 1),
       (4, 3);

INSERT INTO management(management_role)
VALUES ('DIRECTOR');

INSERT INTO forwarders (id, extra_percentage)
VALUES (2, 20.0),
       (3, 20.0);

INSERT INTO accountants(type_of_role)
VALUES ('INVOICES');
