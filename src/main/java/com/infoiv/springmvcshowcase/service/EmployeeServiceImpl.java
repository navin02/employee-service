package com.infoiv.springmvcshowcase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoiv.springmvcshowcase.dao.EmployeeDao;
import com.infoiv.springmvcshowcase.model.Address;
import com.infoiv.springmvcshowcase.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeSerivce {

	@Autowired
	private EmployeeDao empDao;

	@Override
	public Employee getEmployeeById(String id) {

		return empDao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empDao.getAllEmployee();
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.updateEmployee(emp);
	}

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.addEmployee(emp);
	}

	@Override
	public void deleteEmployee(Employee emp) {
		empDao.deleteEmployee(emp);
	}

	@Override
	public Address getAddressById(String id) {
		// TODO Auto-generated method stub
		return empDao.getAddressById(id);
	}

}
