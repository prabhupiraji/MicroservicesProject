package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.dto.ApiResponseDto;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<ApiResponseDto> getemployeeById(@PathVariable("id") Long id){
		
		 ApiResponseDto apiResponseDto= employeeService.getemployeeById(id);
		 return  new ResponseEntity(apiResponseDto,HttpStatus.OK);
	}

	
}
