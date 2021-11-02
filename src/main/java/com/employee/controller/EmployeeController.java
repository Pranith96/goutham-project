package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	// @Qualifier("employee-service")
	EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		String response = employeeService.create(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/get/all")
	public ResponseEntity<List<Employee>> getAllEmployee() throws Exception {
		List<Employee> response = employeeService.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/{employeeId}")
	public ResponseEntity<Employee> getEmployeeId(@PathVariable("employeeId") Integer employeeId) throws Exception {
		Employee response = employeeService.getEmployee(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/details")
	public ResponseEntity<Employee> getEmployee(@RequestParam("employeeId") Integer employeeId) throws Exception {
		Employee response = employeeService.getEmployee(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/{loginId}/{password}")
	public ResponseEntity<Employee> getEmployeeLoginDetails(@PathVariable("loginId") String loginId,
			@PathVariable("password") String password) throws Exception {
		Employee response = employeeService.getEmployeeLoginDetails(loginId, password);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/name/{employeeName}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("employeeName") String employeeName)
			throws Exception {
		List<Employee> response = employeeService.getEmployeeName(employeeName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) throws Exception {
		String response = employeeService.update(employee);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/update/details/{employeeId}/{employeeName}")
	public ResponseEntity<String> updateEmployeeName(@PathVariable("employeeId") Integer employeeId,
			@PathVariable("employeeName") String employeeName) throws Exception {
		String response = employeeService.updateEmployeeName(employeeId,employeeName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("employeeId") Integer employeeId) throws Exception {
		String response = employeeService.deleteEmployee(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
