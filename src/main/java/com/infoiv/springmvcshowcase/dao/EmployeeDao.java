package com.infoiv.springmvcshowcase.dao;

import java.util.List;

import com.infoiv.springmvcshowcase.model.Address;
import com.infoiv.springmvcshowcase.model.Employee;

public interface EmployeeDao {
public Employee getEmployeeById(String id);

public List<Employee> getAllEmployee();

public Employee updateEmployee(Employee emp);

public Employee addEmployee(Employee emp);

public void deleteEmployee(Employee emp);

public Address getAddressById(String id);
}
