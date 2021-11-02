package com.employee.repository;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee> findByLoginIdAndPassword(String loginId, String password);

	@Query("select e from Employee e where e.employeeName = :employeeName ")
	List<Employee> getEmployeeByName(@PathParam("employeeName") String employeeName);

	@Modifying
	@Query("update Employee e set e.employeeName=:employeeName where e.employeeId=:employeeId")
	void updateEmployee(Integer employeeId, String employeeName);

	// Optional<Employee> findByEmployeeName(Integer employeeId);

	/*
	 * @Query(value =
	 * "select * from employee_table where employee_name = :employeeName "
	 * ,nativeQuery = true ) List<Employee>
	 * getEmployeeByName(@PathParam("employeeName") String employeeName);
	 */
}
