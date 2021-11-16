package com.employee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "employee_table")
@ApiModel(description = "Details About the Employee Entity")
public class Employee {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The Unique Employee Id")
	private Integer employeeId;
	@ApiModelProperty(notes = "The Employee Name")
	private String employeeName;
	@ApiModelProperty(notes = "The Employee Mobile Number")
	private String mobileNumber;
	@ApiModelProperty(notes = "The Employee Address")
	private String address;
	@Column(name = "login_id", unique = true)
	@ApiModelProperty(notes = "The Login id")
	private String loginId;
	@ApiModelProperty(notes = "The Employee Password")
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address employeeAddress;

	@ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "companyId")
	private Company company;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "employee_project", joinColumns = { @JoinColumn(name = "employeeId") }, inverseJoinColumns = {
			@JoinColumn(name = "projectId") })
	private List<Project> projects;

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Address getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(Address employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Employee(Integer employeeId, String employeeName, String mobileNumber, String address, String loginId,
			String password) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.loginId = loginId;
		this.password = password;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", mobileNumber="
				+ mobileNumber + ", address=" + address + ", loginId=" + loginId + ", password=" + password + "]";
	}

}
