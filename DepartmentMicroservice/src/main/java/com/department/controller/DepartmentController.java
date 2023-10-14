package com.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.entity.Department;
import com.department.service.DepartmentService;
//import com.pcsgpl.entity.EmployeePersonalDetails;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/getalldepartments")
	public List<Department> getalldepartments() {
		
		return departmentService.getalldepartments();
		
		
	}
	@GetMapping("/getdepartmentbyid/{deparmentcode}")
	public Department getdepartmentById(@PathVariable("deparmentcode") String deparmentcode) {
		
	 return departmentService.getdepartmentById(deparmentcode);
		
		
	}
	
}
