package com.infoiv.springmvcshowcase.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.infoiv.springmvcshowcase.exception.EmployeeNotFoundException;
import com.infoiv.springmvcshowcase.model.Address;
import com.infoiv.springmvcshowcase.model.Employee;
import com.infoiv.springmvcshowcase.service.EmployeeSerivce;

@RestController

public class EmployeeController {

	@Autowired
	private EmployeeSerivce empService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> listAllEmployees() {
		List<Employee> empList = empService.getAllEmployee();
		String empId = null;
		// String addressId=null;
		Link selfLink = null;
		Link addressLink = null;
		for (Employee emp : empList) {
			empId = emp.getEmpId();
			selfLink = ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder.methodOn(EmployeeController.class).getEmployeeById(empId))
					.withSelfRel();
			addressLink = ControllerLinkBuilder.linkTo(EmployeeController.class).slash(empId).withRel("order");
			emp.add(selfLink);
			emp.add(addressLink);
		}

		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/getEmp")
	public ResponseEntity<?> getEmployeeByIdUsingReqParam(@RequestParam String id) {
		Employee emp = empService.getEmployeeById(id);
		if (null != emp)
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);

		return new ResponseEntity<>("USer with id = " + id + " not found", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String id) {
		Employee emp = empService.getEmployeeById(id);
		if (null == emp)
			throw new EmployeeNotFoundException("Employee with id = " + id + " not available");
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@RequestMapping(value="/address/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<?> getAddressById(@PathVariable("id") String id){
		Address add=empService.getAddressById(id);
		if (null == add)
			throw new EmployeeNotFoundException("Address with id = " + id + " not available");
		return new ResponseEntity<Address>(add, HttpStatus.OK);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
		Employee emp = empService.getEmployeeById(id);

		if (null != emp) {
			emp = empService.updateEmployee(employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<>("User with id = " + id + " is not available ", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee,
			@RequestHeader(name = "X-COM_LOCATION") String empLocation) {

		Employee emp = empService.getEmployeeById(employee.getEmpId());
		System.out.println(empLocation);
		if (null == emp) {
//			List<Address> addressList = employee.getAddress();
//			for (Address add : addressList) {
//				add.setEmployee(employee);
//			}
			employee = empService.addEmployee(employee);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(employee.getEmpId()).toUri();
			return ResponseEntity.created(location).build();
		}
		return new ResponseEntity<>("User with id = " + employee.getEmpId() + " is exits", HttpStatus.CONFLICT);

	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable String id) {
		Employee emp = empService.getEmployeeById(id);
		if (null != emp) {
			empService.deleteEmployee(emp);
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("User with id = " + id + " is not available ", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAllUser() {
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}

	// Adding method link employee 'singular' resource
	// ResponseEntity<EmployeeReport> methodLinkBuilder = ControllerLinkBuilder
	// .methodOn(EmployeeRESTController.class).getAddressByEmployeeById(employee.getEmployeeId());
	// Link reportLink = ControllerLinkBuilder
	// .linkTo(methodLinkBuilder)
	// .withRel("address");

	// @RequestMapping("/customers")
	// class CustomerController {
	//
	// @RequestMapping("/{id}/addresses")
	// HttpEntity<Addresses> showAddresses(@PathVariable Long id) { … }
	// }
	//
	// Link link =
	// linkTo(methodOn(CustomerController.class).showAddresses(2L)).withRel("addresses");

}
