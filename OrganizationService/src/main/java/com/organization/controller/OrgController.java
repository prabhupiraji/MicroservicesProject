package com.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.entity.Organization;
import com.organization.service.OrgService;

@RestController
@RequestMapping("/api/organization")
public class OrgController {
     @Autowired
	OrgService orgService;
     
     @PostMapping("/save")
     public ResponseEntity<Organization> saveorganization(@RequestBody Organization organization){
    	 
    	Organization saveorganization= orgService.saveorganization(organization);
		return new ResponseEntity<> (saveorganization,HttpStatus.OK);
    	 
     }
     
     @GetMapping("/getorganization/{organizationcode}")
     public Organization getOrganizationByCode(@PathVariable("organizationcode") String organizationcode){
    	 
		return orgService.getOrganizationByCode(organizationcode);
    	 
     }

}
