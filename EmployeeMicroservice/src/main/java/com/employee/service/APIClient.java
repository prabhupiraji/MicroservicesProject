package com.employee.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.dto.DepartmentDto;



//@FeignClient(url = "http://localhost:9090", value = "DEPARTMENT-SERVICE") before using load balancer hardcoded url from department service

@FeignClient(name ="DEPARTMENT-SERVICE")
	public interface APIClient {
	    // Build get department rest api
	    @GetMapping("/api/department/getdepartmentbyid/{deparmentcode}")
	    DepartmentDto getDepartment(@PathVariable("deparmentcode") String deparmentcode);
	}


