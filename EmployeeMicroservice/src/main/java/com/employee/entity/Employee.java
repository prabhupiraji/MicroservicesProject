package com.employee.entity;

import com.employee.dto.DepartmentDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
	Long id;
	String name;
	String email;
	String deparmentcode;
	String organizationcode;
//	public String getDepartmentCode() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
