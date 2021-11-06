package com.employee.service;

import java.util.List;

import com.employee.exception.EmployeeNoContentException;
import com.employee.model.Employee;

public interface EmployeeService {

	String create(Employee employee);

	List<Employee> getAllEmployees() throws EmployeeNoContentException;

	Employee getEmployee(Integer employeeId) throws Exception;

	Employee getEmployeeLoginDetails(String loginId, String password) throws Exception;

	List<Employee> getEmployeeName(String employeeName) throws Exception;

	String update(Employee employee) throws Exception;

	String updateEmployeeName(Integer employeeId, String employeeName) throws Exception;

	String deleteEmployee(Integer employeeId) throws Exception;

}
