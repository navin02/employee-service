package com.infoiv.springmvcshowcase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "address")
public class Address extends ResourceSupport {

	@Id
	@Column(name = "addressid", unique = true, nullable = false)
	private String addressId;

	@Column(nullable = false)
	private String street;

	@Column(nullable = false)
	private String pinCode;

	@Column(nullable = false)
	private String city;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
//	@JsonBackReference
	@OneToOne
	@PrimaryKeyJoinColumn
	//@JsonManagedReference
	@JsonBackReference
	private Employee employee;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
