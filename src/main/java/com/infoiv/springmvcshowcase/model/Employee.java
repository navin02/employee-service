package com.infoiv.springmvcshowcase.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employee")
public class Employee extends ResourceSupport {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private String empId;

	@Column(nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	private String mobileNum;

//	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//	@JsonManagedReference
//
//	// @JoinColumn(name="emp_id")
//	private List<Address> address;
	@OneToOne(mappedBy="employee",cascade = CascadeType.ALL)
	//@JsonBackReference
	@JsonManagedReference
    private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

//	public List<Address> getAddress() {
//		return address;
//	}
//
//	public void setAddress(List<Address> address) {
//		this.address = address;
//	}

}
