package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

//@Service("employee-service")
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

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> response = employeeRepository.findAll();
		if (null == response || response.isEmpty()) {
			throw new Exception("Data is empty");
		}
		return response;
	}

	@Override
	public Employee getEmployee(Integer employeeId) throws Exception {
		Optional<Employee> employeeResponse = employeeRepository.findById(employeeId);
		if (!employeeResponse.isPresent()) {
			throw new Exception("Data is not found");
		}
		return employeeResponse.get();
	}

	@Override
	public Employee getEmployeeLoginDetails(String loginId, String password) throws Exception {
		Optional<Employee> employeeResponse = employeeRepository.findByLoginIdAndPassword(loginId, password);
		if (!employeeResponse.isPresent()) {
			throw new Exception("Data is Incorrect");
		}
		return employeeResponse.get();
	}

	@Override
	public List<Employee> getEmployeeName(String employeeName) throws Exception {
		List<Employee> response = employeeRepository.getEmployeeByName(employeeName);
		if (null == response || response.isEmpty()) {
			throw new Exception("Data is not found");
		}
		return response;
	}
}
