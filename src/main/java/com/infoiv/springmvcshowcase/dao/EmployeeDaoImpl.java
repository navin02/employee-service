package com.infoiv.springmvcshowcase.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infoiv.springmvcshowcase.model.Address;
import com.infoiv.springmvcshowcase.model.Employee;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Employee getEmployeeById(String id) {
		// TODO Auto-generated method stub
		return entityManager.find(Employee.class, id);

	}

	@Override
	public List<Employee> getAllEmployee() {
		Query qury = entityManager.createQuery("from Employee e");
		List<Employee> listEmployee = qury.getResultList();
		return listEmployee;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Employee emp1 = (Employee) entityManager.merge(emp);
		return emp1;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		entityManager.persist(emp);
		return emp;
	}

	@Override
	public void deleteEmployee(Employee emp) {
		entityManager.remove(emp);
	}

	@Override
	public Address getAddressById(String id) {
		// TODO Auto-generated method stub
		return entityManager.find(Address.class, id);
	}

}
