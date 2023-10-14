package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee.dto.ApiResponseDto;
import com.employee.dto.DepartmentDto;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;

import io.github.resilience4j.retry.annotation.Retry;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	
	  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
EmployeeRepo employeeRepo;
	
//	@Autowired
//	RestTemplate restTemplate;
	
//	@Autowired
//	WebClient webClient;
	@Autowired
    private APIClient apiClient;

//	 @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	 @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	public ApiResponseDto getemployeeById(Long id) {
		 LOGGER.info("inside getEmployeeById() method");
		 
	  Employee employee=employeeRepo.findById(id).get();
	  //Rest template inbuilt
//	  ResponseEntity<DepartmentDto> responseEntity=restTemplate.getForEntity("http://localhost:9090/getdepartmentbyid/" + employee.getDeparmentcode(),
//			 DepartmentDto.class);
//	  DepartmentDto departmentDto = responseEntity.getBody();
	  
	  //webclient from spring web flux maven dependency
//	  DepartmentDto departmentDto = webClient.get()
//          .uri("http://localhost:9090/getdepartmentbyid/" + employee.getDeparmentcode())
//           .retrieve()
//          .bodyToMono(DepartmentDto.class)
//          .block();
	  
	  DepartmentDto departmentDto = apiClient.getDepartment(employee.getDeparmentcode());

     ApiResponseDto apiResponseDto=new ApiResponseDto();
 
     apiResponseDto.setEmployee(employee);
     apiResponseDto.setDepartmentDto(departmentDto);
	  return apiResponseDto;
	}
	
	 public ApiResponseDto getDefaultDepartment(Long id, Exception exception) {

	        LOGGER.info("inside getDefaultDepartment() method");

	        Employee employee = employeeRepo.findById(id).get();

	        DepartmentDto departmentDto = new DepartmentDto();
	        departmentDto.setDepartmentname("R&D Department");
	        departmentDto.setDeparmentcode("RD001");
//	        departmentDto.setDepartmentDescription("Research and Development Department");

//	        Employee employee=employeeRepo.findById(id).get();

	        ApiResponseDto apiResponseDto = new ApiResponseDto();
	        apiResponseDto.setEmployee(employee);
	        apiResponseDto.setDepartmentDto(departmentDto);
	        return apiResponseDto;
	    }	
	 
}
