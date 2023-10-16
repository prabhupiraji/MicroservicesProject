package com.organization.service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.entity.Organization;
import com.organization.repository.OrgRepo;

@Service
public class OrgService {

	
	@Autowired
	OrgRepo orgRepo;

	
	public Organization saveorganization(Organization organization) {
		// TODO Auto-generated method stub
		return  orgRepo.save(organization);
	}

	public Organization getOrganizationByCode(String organizationcode) {
		// TODO Auto-generated method stub
		return  orgRepo.findByorganizationcode(organizationcode);

}
}