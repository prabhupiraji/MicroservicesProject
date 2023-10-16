package com.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.entity.Organization;

@Repository
public interface OrgRepo extends JpaRepository<Organization, Long> {

//	Organization findById(String organizationcode);

	Organization findByorganizationcode(String organizationcode);

}
