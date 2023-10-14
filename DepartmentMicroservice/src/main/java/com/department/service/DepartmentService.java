package com.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.entity.Department;
import com.department.repository.DepartmentRepo;

@Service
public class DepartmentService {
     @Autowired
	private DepartmentRepo departmentRepo;
	
	public List<Department> getalldepartments() {
		return departmentRepo.findAll();
		
	}

	public  Department getdepartmentById(String deparmentcode) {
		// TODO Auto-generated method stub
//	 departmentRepo.findBydeparmentcode(deparmentcode);
	return departmentRepo.findBydeparmentcode(deparmentcode);
	}

}
