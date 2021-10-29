package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String create(Employee employee) {
		Employee employeeResponse = employeeRepository.save(employee);
		if (employeeResponse == null) {
			return "Data not saved properly";
		}
		return "Employee Details Added";
	}

}
