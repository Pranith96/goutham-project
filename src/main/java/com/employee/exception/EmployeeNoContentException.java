package com.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Data is not exists or empty")
public class EmployeeNoContentException extends RuntimeException {

	public EmployeeNoContentException(String message) {
		super(message);
	}
}
