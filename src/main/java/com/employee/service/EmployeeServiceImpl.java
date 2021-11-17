package com.employee.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.employee.exception.EmployeeNoContentException;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

//@Service("employee-service")
@Service
@Transactional
//@Profile(value= {"local","dev","prod","qa"})
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String create(Employee employee) {
		employee.getEmployeeAddress().setEmployee(employee);
		Employee employeeResponse = employeeRepository.save(employee);
		if (employeeResponse == null) {
			return "Data not saved properly";
		}
		return "Employee Details Added";
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeNoContentException {
		List<Employee> response = employeeRepository.findAll();
		if (null == response || response.isEmpty()) {
			throw new EmployeeNoContentException("Data is empty");
		}
		return response;
	}

	@Override
	public Employee getEmployee(Integer employeeId) throws EmployeeNotFoundException {
		Optional<Employee> employeeResponse = employeeRepository.findById(employeeId);
		if (!employeeResponse.isPresent()) {
			throw new EmployeeNotFoundException("Data is not found");
		}
		return employeeResponse.get();
	}

	@Override
	public Employee getEmployeeLoginDetails(String loginId, String password) throws EmployeeNotFoundException {
		Optional<Employee> employeeResponse = employeeRepository.findByLoginIdAndPassword(loginId, password);
		if (!employeeResponse.isPresent()) {
			throw new EmployeeNotFoundException("Data is Incorrect");
		}
		return employeeResponse.get();
	}

	@Override
	public List<Employee> getEmployeeName(String employeeName) throws EmployeeNotFoundException {
		List<Employee> response = employeeRepository.getEmployeeByName(employeeName);
		if (null == response || response.isEmpty()) {
			throw new EmployeeNotFoundException("Data is not found");
		}
		return response;
	}

	@Override
	public String update(Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> response = employeeRepository.findById(employee.getEmployeeId());
		if (!response.isPresent()) {
			throw new EmployeeNotFoundException("Data is not found");
		}

		if (employee.getEmployeeName() != null) {
			response.get().setEmployeeName(employee.getEmployeeName());
		}
		if (employee.getMobileNumber() != null) {
			response.get().setMobileNumber(employee.getMobileNumber());
		}
		if (employee.getAddress() != null) {
			response.get().setAddress(employee.getAddress());
		}
		if (employee.getLoginId() != null) {
			response.get().setLoginId(employee.getLoginId());
		}
		if (employee.getPassword() != null) {
			response.get().setPassword(employee.getPassword());
		}

		employeeRepository.save(response.get());
		return "Updated successfully";
	}

	@Override
	public String updateEmployeeName(Integer employeeId, String employeeName) throws Exception {
		Optional<Employee> response = employeeRepository.findById(employeeId);
		if (!response.isPresent()) {
			throw new Exception("Data is not found");
		}
		employeeRepository.updateEmployee(employeeId, employeeName);
		return "updated succesffuly";
	}

	@Override
	public String deleteEmployee(Integer employeeId) throws Exception {
		Optional<Employee> response = employeeRepository.findById(employeeId);
		if (!response.isPresent()) {
			throw new Exception("Data is not found");
		}
		employeeRepository.deleteById(employeeId);
		return "Deleted Successfully";
	}
}
