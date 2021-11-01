package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {

	String create(Employee employee);

	List<Employee> getAllEmployees() throws Exception;

	Employee getEmployee(Integer employeeId) throws Exception;

	Employee getEmployeeLoginDetails(String loginId, String password) throws Exception;

	List<Employee> getEmployeeName(String employeeName) throws Exception;

}
